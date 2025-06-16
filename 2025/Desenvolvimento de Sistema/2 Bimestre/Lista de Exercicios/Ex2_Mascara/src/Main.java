import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        try {

// Máscaras de entrada (definem o formato que o usuário deve seguir)
// O símbolo '#' indica que apenas números serão aceitos naquela posição

            MaskFormatter cepFormatter = new MaskFormatter("#####-###");
            MaskFormatter telefoneFormatter = new MaskFormatter("(##) #####-####");
            MaskFormatter cpfFormatter = new MaskFormatter("###.###.###-##");
            MaskFormatter dataFormatter = new MaskFormatter("##/##/####");

// Campos de texto formatados usando as máscaras criadas acima
// A palavra-chave 'final' significa que a variável não pode ser reatribuída depois de criada,
// mas você ainda pode alterar as propriedades do objeto (como texto, cor, tamanho etc.)

            final JFormattedTextField cepField = new JFormattedTextField(cepFormatter);
// Define posição (x, y) e tamanho (largura, altura) do campo na janela
            cepField.setBounds(120, 20, 200, 20);

            final JFormattedTextField telefoneField = new JFormattedTextField(telefoneFormatter);
            telefoneField.setBounds(120, 50, 200, 20);

            final JFormattedTextField cpfField = new JFormattedTextField(cpfFormatter);
            cpfField.setBounds(120, 80, 200, 20);

            final JFormattedTextField dataField = new JFormattedTextField(dataFormatter);
            dataField.setBounds(120, 110, 200, 20);

            // Criando o frame
            JFrame frame = new JFrame("Cadastro de Dados");
            frame.setSize(400, 300);
            frame.setLayout(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Labels
            JLabel labelCep = new JLabel("CEP:");
            labelCep.setBounds(30, 20, 100, 20);
            frame.add(labelCep);

            JLabel labelTelefone = new JLabel("Telefone:");
            labelTelefone.setBounds(30, 50, 100, 20);
            frame.add(labelTelefone);

            JLabel labelCpf = new JLabel("CPF:");
            labelCpf.setBounds(30, 80, 100, 20);
            frame.add(labelCpf);

            JLabel labelData = new JLabel("Data:");
            labelData.setBounds(30, 110, 100, 20);
            frame.add(labelData);

            // Adicionando os campos
            frame.add(cepField);
            frame.add(telefoneField);
            frame.add(cpfField);
            frame.add(dataField);

            // Botão "Mostrar"
            JButton botaoMostrar = new JButton("Mostrar");
            botaoMostrar.setBounds(80, 160, 100, 30);
            frame.add(botaoMostrar);

            // Botão "Finalizar"
            JButton botaoFinalizar = new JButton("Finalizar");
            botaoFinalizar.setBounds(200, 160, 100, 30);
            frame.add(botaoFinalizar);

            // Ação do botão "Mostrar"
            botaoMostrar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String mensagem = "CEP: " + cepField.getText() +
                            "\nTelefone: " + telefoneField.getText() +
                            "\nCPF: " + cpfField.getText() +
                            "\nData: " + dataField.getText();
                    JOptionPane.showMessageDialog(frame, mensagem);
                }
            });

            // Ação do botão "Finalizar"
            botaoFinalizar.addActionListener(e -> System.exit(0));

            frame.setVisible(true);

        } catch (Exception e) {    // Captura qualquer erro que ocorra dentro do bloco try
            e.printStackTrace();    // e imprime detalhes do erro no console para ajudar no diagnóstico
        }
    }
}
