@extends('layouts.main_layout')
    @section('content')

<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Nome da prenda</th>
      <th scope="col">Valor previsto</th>
      <th scope="col">Valor gasto</th>
      <th scope="col">Para quem</th>

    </tr>
  </thead>

  <tbody>
    {{--mostrar tabela de gifts a partir dos dados da base de dados--}}
    @foreach ($gifts as $gift)
    <tr>
      <th scope="row">{{ $gift->id }}</th>
      <td>{{ $gift->name }}</td>
      <td>{{ $gift->expected_value }} €</td>
      <td>{{ $gift->spent_value }} €</td>
      <td>{{ $gift->user_id }}</td>
      {{--Fazer button com "a" em vez de "button"para conseguir chamar a rota--}}
      {{--Relacionar a rota gifts.view ao botao--}}
      <td><a href="{{route('gifts.view', $gift->id)}}" class="btn btn-info">Ver</a></td>
      <td><a href="{{route ('gifts.delete', $gift->id)}}" class="btn btn-danger" onclick="return confirm('Tem certeza que quer apagar{{$gift->gift_id}}')">Apagar</a></td>
      </tr>
      @endforeach
  </tbody>
</table>

    @endsection
