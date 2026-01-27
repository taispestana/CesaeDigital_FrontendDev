<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Movie extends Model
{
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

    public function category()
    {
        return $this->belongsTo(Category::class);
    }
}
