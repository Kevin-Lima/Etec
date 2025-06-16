// Declaração do pacote (organização do código)
package com.example.appcadastro

// Importações de bibliotecas Android e Compose necessárias
import android.os.Bundle  // Para manipulação de estado da Activity
import android.widget.Toast  // Para mostrar mensagens popup
import androidx.activity.ComponentActivity  // Classe base para Activities
import androidx.activity.compose.setContent  // Para definir conteúdo com Compose
import androidx.activity.enableEdgeToEdge  // Para layout edge-to-edge
import androidx.compose.foundation.Image  // Componente de imagem
import androidx.compose.foundation.background  // Para cor de fundo
import androidx.compose.foundation.layout.*  // Todos os layouts (Column, Row, etc)
import androidx.compose.foundation.rememberScrollState  // Para scroll
import androidx.compose.foundation.shape.CircleShape  // Forma circular
import androidx.compose.foundation.text.KeyboardOptions  // Opções de teclado
import androidx.compose.foundation.verticalScroll  // Scroll vertical
import androidx.compose.material3.*  // Componentes Material Design 3
import androidx.compose.runtime.*  // Para estado e efeitos
import androidx.compose.ui.Alignment  // Alinhamento de componentes
import androidx.compose.ui.Modifier  // Modificadores de estilo
import androidx.compose.ui.draw.clip  // Para cortar elementos
import androidx.compose.ui.graphics.Brush  // Para gradientes
import androidx.compose.ui.layout.ContentScale  // Escala de imagem
import androidx.compose.ui.platform.LocalContext  // Contexto Android
import androidx.compose.ui.res.painterResource  // Para carregar imagens
import androidx.compose.ui.text.font.FontFamily  // Família de fontes
import androidx.compose.ui.text.font.FontWeight  // Peso da fonte
import androidx.compose.ui.text.input.KeyboardType  // Tipo de teclado
import androidx.compose.ui.unit.dp  // Unidade de medida independente de densidade
import androidx.compose.ui.unit.sp  // Unidade de medida para texto
import androidx.compose.ui.tooling.preview.Preview  // Para pré-visualização
import com.example.appcadastro.ui.theme.AppCadastroTheme  // Tema personalizado
import com.example.appcadastro.ui.theme.Darkblue  // Cor do tema
import com.example.appcadastro.ui.theme.Lightblue  // Cor do tema

// Classe principal da Activity (ponto de entrada do app)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Ativa o modo edge-to-edge (conteúdo sob a barra de status/navegação)
        enableEdgeToEdge()

        // Define o conteúdo da tela usando Compose
        setContent {
            // Aplica o tema personalizado do app
            AppCadastroTheme {
                // Scaffold provê estrutura básica de layout Material Design
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    // Exibe a pré-visualização do nosso componente
                    appPreview()
                }
            }
        }
    }
}

