package com.mycompany.cadastro.aluno;

import java.util.Scanner;

public class CadastroAluno {
public static void main(String [] args){
    //captura dos valores
    Scanner scanner = new Scanner(System.in);
    
    //agora o usuário tem tem que digitar o nome
    System.out.println("Por favor digite o seu nome: ");
    
    //ele ira ver o nome que o usuario digitou e ira guardar na variavel nome
    var nome = scanner.next() + scanner.nextLine();
    
    //usuário terá que digitar a idade
    System.out.println("Por favor digite sua idade: ");
    
    //ele ira ver a idade que o usuario digitou e ira guardar na variavel idade
    int idade = scanner.nextInt();
    
     //usuário terá que digitar o sexo
    System.out.println("Digite seu sexo: ");
    
    //ele ira ver o sexo que o usuario digitou e ira guardar na variavel sexo
    var sexo = scanner.next() + scanner.nextLine();
    
    //usuário terá que digitar o endereço
    System.out.println("Digite o seu endereço: ");

    //ele ira ver o endereço que o usuario digitou e ira guardar na variavel endereco
    var endereco = scanner.next() + scanner.nextLine();
    
    //usuário terá que digitar a altura
    System.out.println("Digite sua altura: ");
    
    //ele ira ver a altura que o usuario digitou e ira guardar na variavel altura
    double altura = scanner.nextDouble();
    
    //usuário terá que digitarn as observações sobre ele
    System.out.println("Digie as observações: ");
    
    //ele ira ver as observações que o usuario digitou e ira guardar na variavel observacoes
    var observacoes = scanner.next() + scanner.nextLine();
    
     //usuário terá que digitar o peso
    System.out.println("Digite seu peso: ");
    
    //ele ira ver peso que o usuario digitou e ira guardar na variavel peso
    double peso = scanner.nextDouble();
    
    //calculo do imc
    double imc = peso / altura * altura;
    
    //ira mostrar para o usuário o nome
    System.out.println("Nome: " + nome);
    
    //ira mostrar para o usuário a idade
    System.out.println("Idade: " + idade);
    
    //confere e mostra qual o sexo (F ou M) armazenado na variavel sexo
    if (sexo == "M"){
        System.out.println("Sexo: Masculino");
    }else{
        System.out.println("Sexo: Feminino");
    }
    
    //ira mostrar para o usuário o endereco
    System.out.println("Endereço: " + endereco);
    
    //ira mostrar para o usuário a altura
    System.out.println("Altura: " + altura);
    
    //ira mostrar para o usuário as obeservaçoes
    System.out.println("Observações: " + observacoes);
    
    //ira mostrar para o usuário o peso
    System.out.println("Peso: " + peso);
    
    //ira mostrar para o usuário o imc
    System.out.println("IMC: " + imc);
    

} 
}