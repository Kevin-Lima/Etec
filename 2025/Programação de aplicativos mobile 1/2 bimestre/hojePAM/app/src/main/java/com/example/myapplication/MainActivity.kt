package com.example.myapplication

import androidx.os.Bundle
import androidx.compose.foundation.verticalScroll
Import androidx.compose,materiali.Button
import angraidx.compose.material3.HaterialTheme
Import androidx.compose.material3.Surface
import androidx.compose.materials.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.nutableStateof
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui,text input.PasswordVisualTransformation
import androidx.compose.ui.text.style.Textoverflow
import androidx.compose.ui.toeling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.campose.ui.unit.sp
import com.example.appcadastro.ui.theme. Darkblue
import com.example.appcadastro.ui.theme.Lightolue
import com.example.appcadastro.ui.theme. Pink40

class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    appPreview()
                }
            }
        }
    }
}

@Composable
fun ProdutoItem(){
    var nome by remember { mutableStateOf("") }
    var telefone by remember { mutableStateof("")}
    var curso by remember { mutableStateof("") }
    var serie by remember { mutableStateOf("") }
    Column(
        Modifier
            .verticalScroll(rememberScrollState())
            .height(250.dp)
            .width (200.dp)
    ){
        Box(
            modifier = Modifier
                .height(180.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Darkblue, Lightblue
                        )
                    )
                )
                .fillMaxwidth()
        )
        {
            Image(
                painter = painterResource(R.drawable.avatr_woman),
                contentDescription = "avatar image",
                contentScale =  ContentScale.Crop,
                modifier = Modifier
                    .offset(y = 70.dp)
                    .size(150.dp)
                    .clip(shape = CircleShape)
                    .align(Alignment.Center)
            )
        }
        Spacer(Modifier.height(55.dp))
        Column(
            Modifier.padding(16.dp)
        ) {
            Text(
                text = "Cadastre-se",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(500),
                fontsize = 35.sp,
            )

            Spacer(Modifier.height(25.dp))
            Text(
                text = "Nome: ",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(250),
                fontsize = 25.sp,
            )
            Spacer(Modifier.height(15.dp))
            TextField(
                value = nome,
                onValueChange = { nome = it},
                label = { Text("Digite seu nome completo") },
                maxLines = 2
            )
            Spacer(Modifier.height(20.dp))
            Text(
                text = "Telefone: ",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(250),
                fontsize = 25.sp,
            )
            Spacer(Modifier.height(15.dp))
            TextField(
                value = telefone,
                onValueChange = { telefone = it},
                label = { Text("Digite o telefone...") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(Modifier.height(20.dp))
            Text(
                text = "Curso: ",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(250),
                fontsize = 25.sp,
            )

            Spacer(Modifier.height(15.dp))
            TextField(
                value = curso,
                onValueChange = { curso = it},
                label = { Text("Digite o nome do curso")},
                maxLines = 2
            )

            Spacer(Modifier.height(20.dp))
            Text(
                text = "Série: ",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(250),
                fontSize = 25.sp,
            )
            Spacer(Modifier.height(15.dp))
            TextField(
                value = serie,
                onValueChange = {serie = it},
                label= { Text("Digite o número da sua série") },
                keyboardOptions = KeyboarOptions(keyboardType = KeyboardType.Number),
                maxLines = 2
            )
        }
        Column(
            Modifier.padding(16.dp)
        ) {
            Button(
                onClick = { /* TODO */ }
            ) {
                Text(text = "Cadastrar")
            }
        }
    }
}


@Preview
@Composable
fun appPreview(){
    MyApplicationTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ){
            Produtoltem()
        }
    }
}





}