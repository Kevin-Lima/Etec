package com.mycompany.metodos;
import javax.swing.JOptionPane;
public class ExemploUm {
    public static void main(String[] args){
        int a;
        a = Integer.parseInt(JOptionPane.showInputDialog("Digite um número: "));
        dobro(a);
    }

     static void dobro(int n) {
        int d = n * 2;
        JOptionPane.showMessageDialog(null, "O dobro de " + n + " é " + d + ".");
        }
}
