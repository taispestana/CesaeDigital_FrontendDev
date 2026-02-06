<x-main-layout>

    {{-- Livewire que controla o watchlist --}}
    <div class="font-sans" x-data="{ 
        selectedMovie: null,
        isInWatchlist: false,
        async toggleWatchlist() {
            if (!this.selectedMovie || !this.selectedMovie.id) return;
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
                }
            } catch (error) {
                console.error('Error toggling watchlist:', error);
            }
        },
        async checkWatchlist(movie) {
            this.selectedMovie = movie;
            if (!movie.id) {
                this.isInWatchlist = false;
                return;
            }
            try {
                const response = await fetch(`/watchlist/check/${movie.id}`);
                const data = await response.json();
                this.isInWatchlist = data.is_in_watchlist;
            } catch (error) {
                console.error('Error checking watchlist:', error);
            }
        }
    }">
        {{-- Hero --}}
        @if($featured)
                <div class="hero-banner"
                    style="background-image: url('{{ $featured['Backdrop'] ?? str_replace('SX300', 'SX1920', $featured['Poster']) }}'); background-position: center 20%;">
                    <div class="hero-overlay"></div>

                    <div class="hero-brand-logo">
                        <span class="logo-red">Laraflix</span>
                    </div>

                    <div class="hero-content">
                        <div class="series-tag">Série original</div>

                        @if(isset($featured['LogoUrl']) && $featured['LogoUrl'])
                            <img src="{{ $featured['LogoUrl'] }}" alt="{{ $featured['Title'] }}" class="hero-logo-img"
                                onerror="this.style.display='none'">
                        @else
                            <h1 class="hero-title">{{ $featured['Title'] }}</h1>
                        @endif

                        <p class="hero-synopsis">
                            {{ $featured['Plot'] }}
                        </p>
                        <div class="flex gap-4">
                            <button class="btn-white">
                                <svg class="h-6 w-6 fill-current" viewBox="0 0 24 24">
                                    <path d="M6 4l15 8-15 8V4z" />
                                </svg>
                                Ver agora
                            </button>
                            <button class="btn-gray" @click="checkWatchlist({{ json_encode([
                'id' => $featured['id'] ?? null,
                'title' => $featured['Title'],
                'synopsis' => $featured['Plot'],
                'rating' => $featured['imdbRating'] ?? null,
                'release_date' => $featured['Released'] ?? $featured['Year'] ?? null,
                'poster_url' => str_replace('SX300', 'SX1920', $featured['Poster']),
                'backdrop_url' => $featured['Backdrop'] ?? null,
            ]) }})">
                                <svg class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                        d="M13 16h-1v-4h-1m1-4h.01M21 12a9 9 0 11-18 0 9 9 0 0118 0z" />
                                </svg>
                                Mais informações
                            </button>
                        </div>
                    </div>

                    <div class="maturity-badge">
                        {{ $featured['Rated'] ?? '13+' }}
                    </div>
                </div>
        @else
            {{-- Hero se não carregar --}}
            <div class="hero-banner"
                style="background-image: url('https://occ-0-1168-299.1.nflxso.net/dnm/api/v6/6AYY38jnywDWOOMBv7qDX6UpBAM/AAAABZ-E7YyP_f_f_f_f.jpg')">
                <div class="hero-overlay"></div>
                <div class="hero-content">
                    <h1 class="hero-title">Machos Alfa</h1>
                    <p class="hero-synopsis">
                        Quatro amigos em plena crise de masculinidade tentam adaptar-se aos novos tempos.
                    </p>
                    <div class="flex gap-4">
                        <button class="btn-white">Ver</button>
                        <button class="btn-gray">Mais informações</button>
                    </div>
                </div>
            </div>
        @endif

        {{-- Rows --}}
        <div class="pb-20 relative z-20">
            @foreach ($categories as $category)
                @if ($category->movies->count() > 0)
                    <div class="row-container group" x-data="{ 
                                                                    canScrollLeft: false,
                                                                    canScrollRight: true,
                                                                    updateArrows() {
                                                                        const el = this.$refs.grid;
                                                                        if (!el) return;
                                                                        this.canScrollLeft = el.scrollLeft > 10;
                                                                        this.canScrollRight = el.scrollLeft + el.offsetWidth < el.scrollWidth - 10;
                                                                    },
                                                                    next() {
                                                                        const el = this.$refs.grid;
                                                                        const step = 288;
                                                                        el.scrollBy({ left: step, behavior: 'smooth' });
                                                                        setTimeout(() => this.updateArrows(), 400);
                                                                    },
                                                                    prev() {
                                                                        const el = this.$refs.grid;
                                                                        const step = 288;
                                                                        el.scrollBy({ left: -step, behavior: 'smooth' });
                                                                        setTimeout(() => this.updateArrows(), 400);
                                                                    }
                                                                 }" x-init="setTimeout(() => updateArrows(), 100)">

                        <h2 class="row-title">{{ $category->name }}</h2>

                        {{-- Botoes de Scroll --}}
                        <button class="nav-arrow left-arrow" @click="prev()" x-show="canScrollLeft" x-transition>
                            <svg fill="none" stroke="currentColor" viewBox="0 0 24 24">
                                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15 19l-7-7 7-7">
                                </path>
                            </svg>
                        </button>
                        <button class="nav-arrow right-arrow" @click="next()" x-show="canScrollRight" x-transition>
                            <svg fill="none" stroke="currentColor" viewBox="0 0 24 24">
                                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 5l7 7-7 7"></path>
                            </svg>
                        </button>

                        {{-- Grid de Filmes --}}
                        <div class="movie-grid" x-ref="grid" @scroll.debounce.100ms="updateArrows()">
                            @foreach ($category->movies as $movie)
                                <div class="movie-card" @click="checkWatchlist({{ json_encode($movie) }})">

                                    @php
                                        $randomBadge = rand(1, 10);
                                    @endphp

                                    {{-- Badge de TOP 10 --}}
                                    @if($randomBadge == 1)
                                        <div class="top10-badge">TOP 10</div>
                                    @endif

                                    {{-- Badge de Rating --}}
                                    @if($movie->rating)
                                        <div class="rating-badge text-white">★ {{ $movie->rating }}</div>
                                    @endif

                                    {{-- Imagem do Filme --}}
                                    <img src="{{ $movie->poster_url ?: ($movie->image ? asset('storage/' . $movie->image) : 'https://via.placeholder.com/300x169/1a1a1a/ffffff?text=' . urlencode($movie->title)) }}"
                                        alt="{{ $movie->title }}" class="movie-img">

                                    {{-- Badge de Nova Temporada --}}
                                    @if($randomBadge == 2)
                                        <div class="bottom-badge">Nova temporada</div>
                                    @elseif($randomBadge == 3)
                                        <div class="bottom-badge">Adicionado recentemente</div>
                                    @endif

                                    {{-- Badge de Titulo --}}
                                    <div
                                        class="absolute inset-0 bg-gradient-to-t from-black/80 via-transparent to-transparent opacity-0 hover:opacity-100 transition-opacity flex items-end p-3">
                                        <p class="text-xs font-bold text-white uppercase tracking-wider">{{ $movie->title }}</p>
                                    </div>
                                </div>
                            @endforeach
                        </div>
                    </div>
                @endif
            @endforeach

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
                            <img :src="selectedMovie.backdrop_url || selectedMovie.poster_url || 'https://via.placeholder.com/800x450/1a1a1a/ffffff?text=Laraflix'"
                                class="w-full h-full object-cover">
                            <div
                                class="absolute inset-0 bg-gradient-to-t from-[#181818] via-transparent to-transparent">
                            </div>
                            <div class="absolute bottom-8 left-12">
                                <h3 class="text-4xl font-bold mb-4" x-text="selectedMovie.title"></h3>
                                <div class="flex gap-4">
                                    <button class="btn-white">Ver agora</button>
                                    <button @click="toggleWatchlist()" x-show="selectedMovie.id"
                                        class="p-2 rounded-full border border-zinc-500 transition-colors"
                                        :class="isInWatchlist ? 'bg-white text-black border-white' : 'bg-zinc-800/80 text-white hover:bg-zinc-700'">
                                        <svg x-show="!isInWatchlist" class="h-6 w-6" fill="none" viewBox="0 0 24 24"
                                            stroke="currentColor">
                                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                                d="M12 4v16m8-8H4" />
                                        </svg>
                                        <svg x-show="isInWatchlist" class="h-6 w-6" fill="none" viewBox="0 0 24 24"
                                            stroke="currentColor">
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
</x-main-layout>