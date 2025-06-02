
package com.mycompany.exercicio1;

import java.util.Arrays;
import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Criando um array pra guardar 10 nomes
        String[] nomes = new String[10];

        // Pedindo pro usuário digitar os 10 nomes
        System.out.println("Digite 10 nomes:");
        for (int i = 0; i < nomes.length; i++) {
            // Lendo e armazenando cada nome no array
            nomes[i] = scanner.nextLine();
        }

        // Ordenando os nomes em ordem crescente 
        Arrays.sort(nomes);

        // Mostrando os nomes na ordem crescente
        System.out.println("Nomes em ordem crescente:");
        for (String nome : nomes) {
            // Exibindo cada nome do array
            System.out.println(nome);
        }
    }
}

