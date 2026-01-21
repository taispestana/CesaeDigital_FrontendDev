<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use App\Models\Movie;
use App\Models\Category;


class MovieSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        $marvel = Category::where('name', 'Marvel')->first();
    $starwars = Category::where('name', 'Star Wars')->first();

    Movie::create([
        'category_id' => $marvel->id,
        'title' => 'Avengers: Endgame',
        'image' => 'https://via.placeholder.com/200x300.png?text=Avengers',
        'release_date' => '2019-04-26'
    ]);

    Movie::create([
        'category_id' => $starwars->id,
        'title' => 'The Mandalorian',
        'image' => 'https://via.placeholder.com/200x300.png?text=Mandalorian',
        'release_date' => '2019-11-12'
    ]);
    }
}
