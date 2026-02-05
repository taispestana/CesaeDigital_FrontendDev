<?php

namespace App\Http\Controllers;

use App\Models\Movie;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;

class WatchlistController extends Controller
{
    /**
     * Função que exibe a lista de filmes favoritos do usuário
     */
    public function index()
    {
        $user = Auth::user();
        $movies = $user->watchlist()->latest()->get();

        return view('watchlist.index', compact('movies'));
    }

    /**
     * Função que adiciona ou remove um filme da lista de favoritos do usuário
     */
    public function toggle(Request $request)
    {
        $request->validate([
            'movie_id' => 'required|exists:movies,id',
        ]);

        $user = Auth::user();
        $movie_id = $request->movie_id;

        $status = $user->watchlist()->toggle($movie_id);

        // Checa se o filme foi adicionado ou removido
        $is_in_watchlist = count($status['attached']) > 0;

        return response()->json([
            'success' => true,
            'is_in_watchlist' => $is_in_watchlist,
            'message' => $is_in_watchlist ? 'Adicionado à sua lista' : 'Removido da sua lista'
        ]);
    }

    /**
     * Função que verifica se um filme está na lista de favoritos do usuário
     */
    public function check(Movie $movie)
    {
        $is_in_watchlist = Auth::user()->watchlist()->where('movie_id', $movie->id)->exists();

        return response()->json([
            'is_in_watchlist' => $is_in_watchlist
        ]);
    }
}
