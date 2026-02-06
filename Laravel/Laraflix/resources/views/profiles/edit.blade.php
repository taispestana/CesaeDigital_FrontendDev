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

<body class="page-profiles profiles-edit-mode">
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