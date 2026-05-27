package com.example.degustacatalogo

import android.content.Intent
import android.os.Bundle
import android.view.View
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

        // Carrega os dados salvos
        BancoDeDados.carregar(this)

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

        atualizarVisualDataTela()
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
        atualizarVisualDataTela()
    }

    private fun atualizarVisualDataTela() {
        if (BancoDeDados.listaDegustacoes.isEmpty()) {
            layoutListaVazia.visibility = View.VISIBLE // Corrigido aqui!
        } else {
            layoutListaVazia.visibility = View.GONE
        }
    }
}