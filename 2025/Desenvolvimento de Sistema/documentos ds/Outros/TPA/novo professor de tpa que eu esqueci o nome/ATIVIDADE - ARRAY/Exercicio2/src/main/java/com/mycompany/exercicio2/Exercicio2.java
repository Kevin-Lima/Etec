
package com.mycompany.exercicio2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Criando um array pra guardar 20 nomes
        String[] nomes = new String[20];

        // Pedindo pro usuário digitar os 20 nomes
        System.out.println("Digite 20 nomes:");
        for (int i = 0; i < nomes.length; i++) {
            // Lendo e armazenando cada nome no array
            nomes[i] = scanner.nextLine();
        }

        // Ordenando os nomes em ordem decrescente (Z -> A)
        Arrays.sort(nomes, Collections.reverseOrder());

        // Mostrando os nomes na ordem decrescente
        System.out.println("Nomes em ordem decrescente:");
        for (String nome : nomes) {
            // Exibindo cada nome do array
            System.out.println(nome);
        }
    }
}
