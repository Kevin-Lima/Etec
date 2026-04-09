
# Logcat Mentions App

Aplicativo Android desenvolvido em **Kotlin + Jetpack Compose** para demonstrar na prática os níveis de log do Android (`Log.e`, `Log.w`, `Log.d`, `Log.i`) usando a API `android.util.Log`.

## Como funciona

A tela exibe um campo para digitar o nome e quatro botões de menção. Cada botão registra uma mensagem no Logcat com base na menção selecionada.

| Botão | Método | Nível do Log | Mensagem registrada |
|-------|--------|--------------|---------------------|
| 🔴 **Menção I** | `Log.e()` | Erro | Informa que a menção é I |
| 🟠 **Menção R** | `Log.w()` | Aviso | Informa que a menção é R |
| 🟢 **Menção B** | `Log.d()` | Debug | Informa que a menção é B |
| 🔵 **Menção MB** | `Log.i()` | Informação | Informa que a menção é MB |

> O nome digitado é incluído na mensagem exibida no Logcat, simulando um cenário real de uso.

---

## Screenshots

### Tela do app
<div align="center">
  <img src="screenshots/app.png" width="300"/>
</div>

### Saída no Logcat
![Logcat](screenshots/logcat.png)
---

## Como executar

```bash
git clone https://github.com/Wallex-Andre/logcat-mentions-app.git
```
1. Abra o projeto no Android Studio
2. Aguarde o Gradle sincronizar
3. Conecte um dispositivo físico ou inicie um emulador
4. Clique em Run ▶️

## Como usar o app

1. Digite um nome no campo de texto
2. Clique em uma das menções (I, R, B, MB)
3. Abra o painel Logcat
4. Filtre por: package:mine
5. Visualize as mensagens geradas
