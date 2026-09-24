package com.example.paineliot

import com.google.firebase.firestore.FirebaseFirestore

class IotRepository {
    private val db = FirebaseFirestore.getInstance()
    private val comodosRef = db.collection("comodos")
    private val sensoresRef = db.collection("sensores")
    private val rotinasRef = db.collection("rotinas")

    // --- AMBIENTES (CÔMODOS) ---
    fun adicionarComodo(nome: String, tipo: String, onResult: (Boolean) -> Unit) {
        val id = comodosRef.document().id
        comodosRef.document(id).set(Comodo(id, nome, tipo))
            .addOnSuccessListener { onResult(true) }
            .addOnFailureListener { onResult(false) }
    }

    // NOVA FUNÇÃO: Editar (Update)
    fun atualizarComodo(id: String, nome: String, tipo: String) {
        comodosRef.document(id).update(mapOf("nome" to nome, "tipo" to tipo))
    }

    fun listarComodos(onResult: (List<Comodo>) -> Unit) {
        comodosRef.addSnapshotListener { snapshot, _ ->
            if (snapshot != null) onResult(snapshot.toObjects(Comodo::class.java))
        }
    }

    fun deletarComodo(id: String, onResult: (Boolean) -> Unit) {
        comodosRef.document(id).delete().addOnSuccessListener { onResult(true) }
    }

    // --- SENSORES ---
    fun adicionarSensor(nome: String, comodoId: String) {
        val id = sensoresRef.document().id
        sensoresRef.document(id).set(Sensor(id, nome, false, comodoId))
    }

    fun listarSensores(onResult: (List<Sensor>) -> Unit) {
        sensoresRef.addSnapshotListener { snapshot, _ ->
            if (snapshot != null) onResult(snapshot.toObjects(Sensor::class.java))
        }
    }

    fun mudarStatusSensor(sensorId: String, ativo: Boolean) {
        sensoresRef.document(sensorId).update("ativo", ativo)
    }

    fun deletarSensor(id: String) = sensoresRef.document(id).delete()

    // --- ROTINAS ---
    fun adicionarRotina(dispositivoNome: String, acao: String, horario: String, comodoId: String) {
        val id = rotinasRef.document().id
        val novaRotina = Rotina(id, dispositivoNome, acao, horario, true, comodoId)
        rotinasRef.document(id).set(novaRotina)
    }

    fun listarRotinas(onResult: (List<Rotina>) -> Unit) {
        rotinasRef.addSnapshotListener { snapshot, _ ->
            if (snapshot != null) onResult(snapshot.toObjects(Rotina::class.java))
        }
    }

    fun mudarStatusRotina(rotinaId: String, ativa: Boolean) {
        rotinasRef.document(rotinaId).update("ativa", ativa)
    }

    fun deletarRotina(id: String) = rotinasRef.document(id).delete()
}