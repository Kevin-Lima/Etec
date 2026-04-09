package com.example.botao_logcat

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.botao_logcat.ui.theme.BotaologcatTheme
import com.example.botao_logcat.ui.theme.DebugButtonColors
import com.example.botao_logcat.ui.theme.ErrorButtonColors
import com.example.botao_logcat.ui.theme.InfoButtonColors
import com.example.botao_logcat.ui.theme.WarningButtonColors

const val TAG = "TesteAndroid"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BotaologcatTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    App(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}


@Composable
fun App(modifier: Modifier = Modifier) {
    // Variável que guarda o nome digitado pelo usuário
    var nome by remember { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Imagem no topo
        val image = painterResource(R.drawable.img)
        Image(
            painter = image,
            contentDescription = "Logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(150.dp)
                .height(100.dp)
        )

        //Título
        Greeting("PAM 2")

        //Campo de digitar o nome
        Row(
            Modifier.fillMaxWidth(),
            Arrangement.Center
        ) {
            TextField(
                value = nome,
                onValueChange = { novoValor -> nome = novoValor },
                label = { Text("Digite seu nome:") },
            )
        }

        //Botões de Notas
        ActionButton(
            text = "I",
            buttonColors = ErrorButtonColors(),
            modifier = Modifier.fillMaxWidth(0.5f)
        ) {
            Log.e(TAG, "App: $nome Nota I")
        }

        ActionButton(
            text = "R",
            buttonColors = WarningButtonColors(),
            modifier = Modifier.fillMaxWidth(0.5f)
        ) {
            Log.w(TAG, "App: $nome Nota R")
        }

        ActionButton(
            text = "B",
            buttonColors = DebugButtonColors(),
            modifier = Modifier.fillMaxWidth(0.5f)
        ) {
            Log.d(TAG, "App: $nome Nota B")
        }

        ActionButton(
            text = "MB",
            buttonColors = InfoButtonColors(),
            modifier = Modifier.fillMaxWidth(0.5f)
        ) {
            Log.i(TAG, "App: $nome Nota MB")
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier){
    Text(
        text = "ATIVIDADE DE $name",
        style = MaterialTheme.typography.bodyLarge.copy(
            fontWeight = FontWeight.Bold
        ),
        color = MaterialTheme.colorScheme.secondary,
        modifier = modifier
    )
}

@Composable
fun ActionButton(O
    text: String,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    modifier: Modifier = Modifier,
    block: () -> Unit
) {
    ElevatedButton(
        onClick = block,
        shape = RoundedCornerShape(5.dp),
        colors = buttonColors,
        modifier = modifier
    ) {
        Text(
            text = text,
            color = Color.White 
        )
    }
}



@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Visualização Completa (Device)",
    device = "spec:width=411dp,height=891dp"
)
@Composable
fun AppPreviewFull() {
    BotaologcatTheme {
        App()
    }
}

@Preview(showBackground = true, name = "Apenas os Botões", heightDp = 600)
@Composable
fun AppPreviewSimple() {
    BotaologcatTheme {
        App()
    }
}