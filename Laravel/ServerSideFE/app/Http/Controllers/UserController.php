<?php

namespace App\Http\Controllers;

use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Hash;

class UserController extends Controller
{

public function addUser() {
    $pageAdmin = 'António';

    //Retornar a view addusers.blade.php
    return view('users.add_user', compact('pageAdmin'));
}

//funcao que recebe os dados do formulario e os armazena na base de dados
public function storeUser(Request $request) {
      // dd($request->all());

      $request->validate([
          'name' => 'required|string|max:255',
          'email' => 'required|string|email|max:255|unique:users',
          'password' => 'required|string|min:8',
      ]);

      User::insert([
            'name' => $request->name,
            'email' => $request->email,
            'password' => Hash::make($request->password)
      ]);

        return redirect()->route('users.all')->with('message', 'User created successfully.');
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

//funcao que abre a view com toda a info do user
public function viewUser($id){
    //query que vai buscar o user pelo id que estou a clicar
    //$user = User::find($id);

    $user = DB::table('users')->where('id', $id)->first();

    return view('users.view_user', compact('user'));
}

//funcao que apaga o user da base de dados
public function deleteUser($id){

    //apagar todas as tasks associadas ao user antes de apagar o user
    DB::table('tasks')
    ->where('user_id', $id)
    ->delete();

    //apagar o user da base de dados
    DB::table('users')
    ->where('id', $id)
    ->delete();

    return back();
}

//funcao que atualiza o user na base de dados
public function updateUser(Request $request){
    //dd($request->all());

    $request->validate([
        'name' => 'required|string|max:50',
    ]);

    DB::table('users')
    ->where('id', $request->id)
    ->update([
        'name' => $request->name,
        'nif' => $request->nif,
        'address' => $request->address,
    ]);

    return redirect()->route('users.all')->with('message', 'User updated successfully.');
}
}
