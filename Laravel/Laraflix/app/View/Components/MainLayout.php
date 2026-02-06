<?php

namespace App\View\Components;

use Illuminate\View\Component;
use Illuminate\View\View;

class MainLayout extends Component
{
    /**
     * Renderiza a view do layout principal
     */
    public function render(): View
    {
        return view('layouts.mainlayout');
    }
}
