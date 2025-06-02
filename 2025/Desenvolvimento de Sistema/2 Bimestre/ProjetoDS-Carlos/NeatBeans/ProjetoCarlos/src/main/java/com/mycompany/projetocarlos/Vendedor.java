/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetocarlos;

public class Vendedor {
    private int id;
    private String nome;
    private double salarioBase;

    public Vendedor(int id,String nome, double salarioBase) {
        this.id = id;
        this.nome = nome;
        this.salarioBase = salarioBase;
    }

    public int getId() {
        return id;
    }

    public String getNome(){
        return nome;
    }

    public Double getSalarioBase(){
        return salarioBase;
    }

    public double calcularComissao(double valorVendido){
        return valorVendido * (0.03+(salarioBase * 0.00001));
    }



}