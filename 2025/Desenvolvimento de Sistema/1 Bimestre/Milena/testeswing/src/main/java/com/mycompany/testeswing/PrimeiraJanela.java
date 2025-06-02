//pacote em que a classe está localizada
package com.mycompany.testeswing;

//importa os componentes e classes da biblioteca "javaz.swing", o "*" importa todos
import javax.swing.*;

//define a classe "PrimeiraJanela" que é uma subclasse(herda de) JFrame (classe Swing para criar uma janela gráfica)
public class PrimeiraJanela extends JFrame {
    
    //define o construtor da classe filho, que recebe o parâmetro titulo do tipo String
    public PrimeiraJanela(String titulo){
        
        //chama o construtor da classe pai e passa o titulo  da janela como argumento
        super(titulo);
        
        //define a largura e altura da janela em pixels
        setSize(300, 150);
        
        //torna a janela visível
        setVisible(true);
    }

    //define o método principal, ponto de entrada do programa
    public static void main(String[] args) {
        
        //cria uma nova instância da classe "PrimeiraJanela" e a chama de "app"
        //título da janela é passado para o construtor da classe "PrimeiraJanela"
        PrimeiraJanela app = new PrimeiraJanela("Minha primeira janela personalizada.");
        
        //define o comportamento quando a janela for fechada, o parâmetro indica que o programa será encerrado
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
