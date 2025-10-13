/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.tiptime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tiptime.ui.theme.TipTimeTheme
import java.text.NumberFormat
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            TipTimeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TipTimeLayout()
                }
            }
        }
    }
}

@Composable
fun TipTimeLayout() {
    // Estados para armazenar os valores inseridos pelo usuário
    // MUDANÇA: Corrigido typo nos comentários - "armazenar" e "valores" estavam com erro de digitação
    var amountInput by remember { mutableStateOf("") }
    var tipInput by remember { mutableStateOf("") }
    var roundUp by remember { mutableStateOf(false) }

    // Conversão dos inputs para números, com fallback para 0.0 se inválido
    val amount = amountInput.toDoubleOrNull() ?: 0.0
    val tipPercent = tipInput.toDoubleOrNull() ?: 0.0
    val tip = calculateTip(amount, tipPercent, roundUp)

    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 20.dp) // MUDANÇA: Padding horizontal reduzido de 24dp para 20dp para mais espaço
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp) // MUDANÇA: Usando spacedBy em vez de Center para espaçamento consistente
    ) {

        Spacer(modifier = Modifier.height(40.dp))

        // MUDANÇA COMPLETA: Adicionado HeaderSection separado com ícone circular
        HeaderSection()

        Spacer(modifier = Modifier.height(8.dp))

        // MUDANÇA: Card principal agora é um OutlinedCard com borda sutil
        OutlinedCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp), // MUDANÇA: Padding horizontal reduzido
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface,
            ),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant), // NOVO: Borda sutil
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            shape = RoundedCornerShape(24.dp) // MUDANÇA: Cantos mais arredondados (16dp → 24dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp) // MUDANÇA: Espaçamento vertical entre elementos
            ) {
                // MUDANÇA COMPLETA: Substituído EditNumberField por InputFieldWithIcon com design melhorado
                InputFieldWithIcon(
                    icon = R.drawable.money, // MUDANÇA: Usando ícone do drawable em vez de Material Icons
                    label = R.string.bill_amount,
                    value = amountInput,
                    onValueChange = { amountInput = it },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ),
                    modifier = Modifier.fillMaxWidth()
                )

                // MUDANÇA COMPLETA: Segundo campo também usando InputFieldWithIcon
                InputFieldWithIcon(
                    icon = R.drawable.percent, // MUDANÇA: Usando ícone do drawable em vez de Material Icons
                    label = R.string.how_was_the_service,
                    value = tipInput,
                    onValueChange = { tipInput = it },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done
                    ),
                    modifier = Modifier.fillMaxWidth()
                )

                // MUDANÇA COMPLETA: Substituído RoundTheTipRow por RoundTheTipRowModern com card próprio
                RoundTheTipRowModern(
                    roundUp = roundUp,
                    onRoundUpChanged = { roundUp = it },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        // MUDANÇA: Card de resultado com sombra personalizada e layout expandido
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp)
                .shadow( // NOVO: Sombreamento personalizado
                    elevation = 12.dp, // MUDANÇA: Sombra mais pronunciada
                    shape = RoundedCornerShape(20.dp),
                    clip = false
                ),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 0.dp), // MUDANÇA: Elevação zerada pois usamos shadow
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(28.dp) // MUDANÇA: Padding aumentado para mais respiro
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp) // NOVO: Espaçamento consistente
            ) {
                Text(
                    text = "Total da Gorjeta", // MUDANÇA: Texto em português para consistência
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    fontWeight = FontWeight.Medium // NOVO: Peso de fonte para hierarquia
                )
                Text(
                    text = tip,
                    style = MaterialTheme.typography.displayMedium.copy( // MUDANÇA: DisplayMedium em vez de DisplaySmall
                        fontWeight = FontWeight.ExtraBold // NOVO: Fonte extra bold para destaque
                    ),
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                // NOVO: Informação adicional sobre o cálculo (apenas quando há valores)
                if (amount > 0 && tipPercent > 0) {
                    Text(
                        text = String.format( // CORREÇÃO: Usando String.format com Locale explícito
                            Locale.getDefault(), // MUDANÇA CRÍTICA: Adicionado Locale para evitar bug de internacionalização
                            "%.0f%% de %s",
                            tipPercent,
                            NumberFormat.getCurrencyInstance().format(amount)
                        ),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f) // NOVO: Transparência para texto secundário
                    )
                }
            }
        }

        // NOVO: Botão de ação flutuante adicionado para ação secundária
        FloatingActionButton(
            onClick = { /* Pode ser usado para ação adicional como salvar ou compartilhar */ },
            containerColor = MaterialTheme.colorScheme.secondary, // NOVO: Usando cor secondary do tema
            shape = CircleShape,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.money),
                contentDescription = "Calcular gorjeta",
                tint = MaterialTheme.colorScheme.onSecondary
            )
        }

        Spacer(modifier = Modifier.height(60.dp))
    }
}

