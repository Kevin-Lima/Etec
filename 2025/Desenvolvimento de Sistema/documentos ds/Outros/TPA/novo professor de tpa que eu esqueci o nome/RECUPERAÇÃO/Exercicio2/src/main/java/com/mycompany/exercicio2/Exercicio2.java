package com.mycompany.exercicio2;

import javax.swing.JOptionPane;

public class Exercicio2 {
    public static void main(String[] args) {
        // Criando a matriz 5x5
        int[][] matriz = new int[5][5];

        // Variável pra somar os números ímpares
        int somaImpares = 0;

        // Vetores para guardar as somas das colunas e das linhas
        int[] somaColunas = new int[5];
        int[] somaLinhas = new int[5];

        // preencher a matriz
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                // Pedindo os números pro usuário (bem básico)
                int numero = Integer.parseInt(JOptionPane.showInputDialog(null, 
                    "Digite um número pra posição [" + i + "][" + j + "] da matriz:"));

                matriz[i][j] = numero; // Guardando o número na matriz

                // Se o número for ímpar, já soma aqui
                if (numero % 2 != 0) {
                    somaImpares += numero;
                }
            }
        }

        // Agora a gente calcula as somas das colunas e das linhas
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                somaLinhas[i] += matriz[i][j]; // Soma a linha atual
                somaColunas[j] += matriz[i][j]; // Soma a coluna atual
            }
        }

        // Mostrar a matriz (pra gente ver como ficou)
        System.out.println("Matriz preenchida:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                // Mostrando os números organizadinhos (se for menor que 10, dá um espacinho extra)
                System.out.print(matriz[i][j] + (matriz[i][j] < 10 ? "  " : " "));
            }
            System.out.println(); // Pula pra próxima linha
        }

        // Mostrando a soma dos números ímpares
        System.out.println("\nSoma dos números ímpares: " + somaImpares);

        // Mostrar as somas das colunas
        System.out.println("\nSoma de cada coluna:");
        for (int j = 0; j < somaColunas.length; j++) {
            System.out.println("Coluna " + (j + 1) + ": " + somaColunas[j]);
        }

        // Mostrar as somas das linhas
        System.out.println("\nSoma de cada linha:");
        for (int i = 0; i < somaLinhas.length; i++) {
            System.out.println("Linha " + (i + 1) + ": " + somaLinhas[i]);
        }
    }
}
