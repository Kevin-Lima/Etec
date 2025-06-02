package ex_3;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	System.out.print("Digite o nome: ");
	String nome = sc.nextLine();
	
	System.out.print("Digite o seu salário fixo: ");
	double salario = sc.nextDouble();
	
	System.out.print("Digite o valor de suas vendas esse mês: ");
	double vendas = sc.nextDouble();
	
	double comissao = vendas*0.04;
	
	double f = comissao + salario;
	
	System.out.println("Olá " + nome +", a sua comissão deste mês é de R$" + comissao + " e o seu salário final é R$" + f);
	
	}
}