<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Laraflix - Acesso ilimitado</title>
    <link rel="icon" type="image/png" href="{{ asset('favicon.png') }}">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Outfit:wght@400;700;900&display=swap" rel="stylesheet">
    @vite(['resources/css/app.css', 'resources/js/app.js'])


<body class="antialiased page-welcome">
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
                Acesso ilimitado
            </h1>
            <p class="text-lg lg:text-2xl mb-6">
                A partir de 8,99 €. Cancele quando quiser.
            </p>

        </div>
    </div>


</body>

</html>