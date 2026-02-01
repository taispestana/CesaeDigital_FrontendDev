<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Página não encontrada - Laraflix</title>
    <link rel="icon" type="image/png" href="{{ asset('favicon.png') }}">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Outfit:wght@400;700;900&display=swap" rel="stylesheet">

    @vite(['resources/css/app.css', 'resources/js/app.js'])

    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: 'Outfit', sans-serif;
            background-color: #000;
            color: #fff;
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            overflow: hidden;
        }

        .bg-container {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            z-index: -1;
        }

        .bg-image {
            width: 100%;
            height: 100%;
            object-fit: cover;
            filter: brightness(0.7);
        }

        .overlay {
            position: absolute;
            inset: 0;
            background: radial-gradient(circle, transparent 20%, rgba(0, 0, 0, 0.4) 80%);
        }

        .content {
            text-align: center;
            max-width: 800px;
            padding: 40px;
            z-index: 1;
            position: relative;
        }

        h1 {
            font-size: 5rem;
            font-weight: 900;
            margin: 0 0 20px 0;
            text-shadow: 0 2px 10px rgba(0, 0, 0, 0.5);
        }

        p {
            font-size: 1.5rem;
            line-height: 1.5;
            margin-bottom: 40px;
            font-weight: 400;
            max-width: 600px;
            margin-left: auto;
            margin-right: auto;
            text-shadow: 0 1px 5px rgba(0, 0, 0, 0.5);
        }

        .btn-home {
            background-color: #fff;
            color: #000;
            padding: 12px 30px;
            font-size: 1.25rem;
            font-weight: 700;
            text-decoration: none;
            border-radius: 4px;
            display: inline-block;
            transition: transform 0.2s, background-color 0.2s;
        }

        .btn-home:hover {
            background-color: rgba(255, 255, 255, 0.9);
            transform: scale(1.05);
        }

        .error-footer {
            position: absolute;
            bottom: 40px;
            left: 50%;
            transform: translateX(-50%);
            width: 100%;
            display: flex;
            justify-content: center;
            align-items: center;
            gap: 20px;
            color: #fff;
            font-size: 1.25rem;
        }

        .error-code {
            border-left: 2px solid #E50914;
            padding-left: 15px;
            font-weight: 400;
        }

        .error-code strong {
            font-weight: 700;
        }

        .attribution {
            position: absolute;
            bottom: 20px;
            right: 4%;
            font-size: 0.8rem;
            color: rgba(255, 255, 255, 0.5);
            text-transform: uppercase;
            letter-spacing: 1px;
        }
    </style>
</head>

{{-- Conteúdo da página --}}

<body>
    <div class="bg-container">
        <img src="{{ asset('images/error-bg.png') }}" class="bg-image" alt="Background">
        <div class="overlay"></div>
    </div>

    <div class="content">
        <h1>Perdeu-se?</h1>
        <p>Não foi possível encontrar a página. Uma vasta escolha de títulos espera por si na página inicial.</p>
        <a href="/" class="btn-home">Página inicial da Laraflix</a>
    </div>

    <div class="error-footer">
        <div class="error-code">
            Código de erro <strong>NSES-404</strong>
        </div>
    </div>

    <div class="attribution">
        DE PERDIDOS NO ESPAÇO
    </div>
</body>

</html>