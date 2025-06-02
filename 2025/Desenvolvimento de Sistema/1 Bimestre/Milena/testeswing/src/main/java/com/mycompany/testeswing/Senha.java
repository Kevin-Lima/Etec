 package com.mycompany.testeswing;

//fornece componentes gráficos
import javax.swing.*;

//contém classes para manipulação de estilos e container
import java.awt.*;
 
//contém classes de manipulação de eventos
import java.awt.event.*;

public class Senha extends JFrame {
    
    JPasswordField caixa;//campo de entrada para senha
    JLabel rotulo; //rótulo associado ao campo de senha
    JButton mostrar; //botão que armazena a visibilidade da senha
    boolean senhaVisivel = false; //armazena o estado da visibilidade da senha
    
    public Senha(String titulo){ //construtor da classe senha, que recebe o título da janela
        
        super(titulo); //construtor da classe JFrame que define o título
        
        Container tela = getContentPane(); //Obtém o ocntainer principal
        
        setLayout(null); //layout absoluto
        
        rotulo = new JLabel("Senha: "); //cria o rótulo
        caixa = new JPasswordField(10); //cria o campo de senha com 10 colunas de largura
        mostrar = new JButton("Mostrar"); //cria o botão com ação
        
        //define a posição dos elementos na janela 
        rotulo.setBounds(50, 20, 100, 20);
        caixa.setBounds(50, 60, 200, 20);
        mostrar.setBounds(150, 100, 80, 20);
        
        mostrar.addActionListener( //adiciona um ouvinte de eventos ao botão
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        senhaVisivel = !senhaVisivel; //alterna entre true e false
                        
                        if (senhaVisivel){
                            caixa.setEchoChar('\0'); //remove a ocultação da senha
                            mostrar.setText("Ocultar"); //muda o texto do botão    
                        }
                        else{
                            caixa.setEchoChar('*'); //oculta a senha
                            mostrar.setText("Mostrar"); //muda o texto do botão  
                        }
                        String senha = new String(caixa.getPassword()); //obtém a senha digitada
                        
                    }
                }
        );
        
        rotulo.setForeground(Color.red); //cor do rótulo
        tela.setBackground(Color.yellow); //cor de fundo da tela
        caixa.setForeground(Color.blue); //cor do texto da senha
        caixa.setBackground(Color.pink); //cor de fundo do campo de senha
        
        caixa.setFont(new Font("Arial", Font.BOLD,20)); //fonte, formatação e tamanho
        
        caixa.setEchoChar('*'); //substitui os caracteres digitados pelo símbolo
        
        //adiciona os rótulos e campos de entrada de senha ao container principal
        tela.add(rotulo);
        tela.add(caixa);
    
        tela.add(mostrar);
        
        setSize(400, 250); //tamanho da janela em px
        setVisible(true); //torna a janela visível
        setLocationRelativeTo(null); //centraliza a janela

    }
    
    //método principal
    public static void main (String args[]){
        
        //cria um objeto da classe "Senha" e abre a janela com o título
        Senha app = new Senha("Exemplo de senha com JPassword Field");
        
        //define comportamento ao fechar a janela
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
