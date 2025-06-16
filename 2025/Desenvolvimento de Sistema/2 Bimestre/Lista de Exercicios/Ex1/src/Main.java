import javax.swing.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora");
        frame.setSize(350, 300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Campos de entrada
        JLabel labelN1 = new JLabel("N1");
        labelN1.setBounds(20, 10, 20, 20);
        JTextField txtN1 = new JTextField();
        txtN1.setBounds(50, 10, 250, 20);

        JLabel labelN2 = new JLabel("N2");
        labelN2.setBounds(20, 40, 20, 20);
        JTextField txtN2 = new JTextField();
        txtN2.setBounds(50, 40, 250, 20);

        // Botões de operação
        //é um botão de opção (tipo "bolinha selecionável")
        JRadioButton soma = new JRadioButton("Soma (+)");
        soma.setBounds(30, 70, 100, 20);
        JRadioButton subtracao = new JRadioButton("Subtração (-)");
        subtracao.setBounds(30, 90, 150, 20);
        JRadioButton multiplicacao = new JRadioButton("Multiplicação (*)");
        multiplicacao.setBounds(30, 110, 150, 20);
        JRadioButton divisao = new JRadioButton("Divisão (/)");
        divisao.setBounds(30, 130, 150, 20);
        JRadioButton resto = new JRadioButton("Resto (%)");
        resto.setBounds(30, 150, 150, 20);

        // Agrupando botões
        // Adiciona cada botão ao grupo. Todos passam a se comportar como uma seleção única (um selecionado por vez)
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(soma);
        grupo.add(subtracao);
        grupo.add(multiplicacao);
        grupo.add(divisao);
        grupo.add(resto);

        // Botão calcular
        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(200, 100, 100, 30);

        // Resultado
        JLabel labelResultado = new JLabel("Resultado");
        labelResultado.setBounds(20, 190, 100, 20);
        JTextField txtResultado = new JTextField();
        txtResultado.setBounds(100, 190, 200, 20);
        txtResultado.setEditable(false);// Impede que o usuário digite ou edite o campo — usado apenas para mostrar o resultado

        // Ação do botão calcular
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double n1 = Double.parseDouble(txtN1.getText());
                    double n2 = Double.parseDouble(txtN2.getText());
                    double resultado = 0;

                    if (soma.isSelected()) {
                        resultado = n1 + n2;
                    } else if (subtracao.isSelected()) {
                        resultado = n1 - n2;
                    } else if (multiplicacao.isSelected()) {
                        resultado = n1 * n2;
                    } else if (divisao.isSelected()) {
                        resultado = n1 / n2;
                    } else if (resto.isSelected()) {
                        resultado = n1 % n2;
                    }

                    txtResultado.setText(String.valueOf(resultado)); // Converte o valor numérico para texto e exibe no campo de resultado
                } catch (NumberFormatException ex) { // Captura erro de conversão quando o usuário digita algo que não é número
                    JOptionPane.showMessageDialog(frame, "Digite números válidos.");
                }
            }
        });

        // Adicionando componentes ao frame
        frame.add(labelN1);
        frame.add(txtN1);
        frame.add(labelN2);
        frame.add(txtN2);
        frame.add(soma);
        frame.add(subtracao);
        frame.add(multiplicacao);
        frame.add(divisao);
        frame.add(resto);
        frame.add(btnCalcular);
        frame.add(labelResultado);
        frame.add(txtResultado);

        frame.setVisible(true);
    }
}
