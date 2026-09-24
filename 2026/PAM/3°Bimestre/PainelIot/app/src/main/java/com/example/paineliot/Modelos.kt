package com.example.paineliot

data class Comodo(
    var id: String = "",
    var nome: String = "",
    var tipo: String = ""
)

data class Sensor(
    var id: String = "",
    var nome: String = "",
    var ativo: Boolean = false,
    var comodoId: String = ""
)

data class Rotina(
    var id: String = "",
    var dispositivoNome: String = "", // Guarda o nome do sensor específico
    var acao: String = "Ligar",       // "Ligar" ou "Desligar"
    var horario: String = "",
    var ativa: Boolean = true,        // Permite pausar a rotina sem excluí-la
    var comodoId: String = ""
)