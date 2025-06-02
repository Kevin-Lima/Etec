package com.mycompany.metodos;
import javax.swing.JOptionPane;
public class ExemploQuatro {
    public static void main(String[] args){
        int num;
        num=Integer.parseInt(JOptionPane.showInputDialog("Digite um número: "));
        
        if (RestoPorDois(num) == 0)
            JOptionPane.showMessageDialog(null, "O número é par.");
        else 
            JOptionPane.showMessageDialog(null, "O número é ímpar.");
    }
    static int RestoPorDois(int a){
        return a % 2;
    }
}
