@extends('layouts.main_layout')

@section('content')
<h6>Info do User</h6>
<p>Name: {{ $user->name }}</p>
<p>Email: {{ $user->email }}</p>
<p>Address: {{ $user->address }}</p>
<p>NIF: {{ $user->nif }}</p>
@endsection
