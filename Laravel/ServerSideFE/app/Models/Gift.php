<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Gift extends Model
{
     protected $fillable = [
        'name',
        'expected_value',
        'spent_value',
        'user_id'
    ];

     public function user()
    {
        return $this->belongsTo(User::class);
    }

    //diferença de valores
    public function getDifferenceAttribute()
    {
        if ($this->spent_value === null) {
            return null;
        }

        return $this->expected_value - $this->spent_value;
    }
}


