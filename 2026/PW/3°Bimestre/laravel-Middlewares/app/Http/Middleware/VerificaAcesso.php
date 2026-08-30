<?php

namespace App\Http\Middleware;

use Closure;
use Illuminate\Http\Request;
use Symfony\Component\HttpFoundation\Response;

class VerificaAcesso
{
    /**
     * Handle an incoming request.
     *
     * @param  Closure(Request): (Response)  $next
     */
public function handle(Request $request, Closure $next): Response
    {
        if ($request->query('acesso') !== 'permitido') {
            return response('<h1>Seu acesso não foi autorizado.</h1><p>Entrar em contato com o administrador.</p>', 403);
        }

        return $next($request);
    }
}
