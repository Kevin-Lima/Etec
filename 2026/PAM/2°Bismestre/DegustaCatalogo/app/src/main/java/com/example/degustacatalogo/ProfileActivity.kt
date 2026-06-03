package com.example.degustacatalogo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import java.io.File
import java.io.FileOutputStream

class ProfileActivity : AppCompatActivity() {

    private var uriFotoPerfil: Uri? = null
    private lateinit var ivFoto: ImageView
    private lateinit var tvTotal: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val user = BancoDeDados.usuarioLogado
        if (user == null) { finish(); return }

        ivFoto = findViewById(R.id.ivPerfilFoto)
        val btnVoltar = findViewById<ImageButton>(R.id.btnPerfilVoltar) // Novo botão importado
        val btnFoto = findViewById<Button>(R.id.btnAlterarFotoPerfil)
        val etNome = findViewById<TextInputEditText>(R.id.etPerfilNome)
        val tvEmail = findViewById<TextView>(R.id.tvPerfilEmail)
        val tvData = findViewById<TextView>(R.id.tvPerfilDataCriacao)
        tvTotal = findViewById(R.id.tvPerfilTotalRegistros)
        val btnLogout = findViewById<Button>(R.id.btnPerfilLogout)
        val btnSalvar = findViewById<Button>(R.id.btnPerfilSalvar)

        etNome.setText(user.nome)
        tvEmail.text = "E-mail: ${user.email}"
        tvData.text = "Membro desde: ${user.dataCriacao}"

        try {
            if (!user.fotoUri.isNullOrEmpty()) {
                ivFoto.setImageURI(Uri.parse(user.fotoUri))
            } else {
                ivFoto.setImageResource(android.R.drawable.ic_menu_camera)
            }
        } catch (e: Exception) {
            ivFoto.setImageResource(android.R.drawable.ic_menu_camera)
        }

        // Configuração de clique do botão voltar superior da interface
        btnVoltar.setOnClickListener {
            finish() // Fecha a atividade atual e retorna de forma fluida para a anterior
        }

        val selecionarFoto = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            if (uri != null) {
                uriFotoPerfil = uri
                ivFoto.setImageURI(uri)
            }
        }

        btnFoto.setOnClickListener { selecionarFoto.launch("image/*") }

        btnSalvar.setOnClickListener {
            val novoNome = etNome.text.toString().trim()
            if (novoNome.isEmpty()) { etNome.error = "Nome inválido"; return@setOnClickListener }

            user.nome = novoNome

            uriFotoPerfil?.let { uri ->
                if (uri.scheme == "content") {
                    val copiada = copiarFotoPerfil(uri)
                    if (copiada != null) user.fotoUri = copiada.toString()
                }
            }

            BancoDeDados.salvar(this)
            Toast.makeText(this, "Perfil updated com sucesso!", Toast.LENGTH_SHORT).show()
            finish()
        }

        btnLogout.setOnClickListener {
            BancoDeDados.usuarioLogado = null
            BancoDeDados.listaDegustacoes.clear()
            BancoDeDados.salvar(this)

            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        val totalItens = BancoDeDados.listaDegustacoes.size
        tvTotal.text = if (totalItens == 1) "1 item catalogado" else "$totalItens itens catalogados"
    }

    private fun copiarFotoPerfil(uri: Uri): Uri? {
        try {
            val inputStream = contentResolver.openInputStream(uri) ?: return null
            val arquivoDestino = File(filesDir, "perfil_${System.currentTimeMillis()}.jpg")
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
            return null
        }
    }
}