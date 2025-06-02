
package com.mycompany.testepessoa;


public class Pessoa {
    String nome;
    String idade;
    
    public void definirnome(String novo){
       nome = novo;
       System.out.println("Nome: " + nome);
    }
    public void definiridade(String novo){
        idade = novo;
        System.out.println("Idade: " + idade);
    }

}

