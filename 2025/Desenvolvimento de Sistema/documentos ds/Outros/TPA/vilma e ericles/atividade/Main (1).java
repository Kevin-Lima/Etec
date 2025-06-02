package Calculo69; 

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		double x, y, soma,divisao;
		
		System.out.print("digite um numero: ");
		x = sc.nextDouble ();
		
		System.out.print("digite outro numero: ");
		y = sc.nextDouble();
		
		soma = x + y;
		divisao = soma / 2;
		
		
		System.out.println("o numero digitado foi: " + x);
		System.out.println("o numero digitado foi: " + y);
		System.out.println("A soma é: " + soma );
		System.out.println(x + " dividido por " + y + " é igual a " + divisao);

	}

}
