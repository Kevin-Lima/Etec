/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetocarlos;

public class ConversorNumeros {
    public static int stringParaInt(String str) throws NumberFormatException {
        return Integer.parseInt(str);
    }

    public static double stringParaDouble(String str) throws NumberFormatException {
        return Double.parseDouble(str);
    }

    public static String intParaString(int num) {
        return Integer.toString(num);
    }

    public static String doubleParaString(double num) {
        return String.format("%.2f", num);
    }
}