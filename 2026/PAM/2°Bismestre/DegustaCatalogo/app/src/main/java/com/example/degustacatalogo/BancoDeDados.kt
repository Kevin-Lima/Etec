package com.example.degustacatalogo

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject

object BancoDeDados {
    val listaDegustacoes = mutableListOf<Degustacao>()
    val listaUsuarios = mutableListOf<Usuario>()
    var usuarioLogado: Usuario? = null

    fun salvar(context: Context) {
        val sharedPreferences = context.getSharedPreferences("DegustaPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        // 1. Salva a lista global de Usuários cadastrados
        val jsonArrayUsuarios = JSONArray()
        for (user in listaUsuarios) {
            val jsonObj = JSONObject()
            jsonObj.put("nome", user.nome)
            jsonObj.put("email", user.email)
            jsonObj.put("senha", user.senha)
            jsonObj.put("dataCriacao", user.dataCriacao)
            jsonObj.put("fotoUri", user.fotoUri ?: "")
            jsonArrayUsuarios.put(jsonObj)
        }
        editor.putString("lista_usuarios", jsonArrayUsuarios.toString())

        // 2. Salva o Estado do Login do Usuário atual
        editor.putString("email_logado", usuarioLogado?.email ?: "")

        // 3. Salva as Degustações na chave EXCLUSIVA do e-mail do usuário logado
        usuarioLogado?.let { user ->
            val jsonArrayDegustacoes = JSONArray()
            for (item in listaDegustacoes) {
                val jsonObj = JSONObject()
                jsonObj.put("nome", item.nome)
                jsonObj.put("tipo", item.tipo)
                jsonObj.put("quantidade", item.quantidade)
                jsonObj.put("nota", item.nota.toDouble())
                jsonObj.put("imagemUri", item.imagemUri ?: "")
                jsonObj.put("dataCriacao", item.dataCriacao)
                jsonObj.put("dataModificacao", item.dataModificacao)
                jsonArrayDegustacoes.put(jsonObj)
            }
            editor.putString("lista_produtos_${user.email}", jsonArrayDegustacoes.toString())
        }

        // commit() garante escrita síncrona imediata eliminando falhas de leitura entre telas
        editor.commit()
    }

    fun carregar(context: Context) {
        val sharedPreferences = context.getSharedPreferences("DegustaPrefs", Context.MODE_PRIVATE)

        // Carrega a lista global de usuários apenas se estiver vazia na memória
        if (listaUsuarios.isEmpty()) {
            val usersString = sharedPreferences.getString("lista_usuarios", null)
            if (!usersString.isNullOrEmpty()) {
                val jsonArray = JSONArray(usersString)
                for (i in 0 until jsonArray.length()) {
                    val jsonObj = jsonArray.getJSONObject(i)
                    val foto = jsonObj.getString("fotoUri")
                    listaUsuarios.add(Usuario(
                        nome = jsonObj.getString("nome"),
                        email = jsonObj.getString("email"),
                        senha = jsonObj.getString("senha"),
                        dataCriacao = jsonObj.getString("dataCriacao"),
                        fotoUri = if (foto.isEmpty()) null else foto
                    ))
                }
            }
        }

        // Restaura a sessão ativa se a memória foi limpa pelo sistema operacional
        if (usuarioLogado == null) {
            val emailLogado = sharedPreferences.getString("email_logado", "") ?: ""
            if (emailLogado.isNotEmpty()) {
                usuarioLogado = listaUsuarios.find { it.email == emailLogado }
            }
        }

        // Força o carregamento dos itens específicos deste usuário se a lista em memória estiver vazia
        usuarioLogado?.let { user ->
            if (listaDegustacoes.isEmpty()) {
                val jsonString = sharedPreferences.getString("lista_produtos_${user.email}", null)
                if (!jsonString.isNullOrEmpty()) {
                    val jsonArray = JSONArray(jsonString)
                    for (i in 0 until jsonArray.length()) {
                        val jsonObj = jsonArray.getJSONObject(i)
                        val img = jsonObj.getString("imagemUri")
                        listaDegustacoes.add(Degustacao(
                            nome = jsonObj.getString("nome"),
                            tipo = jsonObj.getString("tipo"),
                            quantidade = jsonObj.getString("quantidade"),
                            nota = jsonObj.getDouble("nota").toFloat(),
                            imagemUri = if (img.isEmpty()) null else img,
                            dataCriacao = jsonObj.getString("dataCriacao"),
                            dataModificacao = jsonObj.getString("dataModificacao")
                        ))
                    }
                }
            }
        } ?: run {
            listaDegustacoes.clear()
        }
    }
}