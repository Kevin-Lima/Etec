package com.mycompany.exercicio1;

import java.util.Scanner;

public class Exercicio1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //pede que o usuario insira a hora de inicio do turno
        System.out.println("Digite a hora de inicio do turno (de 00 a 24): ");
        double hora = scanner.nextDouble(); 
        
        //ve em qual condição o horario se encaixa
        if (5 <= hora && hora <= 13) {
            System.out.println("O seu turno é de manhã: " + hora);
        }
        else if (13 < hora && hora <= 21) {
            System.out.println("O seu turno é de tarde: " + hora);
        }
        else if ((21 < hora && hora <= 24) || (0 <= hora && hora < 5)) {
            System.out.println("O seu turno é de noite: " + hora);
        } else {
            System.out.println("Hora invalida.");
        }
        
    }
}
