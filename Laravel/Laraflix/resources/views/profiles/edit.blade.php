<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Editar perfil - Laraflix</title>
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
            padding-bottom: 50px;
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

        .edit-container {
            max-width: 800px;
            margin: 40px auto;
            padding: 0 40px;
        }

        h1 {
            font-size: 3rem;
            font-weight: 900;
            margin: 0 0 40px 0;
        }

        .edit-profile-section {
            display: flex;
            gap: 30px;
            margin-bottom: 40px;
        }

        .profile-avatar-container {
            position: relative;
            width: 120px;
            height: 120px;
            flex-shrink: 0;
        }

        .profile-avatar {
            width: 100%;
            height: 100%;
            border-radius: 4px;
            object-fit: cover;
        }

        .avatar-edit-overlay {
            position: absolute;
            inset: 0;
            background: rgba(0, 0, 0, 0.4);
            display: flex;
            align-items: center;
            justify-content: center;
            border-radius: 4px;
            cursor: pointer;
        }

        .edit-icon-main {
            width: 30px;
            height: 30px;
            color: #fff;
            background: rgba(0, 0, 0, 0.6);
            padding: 8px;
            border-radius: 50%;
            border: 1px solid rgba(255, 255, 255, 0.4);
        }

        .input-group {
            flex-grow: 1;
        }

        .input-label {
            font-size: 0.8rem;
            color: #666;
            margin-bottom: 4px;
            display: block;
        }

        .name-input {
            width: 100%;
            padding: 12px 16px;
            font-size: 1.1rem;
            border: 1px solid #333;
            border-radius: 4px;
            font-weight: 500;
            color: #333;
        }

        .section-header {
            font-size: 1.5rem;
            font-weight: 700;
            margin: 40px 0 16px 0;
        }

        .section-description {
            color: #666;
            font-size: 0.95rem;
            line-height: 1.5;
            margin-bottom: 20px;
        }

        .action-box {
            border: 1px solid #333;
            border-radius: 4px;
            padding: 16px 20px;
            display: flex;
            align-items: center;
            gap: 12px;
            cursor: pointer;
            font-weight: 700;
            margin-bottom: 30px;
        }

        .contact-card {
            border: 1px solid #e5e5e5;
            border-radius: 12px;
            padding: 24px;
            display: flex;
            align-items: center;
            justify-content: space-between;
            margin-bottom: 12px;
            cursor: pointer;
            transition: background 0.2s;
        }

        .contact-card:hover {
            border-color: #333;
        }

        .contact-info {
            display: flex;
            align-items: center;
            gap: 16px;
        }

        .contact-text h4 {
            margin: 0;
            font-size: 1.1rem;
        }

        .contact-text p {
            margin: 4px 0 0 0;
            color: #666;
            font-size: 0.9rem;
        }

        .footer-note {
            font-size: 0.85rem;
            color: #666;
            line-height: 1.6;
            margin-bottom: 40px;
        }

        .button-group {
            display: flex;
            flex-direction: column;
            gap: 12px;
            margin-bottom: 60px;
        }

        .btn-guardar {
            background: #000;
            color: #fff;
            padding: 16px;
            border-radius: 4px;
            font-weight: 700;
            font-size: 1.1rem;
            text-align: center;
            border: none;
            cursor: pointer;
        }

        .btn-cancelar {
            background: transparent;
            color: #000;
            padding: 12px;
            font-weight: 700;
            text-align: center;
            text-decoration: none;
            border: none;
            cursor: pointer;
        }

        .divider {
            height: 1px;
            background: #e5e5e5;
            margin: 40px 0;
        }

        .btn-eliminar {
            width: 100%;
            background: transparent;
            border: 1px solid #e5e5e5;
            color: #666;
            padding: 14px;
            border-radius: 4px;
            font-weight: 700;
            cursor: pointer;
            transition: border-color 0.2s, color 0.2s;
        }

        .btn-eliminar:hover {
            border-color: #333;
            color: #333;
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

    <div class="edit-container">
        <h1>Editar perfil</h1>

        {{-- Formulário de edição de perfil --}}
        <form action="{{ route('profiles.update', $user) }}" method="POST" enctype="multipart/form-data"
            id="edit-profile-form">
            @csrf
            @method('PATCH')

            {{-- Seção de edição de perfil --}}
            <div class="edit-profile-section">
                <div class="profile-avatar-container" onclick="document.getElementById('profile_photo').click()">
                    <img src="{{ $user->profile_photo_url }}" class="profile-avatar" id="avatar-preview">
                    <div class="avatar-edit-overlay">
                        <svg class="edit-icon-main" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                d="M15.232 5.232l3.536 3.536m-2.036-5.036a2.5 2.5 0 113.536 3.536L6.5 21.036H3v-3.572L16.732 3.732z" />
                        </svg>
                    </div>
                </div>

                {{-- Input de avatar --}}
                <input type="file" name="profile_photo" id="profile_photo" class="hidden" accept="image/*"
                    onchange="previewImage(event)">

                {{-- Input de nome do perfil --}}
                <div class="input-group">
                    <label class="input-label">Nome do perfil</label>
                    <input type="text" name="name" class="name-input" value="{{ $user->name }}" required>
                </div>
            </div>

            <div class="divider"></div>

            {{-- Seção de informações de contacto --}}
            <h2 class="section-header">Informações de contacto</h2>
            <div class="contact-card">
                <div class="contact-info">
                    <svg class="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                            d="M3 8l7.89 5.26a2 2 0 002.22 0L21 8M5 19h14a2 2 0 002-2V7a2 2 0 00-2-2H5a2 2 0 00-2 2v10a2 2 0 002 2z" />
                    </svg>
                    <div class="contact-text">
                        <h4>E-mail</h4>
                        <p>{{ $user->email }}</p>
                    </div>
                </div>
                <svg class="w-5 h-5 text-zinc-400" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 5l7 7-7 7" />
                </svg>
            </div>

            <div class="button-group">
                <button type="submit" class="btn-guardar">Guardar</button>
                <a href="{{ route('profiles.manage') }}" class="btn-cancelar">Cancelar</a>
            </div>
        </form>

        {{-- Validação de admin para eliminar perfil --}}
        @if(Auth::user()->isAdmin())
            <div class="divider"></div>

            <form action="{{ route('profiles.destroy', $user) }}" method="POST"
                onsubmit="return confirm('Tem a certeza que deseja eliminar este perfil? Esta ação não pode ser desfeita.')">
                @csrf
                @method('DELETE')
                <button type="submit" class="btn-eliminar">Eliminar perfil</button>
            </form>
        @endif
    </div>
    <script>

        // Função para pré-visualizar a imagem do avatar
        function previewImage(event) {
            const reader = new FileReader();
            reader.onload = function () {
                const output = document.getElementById('avatar-preview');
                output.src = reader.result;
            }
            reader.readAsDataURL(event.target.files[0]);
        }
    </script>
</body>

</html>