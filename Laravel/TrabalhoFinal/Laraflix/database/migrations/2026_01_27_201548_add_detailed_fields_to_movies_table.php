<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration {
    /**
     * Run the migrations.
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
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::table('movies', function (Blueprint $table) {
            $table->dropColumn(['synopsis', 'rating', 'imdb_id', 'poster_url']);
        });
    }
};
