<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration {
    /**
     * Cria a tabela movie_user que é a lista de filmes favoritos de cada usuário
     */
    public function up(): void
    {
        Schema::create('movie_user', function (Blueprint $table) {
            $table->id();
            $table->foreignId('user_id')->constrained()->onDelete('cascade');
            $table->foreignId('movie_id')->constrained()->onDelete('cascade');
            $table->timestamps();

            $table->unique(['user_id', 'movie_id']);
        });
    }

    /**
     * Remove a tabela movie_user
     */
    public function down(): void
    {
        Schema::dropIfExists('movie_user');
    }
};
