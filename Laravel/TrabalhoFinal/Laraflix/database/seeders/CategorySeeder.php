<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use App\Models\Category;

class CategorySeeder extends Seeder
{
    /**
     * Corre as seeds de Category
     */
    public function run(): void
    {
        $categories = [
            ['name' => 'Ação'],
            ['name' => 'Ficção Científica'],
            ['name' => 'Drama'],
            ['name' => 'Clássicos'],
        ];

        foreach ($categories as $category) {
            Category::updateOrCreate(['name' => $category['name']], $category);
        }
    }
}
