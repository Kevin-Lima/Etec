package com.mycompany.testeswing; 
import javax.swing.*; //componentes gráficos
import javax.swing.text.*; //manipulação de texto
import java.awt.*; //interfaces gráficas
import java.text.*; //tratamento de exceções

public class Mascara extends JFrame {
    
    //rótulos para indicar campos de entrada
    JLabel rotulocep, rotulotel, rotulocpf, rotulodata;
    
    //campos de entrada formatados para aceitar apenas determinados tipos de dados
    JFormattedTextField cep, tel, cpf, data;
    
    //máscaras para restringir a entrada de dados
    MaskFormatter mascaracep, mascaratel, mascaracpf, mascaradata;
    
    //construtor da classe e parâmetro que ele recebe
    public Mascara(String titulo){
        
        //título da janela
        super(titulo);
        
        //obtém o container principal da janela
        Container tela = getContentPane();
        
        //define um layout absoluto
        setLayout(null);
        
        //cria rótulos para campos de entrada
        rotulocep = new JLabel("CEP: ");
        rotulotel = new JLabel("Telefone: ");
        rotulocpf = new JLabel("CPF: ");
        rotulodata = new JLabel("Data: ");
        
        //define x, y, largura e altura dos rótulos
        rotulocep.setBounds(50,40,100,20);
        rotulotel.setBounds(50,80,100,20);
        rotulocpf.setBounds(50,120,100,20);
        rotulodata.setBounds(50,160,100,20);
        
        //define as máscaras para entrada de dados
        try{
            mascaracep = new MaskFormatter("####-###");
            mascaratel = new MaskFormatter("(##)####-###");
            mascaracpf = new MaskFormatter("#########-##");
            mascaradata = new MaskFormatter("##/##/####");
            
            //define o caractere de espaço reservado que aparece no campo até que o usuário preencha os dados
            mascaracep.setPlaceholderCharacter('_');
            mascaratel.setPlaceholderCharacter('_');
            mascaracpf.setPlaceholderCharacter('_');
            mascaradata.setPlaceholderCharacter('_');
        }
        catch(ParseException excp){}
        
        //cria campos de entrada formatados com as máscaras definidas
        cep = new JFormattedTextField(mascaracep);
        tel = new JFormattedTextField(mascaratel);
        cpf = new JFormattedTextField(mascaracpf);
        data = new JFormattedTextField(mascaradata);
        
        //define a posição dos campos de entrada
        cep.setBounds(150,40,100,20);
        tel.setBounds(150,80,100,20);
        cpf.setBounds(150,120,100,20);
        data.setBounds(150,160,100,20);
        
        //adiciona os rótulos e campos de entrada ao container tela
        tela.add(rotulocep);
        tela.add(rotulotel);
        tela.add(rotulocpf);
        tela.add(rotulodata);
        tela.add(cep);
        tela.add(tel);
        tela.add(cpf);
        tela.add(data);
        
        setSize(400,250); //define o tamanho da janela
        setVisible(true); //torna a janela visível
    }
    
    public static void main(String args[]){
        
        //cria um objeto da classe que abre a janela gráfica
        Mascara app = new Mascara("Máscara para preenchiemnto de informações");
        //define o comportamento ao fechar a janela
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
