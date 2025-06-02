
package com.mycompany.metodos;
import javax.swing.JOptionPane;
public class ExemploDois {
    static String p;
    public static void main(String[] args){
        int t;
        digite();
        t=tamanho(p);
        JOptionPane.showMessageDialog(null, p + " possui " + t + " caracteres.");
    }
    static void digite(){
       p = JOptionPane.showInputDialog(null, "Digite uma palavra:");
    }
    static int tamanho(String x){
        return x.length();
    }
}
