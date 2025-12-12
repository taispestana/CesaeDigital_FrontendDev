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
        Schema::create('flights', function (Blueprint $table) {

            //se nao colocar nada o campo é obrigatorio
            $table->id();
            $table->string('destination');
            $table->integer('passengers_number')->nullable();
            $table->boolean('on_time')->default(0);
            $table->dateTime('arrival');
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('flights');
    }
};
