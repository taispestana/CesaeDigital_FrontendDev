<?php

namespace App\Providers;

use Illuminate\Support\ServiceProvider;

class AppServiceProvider extends ServiceProvider
{
    /**
     * Register any application services.
     */
    public function register(): void
    {
        //
    }

    /**
     * Compose a view com todos os usuários
     */
    public function boot(): void
    {
        \Illuminate\Support\Facades\View::composer('layouts.navigation', function ($view) {
            $view->with('allUsers', \App\Models\User::all());
        });
    }
}

