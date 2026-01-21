<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use App\Models\Category;

class CategorySeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        Category::create([
        'name' => 'Marvel',
        'image' => 'https://via.placeholder.com/300x150.png?text=Marvel+Studios'
    ]);

    Category::create([
        'name' => 'Star Wars',
        'image' => 'https://via.placeholder.com/300x150.png?text=Star+Wars'
    ]);
    }
}
