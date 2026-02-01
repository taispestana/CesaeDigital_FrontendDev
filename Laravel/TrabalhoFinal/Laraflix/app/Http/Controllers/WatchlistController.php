<?php

namespace App\Http\Controllers;

use App\Models\Movie;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;

class WatchlistController extends Controller
{
    /**
     * Display the user's watchlist.
     */
    public function index()
    {
        $user = Auth::user();
        $movies = $user->watchlist()->latest()->get();

        return view('watchlist.index', compact('movies'));
    }

    /**
     * Toggle a movie in/out of the user's watchlist.
     */
    public function toggle(Request $request)
    {
        $request->validate([
            'movie_id' => 'required|exists:movies,id',
        ]);

        $user = Auth::user();
        $movie_id = $request->movie_id;

        $status = $user->watchlist()->toggle($movie_id);

        // Check if it was attached or detached
        $is_in_watchlist = count($status['attached']) > 0;

        return response()->json([
            'success' => true,
            'is_in_watchlist' => $is_in_watchlist,
            'message' => $is_in_watchlist ? 'Adicionado à sua lista' : 'Removido da sua lista'
        ]);
    }

    /**
     * Check if a movie is in the user's watchlist.
     */
    public function check(Movie $movie)
    {
        $is_in_watchlist = Auth::user()->watchlist()->where('movie_id', $movie->id)->exists();

        return response()->json([
            'is_in_watchlist' => $is_in_watchlist
        ]);
    }
}
