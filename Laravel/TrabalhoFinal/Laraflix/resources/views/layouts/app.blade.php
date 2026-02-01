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
        }

        /* Nav Styles */
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

        /* Buttons */
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