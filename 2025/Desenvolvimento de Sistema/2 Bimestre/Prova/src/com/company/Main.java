package com.company;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        final JFrame frame = new JFrame("Formulário com Máscaras e Texto");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(370, 420); // altura ajustada
        frame.setLayout(null);

        try {
            // Campos de texto
            final JTextField nomeEmpresaField = new JTextField();
            final JTextField enderecoField = new JTextField();
            final JTextField municipioField = new JTextField();

            JLabel nomeEmpresaLabel = new JLabel("Nome/Empresa:");
            JLabel enderecoLabel = new JLabel("Endereço:");
            JLabel municipioLabel = new JLabel("Município:");

            nomeEmpresaLabel.setBounds(20, 20, 100, 20);
            nomeEmpresaField.setBounds(130, 20, 200, 20);

            enderecoLabel.setBounds(20, 50, 100, 20);
            enderecoField.setBounds(130, 50, 200, 20);

            municipioLabel.setBounds(20, 80, 100, 20);
            municipioField.setBounds(130, 80, 200, 20);

            // Máscaras
            MaskFormatter cepFormatter = new MaskFormatter("#####-###");
            MaskFormatter telefoneFormatter = new MaskFormatter("(##)####-####");
            MaskFormatter celularFormatter = new MaskFormatter("(##)#####-####");
            MaskFormatter cpfFormatter = new MaskFormatter("###.###.###-##");
            MaskFormatter cnpjFormatter = new MaskFormatter("##.###.###/####-##");

            final JFormattedTextField cepField = new JFormattedTextField(cepFormatter);
            final JFormattedTextField telefoneField = new JFormattedTextField(telefoneFormatter);
            final JFormattedTextField celularField = new JFormattedTextField(celularFormatter);
            final JFormattedTextField cpfField = new JFormattedTextField(cpfFormatter);
            final JFormattedTextField cnpjField = new JFormattedTextField(cnpjFormatter);

            JLabel cepLabel = new JLabel("CEP:");
            JLabel telefoneLabel = new JLabel("Telefone:");
            JLabel celularLabel = new JLabel("Celular:");
            JLabel cpfLabel = new JLabel("CPF:");
            JLabel cnpjLabel = new JLabel("CNPJ:");

            cepLabel.setBounds(20, 110, 100, 20);
            cepField.setBounds(130, 110, 200, 20);

            telefoneLabel.setBounds(20, 140, 100, 20);
            telefoneField.setBounds(130, 140, 200, 20);

            celularLabel.setBounds(20, 170, 100, 20);
            celularField.setBounds(130, 170, 200, 20);

            cpfLabel.setBounds(20, 200, 100, 20);
            cpfField.setBounds(130, 200, 200, 20);

            cnpjLabel.setBounds(20, 230, 100, 20);
            cnpjField.setBounds(130, 230, 200, 20);

            // Gênero
            JLabel generoLabel = new JLabel("Gênero:");
            final JRadioButton masculino = new JRadioButton("M");
            final JRadioButton feminino = new JRadioButton("F");

            ButtonGroup grupoGenero = new ButtonGroup();
            grupoGenero.add(masculino);
            grupoGenero.add(feminino);

            generoLabel.setBounds(20, 260, 100, 20);
            masculino.setBounds(130, 260, 40, 20);
            feminino.setBounds(180, 260, 40, 20);

            // Botão Cadastrar
            JButton cadastrar = new JButton("Cadastrar");
            cadastrar.setBounds(130, 300, 100, 30);

            // Ação do botão
            cadastrar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String generoSelecionado = masculino.isSelected() ? "Masculino" : (feminino.isSelected() ? "Feminino" : "Não selecionado");

                    String mensagem = "Dados cadastrados:\n"
                            + "Nome/Empresa: " + nomeEmpresaField.getText() + "\n"
                            + "Endereço: " + enderecoField.getText() + "\n"
                            + "Município: " + municipioField.getText() + "\n"
                            + "CEP: " + cepField.getText() + "\n"
                            + "Telefone: " + telefoneField.getText() + "\n"
                            + "Celular: " + celularField.getText() + "\n"
                            + "CPF: " + cpfField.getText() + "\n"
                            + "CNPJ: " + cnpjField.getText() + "\n"
                            + "Gênero: " + generoSelecionado;

                    JOptionPane.showMessageDialog(frame, mensagem, "Confirmação", JOptionPane.INFORMATION_MESSAGE);
                }
            });

            // Adicionando ao frame
            frame.add(nomeEmpresaLabel);
            frame.add(nomeEmpresaField);
            frame.add(enderecoLabel);
            frame.add(enderecoField);
            frame.add(municipioLabel);
            frame.add(municipioField);
            frame.add(cepLabel);
            frame.add(cepField);
            frame.add(telefoneLabel);
            frame.add(telefoneField);
            frame.add(celularLabel);
            frame.add(celularField);
            frame.add(cpfLabel);
            frame.add(cpfField);
            frame.add(cnpjLabel);
            frame.add(cnpjField);
            frame.add(generoLabel);
            frame.add(masculino);
            frame.add(feminino);
            frame.add(cadastrar);

            frame.setVisible(true);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
