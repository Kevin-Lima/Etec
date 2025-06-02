package com.mycompany.metodo.com.retorno;

import javax.swing.JOptionPane;

public class MetodoComRetorno {

    public static void main(String[] args) {
        int t;
        String p;
        p = digite();
        t = tamanho(p);
        JOptionPane.showMessageDialog(null, p + " possui " + t + " caracteres");
    }

    static String digite() {
        String p = JOptionPane.showInputDialog(null, "Digite uma palavra qualquer: ");
        return p;
    }

    static int tamanho(String x) {
        return x.length();
    }
}
