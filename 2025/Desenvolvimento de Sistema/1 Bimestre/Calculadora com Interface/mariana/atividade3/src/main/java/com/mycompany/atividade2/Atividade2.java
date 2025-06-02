package com.mycompany.atividade2;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.border.EmptyBorder;
public class Atividade2 extends JFrame{
   
JLabel rotulo1, rotulo2, exibir; 
JTextField texto1, texto2;
JButton somar; 
JButton subtrair; 
JButton dividir; 
JButton multiplicar; 
JButton dobro; 
JButton quadrado; 
JButton cubo; 
JButton resto; 
JButton sair;

public Atividade2(){ 
super("Janela de Operações"); 
Container tela = getContentPane(); 
setLayout(null);

rotulo1 = new JLabel("1° Número: "); 
rotulo2 = new JLabel("2° Número: "); 
texto1 = new JTextField(5); 
texto2 = new JTextField(5); 
exibir = new JLabel(""); 
somar = new JButton("Somar"); 
        somar.setBorder(new EmptyBorder(0, 0, 0, 0));
        somar.setFocusPainted(false);
subtrair = new JButton("Subtrair"); 
subtrair.setBorder(new EmptyBorder(0, 0, 0, 0));
        subtrair.setFocusPainted(false);
dividir =  new JButton("Divisão"); 
dividir.setBorder(new EmptyBorder(0, 0, 0, 0));
        dividir.setFocusPainted(false);
multiplicar = new JButton("Multiplicar");
multiplicar.setBorder(new EmptyBorder(0, 0, 0, 0));
        multiplicar.setFocusPainted(false);
        dobro = new JButton("Dobro");
dobro.setBorder(new EmptyBorder(0, 0, 0, 0));
        dobro.setFocusPainted(false);
        quadrado = new JButton("Quadrado");
quadrado.setBorder(new EmptyBorder(0, 0, 0, 0));
        quadrado.setFocusPainted(false);
        cubo = new JButton("Cubo");
cubo.setBorder(new EmptyBorder(0, 0, 0, 0));
        cubo.setFocusPainted(false);
        resto = new JButton("Resto");
resto.setBorder(new EmptyBorder(0, 0, 0, 0));
        resto.setFocusPainted(false);
sair = new JButton("Sair");
sair.setBorder(new EmptyBorder(0, 0, 0, 0));
        sair.setFocusPainted(false);

rotulo1.setBounds(50,20,100,20); rotulo2.setBounds(50,60,100,20); 
texto1.setBounds(120,20,362,20); texto2.setBounds(120,60,362,20);
exibir.setBounds(50,190,200,20); 
somar.setBounds(50, 100, 100, 30); 
subtrair.setBounds(160, 100, 100, 30); 
dividir.setBounds(270, 100, 100, 30);
multiplicar.setBounds(380, 100, 100, 30);
dobro.setBounds(50, 140, 100, 30);
quadrado.setBounds(160, 140, 100, 30); 
cubo.setBounds(270, 140, 100, 30);
resto.setBounds(380, 140, 100, 30);
sair.setBounds(210, 220, 120, 30);

tela.setBackground(new Color(200, 162, 200));
JButton[] botoes = {somar, subtrair, dividir, multiplicar,dobro,quadrado, cubo, resto, sair};
for (JButton botao : botoes) {
    botao.setBackground(new Color (150, 100,150)); 
    botao.setForeground(Color.WHITE); 
}
exibir.setForeground(Color.WHITE);
rotulo1.setForeground(Color.WHITE);
rotulo2.setForeground(Color.WHITE);

somar.addActionListener( 
new ActionListener(){ 
public void actionPerformed(ActionEvent e){ 
double numero1, numero2, soma; 
soma= 0; 
numero1 = Double.parseDouble(texto1.getText());
numero2 = Double.parseDouble(texto2.getText()); 
soma = numero1 + numero2; 
exibir.setVisible(true); 
exibir.setText("A soma é: "+soma); 
} 
} 
); 
subtrair.addActionListener( 
new ActionListener(){ 
public void actionPerformed(ActionEvent e){ 
double numero1, numero2, subtrair; 
subtrair= 0; 
numero1 = Double.parseDouble(texto1.getText()); 
numero2 = Double.parseDouble(texto2.getText());
subtrair = numero1 - numero2; 
exibir.setVisible(true); 
exibir.setText("A subtração é: "+subtrair); 
} 
} 
); 
dividir.addActionListener( 
new ActionListener(){ 
public void actionPerformed(ActionEvent e){ 
double numero1, numero2, dividir; 
dividir= 0; 
numero1 = Double.parseDouble(texto1.getText()); 
numero2 = Double.parseDouble(texto2.getText());
if (numero2 != 0) { 
            dividir = numero1 / numero2; 
            exibir.setText("A divisão é: " + dividir); 
        } else {
            exibir.setText("Erro: Divisão por zero!");
        } 

} 
} 
); 
multiplicar.addActionListener( 
new ActionListener(){ 
public void actionPerformed(ActionEvent e){ 
double numero1, numero2, multiplicar; 
multiplicar= 0; 
numero1 = Double.parseDouble(texto1.getText()); 
numero2 = Double.parseDouble(texto2.getText());
multiplicar = numero1 * numero2; 
exibir.setVisible(true); 
exibir.setText("A multiplicação é: "+multiplicar); 
} 
} 
); 

dobro.addActionListener( 
new ActionListener(){ 
public void actionPerformed(ActionEvent e){ 
double numero1, numero2, dobro; 
dobro= 0; 
numero1 = Double.parseDouble(texto1.getText()); 
numero2 = Double.parseDouble(texto2.getText());
dobro = numero1 * 2; 
exibir.setVisible(true); 
exibir.setText("O dobro de " +numero1 + " é: "+dobro); 
} 
} 
); 
quadrado.addActionListener( 
new ActionListener(){ 
public void actionPerformed(ActionEvent e){ 
double numero1, numero2, quadrado; 
quadrado= 0; 
numero1 = Double.parseDouble(texto1.getText()); 
numero2 = Double.parseDouble(texto2.getText());
quadrado = numero1 * numero1; 
exibir.setVisible(true); 
exibir.setText("O quadrado de " +numero1 + " é : "+quadrado); 
} 
} 
); 
cubo.addActionListener( 
new ActionListener(){ 
public void actionPerformed(ActionEvent e){ 
double numero1, numero2, cubo; 
cubo= 0; 
numero1 = Double.parseDouble(texto1.getText()); 
numero2 = Double.parseDouble(texto2.getText());
cubo = numero1 * numero1 * numero2; 
exibir.setVisible(true); 
exibir.setText("O cubo de " +numero1+ " + " +numero1+ " + " +numero2 +" é: "+cubo); 
} 
} 
); 
resto.addActionListener( 
new ActionListener(){ 
public void actionPerformed(ActionEvent e){ 
double numero1, numero2, resto; 
resto= 0; 
numero1 = Double.parseDouble(texto1.getText()); 
numero2 = Double.parseDouble(texto2.getText());
resto = numero1 % numero2; 
exibir.setVisible(true); 
exibir.setText("O resto de "+numero1+" dividido "+numero2+" é: "+resto); 
} 
}  
); 

sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
});
                       
exibir.setVisible(false); 
tela.add(rotulo1); tela.add(rotulo2); 
tela.add(texto1); tela.add(texto2); 
tela.add(exibir); tela.add(somar); 
tela.add(subtrair);tela.add(dividir);
tela.add(multiplicar);tela.add(dobro);
tela.add(quadrado);tela.add(cubo);
tela.add(resto);tela.add(sair);
setSize(550, 310);
setResizable(false);
setVisible(true); 
} 
public static void main(String args[]){ 
Atividade2 app = new Atividade2(); 
app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
} 
}
