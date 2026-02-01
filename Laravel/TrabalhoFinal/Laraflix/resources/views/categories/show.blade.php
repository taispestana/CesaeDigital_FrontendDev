<!-- Layout da aplicação 
<x-app-layout>
    {{-- Header da página --}}
    <x-slot name="header">
        <div class="flex justify-between items-center">
            <h2 class="font-semibold text-xl text-gray-800 leading-tight">
                Filmes da Saga: {{ $category->name }}
            </h2>
            <a href="{{ route('categories.index') }}" class="bg-gray-500 text-white px-4 py-2 rounded text-sm">←
                Voltar</a>
        </div>
    </x-slot>

    {{-- Conteúdo da página --}}
    <div class="py-12">
        <div class="max-w-7xl mx-auto sm:px-6 lg:px-8">
            <div class="bg-white overflow-hidden shadow-sm sm:rounded-lg p-6">

                <table class="min-w-full divide-y divide-gray-200">
                    <thead class="bg-gray-50">
                        <tr>
                            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Poster</th>
                            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Título do Filme
                            </th>
                            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Data de
                                Lançamento</th>
                        </tr>
                    </thead>
                    <tbody class="bg-white divide-y divide-gray-200">
                        @forelse($category->movies as $movie)
                            <tr>
                                <td class="px-6 py-4">
                                    <img src="{{ $movie->image }}" alt="{{ $movie->title }}"
                                        class="w-16 h-24 object-cover rounded shadow">
                                </td>
                                <td class="px-6 py-4 font-bold">{{ $movie->title }}</td>
                                <td class="px-6 py-4">{{ \Carbon\Carbon::parse($movie->release_date)->format('d/m/Y') }}
                                </td>
                            </tr>
                        @empty
                            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Ações</th>

                            <td class="px-6 py-4 whitespace-nowrap text-sm font-medium">
                                @auth
                                    <a href="{{ route('movies.edit', $movie->id) }}"
                                        class="text-indigo-600 hover:text-indigo-900 mr-3">Editar</a>

                                    @if (Auth::user()->role == 'admin')
                                        <form action="{{ route('movies.destroy', $movie->id) }}" method="POST"
                                            class="inline">
                                            @csrf
                                            @method('DELETE')
                                            <button type="submit" class="text-red-600 hover:text-red-900"
                                                onclick="return confirm('Tens a certeza?')">Apagar</button>
                                        </form>
                                    @endif
                                @endauth
                            </td>
                            <tr>
                                <td colspan="3" class="px-6 py-4 text-center text-gray-500">Nenhum filme encontrado
                                    nesta categoria.</td>
                            </tr>
                        @endforelse
                    </tbody>
                </table>

            </div>
        </div>
    </div>
</x-app-layout>