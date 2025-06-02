
package com.mycompany.exercicio5;

import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Criando um array pra guardar 100 números
        int[] numeros = new int[100];

        // Pedindo pro usuário digitar 100 números
        System.out.println("Digite 100 números:");
        for (int i = 0; i < numeros.length; i++) {
            // Lendo e armazenando cada número no array
            numeros[i] = scanner.nextInt();
        }

        // Mostrando apenas os números pares
        System.out.println("Números pares:");
        for (int numero : numeros) {
            // Verifica se o número é par (divisível por 2)
            if (numero % 2 == 0) {
                // Exibe o número se for par
                System.out.println(numero);
            }
        }
    }
}
