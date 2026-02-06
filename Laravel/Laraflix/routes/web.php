<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\MovieController;
use App\Http\Controllers\ProfileManagementController;
use App\Http\Controllers\WatchlistController;
use App\Http\Controllers\DashboardController;

Route::view('/', 'welcome');

Route::get('/dashboard', [DashboardController::class, 'index'])
    ->middleware(['auth', 'verified'])
    ->name('dashboard');

// Rota para a lista de categorias
Route::get('/categorias', [MovieController::class, 'index'])->name('categories.index');
Route::get('/categorias/{id}', [MovieController::class, 'show'])->name('categories.show');

//Rotas privadas
Route::middleware('auth')->group(function () {
    Route::put('/movies/{movie}', [MovieController::class, 'update'])->name('movies.update');

    //Rotas de watchlist
    Route::get('/watchlist', [WatchlistController::class, 'index'])->name('watchlist.index');
    Route::post('/watchlist/toggle', [WatchlistController::class, 'toggle'])->name('watchlist.toggle');
    Route::get('/watchlist/check/{movie}', [WatchlistController::class, 'check'])->name('watchlist.check');

    //Rotas de perfil
    Route::get('/profiles/manage', [ProfileManagementController::class, 'index'])->name('profiles.manage');
    Route::get('/profiles/edit/{user}', [ProfileManagementController::class, 'edit'])->name('profiles.edit_form');
    Route::patch('/profiles/update/{user}', [ProfileManagementController::class, 'update'])->name('profiles.update');
    Route::delete('/profiles/{user}', [ProfileManagementController::class, 'destroy'])->name('profiles.destroy');

    //Rotas de admin
    Route::middleware('admin')->group(function () {
        Route::get('/profiles/create', [ProfileManagementController::class, 'create'])->name('profiles.create');
        Route::post('/profiles', [ProfileManagementController::class, 'store'])->name('profiles.store');
    });

    //Rotas de switch de perfil
    Route::post('/profiles/switch/{user}', [ProfileManagementController::class, 'switch'])->name('profiles.switch');
});

//Rotas de autenticação
require __DIR__ . '/auth.php';
