# Painel de Automação IoT

Este projeto é uma aplicação Android desenvolvida com **Kotlin** e **Jetpack Compose**, criada para servir como um painel de controlo centralizado para uma Casa Inteligente (Smart Home). 

O projeto cumpre o tema: **Painel de Automação IoT: CRUD de cômodos, rotinas programadas e sensores de presença vinculados**. Toda a informação é gerida em tempo real utilizando a base de dados **Firebase Firestore**.

## Demonstração do Projeto

Assista ao vídeo demonstrativo com a explicação e funcionamento do aplicativo, incluindo a sincronização em tempo real com o banco de dados Firebase:

**Link do vídeo:** [https://youtu.be/9bZ4yIvOq90](https://youtu.be/9bZ4yIvOq90)

## Funcionalidades (CRUD Completo)

O aplicativo implementa as quatro operações básicas (Create, Read, Update, Delete) em três entidades distintas:

1. **Ambientes (Cômodos):**
   * **Create:** Adicionar novos ambientes definindo o nome e o tipo (ex: Quarto, Sala, Escritório).
   * **Read:** Listagem completa de todos os ambientes cadastrados no painel principal.
   * **Update:** Edição do nome e do tipo do ambiente selecionado.
   * **Delete:** Remoção de ambientes com alerta de confirmação.

2. **Dispositivos (Sensores de Presença):**
   * **Create:** Vinculação de novos sensores diretamente a um ambiente específico.
   * **Read:** Visualização dos dispositivos associados a cada ambiente.
   * **Update:** Alteração de estado (Ligar/Desligar) guardada instantaneamente através de um componente `Switch`.
   * **Delete:** Remoção individual de sensores do ambiente.

3. **Automações (Rotinas Programadas):**
   * **Create:** Programação de novas rotinas selecionando um dispositivo existente no ambiente, a ação desejada (Ligar/Desligar) e o horário.
   * **Read:** Listagem das rotinas programadas por ambiente.
   * **Update:** Ativação ou pausa temporária da rotina sem necessidade de a excluir.
   * **Delete:** Exclusão definitiva de rotinas programadas.

## Tecnologias Utilizadas

* **Linguagem:** [Kotlin](https://kotlinlang.org/)
* **Interface de Utilizador:** [Jetpack Compose](https://developer.android.com/jetpack/compose) (Material Design 3)
* **Base de Dados:** [Firebase Cloud Firestore](https://firebase.google.com/docs/firestore) (Sincronização em tempo real e arquitetura NoSQL)
* **Arquitetura:** Padrão MVVM (Model-View-ViewModel) com `StateFlow` para gestão de estado reativa.
