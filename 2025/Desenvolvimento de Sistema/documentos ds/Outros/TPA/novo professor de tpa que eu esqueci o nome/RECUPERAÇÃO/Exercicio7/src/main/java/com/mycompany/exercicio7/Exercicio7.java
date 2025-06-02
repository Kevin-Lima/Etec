
package com.mycompany.exercicio7;

import javax.swing.JOptionPane;

public class Exercicio7 {
    public static void main(String[] args) {
        double[][] matriz = {{4.5, 5.2}, {4.2,1}};

        //alterei coisinhas
        
        System.out.println("Imprimindo a matriz:");

        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                System.out.printf("matriz[%d][%d] = %.2f\n",
                        linha, coluna, matriz[linha][coluna]);
            }
        }
    }
}