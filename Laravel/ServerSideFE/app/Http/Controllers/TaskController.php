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

}
