# Estruturas Moleculares 3D - App Android

## Sobre o Projeto e Tema
Este aplicativo Android foi desenvolvido do zero como parte de uma atividade prática de desenvolvimento mobile. 

O tema escolhido para a interface gráfica foi **Estruturas Moleculares 3D**. O aplicativo serve como um portal educacional/visual que exibe imagens renderizadas em alta qualidade de **compostos químicos, proteínas e fitas de DNA**. O objetivo foi criar uma identidade visual focada em ciência, biologia estrutural e química, oferecendo uma experiência limpa e moderna para o usuário.

## Pitch Prático (Vídeo de Demonstração)
No vídeo abaixo, é demonstrado o funcionamento completo do aplicativo, incluindo a integração em tempo real com o backend:
- Tela do Firebase Authentication (Console) provando a ausência de registros prévios.
- Criação de um novo usuário (Signup) diretamente no aplicativo via emulador/celular.
- Acesso à interface gráfica 100% desenvolvida em Jetpack Compose com o tema de Estruturas Moleculares 3D.
- Atualização do painel do Firebase mostrando a persistência do novo usuário com sucesso.

▶️ **[Clique aqui para assistir ao vídeo de demonstração no YouTube](https://youtu.be/OKaho702Qw0)**

## Funcionalidades (Features)
- **Autenticação Segura:** Criação de conta e login utilizando o Firebase Authentication (E-mail e Senha).
- **Gerenciamento de Estado:** Utilização de `ViewModel` e `LiveData` para controlar os estados de carregamento, sucesso e erro durante a autenticação.
- **Navegação (Navigation Compose):** Roteamento fluido entre as telas de Login, Cadastro (Signup) e Home.
- **Interface Gráfica UI/UX:** 100% construída utilizando a tecnologia moderna **Jetpack Compose**.
- **Galeria Visual:** Uso de `LazyColumn` para listar renderizações moleculares 3D de forma otimizada.
- **Recursos Nativos:** Ocultar/Mostrar senha e rolagem de tela para se adaptar a diferentes tamanhos de dispositivos.

## Tecnologias Utilizadas
- **Linguagem:** [Kotlin](https://kotlinlang.org/)
- **UI Toolkit:** [Jetpack Compose](https://developer.android.com/jetpack/compose)
- **Backend/Autenticação:** [Firebase Authentication](https://firebase.google.com/docs/auth)
- **IDE:** Android Studio
