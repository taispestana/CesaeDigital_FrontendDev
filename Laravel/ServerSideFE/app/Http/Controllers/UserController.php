<?php

namespace App\Http\Controllers;

use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;

class UserController extends Controller
{

public function addUser() {
    $pageAdmin = 'António';

    //Retornar a view addusers.blade.php
    return view('users.add_user', compact('pageAdmin'));
}

public function allUser() {
    //Array ficticio com informacoes do CESAE que vem da Base de dados
    $cesaeInfo = [
        'name' => 'CESAE',
        'address' => 'Rua Dr. António Bernardino de Almeida, 431',
        'email' => 'cesae@cesae.pt',
        'city' => 'Porto',
        'phone' => '+351 222 010 100'
    ];


    //Array ficticio de utilizadores que vem da Base de dados
    $students = [
        ['name' => 'Ana', 'email' => 'ana@gmail.com'],
        ['name' => 'Bruno', 'email' => 'bruno@gmail.com'],
        ['name' => 'Carla', 'email' => 'carla@gmail.com' ]
    ];

    //testes de debug
    //dd($students);
    //dd($students[1]['name']);

    $users = User::all();

    //Retornar a view allusers.blade.php e passar a variavel users para a view
    return view('users.all_user', compact('cesaeInfo','students', 'users'));
}

public function insertUserIntoDB(){

    //validar se dados estao em conformidade com a estrutura da base de dados

    //se passar em todas validacoes, insere entao na base de dados
    //inserir user na base de dados usando o query builder do Laravel
    DB::table('users')
    ->updateOrinsert(
        [
        'email' => 'joao4@gmail.com',
        ],

        [
        'name' => 'João',
        'password' => 'password123',
        'nif' => '123456789',
        'created_at' => now(),

    ]);

        return response()->json('User inserted successfully');
}

public function updateUserIntoDB(){
    //atualizar user na base de dados usando o query builder do Laravel
    DB::table('users')
    ->where('id', 4)
    ->update([
        'email_verified_at' => now()
    ]);

        return response()->json('User updated successfully');
}

public function deleteUserFromDB(){
    //deletar user na base de dados usando o query builder do Laravel
    DB::table('users')
    ->where('id', 8)
    ->delete();

        return response()->json('User deleted successfully');
}

public function selectUsersFromDB(){
    //utilizar o get sempre traz os users como array de objetos
    //utliziar o first traz apenas o primeiro user que encontrar e como objeto
    $users = DB::table('users')
    ->whereNull('updated_at')
    ->get();


    dd($users);
}

}
