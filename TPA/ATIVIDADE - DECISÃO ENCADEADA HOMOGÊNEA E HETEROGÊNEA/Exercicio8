
package com.mycompany.exercicio8;

import java.util.Scanner;

public class Exercicio8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        
        // Pede ao usuario os comprimentos dos tres lados do triangulo
        System.out.println("Digite o comprimento do primeiro lado do triangulo (em cm): ");
        double a = scanner.nextDouble();
        System.out.println("Digite o comprimento do segundo lado do triangulo (em cm): ");
        double b = scanner.nextDouble();
        System.out.println("Digite o comprimento do terceiro lado do triangulo (em cm): ");
        double c = scanner.nextDouble();
        
        // Ver qual é o tipo de triangulo com base nos comprimentos dos lados
         if (a == b && b == c) {
            System.out.println("O triangulo é equilatero.");
        } else if (a == b || b == c || a == c) {
            System.out.println("O triangulo é isosceles.");
        } else {// Todos os lados diferentes: Triangulo escaleno
            System.out.println("O triangulo é escaleno.");
        }
    }
}
