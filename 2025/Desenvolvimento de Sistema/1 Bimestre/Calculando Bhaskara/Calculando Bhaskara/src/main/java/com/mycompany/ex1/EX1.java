package com.mycompany.ex1;

import java.util.Scanner;

public class EX1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double delta, x1, x2;

        // Entrada dos valores
        System.out.print("Digite o valor de A: ");
        double a = scanner.nextDouble();
        System.out.print("Digite o valor de B: ");
        double b = scanner.nextDouble();
        System.out.print("Digite o valor de C: ");
        double c = scanner.nextDouble();

        // Se A for 0, ve se é equação do primeiro grau ou invalida
        if (a == 0) {
            if (b == 0) {
                System.out.println("Não é uma equação válida.");
            } else {
                System.out.println("Se A for zero, vira uma equação de primeiro grau.");
            }
        }

        // Calculo do delta
        delta = Math.pow(b, 2) - (4 * a * c);
        System.out.println("Delta: " + delta);

        // Se delta for negativo, não tem raizes reais
        if (delta < 0) {
            System.out.println("Delta é negativo, não tem raizes reais.");
        } else {
            // Calculo das raizes
            x1 = (-b + Math.sqrt(delta)) / (2 * a);
            x2 = (-b - Math.sqrt(delta)) / (2 * a);

            // Exibe as raizes
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        }

    }
}
