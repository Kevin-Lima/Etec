package ex_5;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	Scanner sc = new Scanner (System.in);
	
	System.out.print("Digite o custo do espetaculo: ");
	double custo = sc.nextDouble();
	
	System.out.print("Digite o preço do convite: ");
	double preco = sc.nextDouble();
	
	double n = custo/preco;
	
	System.out.println("Para alcançar o custo do espetáculo, devem ser vendidos " + n + "convites");

	}

}
