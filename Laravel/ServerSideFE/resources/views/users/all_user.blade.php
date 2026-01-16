@extends('layouts.main_layout')
    @section('content')

    @if (session('message'))
    <div class="alert alert-success">
        {{ session('message') }}
    </div>

    @endif
    {{--Exibir a variável cesaeInfo--}}
    <p>O email de contacto, caso detecte erros é {{ $cesaeInfo['name'] }}, com endereço {{ $cesaeInfo['address'] }}, com email {{ $cesaeInfo['email'] }}, na cidade {{ $cesaeInfo['city'] }} e contacto {{ $cesaeInfo['phone'] }}</p>

    <h1>Aqui estão todos os usuários de forma estática sem case de dados:</h1>
<ul>
    {{--Iterar sobre a coleção de estudantes e exibir seus detalhes--}}
    @foreach ($students as $student)
    <li>
    O nome é {{ $student['name'] }} e o email é {{ $student['email'] }}
    </li>
    @endforeach
</ul>

<h5>Users que sao carregados da base de dados (tabela de users):</h5>

<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Nome</th>
      <th scope="col">Email</th>
      <th scope="col">Nif</th>
    </tr>
  </thead>

  <tbody>
    {{--mostrar tabela de user a partir dos dados da base de dados--}}
    @foreach ($users as $user)
    <tr>
      <th scope="row">{{ $user->id }}</th>
      <td><img width="40px" height="40px" src="{{ asset('storage/' . $user->photo) }}" alt=""></td>
      <td>{{ $user->name }}</td>
      <td>{{ $user->email }}</td>
      <td>{{ $user->nif }}</td>
      @auth
      {{--Fazer button com "a" em vez de "button"para conseguir chamar a rota--}}
      {{--Relacionar a rota users.view ao botao--}}
      <td><a href="{{route('users.view', $user->id)}}" class="btn btn-info">Ver</a></td>

      @if (Auth::user()->email == 'admin@gmail.com')
      <td><a href="{{route ('users.delete', $user->id)}}" class="btn btn-danger">Apagar</a></td>
      @endif
      @endauth
      </tr>
      @endforeach
  </tbody>
</table>

    @endsection
