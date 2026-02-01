<x-app-layout>
    <style>
        .hero-banner {
            position: relative;
            height: 90vh;
            background-size: cover;
            background-position: center top;
            display: flex;
            align-items: center;
            padding: 0 4%;
            margin-top: -70px; /* Pull content up under transparent nav */
        }

        .hero-overlay {
            position: absolute;
            inset: 0;
            background: linear-gradient(70deg, rgba(0, 0, 0, 0.9) 0%, rgba(0, 0, 0, 0.4) 40%, transparent 70%),
                        linear-gradient(to top, #141414 0%, transparent 20%),
                        linear-gradient(to bottom, rgba(0,0,0,0.5) 0%, transparent 15%);
            z-index: 1;
        }

        .hero-content {
            position: relative;
            z-index: 10;
            max-width: 40%;
            margin-top: 50px;
        }

        .hero-title {
            font-size: 5rem;
            font-weight: 900;
            margin-bottom: 1.5rem;
            line-height: 1;
            text-shadow: 2px 2px 10px rgba(0,0,0,0.5);
        }

        .hero-synopsis {
            font-size: 1.2rem;
            line-height: 1.4;
            margin-bottom: 2rem;
            color: #fff;
            text-shadow: 1px 1px 5px rgba(0,0,0,0.8);
            display: -webkit-box;
            -webkit-line-clamp: 3;
            -webkit-box-orient: vertical;
            overflow: hidden;
        }

        .maturity-badge {
            position: absolute;
            right: 0;
            bottom: 20%;
            background: rgba(51, 51, 51, 0.6);
            border-left: 3px solid #dcdcdc;
            padding: 0.5rem 3rem 0.5rem 1rem;
            font-size: 1.1rem;
            color: #fff;
            z-index: 10;
        }

        .row-container {
            padding: 0 4%;
            margin-bottom: 3rem;
            position: relative;
            z-index: 10;
        }

        .row-title {
            font-size: 1.4rem;
            font-weight: 700;
            margin-bottom: 0.5rem;
            color: #e5e5e5;
            transition: color 0.3s;
        }

        .row-title:hover {
            color: #fff;
        }

        .movie-card {
            position: relative;
            aspect-ratio: 16/9;
            background-color: #333;
            border-radius: 4px;
            overflow: visible;
            transition: transform 0.4s cubic-bezier(0.33, 1, 0.68, 1);
            flex-shrink: 0;
            cursor: pointer;
            width: 280px;
        }

        .movie-card:hover { 
            transform: scale(1.15); 
            z-index: 50; 
            box-shadow: 0px 15px 30px rgba(0,0,0,0.7); 
        }

        .movie-grid { 
            display: flex; 
            gap: 8px; 
            overflow-x: auto; 
            padding: 20px 0 40px 0; 
            scrollbar-width: none; 
            scroll-behavior: smooth;
        }
        
        .movie-grid::-webkit-scrollbar { display: none; }
        
        .movie-img {
            width: 100%;
            height: 100%;
            object-fit: cover;
            border-radius: 4px;
        }

        /* Netflix-style Badges */
        .top10-badge {
            position: absolute;
            top: 0;
            right: 0;
            background-color: #E50914;
            color: white;
            font-size: 0.6rem;
            font-weight: 900;
            padding: 2px 4px;
            border-bottom-left-radius: 2px;
            text-transform: uppercase;
            z-index: 10;
        }

        .bottom-badge {
            position: absolute;
            bottom: 8px;
            left: 50%;
            transform: translateX(-50%);
            background-color: #E50914;
            color: white;
            font-size: 10px;
            font-weight: 800;
            padding: 1px 6px;
            white-space: nowrap;
            border-radius: 2px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.5);
            pointer-events: none;
        }

        .rating-badge { 
            position: absolute; 
            top: 8px; 
            left: 8px; 
            background: rgba(0,0,0,0.6); 
            backdrop-filter: blur(4px);
            padding: 2px 6px; 
            border-radius: 2px; 
            font-size: 10px; 
            font-weight: bold; 
            border: 1px solid rgba(255,255,255,0.2); 
            z-index: 5;
        }

        /* Navigation Arrows */
        .nav-arrow {
            position: absolute;
            top: 60px;
            bottom: 40px;
            width: 4%;
            background: rgba(0,0,0,0.5);
            display: flex;
            align-items: center;
            justify-content: center;
            z-index: 60;
            opacity: 0;
            transition: all 0.3s ease;
            cursor: pointer;
            border: none;
            color: white;
        }

        .row-container:hover .nav-arrow {
            opacity: 1;
        }

        .nav-arrow:hover {
            background: rgba(0,0,0,0.8);
            scale: 1.1;
        }

        .left-arrow { left: 0; border-radius: 0 4px 4px 0; }
        .right-arrow { right: 0; border-radius: 4px 0 0 4px; }

        .nav-arrow svg {
            width: 2rem;
            height: 2rem;
        }
    </style>

    <div class="font-sans">
        {{-- Hero Section --}}
        @if($featured)
            <div class="hero-banner" style="background-image: url('{{ str_replace('SX300', 'SX1920', $featured['Poster']) }}')">
                <div class="hero-overlay"></div>

                <div class="hero-content">
                    <h1 class="hero-title">{{ $featured['Title'] }}</h1>
                    <p class="hero-synopsis">
                        {{ $featured['Plot'] }}
                    </p>
                    <div class="flex gap-4">
                        <button class="btn-white">
                            <svg class="h-8 w-8 fill-current" viewBox="0 0 24 24">
                                <path d="M6 4l15 8-15 8V4z" />
                            </svg>
                            Ver
                        </button>
                        <button class="btn-gray">
                            <svg class="h-8 w-8" fill="none" viewBox="0 0 24 24" stroke="currentColor">
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
            {{-- Fallback Hero --}}
            <div class="hero-banner" style="background-image: url('https://occ-0-1168-299.1.nflxso.net/dnm/api/v6/6AYY38jnywDWOOMBv7qDX6UpBAM/AAAABZ-E7YyP_f_f_f_f.jpg')">
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

        {{-- Rows section --}}
        <div class="pb-20 relative z-20" x-data="{ 
            selectedMovie: null,
            isInWatchlist: false,
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
                    }
                } catch (error) {
                    console.error('Error toggling watchlist:', error);
                }
            },
            async checkWatchlist(movie) {
                this.selectedMovie = movie;
                try {
                    const response = await fetch(`/watchlist/check/${movie.id}`);
                    const data = await response.json();
                    this.isInWatchlist = data.is_in_watchlist;
                } catch (error) {
                    console.error('Error checking watchlist:', error);
                }
            }
        }">
            @foreach ($categories as $category)
                @if ($category->movies->count() > 0)
                    <div class="row-container group" 
                         x-data="{ 
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
                         }"
                         x-init="setTimeout(() => updateArrows(), 100)">

                        <h2 class="row-title">{{ $category->name }}</h2>

                        {{-- Arrows --}}
                        <button class="nav-arrow left-arrow" @click="prev()" x-show="canScrollLeft" x-transition>
                            <svg fill="none" stroke="currentColor" viewBox="0 0 24 24"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15 19l-7-7 7-7"></path></svg>
                        </button>
                        <button class="nav-arrow right-arrow" @click="next()" x-show="canScrollRight" x-transition>
                            <svg fill="none" stroke="currentColor" viewBox="0 0 24 24"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 5l7 7-7 7"></path></svg>
                        </button>

                        <div class="movie-grid" x-ref="grid" @scroll.debounce.100ms="updateArrows()">
                            @foreach ($category->movies as $movie)
                                <div class="movie-card" @click="checkWatchlist({{ json_encode($movie) }})">
                                    {{-- Random Badges --}}
                                    @php
                                        $randomBadge = rand(1, 10);
                                    @endphp

                                    @if($randomBadge == 1)
                                        <div class="top10-badge">TOP 10</div>
                                    @endif

                                    @if($movie->rating)
                                        <div class="rating-badge text-white">★ {{ $movie->rating }}</div>
                                    @endif

                                    <img src="{{ $movie->poster_url ?: ($movie->image ? asset('storage/' . $movie->image) : 'https://via.placeholder.com/300x169/1a1a1a/ffffff?text=' . urlencode($movie->title)) }}"
                                        alt="{{ $movie->title }}" class="movie-img">

                                    @if($randomBadge == 2)
                                        <div class="bottom-badge">Nova temporada</div>
                                    @elseif($randomBadge == 3)
                                        <div class="bottom-badge">Adicionado recentemente</div>
                                    @endif

                                    <div class="absolute inset-0 bg-gradient-to-t from-black/80 via-transparent to-transparent opacity-0 hover:opacity-100 transition-opacity flex items-end p-3">
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
                <div class="fixed inset-0 z-[100] flex items-center justify-center p-4 bg-black/80 backdrop-blur-sm" @click.self="selectedMovie = null">
                    <div class="bg-[#181818] w-full max-w-3xl rounded-lg overflow-hidden relative shadow-2xl animate-fade-in-up">
                        <button @click="selectedMovie = null" class="absolute top-4 right-4 z-10 bg-[#181818] p-2 rounded-full hover:bg-zinc-800">
                             <svg class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M6 18L18 6M6 6l12 12" /></svg>
                        </button>
                        
                        <div class="aspect-video w-full relative">
                            <img :src="selectedMovie.poster_url || 'https://via.placeholder.com/800x450/1a1a1a/ffffff?text=Laraflix'" class="w-full h-full object-cover">
                            <div class="absolute inset-0 bg-gradient-to-t from-[#181818] via-transparent to-transparent"></div>
                            <div class="absolute bottom-8 left-12">
                                <h3 class="text-4xl font-bold mb-4" x-text="selectedMovie.title"></h3>
                                <div class="flex gap-4">
                                    <button class="btn-white">Ver agora</button>
                                    <button @click="toggleWatchlist()" 
                                            class="p-2 rounded-full border border-zinc-500 transition-colors"
                                            :class="isInWatchlist ? 'bg-white text-black border-white' : 'bg-zinc-800/80 text-white hover:bg-zinc-700'">
                                        <svg x-show="!isInWatchlist" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 4v16m8-8H4" /></svg>
                                        <svg x-show="isInWatchlist" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 13l4 4L19 7" /></svg>
                                    </button>
                                </div>
                            </div>
                        </div>

                        <div class="p-12 pt-4">
                            <div class="flex gap-4 items-center mb-6">
                                <span class="text-green-500 font-bold" x-show="selectedMovie.rating" x-text="'IMDb: ' + selectedMovie.rating"></span>
                                <span x-text="new Date(selectedMovie.release_date).getFullYear()" class="text-zinc-400"></span>
                            </div>
                            <p class="text-lg leading-relaxed text-zinc-300" x-text="selectedMovie.synopsis || 'Nenhuma sinopse disponível para este título.'"></p>
                        </div>
                    </div>
                </div>
            </template>
        </div>
    </div>
</x-app-layout>