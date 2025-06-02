
package com.mycompany.exercicio6;

import javax.swing.JOptionPane;

public class Exercicio6 {
    public static void main(String[] args) {
        final int linhas = 3, colunas = 3; 
        int[][] matriz = new int[linhas][colunas];

        //Fiz pequenas alterações no código, espero que não tenha problema 
       
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                String valorStr = JOptionPane.showInputDialog("Digite o valor para a posição [" + (i + 1) + "][" + (j + 1) + "]: ");
                try {
                    matriz[i][j] = Integer.parseInt(valorStr);
                } catch (NumberFormatException e) {
                    System.out.println("Valor inválido. Por favor, digite um número inteiro.");
                    j--; 
                }
            }
        }

        System.out.println("\nMatriz:");
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }
}