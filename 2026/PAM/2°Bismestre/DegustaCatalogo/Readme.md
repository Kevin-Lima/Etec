# Catálogo de Degustação

O Catálogo de Degustação é um aplicativo Android nativo projetado para registrar, organizar e avaliar diferentes experiências sensoriais gastronômicas. A aplicação funciona como um diário pessoal de degustação multicategoria, permitindo catalogar uma variedade de itens (como cafés, chás, chocolates, sucos, doces e salgados). O sistema conta com uma arquitetura de armazenamento isolado por conta, persistência de imagens em diretório privado, controle dinâmico de cronologia e uma interface moderna baseada nas diretrizes do Material Design.

## 📱 Demonstração Visual

<p align="center">
  <img src="assets/01_splash.png" alt="Tela de Carregamento (Splash Screen)" width="23%" />
  <img src="assets/02_login.png" alt="Tela de Login" width="23%" />
  <img src="assets/03_cadastro.png" alt="Tela de Cadastro" width="23%" />
  <img src="assets/04_vazio.png" alt="Catálogo de Degustação Vazio" width="23%" />
</p>

<p align="center">
  <img src="assets/05_lista.png" alt="Catálogo de Degustação com Registros" width="23%" />
  <img src="assets/06_perfil.png" alt="Tela de Perfil" width="23%" />
  <img src="assets/07_formulario.png" alt="Tela de Criação de Novo Registro" width="23%" />
  <img src="assets/08_detalhes.png" alt="Tela de Detalhes de um Item Cadastrado" width="23%" />
</p>

## 🎯 Objetivos do Projeto

Este projeto possui caráter acadêmico e de portfólio, tendo como finalidade a consolidação de conceitos fundamentais e intermediários do desenvolvimento de software nativo para a plataforma Android. O foco do desenvolvimento estruturou-se em:
* Implementação de fluxo de autenticação locais e seguros.
* Gerenciamento de ciclo de vida e persistência de dados isolados por usuário.
* Manipulação avançada de layouts XML com componentes modernos de UI/UX.
* Processamento e armazenamento seguro de mídias no armazenamento interno privado do aplicativo.

## ⚙️ Funcionalidades

### Autenticação e Segurança
* **Cadastro de Usuários:** Tela de registro com validações estritas de formulário (verificação de formato de e-mail, restrição de tamanho mínimo de senha e validação de igualdade na confirmação de senha).
* **Login Estruturado:** Sistema de autenticação local contra registros persistidos no dispositivo.
* **Ocultar/Exibir Senhas:** Implementação nativa do recurso de visibilidade de senha (*password toggle*) com feedback visual nos campos de autenticação.
* **Login Automático:** Autenticação automática e imediata após o cadastro com redirecionamento direto para a tela principal, otimizando a jornada do usuário.
* **Proteção de Rotas:** Filtro inteligente na inicialização que intercepta o estado da sessão e impede o acesso às telas do catálogo por usuários não autenticados.

### Gerenciamento de Dados Isolados
* **Dados Separados por Conta:** Arquitetura de armazenamento baseada em chaves exclusivas vinculadas ao e-mail do usuário autenticado. Registros criados pelo Usuário A são completamente invisíveis e inacessíveis para o Usuário B.
* **Persistência de Imagens Locais:** Sistema que duplica os arquivos de imagens selecionados da galeria para dentro da pasta privada da aplicação, contornando a expiração de permissões temporárias do Android e garantindo o carregamento perpétuo das mídias.
* **Histórico Cronológico Dinâmico:** Geração automatizada da data e hora de criação do registro e rastreamento automático com data e hora da última modificação sempre que o item for editado.
* **Operações CRUD Completas:** Cadastro, visualização detalhada expandida, edição integral de dados/imagens e exclusão segura monitorada por caixas de diálogo de confirmação (*AlertDialog*).

### Perfil do Usuário e Métricas
* **Painel do Usuário:** Tela de perfil organizada em cartões visuais exibindo o nome, e-mail e a data de criação da conta.
* **Foto de Perfil Personalizada:** Suporte para carregamento e alteração de foto de perfil com persistência local no dispositivo.
* **Contador de Registros Dinâmico:** Métrica calculada em tempo real que exibe o totalizador de itens catalogados exclusivamente pela conta ativa.
* **Encerramento de Sessão Seguro:** Botão de *Logout* que limpa a memória volátil de dados da interface e redireciona o usuário para a tela de autenticação, limpando o histórico de pilhas.

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** [Kotlin](https://kotlinlang.org/)
* **Interface Gráfica:** XML Layouts (`ConstraintLayout`, `LinearLayout`, `CardView`, `TextInputLayout`) baseados no ecossistema Material Design.
* **Listagem Dinâmica:** `RecyclerView` integrado ao padrão de projeto *Adapter* customizado para reciclagem otimizada de memória.
* **Armazenamento e Persistência:** `SharedPreferences` configurado com escrita síncrona imediata (`commit()`) combinado com serialização/deserialização estruturada em objetos **JSON** (`JSONArray` e `JSONObject`).
* **Captura de Mídias:** API de resultados do Android (`ActivityResultContracts.GetContent`) para integração com o seletor de arquivos nativo do sistema.

## 📂 Estrutura de Arquivos do Projeto

```text
com.example.degustacatalogo/
│
├── SplashActivity.kt      # Controla a tela de carregamento, animação de entrada e verificação de rota
├── LoginActivity.kt       # Gerencia a validação de credenciais e inicialização da sessão do usuário
├── RegisterActivity.kt    # Gerencia a criação de novas contas e fluxo de login automático
├── MainActivity.kt        # Controla a listagem principal de itens e o estado visual vazio
├── FormActivity.kt        # Controla o formulário unificado de cadastro, edição e cópia privada de mídias
├── DetailActivity.kt      # Controla a visualização detalhada de dados cronológicos e gatilhos de exclusão
├── ProfileActivity.kt     # Controla o painel de informações, foto de perfil, métricas e logout
│
├── Degustacao.kt          # Classe de dados que modela o objeto de registro de degustação
├── Usuario.kt             # Classe de dados que modela o objeto de conta do usuário
├── BancoDeDados.kt        # Mecanismo central (Singleton) de persistência isolada e leitura em JSON
└── DegustacaoAdapter.kt   # Vincula a lista de objetos filtrados aos componentes visuais do RecyclerView
