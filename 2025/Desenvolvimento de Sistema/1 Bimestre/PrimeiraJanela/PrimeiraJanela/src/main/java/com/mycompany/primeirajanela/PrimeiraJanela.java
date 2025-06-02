package com.mycompany.primeirajanela;

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrimeiraJanela extends JFrame { 
    JLabel rotulo1, rotulo2, rotulo3, rotulo4; 
    JTextField texto1, texto2, texto3, texto4; 
    JButton botao;
    
    public PrimeiraJanela() 
    { 
        super("Exemplo com JTextField"); 
        Container tela = getContentPane(); 
        setLayout(null); 
        
        rotulo1 = new JLabel("Nome"); 
        rotulo2 = new JLabel("Idade"); 
        rotulo3 = new JLabel("Telefone"); 
        rotulo4 = new JLabel("Celular"); 
        
        texto1 = new JTextField(50); 
        texto2 = new JTextField(3); 
        texto3 = new JTextField(10); 
        texto4 = new JTextField(10); 
        
        botao = new JButton("Sair");
        
        botao.setBounds(150, 170, 80, 20);
        
        //Essa parte faz com que o button funcione-----
        // Adiciona um "ouvinte de ação" (ActionListener) ao botão, ou seja, define o que deve acontecer quando o botão for clicado.
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Quando o botão for pressionado, o método actionPerformed será executado.
                // Neste caso, System.exit(0) finaliza a execução do programa, encerrando a aplicação completamente.
                System.exit(0);
        }
    });

              
        
        rotulo1.setBounds(50, 20, 80, 20); 
        rotulo2.setBounds(50, 60, 80, 20); 
        rotulo3.setBounds(50, 100, 80, 20); 
        rotulo4.setBounds(50, 140, 80, 20); 
        
        texto1.setBounds(110, 20, 200, 20); 
        texto2.setBounds(110, 60, 20, 20); 
        texto3.setBounds(110, 100, 80, 20); 
        texto4.setBounds(110, 140, 80, 20); 
        
        rotulo1.setForeground(Color.red);
        rotulo2.setForeground(Color.blue);
        rotulo3.setForeground(Color.yellow);
        rotulo4.setForeground(Color.green);
        
        rotulo1.setFont(new Font("Arial",Font.BOLD,14));
        rotulo2.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        rotulo3.setFont(new Font("Courier New",Font.BOLD,12));
        rotulo4.setFont(new Font("Times New Roman",Font.BOLD,16));
        
        tela.setBackground(Color.cyan);
        
        setResizable(false);
        
        tela.add(botao);
        tela.add(rotulo1); 
        tela.add(rotulo2); 
        tela.add(rotulo3); 
        tela.add(rotulo4); 
        tela.add(texto1); 
        tela.add(texto2); 
        tela.add(texto3); 
        tela.add(texto4); 
        
        setSize(400, 250); 
        setVisible(true); 
        setLocationRelativeTo(null); 
    } 

    public static void main(String args[]) { 
        PrimeiraJanela app = new PrimeiraJanela(); 
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    } 
}
