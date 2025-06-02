package com.mycompany.metodo.com.retorno;

import javax.swing.JOptionPane;

public class MetodoComRetorno {

    public static void main(String[] args) {
        digite();
    }

    static void digite() {
        String p = JOptionPane.showInputDialog(null, "Digite uma palavra qualquer: ");
        int t = tamanho(p);
        JOptionPane.showMessageDialog(null, p + " possui " + t + " caracteres");
    }

    static int tamanho(String x) {
        return x.length();
    }
}
