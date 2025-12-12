<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        Schema::create('tasks', function (Blueprint $table) {
            //definir os campos da tabela tasks
            //convem deixar o id e como primeiro campo
            //convem deixar o timestamps e como ultimo campo

            $table->id();
            $table->string('name');
            $table->text('description')->nullable();
            $table->date('due_at')->nullable();
            $table->boolean('status')->nullable();
            $table->unsignedBigInteger('user_id');
            //chave estrangeira para a tabela users
            $table->foreign('user_id')->references('id')->on('users');
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('tasks');
    }
};
