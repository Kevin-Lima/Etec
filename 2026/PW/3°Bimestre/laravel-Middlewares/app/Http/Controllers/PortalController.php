<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class PortalController extends Controller
{
    public function index()
    {
        $mensagem = "Bem vindo ao portal";
        
        return view('portal', ['mensagem' => $mensagem]);
    }
}
