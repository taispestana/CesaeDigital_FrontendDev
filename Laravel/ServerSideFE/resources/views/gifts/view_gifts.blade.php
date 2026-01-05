@extends('layouts.main_layout')

@section('content')

<h6>Info dos Gifts</h6>
<p>Name: {{ $gift->name }}</p>
<p>Valor previsto: {{ $gift->expected_value }}</p>
<p>Valor gasto: {{ $gift->spent_value }}</p>
<p>Para quem: {{ $gift->usname }}</p>
<p>Diferença: {{ $gift->expected_value - $gift->spent_value }}</p>
@endsection
