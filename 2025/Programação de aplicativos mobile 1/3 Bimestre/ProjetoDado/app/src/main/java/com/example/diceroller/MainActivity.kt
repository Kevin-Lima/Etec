package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
// Import para modificar o layout (tamanho, alinhamento etc.)
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
// Import para centralizar os elementos no layout
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
// Import para conseguir visualizar o layout no Android Studio sem rodar no celular
import androidx.compose.ui.tooling.preview.Preview
import com.example.diceroller.ui.theme.DiceRollerTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Aplica o tema padrão do app
            DiceRollerTheme {
                // Chama a função principal do app (onde fica o layout)
                DiceRollerApp()
            }
        }
    }
}

// Função que representa a interface principal do app
// @Preview → permite visualizar essa função no modo Design do Android Studio
// @Composable → indica que essa função constrói um pedaço da interface (UI) usando Compose
@Preview
@Composable
fun DiceRollerApp() {
    // Chama a função que monta o layout do dado + botão
    // Passa um Modifier para preencher a tela e centralizar os elementos
    DiceWithButtonAndImage(
        modifier = Modifier
            .fillMaxSize() // Faz o layout ocupar toda a tela disponível
            .wrapContentSize(Alignment.Center) // Centraliza os componentes no meio da tela
    )
}

// Função que vai conter os elementos principais do app (imagem do dado + botão)
// Recebe um parâmetro modifier para que possamos aplicar estilos e posicionamento
@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    // remember -> mantém o valor mesmo após recomposições
    // mutableStateOf(1) -> começa com 1 e é observável (atualiza a UI quando mudar)
    var result by remember { mutableStateOf(1) }

    //  Seleciona a imagem do dado de acordo com o valor sorteado em "result"
    val imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    Column(
        modifier = modifier, // ocupa a tela inteira + centralizado
        horizontalAlignment = Alignment.CenterHorizontally // centraliza os filhos na largura
    ) {

        //  Mostra a imagem correspondente ao valor sorteado
        Image(
            painter = painterResource(imageResource), // escolhe a imagem do dado
            contentDescription = result.toString()    // descrição acessível muda junto com o valor
        )

                    // Espaço entre a imagem e o botão para não ficarem colados
        Spacer(modifier = Modifier.height(16.dp))


        //  Botão que ao ser clicado sorteia um número de 1 a 6 e atualiza "result"
        Button(
            onClick = { result = (1..6).random() }
        ) {
            // Texto dentro do botão
            // Usa stringResource() para buscar a string "Roll" do strings.xml
            Text(stringResource(R.string.roll))
        }
    }
}

