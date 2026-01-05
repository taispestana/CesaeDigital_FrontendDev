<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
use App\Models\Gift;


class GiftController extends Controller
{
     public function allGift(){

        $gifts = DB::table('gifts')
        ->join(
            'users',
            'gifts.user_id',
             '=',
             'users.id')
        ->select(
            'gifts.*',
            'users.name as usname'
             )
        ->get();


        return view('gifts.all_gifts', compact('gifts'));//passa a variável gifts para a view all_gifts.blade.php

   // $gifts = Gift::get();

    //return view('gifts.all_gifts', compact('gifts'));
}

//funcao que abre a view com toda a info do gift
public function viewGift($id){
    //query que vai buscar os gifts pelo id que estou a clicar

    $gift = DB::table('gifts')->join('users', 'users.id', 'gifts.user_id')->select('gifts.*', 'users.name as usname')->where('gifts.id', $id)->first();

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
