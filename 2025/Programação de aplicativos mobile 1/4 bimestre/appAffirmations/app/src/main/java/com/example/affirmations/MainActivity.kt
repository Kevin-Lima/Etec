// Define o pacote da aplicação
package com.example.affirmations

// Importações básicas do Android
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

// Importações para layout e tema
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.affirmations.ui.theme.AffirmationsTheme

// Importações para lista e cards
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview

// Importações dos arquivos do projeto
import com.example.affirmations.data.Datasource
import com.example.affirmations.model.Affirmation

// Activity principal do app
class MainActivity : ComponentActivity() {
    // Método chamado quando a tela é criada
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Define o conteúdo usando Compose
        setContent {
            // Aplica o tema personalizado do app
            AffirmationsTheme {
                // Cria uma surface (fundo) que ocupa toda a tela
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Inicia o app Compose
                    AffirmationsApp()
                }
            }
        }
    }
}

// Componente principal do app
@Composable
fun AffirmationsApp() {
    // Área principal onde o conteúdo é desenhado
    Surface(
        modifier = Modifier
            .fillMaxSize()              // Ocupa toda a tela
            .statusBarsPadding()        // Respeita a barra de status
    ) {
        // Exibe a lista com todas as afirmações
        AffirmationList(
            affirmationList = Datasource().loadAffirmations()
        )
    }
}

// Lista de afirmações (rolável)
@Composable
fun AffirmationList(affirmationList: List<Affirmation>, modifier: Modifier = Modifier) {
    // Lista eficiente para muitos itens (só renderiza o visível)
    LazyColumn(modifier = modifier) {
        // Para cada item na lista de afirmações...
        items(affirmationList) { affirmation ->
            // Cria um card para a afirmação atual
            AffirmationCard(
                affirmation = affirmation,
                modifier = Modifier.padding(8.dp)  // Espaço entre cards
            )
        }
    }
}

// Card de uma afirmação individual
@Composable
fun AffirmationCard(affirmation: Affirmation, modifier: Modifier = Modifier) {
    // Card com aparência elevada e bordas arredondadas
    Card(modifier = modifier) {
        // Organiza os elementos verticalmente
        Column {
            // Imagem da afirmação
            Image(
                painter = painterResource(affirmation.imageResourceId), // Carrega imagem
                contentDescription = stringResource(affirmation.stringResourceId), // Acessibilidade
                modifier = Modifier
                    .fillMaxWidth()     // Largura total do card
                    .height(194.dp),    // Altura fixa
                contentScale = ContentScale.Crop // Corta imagem para preencher
            )
            // Texto da afirmação
            Text(
                text = stringResource(affirmation.stringResourceId), // Busca texto
                modifier = Modifier.padding(16.dp),                 // Margem interna
                style = MaterialTheme.typography.headlineSmall      // Estilo do tema
            )
        }
    }
}

// Preview para visualizar no Android Studio
@Preview
@Composable
fun AffirmationCardPreview() {
    // Mostra um card de exemplo no preview
    AffirmationCard(
        affirmation = Affirmation(R.string.affirmation1, R.drawable.image1)
    )
}