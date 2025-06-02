package com.mycompany.exercicios_metodos;

import javax.swing.JOptionPane;

public class Ex4 {
    public static void main (String[] args) {
        // Definindo os números que vamos usar nas operações (aqui são fixos, mas podem mudar depois)
        int n1;
        int n2;
        String opcao;

        do {
            // Mostra o menu de operações pro usuário escolher e pega a opção que o usuário escolheu
            opcao = JOptionPane.showInputDialog(null, 
                    "1 – Soma\n" +
                    "2 – Subtração\n" +
                    "3 – Divisão\n" +
                    "4 – Multiplicação\n" +
                    "5 – Resto da Divisão\n" +
                    "6 – Dobro\n" +
                    "7 - Quadrado\n" +
                    "8 – Cubo\n" +
                    "9 – Raiz Quadrada\n" +
                    "0 – Sair\n" +
                    "Escolha uma opção: ");
            
            n1 = 0;
            n2 = 0;
            
            // Verifica se a opção é 9, 8 ou 6
            if(opcao.equals("9") || opcao.equals("8") || opcao.equals("6")) {
                n1 = Integer.parseInt(JOptionPane.showInputDialog("Digite um número: "));
            }else if (!opcao.equals("0")){
                n1 = Integer.parseInt(JOptionPane.showInputDialog("Digite um número: "));
                n2 = Integer.parseInt(JOptionPane.showInputDialog("Digite outro número: "));
            }

            // Aqui, a gente escolhe o que fazer com base na opção do usuário
            switch (opcao) {
                case "1":
                    soma(n1, n2);
                    break;
                case "2":
                    subtracao(n1, n2);
                    break;
                case "3":
                    divisao(n1, n2);
                    break;
                case "4":
                    multiplicacao(n1, n2);
                    break;
                case "5":
                    restoDivisao(n1, n2);
                    break;
                case "6":
                    dobro(n1);
                    break;
                case "7":
                    quadrado(n1);
                    break;
                case "8":
                    cubo(n1);
                    break;
                case "9":
                    raiz(n1);
                    break;
                case "0":
                    // Se escolher 0, sai do programa
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    System.exit(0);
                    break;
                default:
                    // Se a opção for inválida, mostra uma mensagem de erro
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;
            }
        } while (!opcao.equals("0")); // Continua rodando até o usuário digitar "0"
    }

    public static void soma(int n1, int n2) {
        int s = n1 + n2;
        JOptionPane.showMessageDialog(null, "A soma de " + n1 + " e " + n2 + " é igual a: " + s);
    }

    public static void subtracao(int n1, int n2) {
        int s = n1 - n2;
        JOptionPane.showMessageDialog(null, "A subtração de " + n1 + " e " + n2 + " é igual a: " + s);
    }

    public static void divisao(int n1, int n2) {
        if (n2 != 0) {
            double resultado = (double) n1 / n2;
            JOptionPane.showMessageDialog(null, "A divisão de " + n1 + " por " + n2 + " é igual a: " + resultado);
        } else {
            JOptionPane.showMessageDialog(null, "Não é possível dividir por zero.");
        }
    }

    public static void multiplicacao(int n1, int n2) {
        int resultado = n1 * n2;
        JOptionPane.showMessageDialog(null, "A multiplicação de " + n1 + " e " + n2 + " é igual a: " + resultado);
    }

    public static void restoDivisao(int n1, int n2) {
        int resultado = n1 % n2;
        JOptionPane.showMessageDialog(null, "O resto da divisão de " + n1 + " por " + n2 + " é: " + resultado);
    }

    public static void dobro(int n1) {
        int resultado = n1 * 2;
        JOptionPane.showMessageDialog(null, "O dobro de " + n1 + " é: " + resultado);
    }

    public static void quadrado(int n1) {
        int resultado = n1 * n1;
        JOptionPane.showMessageDialog(null, "O quadrado de " + n1 + " é: " + resultado);
    }

    public static void cubo(int n1) {
        double resultado = Math.pow(n1,3);
        JOptionPane.showMessageDialog(null, "O cubo de " + n1 + " é: " + resultado);
    }

    public static void raiz(int n1) {
        double resultado = Math.sqrt(n1);
        JOptionPane.showMessageDialog(null, "A raiz quadrada de " + n1 + " é: " + resultado);
    }
}
