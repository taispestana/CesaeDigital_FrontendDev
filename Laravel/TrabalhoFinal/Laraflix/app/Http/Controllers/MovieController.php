<?php

namespace App\Http\Controllers;

use App\Models\Movie;
use App\Models\Category;
use Illuminate\Http\Request;

class MovieController extends Controller
{
    public function index()
    {
        // "withCount" cria automaticamente uma variável 'movies_count'
        $categories = Category::withCount('movies')->get();

        return view('categories.index', compact('categories'));
    }

    public function show($id)
{
    // Procura a categoria pelo ID ou dá erro 404 se não existir
    $category = Category::with('movies')->findOrFail($id);

    return view('categories.show', compact('category'));
}

public function edit(Movie $movie)
{
    // Precisamos das categorias para o utilizador poder mudar se quiser
    $categories = Category::all();
    return view('movies.edit', compact('movie', 'categories'));
}

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

public function destroy(Movie $movie)
{
    // Verifica se é admin antes de apagar (segurança extra)
    if (auth()->user()->role !== 'admin') {
        abort(403, 'Ação não autorizada.');
    }

    $categoryId = $movie->category_id;
    $movie->delete();

    return redirect()->route('categories.show', $categoryId)
                     ->with('success', 'Filme removido com sucesso!');
}
}
