@extends('layouts.main_layout')
    @section('content')

    {{--Exibir a variável cesaeInfo--}}
    <p>O email de contacto, caso detecte erros é {{ $cesaeInfo['name'] }}, com endereço {{ $cesaeInfo['address'] }}, com email {{ $cesaeInfo['email'] }}, na cidade {{ $cesaeInfo['city'] }} e contacto {{ $cesaeInfo['phone'] }}</p>

    <h1>Aqui estão todos os usuários:</h1>
<ul>
    {{--Iterar sobre a coleção de estudantes e exibir seus detalhes--}}
    @foreach ($students as $student)
    <li>
    <p>O nome é {{ $student['name'] }} e o email é {{ $student['email'] }}</p>
    </li>
    @endforeach
</ul>
    @endsection
