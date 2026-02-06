<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Perfis - Laraflix</title>
    <link rel="icon" type="image/png" href="{{ asset('favicon.png') }}">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Outfit:wght@400;700;900&display=swap" rel="stylesheet">

    @vite(['resources/css/app.css', 'resources/js/app.js'])

<body class="page-profiles">
    <nav class="settings-nav">
        <a href="{{ route('dashboard') }}" class="logo-red">Laraflix</a>
        <div class="user-profile">
            <div class="w-8 h-8 rounded overflow-hidden">
                <img src="{{ Auth::user()->profile_photo_url }}" alt="Profile">
            </div>
        </div>
    </nav>

    <div class="settings-container">
        <aside class="sidebar">
            <a href="{{ route('dashboard') }}" class="back-link">
                <svg viewBox="0 0 24 24" class="w-5 h-5 fill-current">
                    <path d="M15.41 7.41L14 6l-6 6 6 6 1.41-1.41L10.83 12z" />
                </svg>
                Voltar à Laraflix
            </a>


            <a href="#" class="sidebar-link active">
                <svg fill="none" class="w-5 h-5" stroke="currentColor" viewBox="0 0 24 24">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                        d="M5.121 17.804A13.937 13.937 0 0112 16c2.5 0 4.847.655 6.879 1.804M15 10a3 3 0 11-6 0 3 3 0 016 0zm6 2a9 9 0 11-18 0 9 9 0 0118 0z" />
                </svg>
                Perfis
            </a>
        </aside>

        <main class="content">
            <h1>Perfis</h1>


            <div class="card">

                {{-- Valida se o usuário é admin para mostrar o botão de criar perfil --}}
                @if(Auth::user()->isAdmin())
                    <a href="{{ route('profiles.create') }}" class="card-item">
                        <div class="card-item-left">
                            <div class="icon-box">
                                <svg fill="none" class="w-6 h-6" stroke="currentColor" viewBox="0 0 24 24">
                                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                        d="M12 4v16m8-8H4" />
                                </svg>
                            </div>
                            <div class="item-text">
                                <h3>Adicionar um perfil</h3>
                                <p>Criar um novo perfil para esta conta</p>
                            </div>
                        </div>
                        <svg class="chevron" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 5l7 7-7 7" />
                        </svg>
                    </a>
                @endif
            </div>

            {{-- Lista de perfis --}}
            <h2 class="section-title">Definições de perfil</h2>

            <div class="profile-list">
                @foreach($users as $user)
                    <a href="{{ route('profiles.edit_form', $user) }}" class="profile-item group">
                        <div class="profile-info">
                            <img src="{{ $user->profile_photo_url }}" class="profile-avatar">

                            <span class="profile-name">{{ $user->name }}</span>
                            @if($user->id === Auth::id())
                                <span class="badge">O seu perfil</span>
                            @endif
                        </div>
                        <svg class="chevron" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 5l7 7-7 7" />
                        </svg>
                    </a>
                @endforeach
            </div>
        </main>
    </div>
</body>

</html>