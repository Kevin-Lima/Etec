/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testepessoa;

import javax.swing.JOptionPane;

public class Professor extends Pessoa {
    String formacao;
    
     public void definiformacao(String novo){
        formacao = novo;
        novo = JOptionPane.showInputDialog("Digite a formação");
        System.out.println("Analise e Desenvolvimento de Sistemas");
    }
}
