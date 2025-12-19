<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
use App\Models\Task;

class TaskController extends Controller
{

    public function allTasks(){

    $tasks = Task::get();
    //->join('users', 'users.id', 'tasks.user_id')
    //->select('tasks.*', 'users.name as usname')
    //->get();

    return view('tasks.all_tasks', compact('tasks'));
}

//funcao que abre a view com toda a info da task
public function viewTask($id){
    //query que vai buscar a task pelo id que estou a clicar

    $task = DB::table('tasks')->join('users', 'users.id', 'tasks.user_id')->where('tasks.id', $id)->first();

    return view('tasks.view_tasks', compact('task'));
}

//funcao que apaga o user da base de dados
public function deleteTask($id){

    //apagar todas as tasks
    DB::table('tasks')
    ->where('user_id', $id)
    ->delete();

    return back();
}

}