// Função principal que define a interface do formulário
@Composable
fun ProdutoItem() {
    // ==============================================
    // [1] ESTADOS E CONTEXTO
    // ==============================================

    // Estados para cada campo do formulário:
    var nome by remember { mutableStateOf("") }      // Estado para nome
    var telefone by remember { mutableStateOf("") }  // Estado para telefone
    var curso by remember { mutableStateOf("") }     // Estado para curso
    var serie by remember { mutableStateOf("") }     // Estado para série

    // Contexto Android para usar recursos como Toast
    val context = LocalContext.current

    // ==============================================
    // [2] LAYOUT PRINCIPAL (Coluna rolável)
    // ==============================================
    Column(
        modifier = Modifier
            .fillMaxSize()  // Ocupa todo o espaço disponível
            .verticalScroll(rememberScrollState())  // Habilita rolagem vertical
            .imePadding()  // Adiciona padding quando teclado virtual aparece
    ) {
        // ==========================================
        // [3] CABEÇALHO COM IMAGEM
        // ==========================================
        Box(
            modifier = Modifier
                .height(180.dp)  // Altura fixa em dp (independente de densidade)
                .background(
                    // Gradiente horizontal de azul escuro para azul claro
                    brush = Brush.horizontalGradient(
                        colors = listOf(Darkblue, Lightblue)
                    )
                )
                .fillMaxWidth()  // Ocupa toda a largura
        ) {
            // Imagem do avatar
            Image(
                painter = painterResource(R.drawable.avatr_woman),  // Recurso de imagem
                contentDescription = "avatar image",  // Descrição para acessibilidade
                contentScale = ContentScale.Crop,  // Corta a imagem para preencher
                modifier = Modifier
                    .offset(y = 70.dp)  // Desce 70dp do topo
                    .size(150.dp)  // Tamanho fixo 150x150dp
                    .clip(CircleShape)  // Corta em formato circular
                    .align(Alignment.Center)  // Centraliza na Box
            )
        }

        // Espaço entre cabeçalho e formulário (55dp)
        Spacer(Modifier.height(55.dp))

        // ==========================================
        // [4] FORMULÁRIO DE CADASTRO
        // ==========================================
        Column(Modifier.padding(16.dp)) {  // Padding interno de 16dp
            // Título do formulário
            Text(
                text = "Cadastre-se",
                fontFamily = FontFamily.SansSerif,  // Fonte sem serifa
                fontWeight = FontWeight(500),  // Peso médio (500)
                fontSize = 35.sp,  // Tamanho em sp (escala com preferências do usuário)
            )

            // Espaço após título (25dp)
            Spacer(Modifier.height(25.dp))

            // --- CAMPO NOME ---
            Text("Nome:", fontSize = 25.sp, fontWeight = FontWeight(250))
            Spacer(Modifier.height(15.dp))  // Espaço após label
            TextField(
                value = nome,
                onValueChange = { nome = it },  // Atualiza estado quando texto muda
                label = { Text("Digite seu nome completo") },  // Texto de hint
                maxLines = 2  // Máximo de 2 linhas
            )

            Spacer(Modifier.height(20.dp))  // Espaço entre campos

            // --- CAMPO TELEFONE ---
            Text("Telefone:", fontSize = 25.sp, fontWeight = FontWeight(250))
            Spacer(Modifier.height(15.dp))
            TextField(
                value = telefone,
                onValueChange = { telefone = it },
                label = { Text("Digite o telefone...") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)  // Teclado numérico
            )

            Spacer(Modifier.height(20.dp))

            // --- CAMPO CURSO ---
            Text("Curso:", fontSize = 25.sp, fontWeight = FontWeight(250))
            Spacer(Modifier.height(15.dp))
            TextField(
                value = curso,
                onValueChange = { curso = it },
                label = { Text("Digite o nome do curso") },
                maxLines = 2
            )

            Spacer(Modifier.height(20.dp))

            // --- CAMPO SÉRIE ---
            Text("Série:", fontSize = 25.sp, fontWeight = FontWeight(250))
            Spacer(Modifier.height(15.dp))
            TextField(
                value = serie,
                onValueChange = { serie = it },
                label = { Text("Digite o número da sua série") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                maxLines = 2
            )
        }

        // ==========================================
        // [5] BOTÕES DE AÇÃO
        // ==========================================
// ==============================================
// [1] DEFINIÇÃO DOS BOTÕES
// ==============================================

        Row(
            modifier = Modifier
                .padding(16.dp)  // Espaço ao redor dos botões (16 unidades independentes de densidade)
                .fillMaxWidth(),  // Ocupa toda a largura disponível na tela

            // Espaçamento igual entre os botões e as bordas
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // --- BOTÃO LIMPAR ---
            OutlinedButton(
                onClick = {
                    // Reseta todos os campos do formulário para vazio ("")
                    nome = ""
                    telefone = ""
                    curso = ""
                    serie = ""
                }
            ) {
                Text("Limpar")  // Texto exibido no botão
            }

            // Espaço fixo de 16dp entre os botões
            Spacer(modifier = Modifier.width(16.dp))

            // --- BOTÃO CADASTRAR ---
            Button(
                onClick = {
                    // O 'context' é uma referência ao ambiente Android atual
                    // (necessário para operações como mostrar Toasts, abrir novas telas, etc.)
                    //
                    // Em termos simples: é como um "passaporte" que permite
                    // acessar recursos do sistema Android
                    Toast.makeText(
                        context,  // Obrigatório para o Toast funcionar

                        // Mensagem personalizada que inclui o nome digitado
                        // (o símbolo $ insere o valor da variável 'nome' na string)
                        "Cadastro de $nome realizado!",

                        Toast.LENGTH_SHORT  // Duração curta (~2 segundos)
                    ).show()  // Exibe efetivamente o Toast
                }
            ) {
                Text("Cadastrar")  // Texto do botão
            }
        }
    }
}

// Função de pré-visualização para Android Studio
@Preview(showBackground = true)  // Mostra fundo na pré-visualização
@Composable
fun appPreview() {
    // Aplica o tema do app
    AppCadastroTheme {
        // Surface provê fundo padrão do tema
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            // Exibe nosso componente principal
            ProdutoItem()
        }
    }
}