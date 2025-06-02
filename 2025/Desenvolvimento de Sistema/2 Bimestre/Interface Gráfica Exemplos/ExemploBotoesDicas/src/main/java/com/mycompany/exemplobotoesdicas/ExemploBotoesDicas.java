package com.mycompany.exemplobotoesdicas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ExemploBotoesDicas extends JFrame {
    JButton botao1, botao2;

    public ExemploBotoesDicas() {
        super("Botões com Dicas");
        Container tela = getContentPane();
        setLayout(null);

        botao1 = new JButton("Novo");
        botao2 = new JButton("Abrir");
        botao1.setBounds(100, 50, 100, 20);
        botao2.setBounds(100, 100, 100, 20);

        botao1.setToolTipText("Botão usado para abrir algo");
        botao2.setToolTipText("Botão que será usado para sair");

        tela.add(botao1);
        tela.add(botao2);   

        setSize(300, 200);
        setVisible(true);
        setLocationRelativeTo(null);
        
    }

    public static void main(String[] args) {
        ExemploBotoesDicas app = new ExemploBotoesDicas();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
