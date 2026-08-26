package com.example.estruturas_moleculares_3d.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.estruturas_moleculares_3d.AuthState
import com.example.estruturas_moleculares_3d.AuthViewModel
import com.example.estruturas_moleculares_3d.R // Importa a pasta res (imagens)

@Composable
fun HomePage(modifier: Modifier = Modifier, navController: NavController, authViewModel: AuthViewModel) {
    // Observa se o usuário deslogou para voltar à tela de login
    val authState = authViewModel.authState.observeAsState()

    LaunchedEffect(authState.value) {
        when (authState.value) {
            is AuthState.Unauthenticated -> navController.navigate("login")
            else -> Unit
        }
    }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Cabeçalho com o Título e o Botão de Sign out exigido
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Moléculas 3D", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            TextButton(onClick = { authViewModel.signout() }) {
                Text(text = "Sign out")
            }
        }

        // LazyColumn cria uma lista rolável para caber várias imagens
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Primeiro item
            item {
                MoleculaCard(
                    nome = "Glicerol (Composto Químico)",
                    descricao = "Renderização 3D de um composto químico simples.",
                    // TROQUE 'mol_glicerol' pelo nome do seu arquivo de imagem
                    imagemRes = R.drawable.moleculas
                )
            }

            // Segundo item
            item {
                MoleculaCard(
                    nome = "Fita de DNA",
                    descricao = "Estrutura em dupla hélice do DNA humano.",
                    // TROQUE 'mol_dna' pelo nome do seu arquivo de imagem
                    imagemRes = R.drawable.dna
                )
            }

            // Terceiro item
            item {
                MoleculaCard(
                    nome = "Proteína",
                    descricao = "Estrutura complexa de uma proteína celular.",
                    // TROQUE 'mol_proteina' pelo nome do seu arquivo de imagem
                    imagemRes = R.drawable.proteina
                )
            }
        }
    }
}

// Função auxiliar para desenhar o "Cartão" de cada molécula
@Composable
fun MoleculaCard(nome: String, descricao: String, imagemRes: Int) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = nome, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))

            // Puxa a imagem da pasta drawable
            Image(
                painter = painterResource(id = imagemRes),
                contentDescription = nome,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))
            Text(text = descricao, fontSize = 14.sp)
        }
    }
}