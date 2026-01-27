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
        $categories = [
            'Ação' => ['Gladiator', 'The Dark Knight', 'John Wick', 'Mad Max: Fury Road'],
            'Ficção Científica' => ['Inception', 'The Matrix', 'Interstellar', 'Blade Runner 2049'],
            'Drama' => ['The Shawshank Redemption', 'Forrest Gump', 'Parasite', 'The Green Mile'],
            'Clássicos' => ['The Godfather', 'Pulp Fiction', 'Schindler\'s List', 'Citizen Kane'],
        ];

        foreach ($categories as $categoryName => $movieTitles) {
            $category = Category::where('name', $categoryName)->first();

            if ($category) {
                foreach ($movieTitles as $title) {
                    Movie::updateOrCreate(
                        ['title' => $title],
                        [
                            'category_id' => $category->id,
                            'release_date' => now()->subYears(rand(1, 30))->format('Y-m-d'),
                            'image' => null, // OMDb will fill this
                        ]
                    );
                }
            }
        }
    }
}
