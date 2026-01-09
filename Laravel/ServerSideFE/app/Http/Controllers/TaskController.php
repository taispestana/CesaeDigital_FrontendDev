<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
use App\Models\Task;

class TaskController extends Controller
{

    public function allTasks(){

    $tasks = Task::join('users', 'users.id', 'tasks.user_id')
    ->select('tasks.*', 'users.name as usname')
    ->get();

    return view('tasks.all_tasks', compact('tasks'));
}

public function addTask() {
    $users = DB::table('users')->get();
    //Retornar a view addtasks.blade.php
    return view('tasks.add_tasks', compact('users'));
}

//funcao que recebe os dados do formulario e os armazena na base de dados
public function storeTask(Request $request) {
      // dd($request->all());

      $request->validate([
            'name' => 'required|string|max:255',
            'description' => 'required|string',
            'utilizador' => 'required',
      ]);

      Task::insert([
            'name' => $request->name,
            'description' => $request->description,
            'user_id' => $request->utilizador
      ]);

        return redirect()->route('tasks.all')->with('message', 'Task created successfully.');
}

//funcao que abre a view com toda a info da task
public function viewTask($id){
    //query que vai buscar a task pelo id que estou a clicar

    $task = DB::table('tasks')
        ->join('users', 'users.id', 'tasks.user_id')
        ->select('tasks.*', 'users.name as user_name')
        ->where('tasks.id', $id)
        ->first();

    $users = DB::table('users')->get();

    return view('tasks.view_tasks', compact('task', 'users'));
}

//funcao que apaga o user da base de dados
public function deleteTask($id){

    //apagar todas as tasks
    DB::table('tasks')
    ->where('user_id', $id)
    ->delete();

    return back();
}

//funcao que atualiza o user na base de dados
public function updateTask(Request $request){
    //dd($request->all());

    $request->validate([
        'name' => 'required|string|max:50',
    ]);

    DB::table('tasks')
    ->where('id', $request->id)
    ->update([
        'name' => $request->name,
        'description' => $request->description,
        'user_id' => $request->user_id,
        'status' => $request->status,
    ]);

    return redirect()->route('tasks.all')->with('message', 'Task updated successfully.');
}

}
