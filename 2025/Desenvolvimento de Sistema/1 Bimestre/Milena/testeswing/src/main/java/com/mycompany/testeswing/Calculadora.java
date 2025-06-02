package com.mycompany.testeswing; 
import javax.swing.*; //componentes gráficos
import java.awt.*; //estilos
import java.awt.event.*; //eventos

public class Calculadora extends JFrame { //subclasse que adiciona a janela
    //declaração dos componentes
    JLabel rotulo1, rotulo2, exibir;
    JTextField texto1, texto2;
    JButton somar, subtrair, multiplicar, dividir;
    
    public Calculadora(String titulo){ //criação do construtor que recebe o título da janela
        super(titulo);
        
        Container tela = getContentPane(); //obtém o contêiner
        setLayout(null); //posição absoluta dos elemenetos
        setResizable(false); //janela não redimensonável
        tela.setBackground(Color.pink); //cor de fundo da janela
        
        //criação dos rótulos
        rotulo1 = new JLabel("1° Número: ");
        rotulo2 = new JLabel("2° Número: ");
        
        //criação dos campos de texto e sua capacidade
        texto1 = new JTextField(5);
        texto2 = new JTextField(5);
        
        exibir = new JLabel("");
        
        //criação dos botões e remoçao do foco visual
        somar = new JButton("Somar");
        somar.setFocusPainted(false);
        
        subtrair = new JButton("Subtrair");
        subtrair.setFocusPainted(false);

        dividir =  new JButton("Dividir");         
        dividir.setFocusPainted(false);

        multiplicar = new JButton("Multiplicar");
        multiplicar.setFocusPainted(false);
        
        //posicionamento dos componentes
        rotulo1.setBounds(50, 20, 100, 20);
        rotulo2.setBounds(50, 60, 100, 20);
        
        texto1.setBounds(120, 20, 362, 20);
        texto2.setBounds(120, 60, 362, 20);
        
        exibir.setBounds(50, 190, 200, 20);
        
        somar.setBounds(50, 100, 100, 20);
        subtrair.setBounds(160, 100, 100, 20);
        multiplicar.setBounds(270, 100, 100, 20);
        dividir.setBounds(380, 100, 100, 20);

        //personalização das cores de texto e fundo
        somar.setBackground(Color.white);
        subtrair.setBackground(Color.white);
        multiplicar.setBackground(Color.white);
        dividir.setBackground(Color.white);
        
        somar.setForeground(Color.pink);
        subtrair.setForeground(Color.pink);
        multiplicar.setForeground(Color.pink);
        dividir.setForeground(Color.pink);
        
        //evento dos botões
        somar.addActionListener( //quando clicado, será acionado
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    try {
                        int numero1 = Integer.parseInt(texto1.getText()); // Tentativa de conversão
                        int numero2 = Integer.parseInt(texto2.getText()); // Tentativa de conversão
                        int soma = numero1 + numero2;
                        
                        exibir.setVisible(true);
                        exibir.setText("A soma é: " + soma);
                    } catch (NumberFormatException ex) { //se ocorrer um erro durante a conversão dos textos em números
                        exibir.setVisible(true);
                        exibir.setText("Erro: Entrada inválida!");
                    }
                }
            }
        );
        
        // Botão Subtrair
        subtrair.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    try {
                        int numero1 = Integer.parseInt(texto1.getText());
                        int numero2 = Integer.parseInt(texto2.getText());
                        int subtrair = numero1 - numero2;
                        
                        exibir.setVisible(true);
                        exibir.setText("A subtração é: " + subtrair);
                    } catch (NumberFormatException ex) {
                        exibir.setVisible(true);
                        exibir.setText("Erro: Entrada inválida!");
                    }
                }
            }
        );
        
        // Botão Dividir
        dividir.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    try {
                        double numero1 = Double.parseDouble(texto1.getText());
                        double numero2 = Double.parseDouble(texto2.getText());
                        
                        if (numero2 != 0) {
                            double dividir = numero1 / numero2;
                            exibir.setText("A divisão é: " + dividir);
                        } else {
                            exibir.setText("Erro: Divisão por zero!");
                        }
                    } catch (NumberFormatException ex) {
                        exibir.setText("Erro: Entrada inválida!");
                    }
                }
            }
        );
        
        // Botão Multiplicar
        multiplicar.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    try {
                        double numero1 = Double.parseDouble(texto1.getText());
                        double numero2 = Double.parseDouble(texto2.getText());
                        double multiplicar = numero1 * numero2;
                        
                        exibir.setVisible(true);
                        exibir.setText("A multiplicação é: " + multiplicar);
                    } catch (NumberFormatException ex) {
                        exibir.setVisible(true);
                        exibir.setText("Erro: Entrada inválida!");
                    }
                }
            }
        );
        
        exibir.setVisible(false); //inicialmente oculto
        
        //adiciona os componentes à janela
        tela.add(somar);
        tela.add(subtrair);
        tela.add(multiplicar);
        tela.add(dividir);
        tela.add(exibir);
        tela.add(rotulo1);
        tela.add(rotulo2);
        tela.add(texto1);
        tela.add(texto2);
        
        setSize(550,310); //define o tamanho da janela
        setVisible(true); //torna a janela visível
    }
    
    public static void main(String args[]){ //ponto de entrada
        Calculadora app = new Calculadora("Calculadora"); //instância da calculadora
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //define o comportamento quando a janela for fechada (programa encerrado)
    }
}
