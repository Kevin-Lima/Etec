package com.mycompany.exercicio4;

import javax.swing.JOptionPane;

public class Exercicio4 {
    public static void main(String[] args) {
        // Criando a matriz 4x4 (4 linhas e 4 colunas) de números decimais
        double[][] matriz = new double[4][4];

        // Preenchendo a matriz com números fornecidos pelo usuário
        for (int i = 0; i < matriz.length; i++) { // Percorre as linhas
            for (int j = 0; j < matriz[i].length; j++) { // Percorre as colunas
                // Pedindo para o usuário um número decimal para a posição [i][j]
                matriz[i][j] = Double.parseDouble(JOptionPane.showInputDialog(
                    "Digite um número decimal para a posição [" + i + "][" + j + "] da matriz:"));
            }
        }

        // Exibindo a matriz completa (só pra visualização no console)
        System.out.println("Matriz preenchida:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%.2f ", matriz[i][j]); // Formata para 2 casas decimais
            }
            System.out.println(); // Pula para a próxima linha
        }

        // Exibindo os valores da diagonal principal
        System.out.println("\nValores da diagonal principal:");
        for (int i = 0; i < matriz.length; i++) { // Na diagonal principal, linha == coluna
            System.out.printf("%.2f ", matriz[i][i]);
        }

        // Exibindo os valores da diagonal secundária
        System.out.println("\n\nValores da diagonal secundária:");
        for (int i = 0; i < matriz.length; i++) { // Na diagonal secundária, linha + coluna == tamanho - 1
            System.out.printf("%.2f ", matriz[i][matriz.length - 1 - i]);
        }
    }
}
