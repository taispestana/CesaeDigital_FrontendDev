<?php

namespace App\Console\Commands;

use Illuminate\Console\Command;

class TestOmdbIntegration extends Command
{
    /**
     * The name and signature of the console command.
     *
     * @var string
     */
    protected $signature = 'app:test-omdb {title}';
    protected $description = 'Test OMDb API integration';

    public function handle(\App\Services\OmdbService $omdb)
    {
        $title = $this->argument('title');
        $this->info("Searching for: {$title}...");

        $movieData = $omdb->fetchMovieByTitle($title);

        if ($movieData) {
            $this->table(['Field', 'Value'], [
                ['Title', $movieData['Title']],
                ['Year', $movieData['Year']],
                ['Rating', $movieData['imdbRating']],
                ['Plot', \Illuminate\Support\Str::limit($movieData['Plot'], 50)],
                ['IMDb ID', $movieData['imdbID']],
            ]);
            $this->info("Poster URL: " . $movieData['Poster']);
        } else {
            $this->error("No movie found or API error.");
        }
    }
}
