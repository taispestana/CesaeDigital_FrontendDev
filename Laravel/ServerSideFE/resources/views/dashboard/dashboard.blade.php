@extends('layouts.main_layout')
@section('content')

<div>
@if(auth()->user()->user_type == 1)
<h1>Olá, {{ auth()->user()->name }}!</h1>
    <div class="alert alert-success" role="alert">
        Conta de Administrador
    </div>
</div>
@endif

@endsection
