import javax.swing.JOptionPane;

public class Ex4 {
    public static void main (String[] args) {
        // Definindo os números que vamos usar nas operações (aqui são fixos, mas podem mudar depois)
        int n1 = 2;
        int n2 = 2;
        String opcao;

        do {
            // Mostra o menu de operações pro usuário escolher e pega a opção que o usuário escolheu
            opcao = JOptionPane.showInputDialog(null, "1 – Soma\n" +
                    "2 – Subtração\n" +
                    "3 – Divisão\n" +
                    "4 – Multiplicação\n" +
                    "5 – Resto da Divisão\n" +
                    "6 – Dobro\n" +
                    "7 - Quadrado\n" +
                    "8 – Cubo\n" +
                    "9 – Raiz Quadrada\n" +
                    "0 – Sair\n" +
                    "Digite o valor correspondente a sua escolha: ");

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
                    // Se a opção for inválida, mostra uma mensagem de erro. isso vai servir pra caso seja o usuario que digite os valores
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;
            }
        } while (!opcao.equals ("0")); // Aqui, a gente usa o equals (ele faz comparação de strings) pra comparar o valor de 'opcao' com "0". Se 'opcao' for diferente de "0", o laço vai continuar rodando
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
            double resultado = (double) n1 / n2; // Quando a gente divide dois numeros inteiros, o resultado tambem vai ser inteiro. Então, tipo, 5 / 2 da 2. Mas se a gente quiser que o resultado tenha virgula, ai tem que transformar um dos numeros em double, pra ele poder fazer a conta com casas decimais. Aí, colocando (double), o resultado de 5 / 2 vai ser 2.5
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