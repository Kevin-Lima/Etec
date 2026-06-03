package com.example.degustacatalogo

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val etNome = findViewById<TextInputEditText>(R.id.etRegNome)
        val etEmail = findViewById<TextInputEditText>(R.id.etRegEmail)
        val etSenha = findViewById<TextInputEditText>(R.id.etRegSenha)
        val etConfirmar = findViewById<TextInputEditText>(R.id.etRegConfirmarSenha)
        val btnCadastrar = findViewById<Button>(R.id.btnCadastrar)
        val tvLogin = findViewById<TextView>(R.id.tvIrParaLogin)

        btnCadastrar.setOnClickListener {
            val nome = etNome.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val senha = etSenha.text.toString().trim()
            val confirmar = etConfirmar.text.toString().trim()

            if (nome.isEmpty()) { etNome.error = "Campo obrigatório"; return@setOnClickListener }
            if (email.isEmpty()) { etEmail.error = "Campo obrigatório"; return@setOnClickListener }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) { etEmail.error = "E-mail inválido"; return@setOnClickListener }
            if (senha.length < 6) { etSenha.error = "A senha deve ter pelo menos 6 dígitos"; return@setOnClickListener }
            if (confirmar != senha) { etConfirmar.error = "As senhas não coincidem"; return@setOnClickListener }

            if (BancoDeDados.listaUsuarios.any { it.email == email }) {
                Toast.makeText(this, "Este e-mail já está cadastrado.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val dataAtual = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Calendar.getInstance().time)
            val novoUsuario = Usuario(nome, email, senha, dataAtual)

            // Registra e isola a memória instantaneamente
            BancoDeDados.listaUsuarios.add(novoUsuario)
            BancoDeDados.usuarioLogado = novoUsuario
            BancoDeDados.listaDegustacoes.clear() // Nova conta obrigatoriamente inicia com catálogo limpo
            BancoDeDados.salvar(this)

            Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }

        tvLogin.setOnClickListener { finish() }
    }
}