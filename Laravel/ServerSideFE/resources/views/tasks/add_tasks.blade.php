@extends('layouts.main_layout')
    @section('content')

    <h6>Formulario para add Task</h6>

      <form method="POST" action="{{ route('tasks.store') }}">
        @csrf
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Nome da tarefa</label>
            <input name="name" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
        </div>
        @error('name')
            Nome inválido
        @enderror
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Descrição</label>
            <input name="description" type="name" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
        </div>
        @error('description')
            Descrição inválida
        @enderror
        <div class="mb-3">
            <label for="exampleInputUser1" class="form-label">User</label>
            <select name="utilizador">
            <option value="">--Please choose an option--</option>
             @foreach ($users as $user)
                 <option value="{{$user->id}}">{{$user->name}}</option>
             @endforeach
            </select>
            @error('utilizador')
                <p>User inválido</p>
            @enderror
        </div>
        <div class="mb-3 form-check">
            <input type="checkbox" class="form-check-input" id="exampleCheck1">
            <label class="form-check-label" for="exampleCheck1">Check me out</label>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
@endsection
