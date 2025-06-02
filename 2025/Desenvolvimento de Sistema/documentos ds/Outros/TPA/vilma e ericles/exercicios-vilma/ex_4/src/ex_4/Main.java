package ex_4;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite a altura do degrau em metros: ");
		double d = sc.nextDouble();
		
		System.out.print("Digite a altura que deseja alcançar em metros: ");
		double altura = sc.nextDouble();
		
		double qd = altura/d;
		
		System.out.println("A quantidade de degraus que deve subir é: " + qd + " degraus");
		
	}

}
