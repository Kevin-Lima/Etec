package com.example.degustacatalogo

data class Usuario(
    var nome: String,
    val email: String,
    var senha: String,
    val dataCriacao: String,
    var fotoUri: String? = null
)