package com.mycompany.testeswing;

//biblioteca que fornece componentes gráficos
import javax.swing.*;

//biblioteca que contém containers e manipulação de estilos
import java.awt.*;

public class JLabel_JTextField extends JFrame {
    
    //declaração dos rótulos e textos usados na interface
    JLabel rotulo1, rotulo2, rotulo3, rotulo4;
    JTextField texto1,texto2,texto3,texto4;

    //construtor da classe
    public JLabel_JTextField(String titulo){
        
        //título da janela
        super(titulo);
        
        //obtém o conteúdo da janela para que seja possível adicionar componentes nela
        Container tela = getContentPane();
        
        //mudança de cor da janela
        tela.setBackground(Color.pink);
        
        //necessário para usar "setbounds" pois permite a posição absoluta dos componentes
        setLayout(null);
        
        //cria os rótulos e define o texto de exibição
        rotulo1 = new JLabel ("Nome");
        rotulo2 = new JLabel ("Idade");
        rotulo3 = new JLabel ("Telefone");
        rotulo4 = new JLabel ("Celular");
        
        //cria os campos de texto com o número de colunas sugerido
        texto1 = new JTextField(50);
        texto2 = new JTextField(3);
        texto3 = new JTextField(10);
        texto4 = new JTextField(10);
        
        //x, y, largura e altura dos componentes
        rotulo1.setBounds(50,20,80,20);
        rotulo2.setBounds(50,60,80,20);
        rotulo3.setBounds(50,100,80,20);
        rotulo4.setBounds(50,140,80,20);
        
        texto1.setBounds(110,20,200,20);
        texto2.setBounds(110,60,20,20);
        texto3.setBounds(110,100,80,20);
        texto4.setBounds(110,140,80,20);
        
        //define a cor do texto
        rotulo1.setForeground(Color.red);
        rotulo2.setForeground(new Color(190, 152, 142));
        
        texto3.setForeground(Color.blue);
        texto4.setForeground(new Color(100,200,201));
      
        //define a cor de fundo da caixa de texto
        texto1.setBackground(Color.red);
        
        //define o alinhamento do texto dentro dos campos
        texto2.setHorizontalAlignment(JTextField.CENTER);
        texto3.setHorizontalAlignment(JTextField.RIGHT);
        texto4.setHorizontalAlignment(JTextField.LEFT);

        //define a fonte, estilo e tamanho
        rotulo1.setFont(new Font("Arial", Font.BOLD,14));
        rotulo2.setFont(new Font("Comic Sans MS", Font.BOLD,16));
        
        texto3.setFont(new Font("Courier New", Font.BOLD,18));
        texto4.setFont(new Font("Times New Roman", Font.BOLD,20));
        
        //faz com que o cursos do teclado fique automaticamente no "texto1" quando o programa é iniciado
        texto1.requestFocus();
        
        
        //adiciona os componentes à tela
        tela.add(rotulo1);
        tela.add(rotulo2);
        tela.add(rotulo3);
        tela.add(rotulo4);
        
        tela.add(texto1);
        tela.add(texto2);
        tela.add(texto3);
        tela.add(texto4);
        
        //define o tamanho da janela
        setSize(400, 250);
        
        //torna a janela visível
        setVisible(true);
        
        //centraliza a janela na tela
        setLocationRelativeTo(null);  
    }
    
    //ponto de entrada do programa
    public static void main(String args[]){
        
        //cria um objeto da classe, fazendo com que o construtor execute e crie a janela
        JLabel_JTextField app = new JLabel_JTextField("Rótulos e caixas de texto");
        
        //define que o programa será encerrado quando o usuário fechar a janela
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    } 
}