// NOVO COMPONENTE: HeaderSection criado para agrupar o cabeçalho do app
@Composable
fun HeaderSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp) // NOVO: Espaçamento consistente
    ) {
        // NOVO: Ícone circular com sombra e cor primária
        Surface(
            modifier = Modifier
                .width(80.dp)
                .height(80.dp)
                .shadow(8.dp, CircleShape), // NOVO: Sombreamento no ícone
            shape = CircleShape, // NOVO: Forma circular
            color = MaterialTheme.colorScheme.primary, // NOVO: Cor primária do tema
            contentColor = MaterialTheme.colorScheme.onPrimary
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.money),
                    contentDescription = "Ícone do Tip Time", // NOVO: Descrição acessível
                    modifier = Modifier.padding(16.dp)
                )
            }
        }

        Text(
            text = stringResource(R.string.calculate_tip),
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Bold // NOVO: Peso bold para destaque
            ),
            color = MaterialTheme.colorScheme.primary // NOVO: Cor primária
        )
        // NOVO: Subtítulo adicionado para melhor explicação
        Text(
            text = "Calcule sua gorjeta facilmente", // Texto explicativo
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant // NOVO: Cor para texto secundário
        )
    }
}

// NOVO COMPONENTE: InputFieldWithIcon substitui EditNumberField com design melhorado
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputFieldWithIcon(
    @DrawableRes icon: Int, // MUDANÇA: Parâmetro mudado para resource ID de drawable
    @StringRes label: Int,
    value: String,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        // NOVO: Label separado acima do campo (design moderno)
        Text(
            text = stringResource(label),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(bottom = 8.dp) // NOVO: Espaço entre label e campo
        )
        TextField(
            value = value,
            onValueChange = onValueChange,
            leadingIcon = {
                Icon(
                    painter = painterResource(id = icon), // MUDANÇA: Usando painterResource em vez de ImageVector
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(start = 4.dp) // NOVO: Padding no ícone
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp)), // MUDANÇA: Cantos arredondados
            keyboardOptions = keyboardOptions,
            singleLine = true,
            colors = TextFieldDefaults.colors( // MUDANÇA: Cores customizadas do tema
                focusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                disabledContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                focusedTextColor = MaterialTheme.colorScheme.onSurface,
                unfocusedTextColor = MaterialTheme.colorScheme.onSurface,
                focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.outlineVariant,
                cursorColor = MaterialTheme.colorScheme.primary, // NOVO: Cor do cursor personalizada
            ),
            // NOVO: Placeholder com valores sugeridos
            placeholder = {
                Text(
                    text = when (label) {
                        R.string.bill_amount -> "0,00" // Sugestão para valor monetário
                        R.string.how_was_the_service -> "15" // Sugestão para porcentagem comum
                        else -> ""
                    },
                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f) // NOVO: Placeholder com transparência
                )
            }
        )
    }
}

// NOVO COMPONENTE: RoundTheTipRowModern com design de card próprio
@Composable
fun RoundTheTipRowModern(
    roundUp: Boolean,
    onRoundUpChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    // NOVO: Card próprio para a opção de arredondamento
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant, // NOVO: Cor de fundo diferenciada
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp), // MUDANÇA: Padding interno
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween // NOVO: Espaçamento entre texto e switch
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = stringResource(R.string.round_up_tip),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontWeight = FontWeight.Medium // NOVO: Peso de fonte para destaque
                )
                // NOVO: Texto explicativo adicional
                Text(
                    text = "Arredondar para o valor inteiro mais próximo", // Explicação da funcionalidade
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(top = 2.dp) // NOVO: Espaço entre títulos
                )
            }
            Switch(
                checked = roundUp,
                onCheckedChange = onRoundUpChanged,
                colors = SwitchDefaults.colors( // MUDANÇA: Cores customizadas do switch
                    checkedThumbColor = MaterialTheme.colorScheme.onPrimary,
                    checkedTrackColor = MaterialTheme.colorScheme.primary,
                    uncheckedThumbColor = MaterialTheme.colorScheme.outline,
                    uncheckedTrackColor = MaterialTheme.colorScheme.surface,
                )
            )
        }
    }
}

/**
 * Calcula a gorjeta baseada no input do usuário e formata o valor
 * de acordo com a moeda local.
 * Exemplo: "R$ 10,00" ou "$10.00"
 */
private fun calculateTip(amount: Double, tipPercent: Double = 15.0, roundUp: Boolean): String {
    var tip = tipPercent / 100 * amount
    if (roundUp) {
        tip = kotlin.math.ceil(tip) // Arredonda para cima se a opção estiver ativa
    }
    return NumberFormat.getCurrencyInstance().format(tip)
}

@Preview(showBackground = true)
@Composable
fun TipTimeLayoutPreview() {
    TipTimeTheme {
        TipTimeLayout()
    }
}