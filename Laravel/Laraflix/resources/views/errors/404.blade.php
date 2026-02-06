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

<body class="page-error">
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