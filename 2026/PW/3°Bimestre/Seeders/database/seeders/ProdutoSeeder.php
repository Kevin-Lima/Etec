<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;

class ProdutoSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        DB::table('produtos')->insert([
            [
                'nome' => 'Notebook Dell',
                'descricao' => 'Notebook 16GB RAM',
                'preco' => 4500.00,
                'created_at' => now(),
                'updated_at' => now(),
            ],
            [
                'nome' => 'Mouse Sem Fio',
                'descricao' => 'Mouse óptico recarregável',
                'preco' => 120.00,
                'created_at' => now(),
                'updated_at' => now(),
            ]
        ]);
    }
}
