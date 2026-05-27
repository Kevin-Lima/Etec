package com.example.degustacatalogo

// Este arquivo agora guarda APENAS a estrutura do dado
data class Degustacao(
    var nome: String,
    var tipo: String,
    var quantidade: String,
    var nota: Float,
    var imagemUri: String? = null,
    val dataCriacao: String,
    var dataModificacao: String
)