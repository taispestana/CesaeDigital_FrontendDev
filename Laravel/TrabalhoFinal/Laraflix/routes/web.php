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

    return view('dashboard', compact('categories'));
})->middleware(['auth', 'verified'])->name('dashboard');

Route::get('/categorias', [MovieController::class, 'index'])->name('categories.index');
Route::get('/categorias/{id}', [MovieController::class, 'show'])->name('categories.show');

Route::middleware('auth')->group(function () {
    Route::get('/movies/{movie}/edit', [MovieController::class, 'edit'])->name('movies.edit');
    Route::put('/movies/{movie}', [MovieController::class, 'update'])->name('movies.update');
    Route::get('/profile', [ProfileController::class, 'edit'])->name('profile.edit');
    Route::patch('/profile', [ProfileController::class, 'update'])->name('profile.update');
    Route::delete('/profile', [ProfileController::class, 'destroy'])->name('profile.destroy');

    Route::delete('/movies/{movie}', [MovieController::class, 'destroy'])->name('movies.destroy');
});

require __DIR__ . '/auth.php';
