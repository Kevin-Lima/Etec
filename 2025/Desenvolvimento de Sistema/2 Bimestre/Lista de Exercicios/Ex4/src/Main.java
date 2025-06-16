import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    JFormattedTextField texNome, texClasse, textRm;

    public Main() {
        super("Empréstimo de Livro");
        setLayout(null);
        setSize(450, 300);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Título
        JLabel titulo = new JLabel("Empréstimo");
        titulo.setBounds(170, 10, 200, 30);
        titulo.setFont(titulo.getFont().deriveFont(16.0f));
        titulo.setForeground(Color.RED);
        add(titulo); // Adiciona o título à janela

        // ComboBox de livros
        String[] livros = {"Livro1", "Livro2", "Livro3", "Livro4"};
        JComboBox<String> comboLivros = new JComboBox<>(livros);
        comboLivros.setBounds(300, 50, 100, 20);
        add(comboLivros);

        // Nome
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(20, 50, 50, 20);
        add(lblNome);

        texNome = new JFormattedTextField();
        texNome.setBounds(70, 50, 200, 20);
        add(texNome);

        // Classe
        JLabel lblClasse = new JLabel("Classe:");
        lblClasse.setBounds(20, 90, 50, 20);
        add(lblClasse);

        texClasse = new JFormattedTextField();
        texClasse.setBounds(70, 90, 200, 20);
        add(texClasse);

        // RM
        JLabel lblRM = new JLabel("RM:");
        lblRM.setBounds(20, 130, 50, 20);
        add(lblRM);

        textRm = new JFormattedTextField();
        textRm.setBounds(70, 130, 200, 20);
        add(textRm);

        // Botão Emprestar
        JButton btnEmprestar = new JButton("Emprestar");
        btnEmprestar.setBounds(160, 180, 120, 30);
        add(btnEmprestar);

        // Ação do botão
        btnEmprestar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Pega o texto digitado no campo 'texNome' e remove espaços em branco no início e no fim
                String nome = texNome.getText().trim();// trim() - remove espaços extras no começo e no fim da string
                String classe = texClasse.getText().trim();
                String rm = textRm.getText().trim();
                String livro = (String) comboLivros.getSelectedItem();

                // Exibir as informações em um JOptionPane
                JOptionPane.showMessageDialog(null,
                        "Nome: " + nome +
                                "\nClasse: " + classe +
                                "\nRM: " + rm +
                                "\nLivro: " + livro,
                        "Empréstimo Realizado",// Título da janela
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
