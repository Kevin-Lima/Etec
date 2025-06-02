package com.mycompany.testeswing;

//contém classes para manipulação de eventos
import java.awt.event.*;

//fornece componentes gráficos
import javax.swing.*;

//contém classes para manipulação de estilos e container
import java.awt.*;

public class Botao extends JFrame {
    
    //botões da interface
    JButton botao1, botao2, botao3, botao4;
    
    //contrutor da classe que será executado quando um objeto for criado
    public Botao(){
        
        //título da janela
        super("JButton");
        
        //obtém o container da janela
        Container tela = getContentPane();
        
        //permite posição absoluta dos componentes
        setLayout(null);
        
        //cria os botões e define os textos exibidos neles
        botao1= new JButton ("Procurar");
        botao2= new JButton ("Voltar");
        botao3= new JButton ("Próximo");
        botao4= new JButton ("Abrir");
        
        //define x, y, largura e altura
        botao1.setBounds(50,20,100,20);
        botao2.setBounds(50,60,100,20);
        botao3.setBounds(50,100,100,20);
        botao4.setBounds(50,140,100,20);
        
        //define a cor e fundo dos botões
        botao1.setBackground(Color.yellow);
        botao2.setBackground(Color.red);
        botao3.setBackground(Color.blue);
        botao4.setBackground(Color.white);
        
        //define uma tecla de atalho para cada botão
        botao1.setMnemonic(KeyEvent.VK_P);
        botao2.setMnemonic(KeyEvent.VK_V);
        botao3.setMnemonic(KeyEvent.VK_P);
        botao4.setMnemonic(KeyEvent.VK_A);
        
        botao1.setForeground(Color.white);
        botao2.setForeground(Color.yellow);
        botao3.setForeground(Color.red);
        botao4.setForeground(Color.blue);
        
        //botão padrao que será pressionado com "enter"
        getRootPane().setDefaultButton(botao4);

        //adiciona à tela
        tela.add(botao1);
        tela.add(botao2);
        tela.add(botao3);
        tela.add(botao4);
        
        setSize(400,250);
        setVisible(true);
        setLocationRelativeTo(null);
        
    }
    
    public static void main(String args[]){
        Botao app = new Botao();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
