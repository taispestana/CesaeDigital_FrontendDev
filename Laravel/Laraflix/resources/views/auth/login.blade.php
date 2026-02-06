<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Laraflix - Iniciar sessão</title>
    <link rel="icon" type="image/png" href="{{ asset('favicon.png') }}">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Outfit:wght@400;700;900&display=swap" rel="stylesheet">
    @vite(['resources/css/app.css', 'resources/js/app.js'])

<body class="antialiased page-auth">
    <header class="logo-header">
        <a href="/" class="logo">Laraflix</a>
    </header>

    <!-- Conteúdo da página -->
    <main class="flex-grow flex items-start justify-center pt-10 px-4">
        <div class="login-card">
            <h1 class="text-3xl font-bold mb-2">Introduza os seus dados para iniciar sessão</h1>
            <p class="text-gray-400 mb-8">Ou comece com uma nova conta.</p>

            <form method="POST" action="{{ route('login') }}">
                @csrf

                <!-- Email -->
                <div class="mb-4">
                    <input id="email" class="input-field" type="email" name="email" :value="old('email')"
                        placeholder="E-mail" required autofocus autocomplete="username" />
                    <x-input-error :messages="$errors->get('email')" class="mt-1" />
                </div>

                <!-- Palavra-passe -->
                <div class="mb-2">
                    <input id="password" class="input-field" type="password" name="password" placeholder="Senha"
                        required autocomplete="current-password" />
                    <x-input-error :messages="$errors->get('password')" class="mt-1" />
                </div>

                <button type="submit" class="btn-red text-lg">
                    Continuar
                </button>

                <!-- Checkbox de lembrar-me -->
                <div class="flex items-center justify-between mt-4">
                    <label for="remember_me" class="inline-flex items-center cursor-pointer">
                        <input id="remember_me" type="checkbox"
                            class="rounded border-zinc-700 bg-zinc-900 text-red-600 shadow-sm focus:ring-red-500"
                            name="remember">
                        <span class="ms-2 text-sm text-gray-400">Lembrar-me</span>
                    </label>
                </div>
            </form>

            <!-- Link de registro -->
            <div class="mt-10">
                <p class="text-gray-500">
                    Não tem uma conta? <a href="{{ route('register') }}"
                        class="register-link font-bold text-white">Registe-se</a>.
                </p>
            </div>

            <!-- Texto do Footer -->
            <div class="footer-text">
                Esta página está protegida pelo serviço Google reCAPTCHA para garantir que não se trata de um robô. <a
                    href="#" class="text-blue-600 hover:underline">Mais informações</a>
            </div>
        </div>
    </main>
</body>

</html>