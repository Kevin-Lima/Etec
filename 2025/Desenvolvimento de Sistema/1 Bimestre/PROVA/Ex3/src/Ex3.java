/* Este comando importa todas as classes do pacote javax.swing,
   que é usado para criar interfaces gráficas em Java */
import javax.swing.*;

/* Este comando importa todas as classes do pacote java.awt,
   que também é usado para construir interfaces gráficas, permitindo adicionar cor,
   tamanho das fontes, estilo das fontes, etc */
import java.awt.*;

/* Este comando importa todas as classes do pacote java.awt.event, que são usadas para
   capturar eventos, como cliques de botão, teclas, movimentação do mouse, etc */
import java.awt.event.*;

public class Ex3 extends JFrame {

    JLabel rotulo1,rotulo2,resultado1,resultado2,resultado3,titulo;

    JTextField texto1, texto2, texto3;

    JButton calcular;

    public Ex3() {
        Container tela = getContentPane();

        setLayout(null);

        titulo = new JLabel("EXERCICIO 3");
        rotulo1 = new JLabel("Horas-Trabalhadas: ");
        rotulo2 = new JLabel("Numeros de Dependentes: ");

        texto1 = new JTextField(5);
        texto2 = new JTextField(5);

        resultado1 = new JLabel("");
        resultado2 = new JLabel("");
        resultado3 = new JLabel("");

        calcular = new JButton("Calcular");


        titulo.setBounds(150,20,200,25);

        rotulo1.setBounds(50, 65, 150, 25);
        rotulo2.setBounds(50,95,200,25);

        texto1.setBounds(200,67,180,20);
        texto2.setBounds(250,97,130,20);

        calcular.setBounds(180,220,100,25);

        resultado1.setBounds(50,140,250,25);
        resultado2.setBounds(50,160,250,25);
        resultado3.setBounds(50,180,250,25);

        titulo.setForeground(new Color (0,0,205));

        titulo.setFont(new Font("Arial", Font.PLAIN,19));

        rotulo1.setFont(new Font("Arial", Font.PLAIN, 17));
        rotulo2.setFont(new Font("Arial", Font.PLAIN, 17));

        texto1.setFont(new Font("Arial", Font.PLAIN, 15));
        texto2.setFont(new Font("Arial", Font.PLAIN, 15));

        resultado1.setFont(new Font("Arial", Font.PLAIN, 15));
        resultado2.setFont(new Font("Arial", Font.PLAIN, 15));
        resultado3.setFont(new Font("Arial", Font.PLAIN, 15));

        resultado1.setForeground(Color.BLUE);
        resultado2.setForeground(Color.BLUE);
        resultado3.setForeground(Color.BLUE);

        calcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double horas = Double.parseDouble(texto1.getText());
                    double dependentes = Double.parseDouble(texto2.getText());

                    double bruto = horas * 20;

                    if(bruto <= 700){
                        resultado1.setText("Salario Liquido a receber = "+String.format("%.2f",bruto));
                        resultado2.setText("Desconto = R$ 0");
                        resultado3.setText("Salario bruto = "+String.format("%.2f",bruto));
                    }else if(bruto > 700 && bruto <= 1200){
                        double d1 = (bruto * 5) / 100;
                        double sl1 = (bruto - d1) + (dependentes * 300);
                        resultado1.setText("Salario Liquido a receber = "+String.format("%.2f",sl1));
                        resultado2.setText("Desconto = R$ "+String.format("%.2f",d1));
                        resultado3.setText("Salario bruto = "+String.format("%.2f",bruto));
                    }else if(bruto > 1200 && bruto <= 1800){
                        double d2 = (bruto * 10) / 100;
                        double sl2 = (bruto - d2) + (dependentes * 300);
                        resultado1.setText("Salario Liquido a receber = "+String.format("%.2f",sl2));
                        resultado2.setText("Desconto = R$ "+String.format("%.2f",d2));
                        resultado3.setText("Salario bruto = "+String.format("%.2f",bruto));
                    }else{
                        double d3 = (bruto * 20) / 100;
                        double sl3 = (bruto - d3) + (dependentes * 300);
                        resultado1.setText("Salario Liquido a receber = R$"+String.format("%.2f",sl3));
                        resultado2.setText("Desconto = R$ "+String.format("%.2f",d3));
                        resultado3.setText("Salario bruto = R$"+String.format("%.2f",bruto));
                    }

                }catch (NumberFormatException ex){
                    //resultado2.setVisible(false);
                    //resultado3.setVisible(false);
                    resultado1.setText("Erro: Digite números válidos!");
                    resultado2.setText("Erro: Digite números válidos!");
                    resultado3.setText("Erro: Digite números válidos!");
                }
            }
        });


        tela.add(titulo);
        tela.add(rotulo1);
        tela.add(rotulo2);
        tela.add(texto1);
        tela.add(texto2);
        tela.add(resultado1);
        tela.add(resultado2);
        tela.add(resultado3);
        tela.add(calcular);

        //toda vez que executar, o frame vai ficar centralizado no centro da tela
        setLocationRelativeTo(null);

        //faz com que o usuario não consiga redimensionar a tela
        setResizable(false);

        setSize(450,350);

        setVisible(true);

    }


    public static void main(String[] args){
        Ex3 ex3 = new Ex3();

        ex3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
