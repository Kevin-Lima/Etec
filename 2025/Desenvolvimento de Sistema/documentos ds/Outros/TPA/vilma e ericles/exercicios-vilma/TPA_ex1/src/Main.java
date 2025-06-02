import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite o tamanho da Base Maior: ");
		double bm = sc.nextDouble();
		
		System.out.println("Digite o tamanho da Base Menor: ");
		double bn = sc.nextDouble();
		
		System.out.println("Digite a Altura: ");
		double al = sc.nextDouble();
				
		double area = ((bm + bn)* al)/2;
		
		System.out.println("A area do Trapézio é: " + area);
	}

}