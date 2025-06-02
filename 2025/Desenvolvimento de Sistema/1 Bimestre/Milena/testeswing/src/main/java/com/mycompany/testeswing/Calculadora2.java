package com.mycompany.testeswing;

import javax.swing.*; //importa componentes gráficos
import java.awt.*; //importa container e estilos

public class Calculadora2 extends JFrame { //subclasse que cria a janela gráfica
    JTextField display; //declaração do campo que exibe as operações
    JButton[] numeros = new JButton[10]; //declaração dos botões dos números (0 a 9)
    JButton somar, subtrair, dividir, multiplicar, limpar, igual, virgula; //declaração dos botões de operadores
    private double num1, num2, resultado; //variável que armazenas os números digitados e resultado
    private char operador; //variável que armazena o operador selecionado
    private boolean novaEntrada = false; //indica quando começa uma nova operação

    public Calculadora2(String titulo) { //construtor chamado quando criamos uma instância. recebe o título
        super(titulo); //define o título da janela
        Container tela = getContentPane(); //obtém o conteúdo da janela
        setLayout(null); //define o posicionamento absoluto dos componentes

        display = new JTextField(); //cria o campo de texto display
        display.setBounds(50, 20, 280, 30); //posiciona o display
        display.setEditable(false); //impede que seja digitado diretamente
        display.setFont(new Font("Arial", Font.BOLD, 20)); //estilo do texto
        tela.add(display); //adiciona à tela

        int x = 50, y = 100; //declara duas variáveis e as inicializa com valores. são coordenadas iniciais dos botões na tela
        for (int i = 0; i < 10; i++) { //laço "for" itera de 0 a 9
            numeros[i] = new JButton(String.valueOf(i)); //cria um botão para cada iteração e converte o valor para string
            numeros[i].setBounds(x, y, 50, 40); //define a posição
            numeros[i].setFont(new Font("Arial", Font.BOLD, 18)); //define o estilo
            int num = i; //atribui a variável ao valor de i
            numeros[i].addActionListener(e -> { //define o que acontece quando o botão é pressionado
                if (novaEntrada) { //se a nova entrada for verdadeira
                    display.setText(""); //limpa display ao começar nova operação
                    novaEntrada = false; //define a nova entrada como false para que o display não seja limpo novamente
                }
                display.setText(display.getText() + num); //adiciona o número pressionado ao conteúdo atual do display
            });
            tela.add(numeros[i]); //adiciona o número ao display gráfico
            x += 60; //a coordenada x é incrementada em 60 pixels para organização dos botões
            if ((i + 1) % 3 == 0) { //se três botões já estiverem na mesma linha
                x = 50; //reseta a coordenada para 50 pixels
                y += 50; //aumenta a coordenada para 50 pixels
            }
        }

        // Botão de vírgula
        virgula = new JButton(","); //cria o botão
        virgula.setBounds(170, 250, 50, 40); //define a posição
        virgula.setFont(new Font("Arial", Font.BOLD, 18)); //define o estilo
        virgula.addActionListener(e -> { //comportamneto quando pressionado
            String textoAtual = display.getText(); //captura o texto atual
            if (!textoAtual.contains(",")) { //verifica se o texto atual contém alguma vírgula
                display.setText(textoAtual + ","); //adiciona a vírgula
            }
        });
        tela.add(virgula); //adiciona o botão a tela

        //cria os botões
        somar = new JButton("+");
        subtrair = new JButton("-");
        multiplicar = new JButton("*");
        dividir = new JButton("/");
        igual = new JButton("=");
        limpar = new JButton("C");

        JButton[] operacoes = {somar, subtrair, multiplicar, dividir}; //cria o array de botões
        x = 230; y = 100; //posição inicial
        for (JButton botao : operacoes) { //loop que percorre os botões
            botao.setBounds(x, y, 50, 40); //define o tamanho dos botões
            botao.setFont(new Font("Arial", Font.BOLD, 18)); //define o estilo
            botao.addActionListener(e -> { //comportamento quando pressionado
                try {
                    num1 = Double.parseDouble(display.getText().replace(",", ".")); // Converte vírgula para ponto
                    operador = e.getActionCommand().charAt(0); //o operador é obtido e retornado
                    display.setText(display.getText() + " " + operador + " "); //o operador é adicionado na tela 
                    novaEntrada = false; //o display nao deve ser limpo
                } catch (NumberFormatException ex) { //caso ocorra um erro
                    display.setText("Erro"); //imprime "Erro"
                }
            });
            tela.add(botao); //adiciona o botão à tela
            y += 50; //incrementa 50 pixels para descer uma linha
        }

        igual.setBounds(110, 250, 50, 40); //define a posição e tamanho
        igual.setFont(new Font("Arial", Font.BOLD, 18)); //define o estilo
        igual.addActionListener(e -> { //comportamento quando pressionado
            try {
                String[] partes = display.getText().split(" "); //obtém o texto atual e o divide em um array
                if (partes.length < 3) { //se tiver menos de três elementos
                    display.setText("Erro"); //imprime "Erro"
                    return; //interrompe o código
                }
                num1 = Double.parseDouble(partes[0].replace(",", ".")); //converte a primeira parte do array para double e substitui a virgula pelo ponto
                operador = partes[1].charAt(0); //obtém e armazena o operador
                num2 = Double.parseDouble(partes[2].replace(",", ".")); //converte a segunda parte do array para double e substitui a virgula pelo ponto

                switch (operador) { //executa a operação correspondente ao operador
                    case '+': resultado = num1 + num2; break;
                    case '-': resultado = num1 - num2; break;
                    case '*': resultado = num1 * num2; break;
                    case '/': 
                        if (num2 != 0) {
                            resultado = num1 / num2;
                        } else {
                            throw new ArithmeticException("Divisão por zero");
                        }
                        break;
                }
                display.setText(display.getText() + " = " + String.valueOf(resultado).replace(".", ",")); //exibe resultado com vírgula
                novaEntrada = true; //limpa o display
            } catch (NumberFormatException | ArithmeticException ex) { //caso ocorra um erro 
                display.setText("Erro"); //exibe a mensagem
            }
        });
        tela.add(igual); //adiciona o botao à tela

        limpar.setBounds(290, 100, 50, 40); //posição e tamanho do botao "limpar"
        limpar.setFont(new Font("Arial", Font.BOLD, 18)); //define o estilo
        limpar.addActionListener(e -> { //comportamneto quando pressionado
            display.setText(""); //substirui o conteúdo do display por uma string vazia
            novaEntrada = false;
        });
        tela.add(limpar); //adiciona o botão à tela

        setSize(400, 350); //define o tamanho da janela
        setVisible(true); //a torna visivel
    }

    public static void main(String args[]) { //ponto de entrada do programa
        Calculadora2 app = new Calculadora2("Calculadora"); //cria a instância do objeto calculadora e título da janela
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //define o comportamento quando a janela é fechada
    }
}
