package com.mycompany.exercicio2;

import java.util.Scanner;

public class Exercicio2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Pede pro usuário digitar qual tabuada ele quer
        System.out.print("Digite a tabuada que você precisa: ");
        int t = scanner.nextInt(); // Lê o número da tabuada
        
        int i = 1; // Começa com 1 (para multiplicar de 1 a 10)
                
        // Loop que vai de 1 até 10
        while(i <= 10){
            int r = i * t; // Calcula o resultado da multiplicação
            
            // Exibe o resultado da multiplicação na tela
            System.out.println(t + " x " + i + " = " + r);
            i++; // Incrementa o valor de i para passar para o próximo número
        }
    }
}
