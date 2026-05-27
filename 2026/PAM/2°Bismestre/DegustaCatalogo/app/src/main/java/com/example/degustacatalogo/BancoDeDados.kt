package com.example.degustacatalogo

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject

object BancoDeDados {
    val listaDegustacoes = mutableListOf<Degustacao>()

    // Guarda a lista de dados definitivamente no telemóvel
    fun salvar(context: Context) {
        val sharedPreferences = context.getSharedPreferences("DegustaPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val jsonArray = JSONArray()

        for (item in listaDegustacoes) {
            val jsonObj = JSONObject()
            jsonObj.put("nome", item.nome)
            jsonObj.put("tipo", item.tipo)
            jsonObj.put("quantidade", item.quantidade)
            jsonObj.put("nota", item.nota.toDouble())
            jsonObj.put("imagemUri", item.imagemUri ?: "")
            jsonObj.put("dataCriacao", item.dataCriacao)
            jsonObj.put("dataModificacao", item.dataModificacao)
            jsonArray.put(jsonObj)
        }
        editor.putString("lista_produtos", jsonArray.toString())
        editor.apply()
    }

    // Recupera os dados guardados quando o app abre
    fun carregar(context: Context) {
        val sharedPreferences = context.getSharedPreferences("DegustaPrefs", Context.MODE_PRIVATE)
        val jsonString = sharedPreferences.getString("lista_produtos", null)

        // Evita duplicar itens ao carregar
        if (listaDegustacoes.isNotEmpty()) return

        if (!jsonString.isNullOrEmpty()) {
            val jsonArray = JSONArray(jsonString)
            for (i in 0 until jsonArray.length()) {
                val jsonObj = jsonArray.getJSONObject(i)
                val img = jsonObj.getString("imagemUri")

                val item = Degustacao(
                    nome = jsonObj.getString("nome"),
                    tipo = jsonObj.getString("tipo"),
                    quantidade = jsonObj.getString("quantidade"),
                    nota = jsonObj.getDouble("nota").toFloat(),
                    imagemUri = if (img.isEmpty()) null else img,
                    dataCriacao = jsonObj.getString("dataCriacao"),
                    dataModificacao = jsonObj.getString("dataModificacao")
                )
                listaDegustacoes.add(item)
            }
        }
    }
}