/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercíciosvetor;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author FATEC ZONA LESTE
 */
public class Exercíciosvetor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         Scanner scanner = new Scanner(System.in);
        String[] nomes = new String[15];
        
        System.out.println("Digite 15 nomes:");
        for (int i = 0; i < nomes.length; i++) {
            System.out.print("Nome " + (i + 1) + ": ");
            nomes[i] = scanner.nextLine();
        }

        Arrays.sort(nomes);
        
        System.out.println("15 nomes em ordem crescente:");
        for (String nome : nomes) {
            System.out.println(nome);
        }

        scanner.close();
    }
    
}
