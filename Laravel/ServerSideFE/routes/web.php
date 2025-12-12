<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\TaskController;
use App\Http\Controllers\UserController;
use App\Http\Controllers\UtilController;

//utilizar o controller UtilController e a funcao home
Route::get('/', [UtilController::class, 'home'])->name('utils.welcome');

Route::get('/hello', function () {
    //Declaracao da variavel
    $myName = "Taís";
    //Chamar variavel dentro do return
    return "<h1>Hello, World! $myName</h1>";
})->name('utils.hello');

Route::get('/turma/{name}', function ($name) {
    //ir a base de dados e buscar a turma pelo nome
    return "<h1>Turma: $name</h1>";
})->name('utils.turma');

//utilizar o controller UserController e a funcao addUser
Route::get('/addusers', [UserController::class, 'addUser'] )->name('users.add');

//utilizar o controller UserController e a funcao insertUserIntoDB
//funcao raw que insere um user na basde de dados (teste do dbquery builder sem frontend)
Route::get('/insertintodb', [UserController::class, 'insertUserIntoDB'] );

//utilizar o controller UserController e a funcao updateUserIntoDB
Route::get('/uptadeintodb', [UserController::class, 'updateUserIntoDB'] );

//utilizar o controller UserController e a funcao deleteUserFromDB
Route::get('/deleteuser', [UserController::class, 'deleteUserFromDB'] );

//utilizar o controller UserController e a funcao selectUsersFromDB
Route::get('/getuser', [UserController::class, 'selectUsersFromDB'] );

//utilizar o controller TaskController e a funcao allTasks
Route::get('/alltasks', [TaskController::class, 'allTasks'] )->name('tasks.all');;

//utilizar o controller UserController e a funcao allUsers
Route::get('/allusers', [UserController::class, 'allUser'] )->name('users.all');

// Route::fallback(function () {
//     return "<h1>Página não encontrada. <a href='/'>Voltar para a página inicial</a></h1>";
// });

Route::fallback(function () {
 return view('utils.fallbackV');
});
