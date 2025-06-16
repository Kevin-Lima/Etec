import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Filmes");
        frame.setSize(300, 300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Título
        JLabel titulo = new JLabel("Seleção de Filmes");
        titulo.setBounds(70, 10, 200, 30);
        // Altera o tamanho da fonte do título para 18 pontos, mantendo o estilo atual (negrito, itálico, etc.)
        titulo.setFont(titulo.getFont().deriveFont(18.0f));
        frame.add(titulo);


        // Checkboxes
        // Cria uma caixa de seleção com o rótulo "Ação"
        // O usuário pode marcar ou desmarcar essa opção
        JCheckBox acao = new JCheckBox("Ação");
        JCheckBox comedia = new JCheckBox("Comédia");
        JCheckBox comRomantica = new JCheckBox("Comédia Romântica");
        JCheckBox ficcao = new JCheckBox("Ficção");
        JCheckBox romance = new JCheckBox("Romance");
        JCheckBox suspense = new JCheckBox("Suspense");
        JCheckBox terror = new JCheckBox("Terror");

        acao.setBounds(30, 50, 200, 20);
        comedia.setBounds(30, 70, 200, 20);
        comRomantica.setBounds(30, 90, 200, 20);
        ficcao.setBounds(30, 110, 200, 20);
        romance.setBounds(30, 130, 200, 20);
        suspense.setBounds(30, 150, 200, 20);
        terror.setBounds(30, 170, 200, 20);

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(acao);
        grupo.add(comedia);
        grupo.add(comRomantica);
        grupo.add(ficcao);
        grupo.add(romance);
        grupo.add(suspense);
        grupo.add(terror);


        // Adiciona ao frame
        frame.add(acao);
        frame.add(comedia);
        frame.add(comRomantica);
        frame.add(ficcao);
        frame.add(romance);
        frame.add(suspense);
        frame.add(terror);

        // Botões
        JButton ok = new JButton("OK");
        ok.setBounds(50, 210, 80, 30);
        JButton cancelar = new JButton("Cancelar");
        cancelar.setBounds(150, 210, 100, 30);


        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(acao.isSelected()){
                    // Mostra a imagem "ação.png" dentro da pasta src/img
                    ImageIcon imagem = new ImageIcon(Main.class.getResource("/img/ação.png"));
                    JOptionPane.showMessageDialog(null, "", "",
                            JOptionPane.INFORMATION_MESSAGE, imagem);
                } else if (comedia.isSelected()) {
                    ImageIcon imagem = new ImageIcon(Main.class.getResource("/img/comedia.png"));
                    JOptionPane.showMessageDialog(null, "", "",
                            JOptionPane.INFORMATION_MESSAGE, imagem);
                }else if (comRomantica.isSelected()) {
                    ImageIcon imagem = new ImageIcon(Main.class.getResource("/img/comedia romantica.png"));
                    JOptionPane.showMessageDialog(null, "", "",
                            JOptionPane.INFORMATION_MESSAGE, imagem);
                }else if (ficcao.isSelected()) {
                    ImageIcon imagem = new ImageIcon(Main.class.getResource("/img/ficção.png"));
                    JOptionPane.showMessageDialog(null, "", "",
                            JOptionPane.INFORMATION_MESSAGE, imagem);
                }else if (romance.isSelected()) {
                    ImageIcon imagem = new ImageIcon(Main.class.getResource("/img/romance.png"));
                    JOptionPane.showMessageDialog(null, "", "",
                            JOptionPane.INFORMATION_MESSAGE, imagem);
                }else if (suspense.isSelected()) {
                    ImageIcon imagem = new ImageIcon(Main.class.getResource("/img/suspense.png"));
                    JOptionPane.showMessageDialog(null, "", "",
                            JOptionPane.INFORMATION_MESSAGE, imagem);
                }else if (terror.isSelected()) {
                    ImageIcon imagem = new ImageIcon(Main.class.getResource("/img/terror.png"));
                    JOptionPane.showMessageDialog(null, "", "",
                            JOptionPane.INFORMATION_MESSAGE, imagem);
                }
            }
        });

        cancelar.addActionListener(e -> System.exit(0));

        frame.add(ok);
        frame.add(cancelar);


        frame.setVisible(true);
    }
}