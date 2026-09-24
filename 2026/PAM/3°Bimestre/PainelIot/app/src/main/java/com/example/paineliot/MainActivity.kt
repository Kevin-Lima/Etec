package com.example.paineliot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(colorScheme = darkColorScheme()) {
                Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFF0F1014)) {
                    PainelIotApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PainelIotApp(viewModel: IotViewModel = viewModel()) {
    val comodos by viewModel.comodos.collectAsState()
    val sensores by viewModel.sensores.collectAsState()
    val rotinas by viewModel.rotinas.collectAsState()

    var mostrarDialogComodo by remember { mutableStateOf(false) }
    var nomeNovoComodo by remember { mutableStateOf("") }
    var tipoNovoComodo by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Filled.HomeRepairService, contentDescription = "Logo", tint = Color(0xFF00FFCC))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Painel IoT Pro", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 22.sp)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF16181D)),
                modifier = Modifier.background(Color(0xFF16181D))
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { mostrarDialogComodo = true },
                containerColor = Color(0xFF00FFCC),
                elevation = FloatingActionButtonDefaults.elevation(8.dp)
            ) {
                Icon(Icons.Filled.Add, contentDescription = "Adicionar", tint = Color.Black)
            }
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).fillMaxSize()) {
            if (comodos.isEmpty()) {
                Column(
                    modifier = Modifier.fillMaxSize().padding(32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(Icons.Filled.DashboardCustomize, contentDescription = "Vazio", tint = Color.DarkGray, modifier = Modifier.size(80.dp))
                    Spacer(Modifier.height(16.dp))
                    Text("Nenhum ambiente configurado.", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
                    Text("Clique no botão + abaixo para começar a montar a sua Casa Inteligente.", color = Color.Gray, fontSize = 16.sp, textAlign = TextAlign.Center, modifier = Modifier.padding(top = 8.dp))
                }
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(comodos) { comodo ->
                        CardComodo(
                            comodo = comodo,
                            sensores = sensores.filter { it.comodoId == comodo.id },
                            rotinas = rotinas.filter { it.comodoId == comodo.id },
                            viewModel = viewModel
                        )
                    }
                }
            }
        }
    }

    if (mostrarDialogComodo) {
        AlertDialog(
            onDismissRequest = { mostrarDialogComodo = false },
            title = { Text("Novo Ambiente", fontWeight = FontWeight.Bold) },
            text = {
                Column {
                    OutlinedTextField(value = nomeNovoComodo, onValueChange = { nomeNovoComodo = it }, label = { Text("Nome (ex: Sala de Estar)") }, singleLine = true, modifier = Modifier.fillMaxWidth())
                    Spacer(Modifier.height(8.dp))
                    OutlinedTextField(value = tipoNovoComodo, onValueChange = { tipoNovoComodo = it }, label = { Text("Tipo (ex: Sala)") }, singleLine = true, modifier = Modifier.fillMaxWidth())
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        if (nomeNovoComodo.isNotBlank()) {
                            viewModel.adicionarComodo(nomeNovoComodo, tipoNovoComodo)
                            nomeNovoComodo = ""; tipoNovoComodo = ""; mostrarDialogComodo = false
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00FFCC), contentColor = Color.Black)
                ) { Text("Criar Ambiente", fontWeight = FontWeight.Bold) }
            },
            dismissButton = { TextButton(onClick = { mostrarDialogComodo = false }) { Text("Cancelar", color = Color.LightGray) } }
        )
    }
}

