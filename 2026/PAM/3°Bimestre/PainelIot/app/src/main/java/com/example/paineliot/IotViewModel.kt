package com.example.paineliot

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class IotViewModel : ViewModel() {
    private val repositorio = IotRepository()

    private val _comodos = MutableStateFlow<List<Comodo>>(emptyList())
    val comodos: StateFlow<List<Comodo>> = _comodos

    private val _sensores = MutableStateFlow<List<Sensor>>(emptyList())
    val sensores: StateFlow<List<Sensor>> = _sensores

    private val _rotinas = MutableStateFlow<List<Rotina>>(emptyList())
    val rotinas: StateFlow<List<Rotina>> = _rotinas

    init {
        repositorio.listarComodos { _comodos.value = it }
        repositorio.listarSensores { _sensores.value = it }
        repositorio.listarRotinas { _rotinas.value = it }
    }

    fun adicionarComodo(nome: String, tipo: String) = repositorio.adicionarComodo(nome, tipo) { }
    // NOVA FUNÇÃO:
    fun atualizarComodo(id: String, nome: String, tipo: String) = repositorio.atualizarComodo(id, nome, tipo)
    fun deletarComodo(id: String) = repositorio.deletarComodo(id) { }

    fun adicionarSensor(nome: String, comodoId: String) = repositorio.adicionarSensor(nome, comodoId)
    fun mudarStatusSensor(sensorId: String, statusAtual: Boolean) = repositorio.mudarStatusSensor(sensorId, !statusAtual)
    fun deletarSensor(id: String) = repositorio.deletarSensor(id)

    fun adicionarRotina(dispositivoNome: String, acao: String, horario: String, comodoId: String) =
        repositorio.adicionarRotina(dispositivoNome, acao, horario, comodoId)
    fun mudarStatusRotina(rotinaId: String, statusAtual: Boolean) = repositorio.mudarStatusRotina(rotinaId, !statusAtual)
    fun deletarRotina(id: String) = repositorio.deletarRotina(id)
}