package com.example.degustacatalogo

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        BancoDeDados.carregar(this)

        val etEmail = findViewById<TextInputEditText>(R.id.etLoginEmail)
        val etSenha = findViewById<TextInputEditText>(R.id.etLoginSenha)
        val btnEntrar = findViewById<Button>(R.id.btnEntrar)
        val tvCadastro = findViewById<TextView>(R.id.tvIrParaCadastro)

        btnEntrar.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val senha = etSenha.text.toString().trim()

            if (email.isEmpty()) { etEmail.error = "Campo obrigatório"; return@setOnClickListener }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) { etEmail.error = "E-mail inválido"; return@setOnClickListener }
            if (senha.isEmpty()) { etSenha.error = "Campo obrigatório"; return@setOnClickListener }

            val usuarioEncontrado = BancoDeDados.listaUsuarios.find { it.email == email && it.senha == senha }
            if (usuarioEncontrado != null) {
                // Sincronização limpa de dados em memória
                BancoDeDados.usuarioLogado = usuarioEncontrado
                BancoDeDados.listaDegustacoes.clear() // Expulsa dados da conta deslogada da memória ram
                BancoDeDados.carregar(this) // Lê do disco os dados apenas desta conta ativa
                BancoDeDados.salvar(this) // Consolida estado

                Toast.makeText(this, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "E-mail ou senha incorretos.", Toast.LENGTH_LONG).show()
            }
        }

        tvCadastro.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}