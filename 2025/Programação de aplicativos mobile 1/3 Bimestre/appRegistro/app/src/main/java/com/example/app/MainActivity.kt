package com.example.app

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
class MainActivity : ComponentActivity() {

    // --- Data model simples ---
    data class Note(
        val id: Long? = null,
        val title: String,
        val content: String,
        val destinatario: String
    )

    // --- Helper SQLite (dentro da MainActivity para manter "uma única activity") ---
    class DBHelper(context: Context) :
        SQLiteOpenHelper(context, "app.db", null, 1) {

        override fun onCreate(db: SQLiteDatabase) {
            db.execSQL(
                """
                CREATE TABLE notes(
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    title TEXT NOT NULL,
                    content TEXT NOT NULL,
                    destinatario TEXT NOT NULL
                )
                """.trimIndent()
            )
        }

        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
            db.execSQL("DROP TABLE IF EXISTS notes")
            onCreate(db)
        }

        fun insertNote(note: Note): Long {
            val cv = ContentValues().apply {
                put("title", note.title)
                put("content", note.content)
                put("destinatario",note.destinatario)
            }
            return writableDatabase.insert("notes", null, cv)
        }

        fun updateNote(note: Note): Int {
            requireNotNull(note.id) { "ID não pode ser nulo para update" }
            val cv = ContentValues().apply {
                put("title", note.title)
                put("content", note.content)
                put("destinatario",note.destinatario)
            }
            return writableDatabase.update(
                "notes",
                cv,
                "id=?",
                arrayOf(note.id.toString())
            )
        }

        fun deleteNote(id: Long): Int {
            return writableDatabase.delete(
                "notes",
                "id=?",
                arrayOf(id.toString())
            )
        }

        fun getAllNotes(): List<Note> {
            val list = mutableListOf<Note>()
            val c: Cursor = readableDatabase.rawQuery(
                "SELECT id, title, content, destinatario FROM notes ORDER BY id DESC",
                null
            )
            c.use { cur ->
                val idIdx = cur.getColumnIndexOrThrow("id")
                val titleIdx = cur.getColumnIndexOrThrow("title")
                val contentIdx = cur.getColumnIndexOrThrow("content")
                val destinatarioIdx = cur.getColumnIndexOrThrow("destinatario")
                while (cur.moveToNext()) {
                    list.add(
                        Note(
                            id = cur.getLong(idIdx),
                            title = cur.getString(titleIdx),
                            content = cur.getString(contentIdx),
                            destinatario = cur.getString(destinatarioIdx)
                        )
                    )
                }
            }
            return list
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = DBHelper(this)

        setContent {
            MaterialTheme {
                Surface(Modifier.fillMaxSize()) {
                    NotesScreen(dbHelper = db)
                }
            }
        }
    }

