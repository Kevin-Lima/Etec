package com.mycompany.exercicio4;

import java.util.Scanner;

public class Exercicio4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Pede pro usuário digitar o valor inicial
        System.out.print("Informe o valor inicial: ");
        int valorInicial = scanner.nextInt(); // Lê o valor inicial digitado
        
        // Pede pro usuário digitar o valor final
        System.out.print("Informe o valor final: ");
        int valorFinal = scanner.nextInt(); // Lê o valor final digitado
        
        // Inicializa a variável que vai armazenar a soma dos ímpares
        int somaImpares = 0;

        // Se o valor inicial for par, pula pro próximo ímpar
        if (valorInicial % 2 == 0) {
            valorInicial++; // Se era par, agora ele vira ímpar somando 1
        }

        // Laço que percorre só os números ímpares, de 2 em 2
        for (int i = valorInicial; i <= valorFinal; i += 2) {
            somaImpares = somaImpares + i; // Soma os ímpares ao total
        }
        
        // Mostra o resultado da soma dos ímpares entre os dois números
        System.out.println("A soma dos números ímpares entre o intervalo é: " + somaImpares);
        
    }
}
