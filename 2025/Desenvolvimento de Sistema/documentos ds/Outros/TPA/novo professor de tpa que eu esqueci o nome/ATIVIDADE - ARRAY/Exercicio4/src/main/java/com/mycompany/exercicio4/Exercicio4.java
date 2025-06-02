
package com.mycompany.exercicio4;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Criando um array pra guardar 50 números
        Integer[] numeros = new Integer[50];

        // Pedindo pro usuário digitar 50 números
        System.out.println("Digite 50 números:");
        for (int i = 0; i < numeros.length; i++) {
            // Lendo e armazenando cada número no array
            numeros[i] = scanner.nextInt();
        }

        // Ordenando os números em ordem decrescente (maior -> menor)
        Arrays.sort(numeros, Collections.reverseOrder());

        // Mostrando os números na ordem decrescente
        System.out.println("Números em ordem decrescente:");
        for (int numero : numeros) {
            // Exibindo cada número do array
            System.out.println(numero);
        }
    }
}
