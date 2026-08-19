# Atividade: Mapeamento Objeto-Relacional com Laravel

Projeto desenvolvido para demonstrar a execução de migrations e o mapeamento objeto-relacional (ORM) no Laravel, incluindo a criação de tabelas e o gerenciamento de chaves estrangeiras.

## Vídeo de Apresentação
Link da execução em tempo real: https://youtu.be/S4vNG-afZlk

## Estrutura do Banco de Dados

O banco de dados utilizado é o `mapeamento_db`. A aplicação define o relacionamento de um para muitos entre `categorias` e `produtos`.

### Tabelas Principais

1. **categorias**
   - `id`: bigint (unsigned, PK, auto-increment)
   - `nome`: varchar(255)
   - `created_at` / `updated_at`: timestamp

2. **produtos**
   - `id`: bigint (unsigned, PK, auto-increment)
   - `nome`: varchar(255)
   - `preco`: decimal(8,2)
   - `categoria_id`: bigint (unsigned, FK referenciando `id` em `categorias` com `ON DELETE CASCADE`)
   - `created_at` / `updated_at`: timestamp

### Relacionamento e Chave Estrangeira
A tabela `produtos` possui uma restrição de chave estrangeira (`produtos_categoria_id_foreign`) apontando para a coluna `id` da tabela `categorias`. A integridade referencial foi configurada com exclusão em cascata.

---

## Como Executar o Projeto

1. Clone o repositório:
   git clone <URL_DO_REPOSITORIO>

2. Acesse a pasta do projeto e instale as dependências:
   cd <NOME_DA_PASTA>
   composer install

3. Configure o arquivo `.env` com as credenciais do seu banco MySQL local:
   DB_CONNECTION=mysql
   DB_HOST=127.0.0.1
   DB_PORT=3306
   DB_DATABASE=mapeamento_db
   DB_USERNAME=root
   DB_PASSWORD=

4. Execute as migrations:
   php artisan migrate
