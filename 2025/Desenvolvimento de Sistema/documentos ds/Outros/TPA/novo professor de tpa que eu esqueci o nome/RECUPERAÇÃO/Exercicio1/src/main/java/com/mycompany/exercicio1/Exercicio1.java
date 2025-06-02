
package com.mycompany.exercicio1;

public class Exercicio1 {
    public static void main(String[] args) {
        char[][] matriz = {
            {'a', 'b', 'c', 'd', 'e'},
            {'f', 'g', 'h', 'i', 'j'},
            {'l', 'm', 'n', 'o', 'p'},
            {'q', 'r', 's', 't', 'u'}
        };

        // Exibe a matriz com mais espaço entre os elementos
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "   "); // Adiciona mais espaços
            }
            System.out.println(); // Pula para a próxima linha
        }
    }
}
