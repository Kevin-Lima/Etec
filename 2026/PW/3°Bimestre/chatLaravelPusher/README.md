# Desenvolvimento de Chat no Laravel - WebSocket

Este projeto é uma aplicação web de chat em tempo real desenvolvida em Laravel. O objetivo principal é demonstrar o uso da tecnologia WebSocket para estabelecer uma conexão persistente e bidirecional entre o cliente e o servidor, permitindo a troca de mensagens instantâneas sem a necessidade de recarregar a página (HTTP tradicional).

## Demonstração em Vídeo

Acesse o vídeo com a demonstração da comunicação em tempo real e a explicação do código-fonte: 
https://youtu.be/1aaAg9yT2z0

## Tecnologias Utilizadas

- PHP / Laravel (Framework Back-end)
- MySQL (Banco de Dados)
- Laravel Breeze (Autenticação de Usuários)
- Chatify (Pacote para a interface e lógica do chat)
- Pusher (Serviço de WebSocket na nuvem)
- Node.js / NPM (Compilação de assets)

## Etapas de Construção do Projeto

O projeto foi construído seguindo as seguintes etapas:

1. Criação do Projeto:
   Foi criado um novo projeto Laravel utilizando o comando:
   `composer create-project laravel/laravel chatLaravelPusher`

2. Configuração do Banco de Dados:
   Criação de um banco de dados local chamado `chatweb3ams` no phpMyAdmin e configuração da conexão no arquivo `.env`.

3. Sistema de Autenticação:
   Instalação do pacote Laravel Breeze para gerenciar os perfis de usuários, login e registro.
   `composer require laravel/breeze --dev`
   `php artisan breeze:install`

4. Instalação do Chatify:
   Pacote responsável por fornecer o sistema completo do chat.
   `composer require munafio/chatify`
   `php artisan chatify:install`
   Após a instalação, as tabelas foram migradas para o banco com `php artisan migrate`.

5. Configuração do WebSocket (Pusher):
   Criação de um App no site Pusher selecionando o cluster `us2`. As credenciais geradas foram adicionadas ao arquivo `.env` da aplicação:
   ```env
   PUSHER_APP_ID=seu_id
   PUSHER_APP_KEY=sua_key
   PUSHER_APP_SECRET=seu_secret
   PUSHER_HOST=
   PUSHER_PORT=443
   PUSHER_SCHEME=https
   PUSHER_APP_CLUSTER=us2