@Composable
fun CardComodo(comodo: Comodo, sensores: List<Sensor>, rotinas: List<Rotina>, viewModel: IotViewModel) {
    var mostrarDialogSensor by remember { mutableStateOf(false) }
    var nomeSensor by remember { mutableStateOf("") }

    var mostrarDialogRotina by remember { mutableStateOf(false) }
    var sensorAlvo by remember { mutableStateOf("") }
    var acaoRotina by remember { mutableStateOf("Ligar") }
    var horarioRotina by remember { mutableStateOf("") }

    // Estados para Edição do Ambiente
    var mostrarDialogEditar by remember { mutableStateOf(false) }
    var nomeEdicao by remember { mutableStateOf(comodo.nome) }
    var tipoEdicao by remember { mutableStateOf(comodo.tipo) }

    // Estados para Confirmação de Exclusão Genérica
    var mostrarConfirmacao by remember { mutableStateOf(false) }
    var tituloConfirmacao by remember { mutableStateOf("") }
    var textoConfirmacao by remember { mutableStateOf("") }
    var acaoConfirmada by remember { mutableStateOf<() -> Unit>({}) }

    fun pedirConfirmacao(titulo: String, texto: String, acao: () -> Unit) {
        tituloConfirmacao = titulo
        textoConfirmacao = texto
        acaoConfirmada = acao
        mostrarConfirmacao = true
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E2026)),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        border = BorderStroke(1.dp, Color(0xFF2E3038))
    ) {
        Column(modifier = Modifier.padding(20.dp).fillMaxWidth()) {

            // --- CABEÇALHO DO AMBIENTE ---
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
                    Icon(Icons.Filled.MeetingRoom, contentDescription = "Cômodo", tint = Color.White, modifier = Modifier.size(28.dp))
                    Spacer(Modifier.width(12.dp))
                    Column {
                        Text(text = comodo.nome, fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Color.White)
                        Box(modifier = Modifier.padding(top = 4.dp).clip(RoundedCornerShape(8.dp)).background(Color(0xFF333640)).padding(horizontal = 8.dp, vertical = 2.dp)) {
                            Text(text = comodo.tipo.uppercase(), fontSize = 11.sp, color = Color.LightGray, fontWeight = FontWeight.SemiBold)
                        }
                    }
                }
                Row {
                    // BOTÃO EDITAR
                    IconButton(onClick = {
                        nomeEdicao = comodo.nome
                        tipoEdicao = comodo.tipo
                        mostrarDialogEditar = true
                    }) {
                        Icon(Icons.Filled.Edit, contentDescription = "Editar", tint = Color.LightGray)
                    }
                    // BOTÃO ELIMINAR CÔMODO
                    IconButton(onClick = {
                        pedirConfirmacao(
                            "Eliminar Ambiente",
                            "Tem a certeza que deseja eliminar '${comodo.nome}'? Todos os dispositivos e rotinas terão de ser removidos manualmente."
                        ) { viewModel.deletarComodo(comodo.id) }
                    }) {
                        Icon(Icons.Filled.DeleteOutline, contentDescription = "Deletar", tint = Color(0xFFFF5252))
                    }
                }
            }

            HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp), color = Color(0xFF2E3038))

            // --- SEÇÃO DE SENSORES ---
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Filled.WifiTethering, contentDescription = "Sensores", tint = Color(0xFF00FFCC), modifier = Modifier.size(18.dp))
                    Spacer(Modifier.width(8.dp))
                    Text("Dispositivos", color = Color(0xFF00FFCC), fontWeight = FontWeight.Bold, fontSize = 15.sp)
                }
                TextButton(onClick = { mostrarDialogSensor = true }, contentPadding = PaddingValues(0.dp)) {
                    Text("+ Novo", color = Color(0xFF00FFCC), fontWeight = FontWeight.Bold)
                }
            }
            sensores.forEach { sensor ->
                Card(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF262933)),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 8.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                        Text(text = sensor.nome, color = if (sensor.ativo) Color.White else Color.Gray, modifier = Modifier.weight(1f), fontWeight = FontWeight.Medium)
                        Switch(checked = sensor.ativo, onCheckedChange = { viewModel.mudarStatusSensor(sensor.id, sensor.ativo) }, colors = SwitchDefaults.colors(checkedThumbColor = Color(0xFF00FFCC), checkedTrackColor = Color(0xFF00FFCC).copy(alpha = 0.3f)))
                        IconButton(onClick = {
                            pedirConfirmacao("Remover Dispositivo", "Deseja remover '${sensor.nome}' deste ambiente?") { viewModel.deletarSensor(sensor.id) }
                        }) { Icon(Icons.Filled.Close, tint = Color.Gray, modifier = Modifier.size(18.dp), contentDescription = "") }
                    }
                }
            }

            Spacer(Modifier.height(8.dp))

            // --- SEÇÃO DE ROTINAS ---
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Filled.AccessTime, contentDescription = "Rotinas", tint = Color(0xFFFF9800), modifier = Modifier.size(18.dp))
                    Spacer(Modifier.width(8.dp))
                    Text("Automações", color = Color(0xFFFF9800), fontWeight = FontWeight.Bold, fontSize = 15.sp)
                }
                TextButton(onClick = {
                    sensorAlvo = sensores.firstOrNull()?.nome ?: ""
                    mostrarDialogRotina = true
                }, contentPadding = PaddingValues(0.dp)) {
                    Text("+ Nova", color = Color(0xFFFF9800), fontWeight = FontWeight.Bold)
                }
            }
            rotinas.forEach { rotina ->
                Card(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF262933)),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 8.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(text = "${rotina.acao} ${rotina.dispositivoNome}", color = if (rotina.ativa) Color.White else Color.Gray, fontSize = 15.sp, fontWeight = FontWeight.Medium)
                            Text(text = "Hoje às ${rotina.horario}", color = Color(0xFFFF9800).copy(alpha = 0.8f), fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                        }
                        Switch(checked = rotina.ativa, onCheckedChange = { viewModel.mudarStatusRotina(rotina.id, rotina.ativa) }, colors = SwitchDefaults.colors(checkedThumbColor = Color(0xFFFF9800), checkedTrackColor = Color(0xFFFF9800).copy(alpha = 0.3f)))
                        IconButton(onClick = {
                            pedirConfirmacao("Apagar Automação", "Deseja apagar esta rotina programada?") { viewModel.deletarRotina(rotina.id) }
                        }) { Icon(Icons.Filled.Close, tint = Color.Gray, modifier = Modifier.size(18.dp), contentDescription = "") }
                    }
                }
            }
        }
    }

    // Modal Confirmação de Exclusão (Genérico para os 3 tipos)
    if (mostrarConfirmacao) {
        AlertDialog(
            onDismissRequest = { mostrarConfirmacao = false },
            title = { Text(tituloConfirmacao, fontWeight = FontWeight.Bold) },
            text = { Text(textoConfirmacao) },
            confirmButton = {
                Button(onClick = { acaoConfirmada(); mostrarConfirmacao = false }, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF5252), contentColor = Color.White)) {
                    Text("Eliminar", fontWeight = FontWeight.Bold)
                }
            },
            dismissButton = { TextButton(onClick = { mostrarConfirmacao = false }) { Text("Cancelar", color = Color.LightGray) } }
        )
    }

    // Modal Editar Ambiente
    if (mostrarDialogEditar) {
        AlertDialog(
            onDismissRequest = { mostrarDialogEditar = false },
            title = { Text("Editar Ambiente", fontWeight = FontWeight.Bold) },
            text = {
                Column {
                    OutlinedTextField(value = nomeEdicao, onValueChange = { nomeEdicao = it }, label = { Text("Nome") }, singleLine = true, modifier = Modifier.fillMaxWidth())
                    Spacer(Modifier.height(8.dp))
                    OutlinedTextField(value = tipoEdicao, onValueChange = { tipoEdicao = it }, label = { Text("Tipo") }, singleLine = true, modifier = Modifier.fillMaxWidth())
                }
            },
            confirmButton = {
                Button(onClick = {
                    if (nomeEdicao.isNotBlank()) {
                        viewModel.atualizarComodo(comodo.id, nomeEdicao, tipoEdicao)
                        mostrarDialogEditar = false
                    }
                }, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00FFCC), contentColor = Color.Black)) { Text("Guardar", fontWeight = FontWeight.Bold) }
            },
            dismissButton = { TextButton(onClick = { mostrarDialogEditar = false }) { Text("Cancelar", color = Color.LightGray) } }
        )
    }

    // Modal Sensor
    if (mostrarDialogSensor) {
        AlertDialog(
            onDismissRequest = { mostrarDialogSensor = false },
            title = { Text("Novo Dispositivo", fontWeight = FontWeight.Bold) },
            text = { OutlinedTextField(value = nomeSensor, onValueChange = { nomeSensor = it }, label = { Text("Nome (ex: Luz Principal)") }, singleLine = true) },
            confirmButton = {
                Button(onClick = {
                    if (nomeSensor.isNotBlank()) { viewModel.adicionarSensor(nomeSensor, comodo.id); nomeSensor = ""; mostrarDialogSensor = false }
                }, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00FFCC), contentColor = Color.Black)) { Text("Vincular", fontWeight = FontWeight.Bold) }
            },
            dismissButton = { TextButton(onClick = { mostrarDialogSensor = false }) { Text("Cancelar", color = Color.LightGray) } }
        )
    }

    // Modal Rotina Aprimorado
    if (mostrarDialogRotina) {
        AlertDialog(
            onDismissRequest = { mostrarDialogRotina = false },
            title = { Text("Nova Automação", fontWeight = FontWeight.Bold) },
            text = {
                if (sensores.isEmpty()) {
                    Text("⚠️ Necessita de registar um dispositivo neste ambiente primeiro.", color = Color(0xFFFF5252))
                } else {
                    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                        Text("1. Selecione o dispositivo:", color = Color.Gray, fontSize = 14.sp)
                        sensores.forEach { sensor ->
                            Row(modifier = Modifier.fillMaxWidth().clickable { sensorAlvo = sensor.nome }.padding(vertical = 4.dp), verticalAlignment = Alignment.CenterVertically) {
                                RadioButton(selected = sensorAlvo == sensor.nome, onClick = { sensorAlvo = sensor.nome }, colors = RadioButtonDefaults.colors(selectedColor = Color(0xFFFF9800)))
                                Text(sensor.nome, color = Color.White)
                            }
                        }
                        Divider(modifier = Modifier.padding(vertical = 8.dp), color = Color.DarkGray)
                        Text("2. Ação:", color = Color.Gray, fontSize = 14.sp)
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(selected = acaoRotina == "Ligar", onClick = { acaoRotina = "Ligar" }, colors = RadioButtonDefaults.colors(selectedColor = Color(0xFFFF9800)))
                            Text("Ligar", color = Color.White)
                            Spacer(Modifier.width(16.dp))
                            RadioButton(selected = acaoRotina == "Desligar", onClick = { acaoRotina = "Desligar" }, colors = RadioButtonDefaults.colors(selectedColor = Color(0xFFFF9800)))
                            Text("Desligar", color = Color.White)
                        }
                        Divider(modifier = Modifier.padding(vertical = 8.dp), color = Color.DarkGray)
                        OutlinedTextField(value = horarioRotina, onValueChange = { horarioRotina = it }, label = { Text("3. Horário (ex: 18:00)") }, singleLine = true)
                    }
                }
            },
            confirmButton = {
                if (sensores.isNotEmpty()) {
                    Button(onClick = {
                        if (sensorAlvo.isNotBlank() && horarioRotina.isNotBlank()) {
                            viewModel.adicionarRotina(sensorAlvo, acaoRotina, horarioRotina, comodo.id)
                            horarioRotina = ""; mostrarDialogRotina = false
                        }
                    }, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF9800), contentColor = Color.Black)) { Text("Programar", fontWeight = FontWeight.Bold) }
                }
            },
            dismissButton = { TextButton(onClick = { mostrarDialogRotina = false }) { Text("Cancelar", color = Color.LightGray) } }
        )
    }
}