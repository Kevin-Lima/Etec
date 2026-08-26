package com.example.estruturas_moleculares_3d

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.estruturas_moleculares_3d.ui.theme.Estruturas_Moleculares_3DTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Inicia o nosso cérebro de autenticação
        val authViewModel: AuthViewModel by viewModels()

        setContent {
            Estruturas_Moleculares_3DTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Inicia o roteador de telas
                    MyAppNavigation(
                        modifier = Modifier.padding(innerPadding),
                        authViewModel = authViewModel
                    )
                }
            }
        }
    }
}