    // --- UI Compose + lógica CRUD ---
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun NotesScreen(dbHelper: DBHelper) {
        var notes by remember { mutableStateOf(dbHelper.getAllNotes()) }

        // Estados para criação/edição
        var title by remember { mutableStateOf(TextFieldValue("")) }
        var content by remember { mutableStateOf(TextFieldValue("")) }
        var destinatario by remember { mutableStateOf(TextFieldValue("")) }

        // Estado para saber se estamos editando algo
        var editingId by remember { mutableStateOf<Long?>(null) }

        fun clearFields() {
            title = TextFieldValue("")
            content = TextFieldValue("")
            destinatario = TextFieldValue("")
            editingId = null
        }

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(if (editingId == null) "Notas (SQLite + Compose)" else "Editando #$editingId")
                    }
                )
            }
        ) { padding ->
            Column(
                Modifier
                    .padding(padding)
                    .padding(16.dp)
                    .fillMaxSize()
            ) {
                OutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Título") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(8.dp))
                OutlinedTextField(
                    value = content,
                    onValueChange = { content = it },
                    label = { Text("Conteúdo") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(8.dp))
                //alteração
                    OutlinedTextField(
                        value = destinatario,
                        onValueChange = { destinatario = it },
                        label = { Text("Destinatario") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(Modifier.height(12.dp))




                Row {
                    Button(
                        onClick = {
                            val t = title.text.trim()
                            val c = content.text.trim()
                            val d = destinatario.text.trim()
                            if (t.isEmpty() || c.isEmpty() || d.isEmpty()) return@Button

                            if (editingId == null) {
                                // CREATE
                                dbHelper.insertNote(Note(title = t, content = c, destinatario = d))
                            } else {
                                // UPDATE
                                dbHelper.updateNote(
                                    Note(id = editingId, title = t, content = c, destinatario = d)
                                )
                            }
                            notes = dbHelper.getAllNotes()
                            clearFields()
                        }
                    ) {
                        Text(if (editingId == null) "Salvar" else "Atualizar")
                    }
                    Spacer(Modifier.width(8.dp))
                    OutlinedButton(onClick = { clearFields() }) {
                        Text("Limpar")
                    }
                }

                Spacer(Modifier.height(16.dp))
                HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)
                Spacer(Modifier.height(8.dp))

RA
                //                //MUDEI DAQUI P BAIXO

                LazyColumn(  // ← ISSO CRIAA UMA LISTA QUE ROLA PARA BAIXO
                    modifier = Modifier.fillMaxSize(),  // ← A LISTA VAI OCUPAR A TELA TODA
                    contentPadding = PaddingValues(bottom = 80.dp)  // ← DEIXA ESPAÇO NO FINAL DA LISTA
                ) {
                    // PARA CADA NOTA NA NOSSA LISTA...
                    items(notes, key = { it.id ?: -1 }) { note ->
                        // MOSTRA UM CARTÃO COM OS DADOS DA NOTA
                        NoteItemCompose(
                            note = note,  // ← OS DADOS DA NOTA (título, conteúdo, destinatário)

                            // BOTÃO "MOSTRAR MAIS" - ELE MESMO SE CONTROLHA, POR ISSO NÃO FAZ NADA AQUI
                            onShowMoreClick = { /* não precisa fazer nada aqui */ },

                            // QUANDO CLICAM NA NOTA...
                            onItemClick = {
                                // PREENCHE OS CAMPOS LÁ EM CIMA PARA PODER EDITAR
                                editingId = note.id  // ← AVISA QUE ESTAMOS EDITANDO
                                title = TextFieldValue(note.title)  // ← COLOCA O TÍTULO NO CAMPO
                                content = TextFieldValue(note.content)  // ← COLOCA O CONTEÚDO NO CAMPO
                                destinatario = TextFieldValue(note.destinatario)  // ← COLOCA O DESTINATÁRIO NO CAMPO
                            },

                            // QUANDO CLICAM EM "EXCLUIR"...
                            onDelete = {
                                note.id?.let { id ->  // ← PEGA O ID DA NOTA
                                    dbHelper.deleteNote(id)  // ← APAGA DO BANCO DE DADOS
                                    notes = dbHelper.getAllNotes()  // ← ATUALIZA A LISTA
                                    // SE ESTÁVAMOS EDITANDO ESTA NOTA, LIMPA OS CAMPOS
                                    if (editingId == id) clearFields()
                                }
                            }
                        )
                        // ESPAÇO DE 8dp ENTRE UMA NOTA E OUTRA
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }
    }


    @Composable
    fun NoteItemCompose(
        note: Note,  // ← OS DADOS +.DA NOTA
        onShowMoreClick: () -> Unit,  // ← BOTÃO "MOSTRAR MAIS" (NÃO USA)
        onItemClick: () -> Unit,  // ← QUANDO CLICAM NA NOTA
        onDelete: () -> Unit  // ← QUANDO CLICAM EM "EXCLUIR"
    ) {
        // CONTROLA SE O TEXTO ESTÁ EXPANDIDO OU NÃO
        var expanded by remember { mutableStateOf(false) }

        // O CARTÃO QUE ENVOLVE CADA NOTA
        Card(
            modifier = Modifier
                .fillMaxWidth()  // ← LARGURA TOTAL DA TELA
                .padding(8.dp)  // ← ESPAÇO AO REDOR DO CARTÃO
                .clickable { onItemClick() },  // ← QUANDO CLICAM, EDITA A NOTA
            elevation = CardDefaults.cardElevation(4.dp)  // ← SOMBINHA BONITINHA
        ) {
            // ORGANIZA TUDO EM COLUNA DENTRO DO CARTÃO
            Column(modifier = Modifier.padding(16.dp)) {

                // TÍTULO DA NOTA
                Text(
                    text = "Título: ${note.title}",  // ← MOSTRA O TÍTULO
                    style = MaterialTheme.typography.titleMedium,  // ← ESTILO DE TÍTULO
                    fontWeight = FontWeight.Bold  // ← EM NEGRITO
                )

                // ESPAÇO ENTRE TÍTULO E CONTEÚDO
                Spacer(modifier = Modifier.height(8.dp))

                // CONTEÚDO DA NOTA
                Text(
                    text = note.content,  // ← TEXTO DA NOTA
                    style = MaterialTheme.typography.bodyMedium,  // ← ESTILO NORMAL
                    maxLines = if (expanded) 100 else 2,  // ← MOSTRA 2 LINHAS OU TUDO
                    overflow = TextOverflow.Ellipsis  // ← COLOCA "..." SE FOR MUITO LONGO
                )

                // SE O TEXTO FOR MAIOR QUE 50 LETRAS, MOSTRA BOTÃO "MOSTRAR MAIS"
                if (note.content.length > 50) {
                    TextButton(onClick = { expanded = !expanded }) {
                        Text(if (expanded) "Mostrar menos" else "Mostrar mais")
                    }
                }

                // ESPAÇO ANTES DO DESTINATÁRIO
                Spacer(modifier = Modifier.height(8.dp))

                // DESTINATÁRIO DA NOTA
                Text(
                    text = "Destinatário: ${note.destinatario}",  // ← MOSTRA PRA QUEM É
                    style = MaterialTheme.typography.bodySmall,  // ← TEXTO PEQUENO
                    color = MaterialTheme.colorScheme.onSurfaceVariant  // ← COR SUAVE
                )

                // ESPAÇO ANTES DO BOTÃO EXCLUIR
                Spacer(modifier = Modifier.height(8.dp))

                // BOTÃO PARA APAGAR A NOTA
                Button(
                    onClick = onDelete,  // ← QUANDO CLICAM, EXCLUI
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.error  // ← COR VERMELHA
                    )
                ) {
                    Text("Excluir")  // ← TEXTO DO BOTÃO
                }
            }
        }
    }
}
