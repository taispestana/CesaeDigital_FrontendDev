<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Movie extends Model
{
    //Colunas que devem ser mass assignable
    protected $fillable = [
        'category_id',
        'title',
        'release_date',
        'image',
        'synopsis',
        'rating',
        'imdb_id',
        'poster_url'
    ];

    //Categoria do filme
    public function category()
    {
        return $this->belongsTo(Category::class);
    }

    //Usuários que favoritaram o filme
    public function favoritedBy()
    {
        return $this->belongsToMany(User::class);
    }
}
