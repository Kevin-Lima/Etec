# Atividade Laravel - Middlewares e Controller

Este projeto consiste em uma aplicação desenvolvida no framework **Laravel** como parte das atividades práticas da disciplina. O objetivo principal é demonstrar o funcionamento de um fluxo de requisição HTTP interceptado por um **Middleware** personalizado antes de ser processado por um **Controller** e exibido em uma **View** Blade.

---

## Estrutura e Lógica do Projeto

O fluxo da aplicação funciona da seguinte forma:

1. **Rota (`routes/web.php`)**: Define a rota GET `/portal`, vinculando-a ao método `index` do `PortalController` e aplicando o middleware `VerificaAcesso`.
2. **Middleware (`app/Http/Middleware/VerificaAcesso.php`)**: Intercepta a requisição e verifica se o parâmetro `acesso=permitido` está presente na URL.
   - Caso a regra não seja atendida, a requisição é bloqueada e retorna o status HTTP **403 Forbidden** com as mensagens de aviso.
   - Caso o acesso seja permitido, a requisição é liberada para o Controller.
3. **Controller (`app/Http/Controllers/PortalController.php`)**: Processa a requisição aprovada, define a variável de mensagem de boas-vindas e chama a View.
4. **View (`resources/views/portal.blade.php`)**: Renderiza a interface exibindo o conteúdo enviado pelo Controller.

---

## Mensagens da Aplicação

### 1. Mensagens de Bloqueio (Middleware)
Quando a URL é acessada diretamente (`/portal` sem permissão):
- **Mensagem:** "Seu acesso não foi autorizado."
- **Instrução:** "Entrar em contato com o administrador."

### 2. Mensagem de Sucesso (Controller + View)
Quando a URL é acessada com o parâmetro de acesso autorizado (`/portal?acesso=permitido`):
- **Mensagem:** "Bem vindo ao portal"