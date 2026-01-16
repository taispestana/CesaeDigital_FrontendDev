@extends('layouts.main_layout')

@section('content')
<h6>Info do User</h6>

 <form method="POST" action="{{ route('users.update') }}" enctype="multipart/form-data">
        @csrf
        @method('PUT')
        <input type="hidden" name="id" value="{{ $user->id }}">
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Nome</label>
            <input value="{{ $user->name }}" name="name" type="text" class="form-control" id="exampleInputEmail1"
                aria-describedby="emailHelp">
        </div>
        @error('name')
            Nome inválido
        @enderror
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Email address</label>
            <input value="{{ $user->email }}" disabled name="email" type="email" class="form-control" id="exampleInputEmail1"
                aria-describedby="emailHelp">
            <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
        </div>

        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Nif</label>
            <input value="{{ $user->nif }}" name="nif" type="text" class="form-control" id="exampleInputEmail1"
                aria-describedby="emailHelp">
        </div>

         <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Morada</label>
            <input value="{{ $user->address }}" name="address" type="text" class="form-control" id="exampleInputEmail1"
                aria-describedby="emailHelp">
        </div>

        <input type="file" name="photo" accept="image/*">
        <br>

        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
@endsection
