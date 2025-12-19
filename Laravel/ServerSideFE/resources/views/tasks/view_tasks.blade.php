@extends('layouts.main_layout')

@section('content')
<h6>Info das Tasks</h6>
<p>Name: {{ $task->name }}</p>
<p>Description: {{ $task->description }}</p>
<p>Status: {{ $task->status }}</p>
<p>User: {{ $task->user_id }}</p>
@endsection
