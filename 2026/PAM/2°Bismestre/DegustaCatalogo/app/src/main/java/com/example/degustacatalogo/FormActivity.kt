package com.example.degustacatalogo

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class FormActivity : AppCompatActivity() {

    private var uriImagemSelecionada: Uri? = null
    private var posicaoEditar: Int = -1
    private lateinit var ivPreview: ImageView

    // Variáveis de controle para monitorar alterações acidentais na Edição
    private var originalNome = ""
    private var originalTipo = ""
    private var originalQuantidade = ""
    private var originalNota = 0f
    private var originalImagem: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        val tvTituloForm = findViewById<TextView>(R.id.tvTituloForm)
        ivPreview = findViewById(R.id.ivFormFotoPreview)
        val btnFoto = findViewById<Button>(R.id.btnSelecionarFoto)
        val etNome = findViewById<EditText>(R.id.etNomeProduto)
        val etTipo = findViewById<EditText>(R.id.etTipoProduto)
        val etQuantidade = findViewById<EditText>(R.id.etQuantidade)
        val rbNota = findViewById<RatingBar>(R.id.rbNota)
        val btnCancelar = findViewById<Button>(R.id.btnCancelar)
        val btnSalvar = findViewById<Button>(R.id.btnSalvar)

        posicaoEditar = intent.getIntExtra("POSICAO_ITEM", -1)

        if (posicaoEditar != -1) {
            val item = BancoDeDados.listaDegustacoes[posicaoEditar]
            tvTituloForm.text = "Editar Registro"
            etNome.setText(item.nome)
            etTipo.setText(item.tipo)
            etQuantidade.setText(item.quantidade)
            rbNota.rating = item.nota

            // Grava o backup dos valores originais para checagem posterior
            originalNome = item.nome
            originalTipo = item.tipo
            originalQuantidade = item.quantidade
            originalNota = item.nota
            originalImagem = item.imagemUri

            try {
                if (!item.imagemUri.isNullOrEmpty()) {
                    uriImagemSelecionada = Uri.parse(item.imagemUri)
                    ivPreview.setImageURI(uriImagemSelecionada)
                }
            } catch (e: Exception) {
                ivPreview.setImageResource(android.R.drawable.ic_menu_gallery)
            }
        }

        val selecionarFoto = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            if (uri != null) {
                uriImagemSelecionada = uri
                ivPreview.setImageURI(uri)
            }
        }

        btnFoto.setOnClickListener {
            selecionarFoto.launch("image/*")
        }

        // Evento do botão Cancelar com validação inteligente
        btnCancelar.setOnClickListener {
            if (posicaoEditar != -1) {
                // Modo Edição: Compara se algo mudou em relação ao início
                val mudou = etNome.text.toString() != originalNome ||
                        etTipo.text.toString() != originalTipo ||
                        etQuantidade.text.toString() != originalQuantidade ||
                        rbNota.rating != originalNota ||
                        (uriImagemSelecionada?.toString() ?: "") != (originalImagem ?: "")

                if (mudou) {
                    AlertDialog.Builder(this)
                        .setTitle("Descartar Alterações")
                        .setMessage("Você fez modificações neste registro. Deseja realmente sair sem salvar?")
                        .setPositiveButton("Sim") { _, _ -> finish() }
                        .setNegativeButton("Não", null)
                        .show()
                } else {
                    finish()
                }
            } else {
                // Modo Criação: Fecha direto sem alertas
                finish()
            }
        }

        btnSalvar.setOnClickListener {
            val nome = etNome.text.toString()
            val tipo = etTipo.text.toString()
            val quantidade = etQuantidade.text.toString()
            val nota = rbNota.rating

            val dataSimple = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
            val dataAtual = dataSimple.format(Calendar.getInstance().time)

            var caminhoFinalImagem: String? = uriImagemSelecionada?.toString()
            uriImagemSelecionada?.let { uri ->
                if (uri.scheme == "content") {
                    val uriCopiada = copiarImagemParaArmazenamentoInterno(uri)
                    if (uriCopiada != null) {
                        caminhoFinalImagem = uriCopiada.toString()
                    }
                }
            }

            if (posicaoEditar != -1) {
                val item = BancoDeDados.listaDegustacoes[posicaoEditar]
                item.nome = nome
                item.tipo = tipo
                item.quantidade = quantidade
                item.nota = nota
                item.imagemUri = caminhoFinalImagem
                item.dataModificacao = dataAtual
            } else {
                val novaDegustacao = Degustacao(
                    nome = nome,
                    tipo = tipo,
                    quantidade = quantidade,
                    nota = nota,
                    imagemUri = caminhoFinalImagem,
                    dataCriacao = dataAtual,
                    dataModificacao = "Nenhuma modificação realizada"
                )
                BancoDeDados.listaDegustacoes.add(novaDegustacao)
            }

            BancoDeDados.salvar(this)
            finish()
        }
    }

    private fun copiarImagemParaArmazenamentoInterno(uri: Uri): Uri? {
        try {
            val inputStream = contentResolver.openInputStream(uri) ?: return null
            val arquivoDestino = File(filesDir, "degustacao_${System.currentTimeMillis()}.jpg")
            val outputStream = FileOutputStream(arquivoDestino)

            val buffer = ByteArray(1024)
            var bytesLidos: Int
            while (inputStream.read(buffer).also { bytesLidos = it } != -1) {
                outputStream.write(buffer, 0, bytesLidos)
            }

            inputStream.close()
            outputStream.close()
            return Uri.fromFile(arquivoDestino)
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }
    }
}