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

public class Ex2 extends JFrame {

    JLabel rotulo1,rotulo2,resultado;

    JTextField texto1, texto2, texto3;

    JButton calcular;

    public Ex2() {
        Container tela = getContentPane();

        setLayout(null);

        rotulo1 = new JLabel("Peso: ");
        rotulo2 = new JLabel("Altura: ");

        texto1 = new JTextField(5);
        texto2 = new JTextField(5);

        resultado = new JLabel("");

        calcular = new JButton("Calcular");


        rotulo1.setBounds(50, 65, 70, 25);
        rotulo2.setBounds(50,95,70,25);

        texto1.setBounds(100,67,130,20);
        texto2.setBounds(100,97,130,20);

        calcular.setBounds(110,180,100,25);

        resultado.setBounds(50,140,250,25);

        rotulo1.setFont(new Font("Arial", Font.PLAIN, 17));
        rotulo2.setFont(new Font("Arial", Font.PLAIN, 17));

        texto1.setFont(new Font("Arial", Font.PLAIN, 15));
        texto2.setFont(new Font("Arial", Font.PLAIN, 15));

        resultado.setFont(new Font("Arial", Font.PLAIN, 15));

        resultado.setForeground(Color.BLUE);

        calcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double peso = Double.parseDouble(texto1.getText());
                    double altura = Double.parseDouble(texto2.getText());

                    double imc = peso / (altura * altura);

                    if(imc < 18){
                        resultado.setText("IMC = "+String.format("%.2f",imc)+". Abaixo do peso");
                    }else if(imc >= 18.5 && imc <= 24.99){
                        resultado.setText("IMC = "+ String.format("%.2f",imc)+". Peso ideal");
                    }else{
                        resultado.setText("IMC = "+String.format("%.2f",imc)+". Acima do peso");
                    }

                }catch (NumberFormatException ex){
                    resultado.setText("Erro: Digite números válidos!");
                }
            }
        });



        tela.add(rotulo1);
        tela.add(rotulo2);
        tela.add(texto1);
        tela.add(texto2);
        tela.add(resultado);
        tela.add(calcular);

        setSize(350,320);

        setVisible(true);

    }


    public static void main(String[] args){
        Ex2 ex2 = new Ex2();

        ex2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
