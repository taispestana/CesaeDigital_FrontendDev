@extends('layouts.main_layout')
@section('content')

@if (session('message'))
    <div class="alert alert-success">
        {{ session('message') }}
    </div>

    @endif

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

    {{--Fazer button com "a" em vez de "button"para conseguir chamar a rota--}}
      {{--Relacionar a rota tasks.view ao botao--}}
      <td><a href="{{route('tasks.view', $task->id)}}" class="btn btn-info">Ver</a></td>
      <td><a href="{{route ('tasks.delete', $task->id)}}" class="btn btn-danger">Apagar</a></td>
                    </tr>
                @endforeach
            </tbody>
        </table>
    </div>

    @endsection
