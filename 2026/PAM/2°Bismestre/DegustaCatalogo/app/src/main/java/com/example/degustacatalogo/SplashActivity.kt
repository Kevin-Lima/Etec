package com.example.degustacatalogo

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Inicializa o carregamento do banco de dados imediatamente
        BancoDeDados.carregar(this)

        val container = findViewById<LinearLayout>(R.id.layoutSplashContainer)
        container.animate().alpha(1.0f).setDuration(1000).start()

        Handler(Looper.getMainLooper()).postDelayed({
            // Rota Protegida Inteligente
            if (BancoDeDados.usuarioLogado != null) {
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                startActivity(Intent(this, LoginActivity::class.java))
            }
            finish()
        }, 2500)
    }
}