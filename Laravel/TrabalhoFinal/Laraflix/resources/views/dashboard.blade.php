<x-app-layout>
    <style>
        body {
            background-color: #141414;
            color: #fff;
        }

        .hero-banner {
            position: relative;
            height: 80vh;
            background: linear-gradient(to top, #141414 0%, transparent 20%),
                linear-gradient(to right, rgba(0, 0, 0, 0.8) 0%, transparent 60%),
                url('https://occ-0-1168-299.1.nflxso.net/dnm/api/v6/6AYY38jnywDWOOMBv7qDX6UpBAM/AAAABZ-E7YyP_f_f_f_f.jpg') no-repeat center center/cover;
            display: flex;
            align-items: center;
            padding: 0 4%;
        }

        .netflix-nav {
            background-color: transparent;
            transition: background-color 0.3s;
            position: fixed;
            top: 0;
            width: 100%;
            z-index: 50;
            display: flex;
            align-items: center;
            padding: 15px 4%;
        }

        .netflix-nav.scrolled {
            background-color: #141414;
        }

        .logo-red {
            color: #E50914;
            font-weight: 900;
            font-size: 1.8rem;
            letter-spacing: -1px;
            text-transform: uppercase;
            margin-right: 30px;
        }

        .nav-link-custom {
            font-size: 0.85rem;
            color: #e5e5e5;
            margin-right: 20px;
            transition: color 0.3s;
        }

        .nav-link-custom:hover {
            color: #b3b3b3;
        }

        .nav-link-custom.active {
            font-weight: bold;
            color: #fff;
        }

        .row-container {
            padding: 0 4%;
            margin-bottom: 2rem;
            position: relative;
            z-index: 10;
            margin-top: -50px;
        }

        .row-title {
            font-size: 1.4vw;
            font-weight: bold;
            margin-bottom: 10px;
            color: #e5e5e5;
        }

        .movie-card {
            aspect-ratio: 16/9;
            background-color: #333;
            border-radius: 4px;
            overflow: hidden;
            transition: transform 0.3s, z-index 0.3s;
            flex-shrink: 0;
            cursor: pointer;
            position: relative;
        }

        .movie-card:hover { transform: scale(1.1); z-index: 20; box-shadow: 0px 10px 20px rgba(0,0,0,0.5); }
        .movie-grid { display: flex; gap: 10px; overflow-x: auto; padding: 20px 0; scrollbar-width: none; }
        .movie-grid::-webkit-scrollbar { display: none; }
        
        .rating-badge { position: absolute; top: 10px; right: 10px; background: rgba(0,0,0,0.7); padding: 2px 6px; border-radius: 4px; font-size: 10px; font-weight: bold; border: 1px solid rgba(255,255,255,0.2); }

        .btn-white {
            background-color: #fff;
            color: #000;
            padding: 10px 25px;
            border-radius: 4px;
            font-weight: bold;
            display: inline-flex;
            align-items: center;
            gap: 10px;
            transition: opacity 0.2s;
        }

        .btn-white:hover {
            opacity: 0.8;
        }

        .btn-gray {
            background-color: rgba(109, 109, 110, 0.7);
            color: #fff;
            padding: 10px 25px;
            border-radius: 4px;
            font-weight: bold;
            display: inline-flex;
            align-items: center;
            gap: 10px;
            transition: background-color 0.2s;
        }

        .btn-gray:hover {
            background-color: rgba(109, 109, 110, 0.4);
        }
    </style>

    <div class="min-h-screen bg-[#141414] font-sans">
        {{-- Custom Navigation --}}
        <div id="navbar" class="netflix-nav">
            <a href="/" class="logo-red">Laraflix</a>
            <div class="hidden lg:flex flex-grow">
                <a href="#" class="nav-link-custom active">Página inicial</a>
                <a href="#" class="nav-link-custom">Séries</a>
                <a href="#" class="nav-link-custom">Filmes</a>
                <a href="#" class="nav-link-custom">Novidades mais vistas</a>
                <a href="#" class="nav-link-custom">A minha lista</a>
            </div>
            <div class="flex items-center gap-6">
                <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6 text-white cursor-pointer" fill="none"
                    viewBox="0 0 24 24" stroke="currentColor">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                        d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z" />
                </svg>
                <span class="text-sm cursor-pointer hidden md:block">Crianças</span>
                <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6 text-white cursor-pointer" fill="none"
                    viewBox="0 0 24 24" stroke="currentColor">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                        d="M15 17h5l-1.405-1.405A2.032 2.032 0 0118 14.158V11a6.002 6.002 0 00-4-5.659V5a2 2 0 10-4 0v.341C7.67 6.165 6 8.388 6 11v3.159c0 .538-.214 1.055-.595 1.436L4 17h5m6 0v1a3 3 0 11-6 0v-1m6 0H9" />
                </svg>
                <div class="relative" x-data="{ open: false }" @click.away="open = false">
                    <div @click="open = !open" class="flex items-center gap-2 cursor-pointer group">
                        <div class="w-8 h-8 rounded bg-blue-500 overflow-hidden">
                            <img src="https://wallpapers.com/images/hd/netflix-profile-pictures-1000-x-1000-qo9h82134t9nv0j0.jpg"
                                alt="Profile">
                        </div>
                        <svg xmlns="http://www.w3.org/2000/svg" class="h-4 w-4 text-white transition-transform" :class="open ? 'rotate-180' : ''" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M19 9l-7 7-7-7" />
                        </svg>
                    </div>

                    {{-- Dropdown Menu --}}
                    <div x-show="open" 
                         x-transition:enter="transition ease-out duration-100"
                         x-transition:enter-start="transform opacity-0 scale-95"
                         x-transition:enter-end="transform opacity-100 scale-100"
                         class="absolute right-0 mt-2 w-56 bg-black/90 border border-zinc-800 shadow-2xl z-50 py-2">
                        
                        {{-- Arrow Top --}}
                        <div class="absolute -top-2 right-4 w-0 h-0 border-l-[8px] border-l-transparent border-r-[8px] border-r-transparent border-b-[8px] border-b-black/90"></div>

                        {{-- Profile List --}}
                        <div class="px-2 border-b border-zinc-800 pb-2 mb-2">
                            <div class="flex items-center gap-3 p-2 hover:underline cursor-pointer">
                                <div class="w-8 h-8 rounded bg-green-500 overflow-hidden shrink-0">
                                    <img src="https://upload.wikimedia.org/wikipedia/commons/0/0b/Netflix-avatar.png" alt="Profile">
                                </div>
                                <span class="text-xs font-bold">{{ Auth::user()->name }}</span>
                            </div>
                            <div class="flex items-center gap-3 p-2 hover:underline cursor-pointer opacity-70">
                                <div class="w-8 h-8 rounded bg-yellow-500 overflow-hidden shrink-0 text-center flex items-center justify-center">
                                    <span class="text-[10px] font-bold">Kids</span>
                                </div>
                                <span class="text-xs font-bold">Infantil</span>
                            </div>
                        </div>

                        {{-- Secondary Menu --}}
                        <div class="px-2">
                            <a href="#" class="flex items-center gap-3 p-2 hover:underline text-xs group">
                                <svg class="h-5 w-5 opacity-70 group-hover:opacity-100" fill="none" viewBox="0 0 24 24" stroke="currentColor"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15.232 5.232l3.536 3.536m-2.036-5.036a2.5 2.5 0 113.536 3.536L6.5 21.036H3v-3.572L16.732 3.732z" /></svg>
                                Gerir perfis
                            </a>
                            <a href="#" class="flex items-center gap-3 p-2 hover:underline text-xs group">
                                <svg class="h-5 w-5 opacity-70 group-hover:opacity-100" fill="none" viewBox="0 0 24 24" stroke="currentColor"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="1.5" d="M16 17l-4 4m0 0l-4-4m4 4V3" /></svg>
                                Transferir perfil
                            </a>
                            <a href="{{ route('profile.edit') }}" class="flex items-center gap-3 p-2 hover:underline text-xs group">
                                <svg class="h-5 w-5 opacity-70 group-hover:opacity-100" fill="none" viewBox="0 0 24 24" stroke="currentColor"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M16 7a4 4 0 11-8 0 4 4 0 018 0zM12 14a7 7 0 00-7 7h14a7 7 0 00-7-7z" /></svg>
                                Conta
                            </a>
                            <a href="#" class="flex items-center gap-3 p-2 hover:underline text-xs group border-b border-zinc-800 pb-3 mb-2">
                                <svg class="h-5 w-5 opacity-70 group-hover:opacity-100" fill="none" viewBox="0 0 24 24" stroke="currentColor"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M8.228 9c.549-1.165 2.03-2 3.772-2 2.21 0 4 1.343 4 3 0 1.4-1.278 2.575-3.006 2.907-.542.104-.994.54-.994 1.093m0 3h.01M21 12a9 9 0 11-18 0 9 9 0 0118 0z" /></svg>
                                Centro de Assistência
                            </a>
                        </div>

                        {{-- Logout --}}
                        <div class="px-2 pb-1">
                            <form method="POST" action="{{ route('logout') }}">
                                @csrf
                                <button type="submit" class="w-full text-center p-2 hover:underline text-xs font-bold pt-2">
                                    Sair da Laraflix
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        {{-- Hero Section --}}
        <div class="hero-banner">
            <div class="max-w-xl">
                <h1 class="text-6xl font-black mb-4 uppercase tracking-tighter">Machos Alfa</h1>
                <p class="text-xl mb-6 font-medium leading-normal drop-shadow-md">
                    O berço, o carrinho, a cadeirinha, as fraldas, o leite em pó... Quatro amigos em plena crise de
                    masculinidade tentam adaptar-se aos novos tempos.
                </p>
                <div class="flex gap-3">
                    <button class="btn-white">
                        <svg class="h-6 w-6 fill-current" viewBox="0 0 24 24">
                            <path d="M6 4l15 8-15 8V4z" />
                        </svg>
                        Ver
                    </button>
                    <button class="btn-gray">
                        <svg class="h-6 w-6 text-white" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                d="M13 16h-1v-4h-1m1-4h.01M21 12a9 9 0 11-18 0 9 9 0 0118 0z" />
                        </svg>
                        Mais informações
                    </button>
                </div>
            </div>
            <div class="absolute bottom-10 right-0 p-3 bg-zinc-800/60 border-l-4 border-zinc-400 text-sm px-6">
                13+
            </div>
        </div>

        {{-- Rows section --}}
        <div class="pb-20 relative z-20" x-data="{ selectedMovie: null }">
            @foreach ($categories as $category)
                @if ($category->movies->count() > 0)
                    <div class="row-container mb-12">
                        <h2 class="row-title">{{ $category->name }}</h2>
                        <div class="movie-grid">
                            @foreach ($category->movies as $movie)
                                <div class="movie-card w-44 md:w-56 lg:w-64" @click="selectedMovie = {{ json_encode($movie) }}">
                                    @if($movie->rating)
                                        <div class="rating-badge text-netflix-red">IMDb {{ $movie->rating }}</div>
                                    @endif
                                    <img src="{{ $movie->poster_url ?: ($movie->image ? asset('storage/' . $movie->image) : 'https://via.placeholder.com/300x169/1a1a1a/ffffff?text=' . urlencode($movie->title)) }}"
                                        alt="{{ $movie->title }}" class="w-full h-full object-cover">
                                    <div
                                        class="absolute inset-0 bg-black/40 opacity-0 hover:opacity-100 transition-opacity flex items-end p-2">
                                        <p class="text-[10px] font-bold text-white uppercase">{{ $movie->title }}</p>
                                    </div>
                                </div>
                            @endforeach
                            {{-- Fill with placeholders if few movies --}}
                            @if ($category->movies->count() < 6)
                                @for ($i = 0; $i < (6 - $category->movies->count()); $i++)
                                    <div class="movie-card w-44 md:w-56 lg:w-64">
                                        <img src="https://via.placeholder.com/300x169/222/555?text=Laraflix"
                                            class="w-full h-full object-cover">
                                    </div>
                                @endfor
                            @endif
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
                                    <button class="bg-zinc-800/80 p-2 rounded-full border border-zinc-500"><svg class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 4v16m8-8H4" /></svg></button>
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

    <script>
        window.onscroll = function () {
            var nav = document.getElementById('navbar');
            if (window.pageYOffset > 50) {
                nav.classList.add("scrolled");
            } else {
                nav.classList.remove("scrolled");
            }
        };
    </script>
</x-app-layout>