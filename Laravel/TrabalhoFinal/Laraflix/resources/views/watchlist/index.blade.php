<x-app-layout>
    <x-slot name="navigation_class">solid</x-slot>

    <style>
        .row-container {
            padding: 0 4%;
            margin-top: 100px;
            margin-bottom: 3rem;
            position: relative;
            z-index: 10;
        }

        .row-title {
            font-size: 1.4rem;
            font-weight: 700;
            margin-bottom: 1.5rem;
            color: #e5e5e5;
        }

        .movie-card {
            position: relative;
            aspect-ratio: 16/9;
            background-color: #333;
            border-radius: 4px;
            overflow: visible;
            transition: transform 0.4s cubic-bezier(0.33, 1, 0.68, 1);
            cursor: pointer;
            width: 280px;
        }

        .movie-card:hover {
            transform: scale(1.15);
            z-index: 50;
            box-shadow: 0px 15px 30px rgba(0, 0, 0, 0.7);
        }

        .movie-grid {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(280px, 1fr));
            gap: 40px 8px;
            padding: 20px 0;
        }

        .movie-img {
            width: 100%;
            height: 100%;
            object-fit: cover;
            border-radius: 4px;
        }

        .rating-badge {
            position: absolute;
            top: 8px;
            left: 8px;
            background: rgba(0, 0, 0, 0.6);
            backdrop-filter: blur(4px);
            padding: 2px 6px;
            border-radius: 2px;
            font-size: 10px;
            font-weight: bold;
            border: 1px solid rgba(255, 255, 255, 0.2);
            z-index: 5;
        }
    </style>

    <div class="min-h-screen font-sans">
        <div class="row-container" x-data="{ 
            selectedMovie: null,
            isInWatchlist: true,
            async toggleWatchlist() {
                if (!this.selectedMovie) return;
                try {
                    const response = await fetch('{{ route('watchlist.toggle') }}', {
                        method: 'POST',
                        headers: {
                            'Content-Type': 'application/json',
                            'X-CSRF-TOKEN': '{{ csrf_token() }}'
                        },
                        body: JSON.stringify({ movie_id: this.selectedMovie.id })
                    });
                    const data = await response.json();
                    if (data.success) {
                        this.isInWatchlist = data.is_in_watchlist;
                        if (!data.is_in_watchlist) {
                            window.location.reload();
                        }
                    }
                } catch (error) {
                    console.error('Error toggling watchlist:', error);
                }
            },
            selectMovie(movie) {
                this.selectedMovie = movie;
                this.isInWatchlist = true;
            }
        }">
            <h1 class="row-title">A minha lista</h1>

            @if($movies->isEmpty())
                <div class="text-center py-20">
                    <p class="text-zinc-500 text-xl">Ainda não adicionou nenhum título à sua lista.</p>
                    <a href="{{ route('dashboard') }}" class="text-white mt-4 inline-block underline">Explorar filmes</a>
                </div>
            @else
                <div class="movie-grid">
                    @foreach ($movies as $movie)
                        <div class="movie-card" @click="selectMovie({{ json_encode($movie) }})">
                            @if($movie->rating)
                                <div class="rating-badge text-white">★ {{ $movie->rating }}</div>
                            @endif

                            <img src="{{ $movie->poster_url ?: ($movie->image ? asset('storage/' . $movie->image) : 'https://via.placeholder.com/300x169/1a1a1a/ffffff?text=' . urlencode($movie->title)) }}"
                                alt="{{ $movie->title }}" class="movie-img">

                            <div
                                class="absolute inset-0 bg-gradient-to-t from-black/80 via-transparent to-transparent opacity-0 hover:opacity-100 transition-opacity flex items-end p-3">
                                <p class="text-xs font-bold text-white uppercase tracking-wider">{{ $movie->title }}</p>
                            </div>
                        </div>
                    @endforeach
                </div>
            @endif

            {{-- Modal --}}
            <template x-if="selectedMovie">
                <div class="fixed inset-0 z-[100] flex items-center justify-center p-4 bg-black/80 backdrop-blur-sm"
                    @click.self="selectedMovie = null">
                    <div
                        class="bg-[#181818] w-full max-w-3xl rounded-lg overflow-hidden relative shadow-2xl animate-fade-in-up">
                        <button @click="selectedMovie = null"
                            class="absolute top-4 right-4 z-10 bg-[#181818] p-2 rounded-full hover:bg-zinc-800">
                            <svg class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                    d="M6 18L18 6M6 6l12 12" />
                            </svg>
                        </button>

                        <div class="aspect-video w-full relative">
                            <img :src="selectedMovie.poster_url || 'https://via.placeholder.com/800x450/1a1a1a/ffffff?text=Laraflix'"
                                class="w-full h-full object-cover">
                            <div
                                class="absolute inset-0 bg-gradient-to-t from-[#181818] via-transparent to-transparent">
                            </div>
                            <div class="absolute bottom-8 left-12">
                                <h3 class="text-4xl font-bold mb-4" x-text="selectedMovie.title"></h3>
                                <div class="flex gap-4">
                                    <button class="btn-white">Ver agora</button>
                                    <button @click="toggleWatchlist()"
                                        class="p-2 rounded-full border border-zinc-500 transition-colors bg-white text-black border-white">
                                        <svg class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                                d="M5 13l4 4L19 7" />
                                        </svg>
                                    </button>
                                </div>
                            </div>
                        </div>

                        <div class="p-12 pt-4">
                            <div class="flex gap-4 items-center mb-6">
                                <span class="text-green-500 font-bold" x-show="selectedMovie.rating"
                                    x-text="'IMDb: ' + selectedMovie.rating"></span>
                                <span x-text="new Date(selectedMovie.release_date).getFullYear()"
                                    class="text-zinc-400"></span>
                            </div>
                            <p class="text-lg leading-relaxed text-zinc-300"
                                x-text="selectedMovie.synopsis || 'Nenhuma sinopse disponível para este título.'"></p>
                        </div>
                    </div>
                </div>
            </template>
        </div>
    </div>
</x-app-layout>