<?php

use Illuminate\Support\Facades\Route;

use App\Http\Controllers\PortalController;

Route::get('/portal', [PortalController::class, 'index'])->middleware('verifica.acesso');

