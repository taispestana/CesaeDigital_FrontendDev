<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration {
    /**
     * Adiciona o campo role na tabela users
     */
    public function up(): void
    {
        Schema::table('users', function (Blueprint $table) {
            // Define o padrão como 'user', mas permite ser 'admin'
            $table->string('role')->default('user');
        });
    }

    /**
     * Remove o campo role da tabela users
     */
    public function down(): void
    {
        Schema::table('users', function (Blueprint $table) {
            //
        });
    }
};
