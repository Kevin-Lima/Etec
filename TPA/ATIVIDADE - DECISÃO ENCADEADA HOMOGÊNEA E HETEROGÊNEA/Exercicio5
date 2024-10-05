
package com.mycompany.exercicio5;

import java.util.Scanner;

public class Exercicio5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Pede as quatro notas do aluno
        System.out.println("Digite a primeira nota: ");
        double nota1 = scanner.nextDouble();
        System.out.println("Digite a segunda nota: ");
        double nota2 = scanner.nextDouble();
        System.out.println("Digite a terceira nota: ");
        double nota3 = scanner.nextDouble();
        System.out.println("Digite a quarta nota: ");
        double nota4 = scanner.nextDouble();
        
        // Calcula a media das notas
        double media = (nota1 + nota2 + nota3 + nota4) / 4;
        
        //ve em qual condição a media se encaixa
        if(9 <= media){
            System.out.println("Conceito: A - Aprovado. Com media: " +media);
        }
        else if(7 <= media && media < 9){
            System.out.println("Conceito: B - Aprovado. Com media: " +media);
        }
        else if(5 <= media && media < 7){
            System.out.println("Conceito: C - Aprovado. Com media: " +media);
        }
        else if(2.5 <= media && media < 5){
            System.out.println("Conceito: D - Reprovado. Com media: " +media);
        }
        else {
            System.out.println("Conceito: E - Reprovado. Com media: " +media);
        }
        
    }
}
