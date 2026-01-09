<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\TaskController;
use App\Http\Controllers\UserController;
use App\Http\Controllers\UtilController;
use App\Http\Controllers\GiftController;

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

//utilizar o controller UserController e a funcao addUser, para visualizar e adicionar users
Route::get('/addusers', [UserController::class, 'addUser'] )->name('users.add');

//utilizar o controller UserController e a funcao addUser, para visualizar e adicionar users
Route::get('/addtasks', [TaskController::class, 'addTask'] )->name('tasks.add');

//utilizar o controller UserController e a funcao storeUser, pega dados do formulario e os envia para o servidor
Route::post('/storeusers', [UserController::class, 'storeUser'] )->name('users.store');

//utilizar o controller TaskController e a funcao storeTask, pega dados do formulario e os envia para o servidor
Route::post('/storetasks', [TaskController::class, 'storeTask'] )->name('tasks.store');

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

//Rota que abre a view com toda a info do user
Route::get('/viewuser/{id}', [UserController::class, 'viewUser'])->name('users.view');

//Rota que apaga o user da base de dados
Route::get('/deleteuser/{id}', [UserController::class, 'deleteUser'])->name('users.delete');

//Rota que abre a view com toda a info da task
Route::get('/viewtask/{id}', [TaskController::class, 'viewTask'])->name('tasks.view');

//Rota que apaga a task da base de dados
Route::get('/deletetask/{id}', [TaskController::class, 'deleteTask'])->name('tasks.delete');

//utilizar o controller GiftController e a funcao allGifts
Route::get('/allgift', [GiftController::class, 'allGift'] )->name('gifts.all');

//Rota que abre a view com toda a info do gift
Route::get('/viewgift/{id}', [GiftController::class, 'viewGift'])->name('gifts.view');

//Rota que apaga o gift da base de dados
Route::get('/deletegift/{id}', [GiftController::class, 'deleteGift'])->name('gifts.delete');

// Route::fallback(function () {
//     return "<h1>Página não encontrada. <a href='/'>Voltar para a página inicial</a></h1>";
// });

//Rota para atualizar o user na base de dados
Route::put('/updateuser', [UserController::class, 'updateUser'])->name('users.update');

//Rota para atualizar o user na base de dados
Route::put('/updatetask', [TaskController::class, 'updateTask'])->name('tasks.update');

Route::fallback(function () {
 return view('utils.fallbackV');
});
