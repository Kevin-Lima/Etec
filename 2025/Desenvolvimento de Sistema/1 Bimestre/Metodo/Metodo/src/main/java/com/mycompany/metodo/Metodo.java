/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.metodo;

import javax.swing.JOptionPane;

public class Metodo {

    public static void main(String[] args) {
        int a;
        a = digite();
        dobro(a);
    }
    
    static int digite(){
        return Integer.parseInt(JOptionPane.showInputDialog(null,"Digite um número: "));
    }
    static void dobro(int n){
       int d = n * 2;
       JOptionPane.showMessageDialog(null,"Dobro de "+n+" é "+d);
    }
}
