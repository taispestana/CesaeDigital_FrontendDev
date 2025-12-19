<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
use App\Models\Gift;


class GiftController extends Controller
{
     public function allGift(){

    $gifts = Gift::get();

    return view('gifts.all_gifts', compact('gifts'));
}

//funcao que abre a view com toda a info do gift
public function viewGift($id){
    //query que vai buscar os gifts pelo id que estou a clicar

    $gift = DB::table('gifts')->join('users', 'users.id', 'gifts.user_id')->where('gifts.id', $id)->first();

    return view('gifts.view_gifts', compact('gift'));
}

//funcao que apaga o user da base de dados
public function deleteGift($id){

    //apagar todas as tasks
    DB::table('gifts')
    ->where('user_id', $id)
    ->delete();

    return back();
}

}
