<nav id="navbar" class="netflix-nav {{ $class ?? '' }}">
    <a href="/" class="logo-red">Laraflix</a>
    <div class="hidden lg:flex flex-grow">
        <a href="{{ route('dashboard') }}"
            class="nav-link-custom {{ request()->routeIs('dashboard') ? 'active' : '' }}">Página inicial</a>

        <a href="{{ route('watchlist.index') }}"
            class="nav-link-custom {{ request()->routeIs('watchlist.index') ? 'active' : '' }}">A minha lista</a>
    </div>
    <div class="flex items-center gap-6">

        <div class="relative" x-data="{ open: false }" @click.away="open = false">
            <div @click="open = !open" class="flex items-center gap-2 cursor-pointer group">
                <div class="w-8 h-8 rounded overflow-hidden">
                    <img src="{{ Auth::user()->profile_photo_url }}" alt="Profile">
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
                <div class="px-2 pb-2 mb-2">
                    @foreach($allUsers as $user)
                        <form method="POST" action="{{ route('profiles.switch', $user) }}">
                            @csrf
                            <button type="submit"
                                class="flex items-center gap-3 p-2 hover:underline cursor-pointer w-full text-left {{ Auth::id() === $user->id ? 'opacity-100' : 'opacity-70' }}">
                                <div class="w-8 h-8 rounded overflow-hidden shrink-0">
                                    <img src="{{ $user->profile_photo_url }}" alt="Profile">
                                </div>
                                <span class="text-xs font-bold text-white">{{ $user->name }}</span>
                                @if (Auth::id() === $user->id)
                                    <span class="text-[10px] text-zinc-500 ml-auto">Atual</span>
                                @endif
                            </button>
                        </form>
                    @endforeach
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