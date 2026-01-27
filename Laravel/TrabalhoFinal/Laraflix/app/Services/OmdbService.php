<?php

namespace App\Services;

use Illuminate\Support\Facades\Http;

class OmdbService
{
    protected $apiKey;
    protected $baseUrl = 'http://www.omdbapi.com/';

    public function __construct()
    {
        $this->apiKey = config('services.omdb.key');
    }

    /**
     * Search for a movie by its title.
     *
     * @param string $title
     * @return array|null
     */
    public function fetchMovieByTitle(string $title)
    {
        if (!$this->apiKey) {
            \Illuminate\Support\Facades\Log::error("OMDb API Key is missing!");
            return null;
        }

        \Illuminate\Support\Facades\Log::info("OMDb: Fetching movie '{$title}'");

        $response = Http::withoutVerifying()->get($this->baseUrl, [
            'apikey' => $this->apiKey,
            't' => $title,
            'plot' => 'full'
        ]);

        if ($response->successful()) {
            if ($response->json('Response') === 'True') {
                \Illuminate\Support\Facades\Log::info("OMDb: SUCCESS for '{$title}'");
                return $response->json();
            } else {
                \Illuminate\Support\Facades\Log::warning("OMDb: Error for '{$title}': " . $response->json('Error'));
            }
        } else {
            \Illuminate\Support\Facades\Log::error("OMDb: Request FAILED for '{$title}' with status: " . $response->status());
        }

        return null;
    }
}
