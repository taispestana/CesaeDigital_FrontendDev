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

    <style>
        body {
            background-color: #fff;
            color: #333;
            font-family: 'Outfit', sans-serif;
            margin: 0;
        }

        .settings-nav {
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 10px 4%;
            background-color: #000;
        }

        .logo-red {
            color: #E50914;
            font-weight: 900;
            font-size: 2rem;
            letter-spacing: -1px;
            text-transform: uppercase;
            text-decoration: none;
        }

        .settings-container {
            max-width: 1000px;
            margin: 40px auto;
            display: flex;
            gap: 40px;
            padding: 0 20px;
        }

        .sidebar {
            width: 200px;
            flex-shrink: 0;
        }

        .sidebar-link {
            display: flex;
            align-items: center;
            gap: 12px;
            padding: 12px 16px;
            color: #333;
            text-decoration: none;
            border-radius: 8px;
            margin-bottom: 4px;
            font-weight: 500;
            transition: background 0.2s;
        }

        .sidebar-link:hover {
            background-color: #f5f5f5;
        }

        .sidebar-link.active {
            font-weight: 700;
            color: #000;
        }

        .content {
            flex-grow: 1;
        }

        .back-link {
            display: flex;
            align-items: center;
            gap: 8px;
            color: #333;
            text-decoration: none;
            font-size: 0.9rem;
            margin-bottom: 30px;
            font-weight: bold;
        }

        h1 {
            font-size: 3rem;
            font-weight: 900;
            margin: 0 0 8px 0;
        }

        .subtitle {
            color: #666;
            font-size: 1.1rem;
            margin-bottom: 40px;
        }

        .section-title {
            font-size: 1.1rem;
            font-weight: 700;
            margin: 40px 0 16px 0;
            color: #333;
        }

        .card {
            border: 1px solid #e5e5e5;
            border-radius: 8px;
            overflow: hidden;
            background: #fff;
        }

        .card-item {
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 24px;
            border-bottom: 1px solid #e5e5e5;
            text-decoration: none;
            color: inherit;
            transition: background 0.2s;
        }

        .card-item:last-child {
            border-bottom: none;
        }

        .card-item:hover {
            background-color: #f9f9f9;
        }

        .card-item-left {
            display: flex;
            align-items: center;
            gap: 20px;
        }

        .icon-box {
            width: 40px;
            height: 40px;
            border: 1px solid #e5e5e5;
            border-radius: 8px;
            display: flex;
            align-items: center;
            justify-content: center;
            color: #333;
        }

        .item-text h3 {
            margin: 0;
            font-size: 1.1rem;
            font-weight: 700;
        }

        .item-text p {
            margin: 4px 0 0 0;
            color: #666;
            font-size: 0.9rem;
        }

        .profile-list {
            border: 1px solid #e5e5e5;
            border-radius: 8px;
            overflow: hidden;
        }

        .profile-item {
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 16px 24px;
            border-bottom: 1px solid #e5e5e5;
            text-decoration: none;
            color: inherit;
            transition: background 0.2s;
        }

        .profile-item:last-child {
            border-bottom: none;
        }

        .profile-item:hover {
            background-color: #f9f9f9;
        }

        .profile-info {
            display: flex;
            align-items: center;
            gap: 16px;
        }

        .profile-avatar {
            width: 48px;
            height: 48px;
            border-radius: 4px;
            object-fit: cover;
        }

        .profile-name {
            font-weight: 700;
            font-size: 1.1rem;
        }

        .badge {
            background-color: #e8f0fe;
            color: #1a73e8;
            font-size: 0.75rem;
            font-weight: 700;
            padding: 4px 12px;
            border-radius: 20px;
            margin-left: 10px;
        }

        .kids-avatar {
            background: #fff6e0;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .chevron {
            color: #333;
            width: 20px;
            height: 20px;
        }
    </style>
</head>

<body>
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