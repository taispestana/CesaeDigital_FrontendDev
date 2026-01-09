@extends('layouts.main_layout')

@section('content')
<h6>Info das Tasks</h6>

<form method="POST" action="{{ route('tasks.update') }}">
        @csrf
        @method('PUT')
        <input type="hidden" name="id" value="{{ $task->id }}">
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Nome da tarefa</label>
            <input value="{{ $task->name }}" name="name" type="text" class="form-control" id="exampleInputEmail1"
                aria-describedby="emailHelp">
        </div>
        @error('name')
            Nome inválido
        @enderror
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Descrição</label>
            <input value="{{ $task->description }}" name="description" type="text" class="form-control" id="exampleInputEmail1"
                aria-describedby="emailHelp">
            <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
        </div>

        <div class="mb-3">
            <label for="statusSelect" class="form-label">Status</label>
            <select name="status" class="form-control" id="statusSelect">
                <option value="0" @if($task->status == 0) selected @endif>Pendente</option>
                <option value="1" @if($task->status == 1) selected @endif>Concluída</option>
            </select>
        </div>

         <div class="mb-3">
            <label for="userSelect" class="form-label">Nome do utilizador</label>
            <select name="user_id" class="form-control" id="userSelect">
                @foreach($users as $user)
                    <option value="{{ $user->id }}" @if($user->id == $task->user_id) selected @endif>{{ $user->name }}</option>
                @endforeach
            </select>

        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
@endsection
