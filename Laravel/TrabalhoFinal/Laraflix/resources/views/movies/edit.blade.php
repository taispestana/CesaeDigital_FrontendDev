<x-app-layout>
    <x-slot name="header">
        <h2 class="font-semibold text-xl text-gray-800 leading-tight">
            Editar Filme: {{ $movie->title }}
        </h2>
    </x-slot>

    <div class="py-12">
        <div class="max-w-7xl mx-auto sm:px-6 lg:px-8">
            <div class="bg-white p-6 shadow-sm sm:rounded-lg">
                <form action="{{ route('movies.update', $movie->id) }}" method="POST">
                    @csrf
                    @method('PUT')

                    <div class="mb-4">
                        <label class="block text-gray-700">Título</label>
                        <input type="text" name="title" value="{{ $movie->title }}" class="w-full border-gray-300 rounded shadow-sm">
                    </div>

                    <div class="mb-4">
                        <label class="block text-gray-700">Data de Lançamento</label>
                        <input type="date" name="release_date" value="{{ $movie->release_date }}" class="w-full border-gray-300 rounded shadow-sm">
                    </div>

                    <div class="mb-4">
                        <label class="block text-gray-700">Categoria</label>
                        <select name="category_id" class="w-full border-gray-300 rounded shadow-sm">
                            @foreach($categories as $category)
                                <option value="{{ $category->id }}" {{ $movie->category_id == $category->id ? 'selected' : '' }}>
                                    {{ $category->name }}
                                </option>
                            @endforeach
                        </select>
                    </div>

                    <button type="submit" class="bg-blue-500 text-white px-4 py-2 rounded">Gravar Alterações</button>
                </form>
            </div>
        </div>
    </div>
</x-app-layout>
