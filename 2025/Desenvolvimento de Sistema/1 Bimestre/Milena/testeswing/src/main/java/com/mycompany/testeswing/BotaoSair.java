package com.mycompany.testeswing;
import javax.swing.*; //componentes gráficos
import java.awt.*; //interfaces gráficas
import java.awt.event.*; //manipulação de eventos
public class BotaoSair extends JFrame { //subclasse que cria a janela gráfica 
    JButton botaosair; //define o botão
    
        public BotaoSair(String titulo){ //construtor da classe, será chamado quando o programa for iniciado e seu parâmetro define o título da janela
         super(titulo); //construtor do JFrame que recebe e exibe o título
         
         Container tela = getContentPane(); //obtém o container principal da janela
         setLayout(null); //posição absoluta dos componentes
         
         botaosair = new JButton("Sair"); //cria o botão e define o texto exibido nele
         botaosair.setBounds(100,50,100,20); //define x, y, largura  e altura
         
         botaosair.addActionListener( //adiciona ação a lista que estar´dentro do botão
                 new ActionListener(){ //chamando a nova ação a ser listada
                     public void actionPerformed(ActionEvent e){ //performance da ação que o evento público chamará será o exit
                         System.exit(0); //finaliza o aplicativo
                     }
                 }
         );
         tela.add(botaosair);
         setSize(300,150);
         setVisible(true);
        }
        
            public static void main (String args[]){
                BotaoSair app = new BotaoSair("Botão com função de sair");
                app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
}
