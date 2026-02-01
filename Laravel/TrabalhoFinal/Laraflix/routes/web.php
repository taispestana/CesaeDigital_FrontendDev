<?php

use App\Http\Controllers\ProfileController;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\MovieController;

Route::get('/', function () {
    return view('welcome');
});

Route::get('/dashboard', function (\App\Services\OmdbService $omdb) {
    \Illuminate\Support\Facades\Log::info("Dashboard route HIT");
    $categories = \App\Models\Category::with('movies')->get();

    // Auto-enrich movies with OMDb data if details are missing
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

    return view('dashboard', compact('categories', 'featured'));
})->middleware(['auth', 'verified'])->name('dashboard');

Route::get('/categorias', [MovieController::class, 'index'])->name('categories.index');
Route::get('/categorias/{id}', [MovieController::class, 'show'])->name('categories.show');

Route::middleware('auth')->group(function () {
    Route::get('/movies/{movie}/edit', [MovieController::class, 'edit'])->name('movies.edit');
    Route::put('/movies/{movie}', [MovieController::class, 'update'])->name('movies.update');
    Route::get('/profile', [ProfileController::class, 'edit'])->name('profile.edit');
    Route::patch('/profile', [ProfileController::class, 'update'])->name('profile.update');
    Route::delete('/profile', [ProfileController::class, 'destroy'])->name('profile.destroy');

    Route::get('/watchlist', [App\Http\Controllers\WatchlistController::class, 'index'])->name('watchlist.index');
    Route::post('/watchlist/toggle', [App\Http\Controllers\WatchlistController::class, 'toggle'])->name('watchlist.toggle');
    Route::get('/watchlist/check/{movie}', [App\Http\Controllers\WatchlistController::class, 'check'])->name('watchlist.check');

    Route::get('/profiles/manage', [App\Http\Controllers\ProfileManagementController::class, 'index'])->name('profiles.manage');
    Route::get('/profiles/edit/{user}', [App\Http\Controllers\ProfileManagementController::class, 'edit'])->name('profiles.edit_form');
    Route::patch('/profiles/update/{user}', [App\Http\Controllers\ProfileManagementController::class, 'update'])->name('profiles.update');
    Route::delete('/profiles/{user}', [App\Http\Controllers\ProfileManagementController::class, 'destroy'])->name('profiles.destroy');

    Route::middleware('admin')->group(function () {
        Route::get('/profiles/create', [App\Http\Controllers\ProfileManagementController::class, 'create'])->name('profiles.create');
        Route::post('/profiles', [App\Http\Controllers\ProfileManagementController::class, 'store'])->name('profiles.store');
    });

    Route::delete('/movies/{movie}', [MovieController::class, 'destroy'])->name('movies.destroy');
    Route::post('/profiles/switch/{user}', [App\Http\Controllers\ProfileManagementController::class, 'switch'])->name('profiles.switch');
});


require __DIR__ . '/auth.php';
