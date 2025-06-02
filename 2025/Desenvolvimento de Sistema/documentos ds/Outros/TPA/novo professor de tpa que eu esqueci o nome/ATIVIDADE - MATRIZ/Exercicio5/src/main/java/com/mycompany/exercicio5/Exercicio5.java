
package com.mycompany.exercicio5;

public class Exercicio5 {

    public static void main(String[] args) {
        char[][] matriz = {
            {'*', '*', '*', '*', '*'},
            {'*', '*', '*', '*', '*'},
            {'*', '*', '*', '*', '*'}
        };

        // Exibe a matriz
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

}
