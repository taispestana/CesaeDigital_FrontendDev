<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Laraflix - Acesso ilimitado a filmes, séries e muito mais</title>
    <link rel="icon" type="image/png" href="{{ asset('favicon.png') }}">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Outfit:wght@400;700;900&display=swap" rel="stylesheet">
    @vite(['resources/css/app.css', 'resources/js/app.js'])
    <style>
        body {
            font-family: 'Outfit', sans-serif;
            background-color: #000;
            color: #fff;
            overflow-x: hidden;
        }

        .hero-section {
            position: relative;
            height: 100vh;
            width: 100%;
            background: url('/images/hero-bg.png') no-repeat center center/cover;
        }

        .hero-overlay {
            position: absolute;
            inset: 0;
            background: radial-gradient(circle, rgba(0, 0, 0, 0.3) 0%, rgba(0, 0, 0, 0.8) 100%), linear-gradient(to top, #000 0%, transparent 40%), linear-gradient(to bottom, #000 0%, transparent 20%);
        }

        .netflix-red {
            color: #E50914;
        }

        .bg-netflix-red {
            background-color: #E50914;
        }

        .bg-netflix-red:hover {
            background-color: #C11119;
        }

        .logo {
            font-size: 2.5rem;
            font-weight: 900;
            letter-spacing: -2px;
            text-transform: uppercase;
            color: #E50914;
            text-decoration: none;
            display: inline-block;
            transition: transform 0.3s ease;
        }

        .logo:hover {
            transform: scale(1.05);
        }
    </style>
</head>

<body class="antialiased">
    <div class="hero-section">
        <div class="hero-overlay"></div>
        <header class="relative z-10 flex items-center justify-between px-6 py-4 lg:px-12">
            <a href="/" class="logo">Laraflix</a>
            <div class="flex items-center gap-4">
                @if (Route::has('login'))
                    <a href="{{ route('login') }}"
                        class="bg-netflix-red text-white px-4 py-1.5 rounded font-bold text-sm transition transition-all duration-300">Iniciar
                        sessão</a>
                @endif
            </div>
        </header>

        <div class="relative z-10 flex flex-col items-center justify-center h-full text-center px-4 max-w-4xl mx-auto">
            <h1 class="text-4xl lg:text-5xl xl:text-6xl font-black mb-4 leading-tight">
                Acesso ilimitado a filmes, séries e muito mais
            </h1>
            <p class="text-lg lg:text-2xl mb-6">
                A partir de 8,99 €. Cancele quando quiser.
            </p>
            <div class="w-full max-w-2xl mt-4">
                <p class="text-lg mb-4">
                    Quer começar a ver? Introduza o seu e-mail para criar ou reativar a sua conta.
                </p>
                <form action="{{ route('register') }}" method="GET" class="flex flex-col md:flex-row gap-2 w-full">
                    <input type="email" placeholder="Endereço de e-mail" required
                        class="flex-grow bg-black/60 border border-white/30 px-4 py-4 rounded text-white focus:outline-none focus:ring-2 focus:ring-white/50 backdrop-blur-sm">
                    <button type="submit"
                        class="bg-netflix-red text-white px-8 py-4 rounded font-black text-xl flex items-center justify-center gap-2 transition transition-all duration-300 transform hover:scale-105 active:scale-95 group">
                        Começar
                        <svg xmlns="http://www.w3.org/2000/svg"
                            class="h-6 w-6 transition-transform group-hover:translate-x-1" fill="none"
                            viewBox="0 0 24 24" stroke="currentColor">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 5l7 7-7 7" />
                        </svg>
                    </button>
                </form>
            </div>
        </div>
    </div>

    <div class="relative bg-black pt-12 pb-24 px-6">
        <div class="max-w-6xl mx-auto text-center">
            <div class="h-1 bg-gradient-to-r from-transparent via-netflix-red to-transparent opacity-50 mb-12"></div>
            <h2 class="text-2xl font-bold mb-4 opacity-70">Tendências agora</h2>
            <div class="grid grid-cols-2 md:grid-cols-4 lg:grid-cols-6 gap-4">
                {{-- Placeholder for trending movies --}}
                @for ($i = 1; $i <= 6; $i++)
                    <div
                        class="aspect-[2/3] bg-zinc-900 rounded-lg overflow-hidden relative group cursor-pointer transition-transform duration-300 hover:scale-110 z-0 hover:z-10 shadow-2xl">
                        <div
                            class="absolute inset-0 bg-gradient-to-t from-black via-transparent to-transparent opacity-0 group-hover:opacity-100 transition-opacity">
                        </div>
                        <div
                            class="absolute bottom-0 left-0 p-4 transform translate-y-4 group-hover:translate-y-0 transition-transform">
                            <span class="bg-netflix-red text-[10px] font-bold px-2 py-0.5 rounded">NOVO</span>
                        </div>
                    </div>
                @endfor
            </div>
        </div>
    </div>
</body>

</html>