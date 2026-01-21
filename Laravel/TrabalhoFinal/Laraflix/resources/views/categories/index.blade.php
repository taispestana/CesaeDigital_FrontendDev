<x-app-layout>
    <x-slot name="header">
        <h2 class="font-semibold text-xl text-gray-800 leading-tight">
            {{ __('Explorar Categorias') }}
        </h2>
    </x-slot>

    <div class="py-12">
        <div class="max-w-7xl mx-auto sm:px-6 lg:px-8">
            <div class="bg-white overflow-hidden shadow-sm sm:rounded-lg p-6">

                <table class="min-w-full divide-y divide-gray-200">
                    <thead class="bg-gray-50">
                        <tr>
                            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Poster</th>
                            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Categoria/Saga
                            </th>
                            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Nº de Filmes</th>
                            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Ações</th>
                        </tr>
                    </thead>
                    <tbody class="bg-white divide-y divide-gray-200">
                        @foreach ($categories as $category)
                            <tr>
                                <td class="px-6 py-4 whitespace-nowrap">
                                    <img src="{{ $category->image }}" alt="{{ $category->name }}"
                                        class="w-20 h-12 object-cover rounded shadow">
                                </td>
                                <td class="px-6 py-4 font-bold">{{ $category->name }}</td>
                                <td class="px-6 py-4">{{ $category->movies_count }} Filmes</td>
                                <td class="px-6 py-4">
                                    <a href="{{ route('categories.show', $category->id) }}"
                                        class="text-blue-600 hover:text-blue-900 font-medium">
                                        Ver Filmes →
                                    </a>
                                </td>
                                <td class="px-6 py-4">
                                    <a href="{{ route('categories.show', $category->id) }}"
                                        class="text-blue-600 hover:text-blue-900">
                                        Ver Filmes
                                    </a>

                                    @auth
                                        <a href="#" class="ml-4 text-yellow-600 hover:text-yellow-900">Editar</a>

                                        @if (Auth::user()->role == 'admin')
                                            <button class="ml-4 text-red-600 hover:text-red-900">Apagar</button>
                                        @endif
                                    @endauth
                                </td>
                            </tr>
                        @endforeach
                    </tbody>
                </table>

            </div>
        </div>
    </div>
</x-app-layout>
