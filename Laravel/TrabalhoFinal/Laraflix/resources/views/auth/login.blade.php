<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Laraflix - Iniciar sessão</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Outfit:wght@400;700;900&display=swap" rel="stylesheet">
    @vite(['resources/css/app.css', 'resources/js/app.js'])
    <style>
        body {
            font-family: 'Outfit', sans-serif;
            background: linear-gradient(to bottom, #440000 0%, #000000 40%);
            background-attachment: fixed;
            color: #fff;
            min-height: 100vh;
            display: flex;
            flex-direction: column;
        }

        .logo-header {
            padding: 25px 50px;
        }

        .logo {
            font-size: 2.5rem;
            font-weight: 900;
            letter-spacing: -2px;
            text-transform: uppercase;
            color: #E50914;
            text-decoration: none;
            display: inline-block;
        }

        .login-card {
            max-width: 450px;
            width: 100%;
            margin: 0 auto;
            padding: 60px;
            background-color: rgba(0, 0, 0, 0.4);
            border-radius: 4px;
        }

        .input-field {
            background: #161616 !important;
            border: 1px solid #333 !important;
            color: #fff !important;
            padding: 16px !important;
            border-radius: 4px !important;
            width: 100%;
            margin-bottom: 5px;
        }

        .input-field:focus {
            border-color: #fff !important;
            ring-color: transparent !important;
            outline: none !important;
        }

        .btn-red {
            background-color: #E50914;
            color: #fff;
            padding: 12px;
            border-radius: 4px;
            font-weight: 700;
            width: 100%;
            margin-top: 15px;
            transition: background 0.2s;
        }

        .btn-red:hover {
            background-color: #C11119;
        }

        .help-link {
            color: #b3b3b3;
            font-size: 0.9rem;
            text-decoration: none;
            display: flex;
            align-items: center;
            gap: 5px;
            margin-top: 15px;
        }

        .help-link:hover {
            text-decoration: underline;
        }

        .footer-text {
            color: #737373;
            font-size: 0.85rem;
            margin-top: 30px;
            line-height: 1.4;
        }

        .register-link {
            color: #fff;
            font-weight: 700;
            text-decoration: none;
        }

        .register-link:hover {
            text-decoration: underline;
        }
    </style>
</head>

<body class="antialiased">
    <header class="logo-header">
        <a href="/" class="logo">Laraflix</a>
    </header>

    <main class="flex-grow flex items-start justify-center pt-10 px-4">
        <div class="login-card">
            <h1 class="text-3xl font-bold mb-2">Introduza os seus dados para iniciar sessão</h1>
            <p class="text-gray-400 mb-8">Ou comece com uma nova conta.</p>

            <form method="POST" action="{{ route('login') }}">
                @csrf

                <!-- Email Address -->
                <div class="mb-4">
                    <input id="email" class="input-field" type="email" name="email" :value="old('email')"
                        placeholder="E-mail" required autofocus autocomplete="username" />
                    <x-input-error :messages="$errors->get('email')" class="mt-1" />
                </div>

                <!-- Password -->
                <div class="mb-2">
                    <input id="password" class="input-field" type="password" name="password" placeholder="Senha"
                        required autocomplete="current-password" />
                    <x-input-error :messages="$errors->get('password')" class="mt-1" />
                </div>

                <button type="submit" class="btn-red text-lg">
                    Continuar
                </button>

                <div class="flex items-center justify-between mt-4">
                    <label for="remember_me" class="inline-flex items-center cursor-pointer">
                        <input id="remember_me" type="checkbox"
                            class="rounded border-zinc-700 bg-zinc-900 text-red-600 shadow-sm focus:ring-red-500"
                            name="remember">
                        <span class="ms-2 text-sm text-gray-400">Lembrar-me</span>
                    </label>
                </div>
            </form>

            <div class="mt-10">
                <p class="text-gray-500">
                    Não tem uma conta? <a href="{{ route('register') }}"
                        class="register-link font-bold text-white">Registe-se</a>.
                </p>
            </div>

            <a href="#" class="help-link">
                Obter ajuda
                <svg xmlns="http://www.w3.org/2000/svg" class="h-4 w-4" fill="none" viewBox="0 0 24 24"
                    stroke="currentColor">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M19 9l-7 7-7-7" />
                </svg>
            </a>

            <div class="footer-text">
                Esta página está protegida pelo serviço Google reCAPTCHA para garantir que não se trata de um robô. <a
                    href="#" class="text-blue-600 hover:underline">Mais informações</a>
            </div>
        </div>
    </main>
</body>

</html>