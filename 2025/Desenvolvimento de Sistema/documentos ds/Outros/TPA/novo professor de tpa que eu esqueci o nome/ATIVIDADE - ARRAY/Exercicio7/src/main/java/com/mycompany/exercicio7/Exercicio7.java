
package com.mycompany.exercicio7;

import java.util.Scanner;

public class Exercicio7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Criando um array pra guardar os nomes de 20 times
        String[] times = new String[20];
        
        // Pedindo pro usuário digitar os times na ordem de classificação
        System.out.println("Digite os nomes dos 20 times na ordem de classificação:");
        for (int i = 0; i < times.length; i++) {
            // Lendo e armazenando cada time no array
            System.out.print("Posição " + (i + 1) + ": ");
            times[i] = scanner.nextLine();
        }

        // Mostrando a tabela de classificação
        System.out.println("Classificação do Campeonato Brasileiro:");
        for (int i = 0; i < times.length; i++) {
            // Exibindo a posição e o nome de cada time
            System.out.println((i + 1) + "º - " + times[i]);
        }
    }
}

