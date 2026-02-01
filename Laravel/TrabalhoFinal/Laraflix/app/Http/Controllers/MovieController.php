<?php

namespace App\Http\Controllers;

use App\Models\Movie;
use App\Models\Category;
use Illuminate\Http\Request;

class MovieController extends Controller
{
    // Função que exibe a lista de categorias
    public function index()
    {
        $categories = Category::withCount('movies')->get();

        return view('categories.index', compact('categories'));
    }

    //Função que exibe os detalhes de uma categoria
    public function show($id)
    {
        // Procura a categoria pelo ID ou dá erro 404 se não existir
        $category = Category::with('movies')->findOrFail($id);

        return view('categories.show', compact('category'));
    }

    // Função que atualiza um filme
    public function update(Request $request, Movie $movie)
    {
        $request->validate([
            'title' => 'required|string|max:255',
            'release_date' => 'required|date',
            'category_id' => 'required|exists:categories,id',
        ]);

        $movie->update($request->all());

        return redirect()->route('categories.show', $movie->category_id)
            ->with('success', 'Filme atualizado com sucesso!');
    }

}
