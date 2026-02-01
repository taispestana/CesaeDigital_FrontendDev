<nav id="navbar" class="netflix-nav {{ $class ?? '' }}">
    <a href="/" class="logo-red">Laraflix</a>
    <div class="hidden lg:flex flex-grow">
        <a href="{{ route('dashboard') }}"
            class="nav-link-custom {{ request()->routeIs('dashboard') ? 'active' : '' }}">Página inicial</a>
        <a href="#" class="nav-link-custom">Séries</a>
        <a href="#" class="nav-link-custom">Filmes</a>
        <a href="#" class="nav-link-custom">Novidades mais vistas</a>
        <a href="{{ route('watchlist.index') }}"
            class="nav-link-custom {{ request()->routeIs('watchlist.index') ? 'active' : '' }}">A minha lista</a>
    </div>
    <div class="flex items-center gap-6">
        <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6 text-white cursor-pointer" fill="none"
            viewBox="0 0 24 24" stroke="currentColor">
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z" />
        </svg>
        <span class="text-sm cursor-pointer hidden md:block text-white">Crianças</span>
        <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6 text-white cursor-pointer" fill="none"
            viewBox="0 0 24 24" stroke="currentColor">
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                d="M15 17h5l-1.405-1.405A2.032 2.032 0 0118 14.158V11a6.002 6.002 0 00-4-5.659V5a2 2 0 10-4 0v.341C7.67 6.165 6 8.388 6 11v3.159c0 .538-.214 1.055-.595 1.436L4 17h5m6 0v1a3 3 0 11-6 0v-1m6 0H9" />
        </svg>
        <div class="relative" x-data="{ open: false }" @click.away="open = false">
            <div @click="open = !open" class="flex items-center gap-2 cursor-pointer group">
                <div class="w-8 h-8 rounded bg-blue-500 overflow-hidden">
                    <img src="https://wallpapers.com/images/hd/netflix-profile-pictures-1000-x-1000-qo9h82134t9nv0j0.jpg"
                        alt="Profile">
                </div>
                <svg xmlns="http://www.w3.org/2000/svg" class="h-4 w-4 text-white transition-transform"
                    :class="open ? 'rotate-180' : ''" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M19 9l-7 7-7-7" />
                </svg>
            </div>

            {{-- Dropdown Menu --}}
            <div x-show="open" x-transition:enter="transition ease-out duration-100"
                x-transition:enter-start="transform opacity-0 scale-95"
                x-transition:enter-end="transform opacity-100 scale-100"
                class="absolute right-0 mt-2 w-56 bg-black/90 border border-zinc-800 shadow-2xl z-50 py-2">

                {{-- Arrow Top --}}
                <div
                    class="absolute -top-2 right-4 w-0 h-0 border-l-[8px] border-l-transparent border-r-[8px] border-r-transparent border-b-[8px] border-b-black/90">
                </div>

                {{-- Profile List --}}
                <div class="px-2 border-b border-zinc-800 pb-2 mb-2">
                    <div class="flex items-center gap-3 p-2 hover:underline cursor-pointer">
                        <div class="w-8 h-8 rounded bg-green-500 overflow-hidden shrink-0">
                            <img src="https://upload.wikimedia.org/wikipedia/commons/0/0b/Netflix-avatar.png"
                                alt="Profile">
                        </div>
                        <span class="text-xs font-bold text-white">{{ Auth::user()?->name ?? 'Utilizador' }}</span>
                    </div>
                    <div class="flex items-center gap-3 p-2 hover:underline cursor-pointer opacity-70">
                        <div
                            class="w-8 h-8 rounded bg-yellow-500 overflow-hidden shrink-0 text-center flex items-center justify-center">
                            <span class="text-[10px] font-bold text-black">Kids</span>
                        </div>
                        <span class="text-xs font-bold text-white">Infantil</span>
                    </div>
                </div>

                {{-- Secondary Menu --}}
                <div class="px-2">
                    <a href="{{ route('profiles.manage') }}"
                        class="flex items-center gap-3 p-2 hover:underline text-xs group text-white/70">
                        <svg class="h-5 w-5 opacity-70 group-hover:opacity-100" fill="none" viewBox="0 0 24 24"
                            stroke="currentColor">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                d="M15.232 5.232l3.536 3.536m-2.036-5.036a2.5 2.5 0 113.536 3.536L6.5 21.036H3v-3.572L16.732 3.732z" />
                        </svg>
                        Gerir perfis
                    </a>
                    <a href="#" class="flex items-center gap-3 p-2 hover:underline text-xs group text-white/70">
                        <svg class="h-5 w-5 opacity-70 group-hover:opacity-100" fill="none" viewBox="0 0 24 24"
                            stroke="currentColor">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="1.5"
                                d="M16 17l-4 4m0 0l-4-4m4 4V3" />
                        </svg>
                        Transferir perfil
                    </a>
                    <a href="{{ route('profile.edit') }}"
                        class="flex items-center gap-3 p-2 hover:underline text-xs group text-white/70">
                        <svg class="h-5 w-5 opacity-70 group-hover:opacity-100" fill="none" viewBox="0 0 24 24"
                            stroke="currentColor">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                d="M16 7a4 4 0 11-8 0 4 4 0 018 0zM12 14a7 7 0 00-7 7h14a7 7 0 00-7-7z" />
                        </svg>
                        Conta
                    </a>
                    <a href="#"
                        class="flex items-center gap-3 p-2 hover:underline text-xs group text-white/70 border-b border-zinc-800 pb-3 mb-2">
                        <svg class="h-5 w-5 opacity-70 group-hover:opacity-100" fill="none" viewBox="0 0 24 24"
                            stroke="currentColor">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                d="M8.228 9c.549-1.165 2.03-2 3.772-2 2.21 0 4 1.343 4 3 0 1.4-1.278 2.575-3.006 2.907-.542.104-.994.54-.994 1.093m0 3h.01M21 12a9 9 0 11-18 0 9 9 0 0118 0z" />
                        </svg>
                        Centro de Assistência
                    </a>
                </div>

                {{-- Logout --}}
                <div class="px-2 pb-1">
                    <form method="POST" action="{{ route('logout') }}">
                        @csrf
                        <button type="submit"
                            class="w-full text-center p-2 hover:underline text-xs font-bold pt-2 text-white">
                            Sair da Laraflix
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</nav>