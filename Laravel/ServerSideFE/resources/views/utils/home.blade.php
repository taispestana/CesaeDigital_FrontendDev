    @extends('layouts.main_layout')
    @section('content')

    <h3>Home Page da {{$surname ? $surname : 'escola'}}</h3>

    @if ($surname)
        <p>Bem-vindo, {{$surname}}!</p>
        <img src="{{asset('images/logotipo-1.jpg')}}" alt="">
    @else
        <p>Bem-vindo, visitante!</p>
        <img src="{{asset('images/nophoto.jpg')}}" alt="">
    @endif

    <img src="{{asset('images/land-o-lakes-inc-1w3tO5F8HYY-unsplash.jpg')}}" alt="">
    <ul>
        <!-- As chavetas abrem e fecham código PHP no Blade. -->
        <li> <a href="{{route('utils.hello')}}">Olá, Mundo!</a></li>
        <li> <a href="{{route('users.add')}}">Adicionar Utilizador</a></li>
        <li> <a href="{{route('users.all')}}">Todos os Utilizadores</a></li>
        <li> <a href="{{route('tasks.all')}}">Todos as Tarefas</a></li>
    </ul>
    @endsection
