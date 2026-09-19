# Povoamento de Banco de Dados com Seeders no Laravel

Este repositório contém a entrega da atividade prática sobre conceitos de povoamento de banco de dados (Seeders) utilizando o framework Laravel. O objetivo principal foi gerar, aplicar e exportar dados de forma massiva e automatizada.

## Etapas Realizadas

### 1. Configuração do Banco de Dados

* Configuração do arquivo `.env` para utilização do banco de dados **MySQL**.

* Criação do banco de dados no SGBD (phpMyAdmin).

### 2. Criação da Migration e do Seeder

* Geração da tabela `produtos` utilizando o comando de migração do Artisan:

  ```
  php artisan make:migration create_produtos_table
  
  ```

* Criação da classe `ProdutoSeeder` via CLI:

  ```
  php artisan make:seeder ProdutoSeeder
  
  ```

* Implementação da lógica de inserção de dados no método `run()` da classe gerada, utilizando a Facade `DB`. O seeder foi devidamente registrado no `DatabaseSeeder.php`.

### 3. Execução do Povoamento (Seeding)

* O banco foi migrado e populado simultaneamente através do comando:

  ```
  php artisan migrate:fresh --seed
  
  ```

* A integridade dos dados e a correta aplicação na tabela foram validadas utilizando o **phpMyAdmin**.

### 4. Exportação do Banco de Dados (Dump)

* Após a verificação da persistência dos dados, foi realizado o dump (exportação) da base de dados.

* O artefato `.sql` gerado foi incluído na raiz deste repositório para avaliação.

## Artefatos Entregues

* **Código-fonte:** Estrutura completa do projeto Laravel (Migrations e Seeders configurados).

* **Dump do Banco:** O arquivo `.sql` com a estrutura e os dados encontra-se na raiz do projeto.

* **Documentação:** Este arquivo README detalhando o processo construtivo.

*Atividade concluída e versionada conforme as instruções propostas.*