package com.mycompany.exercicio2;

import java.util.Scanner;

public class Exercicio2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada de dados
        System.out.print("Digite o peso corporal (em kg): ");
        double peso = scanner.nextDouble();
        
        System.out.print("Digite a altura (em metros): ");
        double altura = scanner.nextDouble();
        
        // Calculo do IMC
        double imc = peso / (altura * altura);
        
        // Classificaçao do IMC
        if (imc < 18) {
            System.out.println("Magreza (IMC: " + imc + ")");
        } 
        else if (imc >= 18 && imc <= 24.9) {
            System.out.println("Saudável (IMC: " + imc + ")");
        } 
        else if (imc >= 25 && imc <= 29.9) {
            System.out.println("Sobrepeso (IMC: " + imc + ")");
        } 
        else if (imc >= 30) {
            System.out.println("Obesidade (IMC: " + imc + ")");
        }
      
    }
}
