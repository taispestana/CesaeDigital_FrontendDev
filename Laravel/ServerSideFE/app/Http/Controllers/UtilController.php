<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class UtilController extends Controller
{
    public function home()
    {
        //aqui vai qualquer codigo de php: funcoes, variaveis etc
    //codigo ficticio que vem de uma consulta a Base de dados

    $surname = 'Pestana';
    $name = 'Taís';

    //retornar a view home.blade.php e passar a variavel surname para a view
    return view('utils.home', compact('surname','name'));
    }
}
