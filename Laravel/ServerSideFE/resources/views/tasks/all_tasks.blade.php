@extends('layouts.main_layout')
@section('content')
<div class="container m-4">
        <h1>Lista de Todas as Tarefas:</h1>

        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Nome</th>
                    <th scope="col">Estado</th>
                    <th scope="col">Data de Conclusão</th>
                    <th scope="col">User</th>
                </tr>
            </thead>
            <tbody>
                @foreach ($tasks as $task)
                    <tr>
                        <th scope="row">{{ $task->id }}</th>
                        <td>{{ $task->name }}</td>
                        <td>{{ $task->status }}</td>
                        <td>{{ $task->due_at }}</td>
                        <td>{{ $task->usname }}</td>
                    </tr>
                @endforeach
            </tbody>
        </table>
    </div>

    @endsection
