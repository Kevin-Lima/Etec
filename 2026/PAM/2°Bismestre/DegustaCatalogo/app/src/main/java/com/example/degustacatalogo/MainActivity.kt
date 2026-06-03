package com.example.degustacatalogo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: DegustacaoAdapter
    private lateinit var layoutListaVazia: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Força o carregamento seguro do estado do banco
        BancoDeDados.carregar(this)

        // BARREIRA DE PROTEÇÃO: Se a sessão for inválida, aborta e exige login
        if (BancoDeDados.usuarioLogado == null) {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
            return
        }

        layoutListaVazia = findViewById(R.id.layoutListaVazia)

        val fabAdicionar = findViewById<FloatingActionButton>(R.id.fabAdicionar)
        fabAdicionar.setOnClickListener {
            val intent = Intent(this, FormActivity::class.java)
            startActivity(intent)
        }

        val rvDegustacoes = findViewById<RecyclerView>(R.id.rvDegustacoes)
        rvDegustacoes.layoutManager = LinearLayoutManager(this)

        adapter = DegustacaoAdapter(BancoDeDados.listaDegustacoes)
        rvDegustacoes.adapter = adapter

        // Vinculação e clique do botão de perfil do cabeçalho
        val ivHeaderPerfil = findViewById<ImageView>(R.id.ivHeaderPerfil)
        ivHeaderPerfil.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        atualizarVisualDataTela()
    }

    override fun onResume() {
        super.onResume()
        // Força a atualização da lista baseada na memória estável do adapter
        adapter.notifyDataSetChanged()
        atualizarVisualDataTela()
    }

    private fun atualizarVisualDataTela() {
        if (BancoDeDados.listaDegustacoes.isEmpty()) {
            layoutListaVazia.visibility = View.VISIBLE
        } else {
            layoutListaVazia.visibility = View.GONE
        }
    }
}