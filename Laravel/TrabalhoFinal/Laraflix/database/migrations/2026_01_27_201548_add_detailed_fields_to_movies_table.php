<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration {
    /**
     * Adiciona os campos de sinopse, nota e poster_url na tabela movies
     */
    public function up(): void
    {
        Schema::table('movies', function (Blueprint $table) {
            $table->text('synopsis')->nullable()->after('title');
            $table->string('rating')->nullable()->after('synopsis');
            $table->string('imdb_id')->nullable()->unique()->after('rating');
            $table->text('poster_url')->nullable()->after('image');
        });
    }

    /**
     * Remove os campos de sinopse, nota e poster_url da tabela movies
     */
    public function down(): void
    {
        Schema::table('movies', function (Blueprint $table) {
            $table->dropColumn(['synopsis', 'rating', 'imdb_id', 'poster_url']);
        });
    }
};
