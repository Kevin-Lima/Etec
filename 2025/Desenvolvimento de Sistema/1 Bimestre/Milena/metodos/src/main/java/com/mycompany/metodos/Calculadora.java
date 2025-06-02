package com.mycompany.metodos;

//Classe da biblioteca Swing, que permite criar caixas de diálogo por meio de interface gráfica
import javax.swing.JOptionPane;

//Classe publica que contém os métodos para realizar as operações e exibir o menu
public class Calculadora {
     
    //Funções que recebem dois parâmetros e retornam o resultado
    
    // Função para soma
    public static double soma(double a, double b) {
        return a + b;
    }

    // Função para subtração
    public static double subtracao(double a, double b) {
        return a - b;
    }

    // Função para divisão
    public static double divisao(double a, double b) {
        if (b != 0) {
            return a / b;
        } else {
            JOptionPane.showMessageDialog(null, "Erro: Divisão por zero.");
            return Double.NaN;  // Retorna NaN para indicar erro
        }
    }

    // Função para multiplicação
    public static double multiplicacao(double a, double b) {
        return a * b;
    }

    // Função para resto da divisão
    public static double restoDivisao(double a, double b) {
        return a % b;
    }
    
    //Funções que recebem um parâmetro e retornam o resultado
    
    // Função para calcular o dobro
    public static double dobro(double a) {
        return 2 * a;
    }

    // Função para calcular o quadrado
    public static double quadrado(double a) {
        return a * a;
    }

    // Função para calcular o cubo
    public static double cubo(double a) {
        return a * a * a;
    }

    // Função para calcular a raiz quadrada
    public static double raizQuadrada(double a) {
        if (a >= 0) {
            return Math.sqrt(a);
        } else {
            JOptionPane.showMessageDialog(null, "Erro: Número negativo não tem raiz quadrada real.");
            return Double.NaN;  // Retorna NaN para indicar erro
        }
    }

    // Função principal que exibe o menu e chama as funções adequadas
    public static void menu() {
        
        //Variáveis que armazenam os números inseridos pelo usuário e o resultado das operações
        double num1, num2, resultado;
        //Variável booleana para controlar quando o programa deve sair do loop
        boolean sair = false;

        //Loop wue será executado enquanto a variável sair for false
        while (!sair) {
            
            // Exibindo o menu usando JOptionPane
            String escolhaStr = JOptionPane.showInputDialog(
                null,
                "Menu de Operações:\n" +
                "1 - Soma\n" +
                "2 - Subtração\n" +
                "3 - Divisão\n" +
                "4 - Multiplicação\n" +
                "5 - Resto da Divisão\n" +
                "6 - Dobro\n" +
                "7 - Quadrado\n" +
                "8 - Cubo\n" +
                "9 - Raiz Quadrada\n" +
                "0 - Sair\n" +
                "Escolha uma opção:");

            //Se o usuário fechar a caixa de diálogo
            if (escolhaStr == null) {
                break;  
            }

            //Convertendo a escolha (entrada em String) para um Int
            int escolha = Integer.parseInt(escolhaStr);

            // Caso o usuário escolha "Sair"
            if (escolha == 0) {
                sair = true;
                JOptionPane.showMessageDialog(null, "Saindo...");
                break;
            }

            // Se a operação precisar de dois números
            if (escolha >= 1 && escolha <= 5) {
                //Os números são armazenados como String
                String num1Str = JOptionPane.showInputDialog("Digite o primeiro número:");
                String num2Str = JOptionPane.showInputDialog("Digite o segundo número:");
                //Os números são convertidos para double
                num1 = Double.parseDouble(num1Str);
                num2 = Double.parseDouble(num2Str);

                switch (escolha) {
                    case 1:  // Soma
                        resultado = soma(num1, num2);
                        JOptionPane.showMessageDialog(null, "Resultado da soma: " + resultado);
                        break;
                    case 2:  // Subtração
                        resultado = subtracao(num1, num2);
                        JOptionPane.showMessageDialog(null, "Resultado da subtração: " + resultado);
                        break;
                    case 3:  // Divisão
                        resultado = divisao(num1, num2);
                        if (!Double.isNaN(resultado)) {
                            JOptionPane.showMessageDialog(null, "Resultado da divisão: " + resultado);
                        }
                        break;
                    case 4:  // Multiplicação
                        resultado = multiplicacao(num1, num2);
                        JOptionPane.showMessageDialog(null, "Resultado da multiplicação: " + resultado);
                        break;
                    case 5:  // Resto da Divisão
                        resultado = restoDivisao(num1, num2);
                        JOptionPane.showMessageDialog(null, "Resultado do resto da divisão: " + resultado);
                        break;
                }
            }
            // Se a operação for de um único número
            else if (escolha >= 6 && escolha <= 9) {
                String num1Str = JOptionPane.showInputDialog("Digite o número:");
                num1 = Double.parseDouble(num1Str);

                switch (escolha) {
                    case 6:  // Dobro
                        resultado = dobro(num1);
                        JOptionPane.showMessageDialog(null, "Resultado do dobro: " + resultado);
                        break;
                    case 7:  // Quadrado
                        resultado = quadrado(num1);
                        JOptionPane.showMessageDialog(null, "Resultado do quadrado: " + resultado);
                        break;
                    case 8:  // Cubo
                        resultado = cubo(num1);
                        JOptionPane.showMessageDialog(null, "Resultado do cubo: " + resultado);
                        break;
                    case 9:  // Raiz Quadrada
                        resultado = raizQuadrada(num1);
                        if (!Double.isNaN(resultado)) {
                            JOptionPane.showMessageDialog(null, "Resultado da raiz quadrada: " + resultado);
                        }
                        break;
                }
            }
            //Se outrso número fora do intervalo for digitado
            else {
                JOptionPane.showMessageDialog(null, "Opção inválida.");
            }
        }
    }

    //Método de entrada do programa que chama o método menu
    public static void main(String[] args) {
        menu();
    }
}
