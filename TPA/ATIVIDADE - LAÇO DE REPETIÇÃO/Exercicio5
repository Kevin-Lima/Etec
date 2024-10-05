package com.mycompany.exercicio5;

import java.util.Scanner;

public class Exercicio5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Pede para o usuário digitar o valor inicial
        System.out.print("Informe o valor inicial: ");
        int valorInicial = scanner.nextInt(); // Lê o valor inicial
        
        // Pede para o usuário digitar o valor final
        System.out.print("Informe o valor final: ");
        int valorFinal = scanner.nextInt(); // Lê o valor final
        
        // Aqui garantimos que o menor número vai ser o valorInicial ou o valorFinal, o menor mesmo
        int menor = Math.min(valorInicial, valorFinal);
        
        // E o maior número vai ser o valorInicial ou o valorFinal, o maior entre eles
        int maior = Math.max(valorInicial, valorFinal);
        
        // Se o menor número for par, a gente soma 1 para pegar o primeiro ímpar
        if (menor % 2 == 0) {
            menor++; // Se era par, agora ele vira ímpar
        }
        
        // Mostra na tela que a gente vai começar a exibir os números ímpares
        System.out.println("Números ímpares entre os valores fornecidos:");
        
        // Variável que começa com o menor número ímpar
        int i = menor;
        
        // Enquanto o valor atual for menor ou igual ao maior número
        while (i <= maior) {
            System.out.println(i); // Mostra o número ímpar atual
            i += 2; // Pula para o próximo ímpar (sempre de 2 em 2)
        }
        
    }
}
