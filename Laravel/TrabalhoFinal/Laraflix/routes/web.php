<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\MovieController;

Route::get('/', function () {
    return view('welcome');
});

Route::get('/dashboard', function (\App\Services\OmdbService $omdb) {
    \Illuminate\Support\Facades\Log::info("Dashboard route HIT");
    $categories = \App\Models\Category::with('movies')->get();

    // Verifica se os dados do filme estão disponíveis no banco de dados
    foreach ($categories as $category) {
        foreach ($category->movies as $movie) {
            \Illuminate\Support\Facades\Log::info("Checking movie '{$movie->title}' (poster_url: '{$movie->poster_url}')");
            if (empty($movie->synopsis) || empty($movie->poster_url) || $movie->poster_url === 'N/A') {
                $data = $omdb->fetchMovieByTitle($movie->title);
                if ($data) {
                    $movie->update([
                        'synopsis' => $data['Plot'] ?? null,
                        'rating' => $data['imdbRating'] ?? null,
                        'poster_url' => $data['Poster'] ?? null,
                        'imdb_id' => $data['imdbID'] ?? null,
                    ]);
                }
            }
        }
    }

    $featured = $omdb->fetchMovieByTitle('Younger');

    // Verifica se o filme Younger está no banco de dados
    if ($featured) {
        $dbMovie = \App\Models\Movie::where('title', 'Younger')->first();
        $featured['id'] = $dbMovie ? $dbMovie->id : null;
        $featured['Backdrop'] = asset('images/younger_custom_backdrop.png');
    }

    return view('dashboard', compact('categories', 'featured'));

})->middleware(['auth', 'verified'])->name('dashboard');

// Rota para a lista de categorias
Route::get('/categorias', [MovieController::class, 'index'])->name('categories.index');
Route::get('/categorias/{id}', [MovieController::class, 'show'])->name('categories.show');

//Rotas privadas
Route::middleware('auth')->group(function () {
    Route::put('/movies/{movie}', [MovieController::class, 'update'])->name('movies.update');

    //Rotas de watchlist
    Route::get('/watchlist', [App\Http\Controllers\WatchlistController::class, 'index'])->name('watchlist.index');
    Route::post('/watchlist/toggle', [App\Http\Controllers\WatchlistController::class, 'toggle'])->name('watchlist.toggle');
    Route::get('/watchlist/check/{movie}', [App\Http\Controllers\WatchlistController::class, 'check'])->name('watchlist.check');

    //Rotas de perfil
    Route::get('/profiles/manage', [App\Http\Controllers\ProfileManagementController::class, 'index'])->name('profiles.manage');
    Route::get('/profiles/edit/{user}', [App\Http\Controllers\ProfileManagementController::class, 'edit'])->name('profiles.edit_form');
    Route::patch('/profiles/update/{user}', [App\Http\Controllers\ProfileManagementController::class, 'update'])->name('profiles.update');
    Route::delete('/profiles/{user}', [App\Http\Controllers\ProfileManagementController::class, 'destroy'])->name('profiles.destroy');

    //Rotas de admin
    Route::middleware('admin')->group(function () {
        Route::get('/profiles/create', [App\Http\Controllers\ProfileManagementController::class, 'create'])->name('profiles.create');
        Route::post('/profiles', [App\Http\Controllers\ProfileManagementController::class, 'store'])->name('profiles.store');
    });

    //Rotas de switch de perfil
    Route::post('/profiles/switch/{user}', [App\Http\Controllers\ProfileManagementController::class, 'switch'])->name('profiles.switch');
});

//Rotas de autenticação
require __DIR__ . '/auth.php';
