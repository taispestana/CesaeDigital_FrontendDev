<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Category extends Model
{
    use HasFactory;

    // ESTA É A FUNÇÃO QUE ESTÁ A FALTAR:
    public function movies()
    {
        return $this->hasMany(Movie::class);
    }
}
