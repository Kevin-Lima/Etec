package com.example.degustacatalogo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    private var posicao: Int = -1
    private lateinit var ivFoto: ImageView
    private lateinit var tvNome: TextView
    private lateinit var tvTipo: TextView
    private lateinit var tvQuantidade: TextView
    private lateinit var rbNota: RatingBar
    private lateinit var tvCriacao: TextView
    private lateinit var tvModificacao: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        posicao = intent.getIntExtra("POSICAO_ITEM", -1)
        if (posicao == -1) { finish(); return }

        ivFoto = findViewById(R.id.ivDetalheFoto)
        tvNome = findViewById(R.id.tvDetalheNome)
        tvTipo = findViewById(R.id.tvDetalheTipo)
        tvQuantidade = findViewById(R.id.tvDetalheQuantidade)
        rbNota = findViewById(R.id.rbDetalheNota)
        tvCriacao = findViewById(R.id.tvDetalheDataCriacao)
        tvModificacao = findViewById(R.id.tvDetalheDataModificacao)

        val btnVoltar = findViewById<Button>(R.id.btnVoltar)
        val btnExcluir = findViewById<Button>(R.id.btnExcluir)
        val btnEditar = findViewById<Button>(R.id.btnEditar)

        // Ação do novo botão voltar de UI
        btnVoltar.setOnClickListener {
            finish()
        }

        btnExcluir.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Excluir Registro")
                .setMessage("Tem certeza de que deseja excluir esta degustação?")
                .setPositiveButton("Sim") { _, _ ->
                    if (posicao < BancoDeDados.listaDegustacoes.size) {
                        BancoDeDados.listaDegustacoes.removeAt(posicao)
                        BancoDeDados.salvar(this)
                    }
                    finish()
                }
                .setNegativeButton("Não", null)
                .show()
        }

        btnEditar.setOnClickListener {
            val intent = Intent(this, FormActivity::class.java)
            intent.putExtra("POSICAO_ITEM", posicao)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        if (posicao != -1 && posicao < BancoDeDados.listaDegustacoes.size) {
            val item = BancoDeDados.listaDegustacoes[posicao]
            tvNome.text = item.nome
            tvTipo.text = "Tipo: ${item.tipo}"
            tvQuantidade.text = "Quantidade: ${item.quantidade}"
            rbNota.rating = item.nota
            tvCriacao.text = "Cadastrado em: ${item.dataCriacao}"
            tvModificacao.text = "Última modificação: ${item.dataModificacao}"

            carregarImagemSegura(item.imagemUri)
        } else {
            finish()
        }
    }

    private fun carregarImagemSegura(uriString: String?) {
        if (uriString.isNullOrEmpty()) {
            ivFoto.setImageResource(android.R.drawable.ic_menu_gallery)
            return
        }
        try {
            val uri = Uri.parse(uriString)
            val stream = contentResolver.openInputStream(uri)
            stream?.close()
            ivFoto.setImageURI(uri)
        } catch (e: Exception) {
            ivFoto.setImageResource(android.R.drawable.ic_menu_gallery)
        }
    }
}