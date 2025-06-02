package com.mycompany.testepessoa;

import javax.swing.JOptionPane;

public class TestePessoa {
    public static void main(String[] args) {

        Aluno aluno = new Aluno();
        
        aluno.nome = JOptionPane.showInputDialog("Digite o nome do aluno:");
        aluno.idade = JOptionPane.showInputDialog("Digite a idade do aluno:");
        aluno.curso = JOptionPane.showInputDialog("Digite o curso do aluno:");


        JOptionPane.showMessageDialog(null, "Aluno:\nNome: " + aluno.nome + "\nIdade: " + aluno.idade + "\nCurso: " + aluno.curso);

        Professor professor = new Professor();
        
        professor.nome = JOptionPane.showInputDialog("Digite o nome do professor:");
        professor.idade = JOptionPane.showInputDialog("Digite a idade do professor:");
        professor.formacao = JOptionPane.showInputDialog("Digite a formação do professor:");

        JOptionPane.showMessageDialog(null, "Professor:\nNome: " + professor.nome + "\nIdade: " + professor.idade + "\nFormação: " + professor.formacao);
    }
}
