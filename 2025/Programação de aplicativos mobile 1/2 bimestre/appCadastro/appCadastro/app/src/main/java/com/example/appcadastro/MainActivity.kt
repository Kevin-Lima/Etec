package com.example.appcadastro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.core.view.WindowCompat
import com.example.appcadastro.ui.theme.AppCadastroTheme
import com.example.appcadastro.ui.theme.Darkblue
import com.example.appcadastro.ui.theme.Lightblue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Ativa um modo onde o conteúdo pode usar a tela inteira, até mesmo por baixo da barra de status
        enableEdgeToEdge()

        // Define o conteúdo da tela
        setContent {
            AppCadastroTheme {
                // Scaffold é tipo uma estrutura padrão com área segura pra conteúdo
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    appPreview()
                }
            }
        }
    }
}

@Composable
fun ProdutoItem() {
    // Variáveis que vão guardar o que o usuário digita nos campos
    var nome by remember { mutableStateOf("") }
    var telefone by remember { mutableStateOf("") }
    var curso by remember { mutableStateOf("") }
    var serie by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize() // ocupa toda a altura possível
            .verticalScroll(rememberScrollState()) // permite rolar a tela
            .imePadding() // 👈 ESSA LINHA FAZ A MÁGICA: dá espaço quando o teclado aparece
    ) {
        // Topo com um fundo colorido em gradiente
        Box(
            modifier = Modifier
                .height(180.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Darkblue, Lightblue)
                    )
                )
                .fillMaxWidth()
        ) {
            // Avatar centralizado no topo
            Image(
                painter = painterResource(R.drawable.avatr_woman),
                contentDescription = "avatar image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .offset(y = 70.dp) // desce um pouco o avatar
                    .size(150.dp) // tamanho da imagem
                    .clip(CircleShape) // deixa redondinho
                    .align(Alignment.Center) // centraliza dentro da Box
            )
        }

        Spacer(Modifier.height(55.dp)) // espaço entre avatar e formulário

        // Campos do formulário
        Column(Modifier.padding(16.dp)) {
            Text(
                text = "Cadastre-se",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(500),
                fontSize = 35.sp,
            )

            Spacer(Modifier.height(25.dp))

            // Campo Nome
            Text("Nome:", fontSize = 25.sp, fontWeight = FontWeight(250))
            Spacer(Modifier.height(15.dp))
            TextField(
                value = nome,
                onValueChange = { nome = it },
                label = { Text("Digite seu nome completo") },
                maxLines = 2
            )

            Spacer(Modifier.height(20.dp))

            // Campo Telefone
            Text("Telefone:", fontSize = 25.sp, fontWeight = FontWeight(250))
            Spacer(Modifier.height(15.dp))
            TextField(
                value = telefone,
                onValueChange = { telefone = it },
                label = { Text("Digite o telefone...") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(Modifier.height(20.dp))

            // Campo Curso
            Text("Curso:", fontSize = 25.sp, fontWeight = FontWeight(250))
            Spacer(Modifier.height(15.dp))
            TextField(
                value = curso,
                onValueChange = { curso = it },
                label = { Text("Digite o nome do curso") },
                maxLines = 2
            )

            Spacer(Modifier.height(20.dp))

            // Campo Série
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

        // Botão de cadastro
        Column(Modifier.padding(16.dp)) {
            Button(
                onClick = { /* Ação do botão */ }
            ) {
                Text(text = "Cadastrar")
            }
        }
    }
}

@Preview
@Composable
fun appPreview() {
    AppCadastroTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ProdutoItem()
        }
    }
}
