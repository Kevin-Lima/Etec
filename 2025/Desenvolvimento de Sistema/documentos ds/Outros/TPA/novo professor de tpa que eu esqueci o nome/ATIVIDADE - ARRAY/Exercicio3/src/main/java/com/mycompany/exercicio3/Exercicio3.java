
package com.mycompany.exercicio3;

import java.util.Arrays;
import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Criando um array pra guardar 50 números
        int[] numeros = new int[50];

        // Pedindo pro usuário digitar 50 números
        System.out.println("Digite 50 números:");
        for (int i = 0; i < numeros.length; i++) {
            // Lendo e armazenando cada número no array
            numeros[i] = scanner.nextInt();
        }

        // Ordenando os números em ordem crescente (menor -> maior)
        Arrays.sort(numeros);

        // Mostrando os números na ordem crescente
        System.out.println("Números em ordem crescente:");
        for (int numero : numeros) {
            // Exibindo cada número do array
            System.out.println(numero);
        }
    }
}

