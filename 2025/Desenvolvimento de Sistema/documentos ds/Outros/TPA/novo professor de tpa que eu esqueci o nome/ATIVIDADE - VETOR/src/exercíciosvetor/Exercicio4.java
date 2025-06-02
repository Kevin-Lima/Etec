/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercíciosvetor;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author FATEC ZONA LESTE
 */
public class Exercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         Scanner scanner = new Scanner(System.in);
        Integer[] numeros = new Integer [50];
        
        System.out.println("Digite 50 números:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Nome " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }

        Arrays.sort(numeros, Collections.reverseOrder());
        
        System.out.println("15 nomes em ordem decrescente:");
        for (int numero : numeros) {
            System.out.println(numero);
        }

        scanner.close();
    }
    
}
