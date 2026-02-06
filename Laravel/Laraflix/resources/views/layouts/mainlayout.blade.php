<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="csrf-token" content="{{ csrf_token() }}">

    <title>{{ config('app.name', 'Laraflix') }}</title>
    <link rel="icon" type="image/png" href="{{ asset('favicon.png') }}">

    <!-- Fonts -->
    <link rel="preconnect" href="https://fonts.bunny.net">
    <link href="https://fonts.bunny.net/css?family=figtree:400,500,600&display=swap" rel="stylesheet" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Outfit:wght@400;700;900&display=swap" rel="stylesheet">

    <!-- Scripts -->
    @vite(['resources/css/app.css', 'resources/js/app.js'])

    <style>
        body {
            background-color: #141414;
            color: #fff;
            font-family: 'Outfit', 'figtree', sans-serif;
            overflow-x: hidden;
            margin: 0;
        }

        /* Nav Styles from app.blade.php */
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

        .netflix-nav.scrolled,
        .netflix-nav.solid {
            background-color: #141414;
        }

        .logo-red {
            color: #E50914;
            font-weight: 900;
            font-size: 1.8rem;
            letter-spacing: -1px;
            text-transform: uppercase;
            margin-right: 30px;
            text-decoration: none;
        }

        .nav-link-custom {
            font-size: 0.85rem;
            color: #e5e5e5;
            margin-right: 20px;
            transition: color 0.3s;
            text-decoration: none;
        }

        .nav-link-custom:hover {
            color: #b3b3b3;
        }

        .nav-link-custom.active {
            font-weight: bold;
            color: #fff;
        }

        /* Buttons from app.blade.php */
        .btn-white {
            background-color: #fff;
            color: #000;
            padding: 0.8rem 2rem;
            border-radius: 4px;
            font-weight: bold;
            font-size: 1.1rem;
            display: inline-flex;
            align-items: center;
            gap: 12px;
            transition: background 0.2s;
            text-decoration: none;
            border: none;
            cursor: pointer;
        }

        .btn-white:hover {
            background-color: rgba(255, 255, 255, 0.75);
        }

        .btn-gray {
            background-color: rgba(109, 109, 110, 0.7);
            color: #fff;
            padding: 0.8rem 2rem;
            border-radius: 4px;
            font-weight: bold;
            font-size: 1.1rem;
            display: inline-flex;
            align-items: center;
            gap: 12px;
            transition: background 0.2s;
            text-decoration: none;
            border: none;
            cursor: pointer;
        }

        .btn-gray:hover {
            background-color: rgba(109, 109, 110, 0.4);
        }

        .animate-fade-in-up {
            animation: fadeInUp 0.4s ease-out;
        }

        @keyframes fadeInUp {
            from {
                opacity: 0;
                transform: translateY(20px);
            }

            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        /* Hero Styles from dashboard.blade.php */
        .hero-banner {
            position: relative;
            height: 90vh;
            background-size: cover;
            background-position: center top;
            display: flex;
            align-items: center;
            padding: 0 4%;
            margin-top: -70px;
        }

        .hero-overlay {
            position: absolute;
            inset: 0;
            background: linear-gradient(70deg, rgba(0, 0, 0, 0.9) 0%, rgba(0, 0, 0, 0.4) 40%, transparent 70%),
                linear-gradient(to top, #141414 0%, transparent 20%),
                linear-gradient(to bottom, rgba(0, 0, 0, 0.5) 0%, transparent 15%);
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
            text-shadow: 2px 2px 10px rgba(0, 0, 0, 0.5);
        }

        .hero-synopsis {
            font-size: 1.1rem;
            line-height: 1.5;
            margin-bottom: 2rem;
            color: #ddd;
            text-shadow: 1px 1px 5px rgba(0, 0, 0, 0.8);
            display: -webkit-box;
            -webkit-line-clamp: 4;
            -webkit-box-orient: vertical;
            overflow: hidden;
            font-weight: 400;
        }

        .series-tag {
            font-size: 0.9rem;
            font-weight: 900;
            letter-spacing: 4px;
            color: #fff;
            margin-bottom: 0.5rem;
            display: flex;
            align-items: center;
            gap: 10px;
            text-transform: uppercase;
        }

        .series-tag::before {
            content: "";
            display: block;
            width: 30px;
            height: 2px;
            background: #E50914;
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

        .hero-brand-logo {
            position: absolute;
            top: 20px;
            left: 50%;
            transform: translateX(-50%);
            z-index: 20;
            opacity: 0.8;
            pointer-events: none;
        }

        .hero-brand-logo .logo-red {
            font-size: 2.5rem;
            margin: 0;
        }

        .hero-logo-img {
            max-width: 450px;
            height: auto;
            margin-bottom: 2rem;
            filter: drop-shadow(0 0 15px rgba(0, 0, 0, 0.8));
            display: block;
        }

        .hero-tagline {
            font-size: 1.1rem;
            font-weight: 700;
            letter-spacing: 2px;
            color: #fff;
            margin-bottom: 1.5rem;
            text-transform: uppercase;
            opacity: 0.9;
        }

        /* Layout & Movie Cards (Common) */
        .row-container {
            padding: 0 4%;
            margin-bottom: 3rem;
            position: relative;
            z-index: 10;
        }

        /* Watchlist specific spacer */
        .row-container.watchlist-spacer {
            margin-top: 100px;
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
            box-shadow: 0px 15px 30px rgba(0, 0, 0, 0.7);
        }

        .movie-img {
            width: 100%;
            height: 100%;
            object-fit: cover;
            border-radius: 4px;
        }

        /* Movie Grid - Dashboard (Horizontal Scroll) */
        .movie-grid {
            display: flex;
            gap: 8px;
            overflow-x: auto;
            padding: 20px 0 40px 0;
            scrollbar-width: none;
            scroll-behavior: smooth;
        }

        .movie-grid::-webkit-scrollbar {
            display: none;
        }

        /* Movie Grid - Watchlist (Grid Layout) */
        .movie-grid-vertical {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(280px, 1fr));
            gap: 40px 8px;
            padding: 20px 0;
        }

        /* Badges */
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
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.5);
            pointer-events: none;
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

        /* Nav Arrows */
        .nav-arrow {
            position: absolute;
            top: 60px;
            bottom: 40px;
            width: 4%;
            background: rgba(0, 0, 0, 0.5);
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
            background: rgba(0, 0, 0, 0.8);
            scale: 1.1;
        }

        .left-arrow {
            left: 0;
            border-radius: 0 4px 4px 0;
        }

        .right-arrow {
            right: 0;
            border-radius: 4px 0 0 4px;
        }

        .nav-arrow svg {
            width: 2rem;
            height: 2rem;
        }
    </style>
</head>

<body class="antialiased">
    <div class="min-h-screen">
        @include('layouts.navigation', ['class' => $navigation_class ?? ''])

        {{-- Conteúdo da página --}}
        <main>
            {{ $slot }}
        </main>
    </div>

    {{-- Script de animação da navbar --}}
    <script>
        window.onscroll = function () {
            var nav = document.getElementById('navbar');
            if (nav && !nav.classList.contains('solid')) {
                if (window.pageYOffset > 50) {
                    nav.classList.add("scrolled");
                } else {
                    nav.classList.remove("scrolled");
                }
            }
        };
    </script>
</body>

</html>