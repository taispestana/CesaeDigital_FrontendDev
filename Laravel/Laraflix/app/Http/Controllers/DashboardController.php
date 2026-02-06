<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Category;
use App\Models\Movie;
use App\Services\OmdbService;
use Illuminate\Support\Facades\Log;

class DashboardController extends Controller
{
    public function index(OmdbService $omdb)
    {
        Log::info("Dashboard route HIT");
        $categories = Category::with('movies')->get();

        // Verifica se os dados do filme estão disponíveis no banco de dados
        foreach ($categories as $category) {
            foreach ($category->movies as $movie) {
                Log::info("Checking movie '{$movie->title}' (poster_url: '{$movie->poster_url}')");
                if (empty($movie->synopsis) || empty($movie->poster_url) || $movie->poster_url === 'N/A') {
                    $data = $omdb->fetchMovieByTitle($movie->title);
                    if ($data) {
                        $movie->update([
                            'synopsis' => $data['Plot'] ?? null,
                            'rating' => $data['imdbRating'] ?? null,
                            'poster_url' => $data['Poster'] ?? null,
                            'imdb_id' => $data['imdbID'] ?? null,
                        ]);
                    }
                }
            }
        }

        $featured = $omdb->fetchMovieByTitle('Younger');

        // Verifica se o filme Younger está no banco de dados
        if ($featured) {
            $dbMovie = Movie::where('title', 'Younger')->first();
            $featured['id'] = $dbMovie ? $dbMovie->id : null;
            $featured['Backdrop'] = asset('images/younger_custom_backdrop.png');
        }

        return view('dashboard', compact('categories', 'featured'));
    }
}
