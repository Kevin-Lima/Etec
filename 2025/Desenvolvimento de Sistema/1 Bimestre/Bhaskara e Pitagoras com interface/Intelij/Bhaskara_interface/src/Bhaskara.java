/* Este comando importa todas as classes do pacote javax.swing,
   que é usado para criar interfaces gráficas em Java */
import javax.swing.*;

/* Este comando importa todas as classes do pacote java.awt,
   que também é usado para construir interfaces gráficas, permitindo adicionar cor,
   tamanho das fontes, estilo das fontes, etc */
import java.awt.*;

/* Este comando importa todas as classes do pacote java.awt.event, que são usadas para
   capturar eventos, como cliques de botão, teclas, movimentação do mouse, etc */
import java.awt.event.*;


public class Bhaskara extends JFrame {

    Funcionalidade funcionalidade = new Funcionalidade();

    // O JLabel é um rótulo de texto exibido na interface gráfica. Ele não permite entrada de dados, apenas exibe informações para o usuário
    JLabel rotulo1, rotulo2, rotulo3, delta, x1, x2, titulo, erro;

    // O JTextField é uma caixa de texto onde o usuário pode digitar informações, como números ou palavras
    JTextField texto1, texto2, texto3;

    //O JButton representa um botão interativo. Quando o usuário clica nele, alguma ação pode ser executada, como somar dois números
    JButton calcular,sair,limpar;


    // Esse é o metodo construtor, ele serve para criar o objeto e definir os valores iniciais.
    public Bhaskara() {
        // O Container é o "painel invisível" que armazena os elementos visuais dentro da janela
        Container tela = getContentPane();

        // isso significa que agnte vai ter que posicionar cada elemento manualmente: setBounds(x, y, largura, altura);
        setLayout(null);

        titulo = new JLabel("BHASKARA");
        rotulo1 = new JLabel("A: ");
        rotulo2 = new JLabel("B: ");
        rotulo3 = new JLabel("C: ");

        texto1 = new JTextField(5);
        texto2 = new JTextField(5);
        texto3 = new JTextField(5);

        delta = new JLabel ("Delta: ");
        x1 = new JLabel("x1: ");
        x2 = new JLabel("x2: ");

        erro = new JLabel("");

        //cria um botao com o texto e quando clicado vai executar uma ação (que ainda não foi definida)
        calcular = new JButton("Calcular");
        sair = new JButton("Sair");
        limpar = new JButton("Limpar");

        // Essa função define a posiçao e o tamanho de cada componente na tela: componente.setBounds(posiçãoX, posiçãoY, largura, altura);

        titulo.setBounds(90,20,120,25);

        rotulo1.setBounds(50, 65, 30, 25);
        rotulo2.setBounds(50,95,30,25);
        rotulo3.setBounds(50,125,30,25);

        texto1.setBounds(70,67,130,20);
        texto2.setBounds(70,97,130,20);
        texto3.setBounds(70,127,130,20);

        calcular.setBounds(90,180,100,25);
        sair.setBounds(200,240,60,25);
        limpar.setBounds(110,240,80,25);


        delta.setVisible(false);
        x1.setVisible(false);
        x2.setVisible(false);


        tela.setBackground(new Color (240,230,140));
        //aqui a gente ta criando uma Array, e tamo adicionando todos os botoes
        JButton[] botoes = {calcular,sair,limpar};
        //esse for vai passar por todos os botoes e vai executar oq tiver especificado dentro dele
        for(JButton botao : botoes){
            botao.setBackground(new Color(152,251,152));
            botao.setForeground(new Color(0,100,0));
        }

        titulo.setForeground(new Color (0,0,205));

        texto1.setBackground(new Color (152,251,152));
        texto2.setBackground(new Color (152,251,152));
        texto3.setBackground(new Color (152,251,152));

        titulo.setFont(new Font("Arial", Font.PLAIN,19));

        rotulo1.setFont(new Font("Arial", Font.PLAIN, 17));
        rotulo2.setFont(new Font("Arial", Font.PLAIN, 17));
        rotulo3.setFont(new Font("Arial", Font.PLAIN, 17));

        texto1.setFont(new Font("Arial", Font.PLAIN, 15));
        texto2.setFont(new Font("Arial", Font.PLAIN, 15));
        texto3.setFont(new Font("Arial", Font.PLAIN, 15));

        delta.setFont(new Font("Arial", Font.PLAIN, 17));
        x1.setFont(new Font("Arial", Font.PLAIN, 17));
        x2.setFont(new Font("Arial", Font.PLAIN, 17));

        erro.setForeground(Color.RED);

        calcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delta.setVisible(true);
                x1.setVisible(true);
                x2.setVisible(true);

                titulo.setBounds(90,20,120,25);

                rotulo1.setBounds(50, 65, 30, 25);
                rotulo2.setBounds(50,95,30,25);
                rotulo3.setBounds(50,125,30,25);

                texto1.setBounds(70,67,130,20);
                texto2.setBounds(70,97,130,20);
                texto3.setBounds(70,127,130,20);

                delta.setBounds(50,165,150,25);
                x1.setBounds(50,195,150,25);
                x2.setBounds(50,225,150,25);

                calcular.setBounds(90,285,100,25);
                sair.setBounds(200,360,60,25);
                limpar.setBounds(110,360,80,25);

                erro.setBounds(20,310,400,25);

                setSize(300,450);

                try{
                    erro.setVisible(false);

                    //aqui ta pegando a entrada do usuario que é String e ta passando pra double
                    double a = Double.parseDouble(texto1.getText());
                    double b = Double.parseDouble(texto2.getText());
                    double c = Double.parseDouble(texto3.getText());

                    // Se A for 0, ve se é equação do primeiro grau ou invalida
                    if (a == 0) {
                        if (b == 0) {
                            erro.setText("Não é uma equação válida");
                            erro.setVisible(true);
                            //isso serve pra limpar o resultado anterior
                            delta.setText("Delta: -");
                            x1.setText("x1: -");
                            x2.setText("x2: -");
                            return;
                        } else {
                            double raizLinear = -c / b;
                            erro.setText("Equação de 1º grau. Solução única: x = " + String.format("%.2f", raizLinear));
                            erro.setVisible(true);
                            x1.setText("x1: " + String.format("%.2f", raizLinear)); // Mostra a solução em x1
                            x2.setText("x2: -"); // Limpa x2
                            delta.setText("Delta: -"); // Limpa delta
                            return; // Interrompe o cálculo, pois já resolvemos a equação
                        }
                    }

                    double resultadoDelta = funcionalidade.calcularDelta(a,b,c);
                    // o String.format arredonda pra dois numeros dps da virgula
                    delta.setText("Delta: " + String.format("%.2f", resultadoDelta));

                    double[] raizes = funcionalidade.calcularRaizes(a,b,resultadoDelta);

                    if (resultadoDelta >= 0) {
                        // o String.format arredonda pra dois numeros dps da virgula
                        x1.setText("x1: " + String.format("%.2f", raizes[0]));// aqui a gente ta chamando o primeiro valor do metodo de raizes que é uma array
                        x2.setText("x2: " + String.format("%.2f", raizes[1]));
                    } else {
                        x1.setText("x1: Não real");
                        x2.setText("x2: Não real");
                        erro.setText("Delta é negativo, não tem raizes reais.");
                        erro.setVisible(true);
                    }


                }catch (NumberFormatException ex){//NumberFormatException (erro ao converter texto para número). ex é um objeto que tem detalhes sobre o erro
                    // Código a ser executado caso ocorra um erro
                    // Se o usuário digitou algo inválido, mostra um aviso
                    erro.setText("Erro: Digite números válidos!");
                    erro.setVisible(true);
                    //isso serve pra limpar o resultado anterior
                    delta.setText("Delta: -");
                    x1.setText("x1: -");
                    x2.setText("x2: -");

                }


            }
        });
        sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //fecha a execução
                System.exit(0);
            }
        });

        limpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //deixa o texto invisivel
                texto1.setText(null);
                texto2.setText(null);
                texto3.setText(null);
                //o mouse do usario vai voltar pro texto 1
                texto1.requestFocus();
            }
        });

        erro.setVisible(false);

        //toda vez que executar, o frame vai ficar centralizado no centro da tela
        setLocationRelativeTo(null);

        //faz com que o usuario não consiga redimensionar a tela
        setResizable(false);

        tela.add(titulo);
        tela.add(rotulo1);
        tela.add(rotulo2);
        tela.add(rotulo3);
        tela.add(delta);
        tela.add(x1);
        tela.add(x2);
        tela.add(texto1);
        tela.add(texto2);
        tela.add(texto3);
        tela.add(calcular);
        tela.add(erro);
        tela.add(sair);
        tela.add(limpar);

        //definindo o tamanho da tela 400 = largura 250 = altura
        setSize(300,340);

        //tornando a janela visivel
        setVisible(true);
    }

    public static void main(String[] args) {
        Bhaskara bhaskara = new Bhaskara();

        //definindo que ao fechar a janela, o programa será encerrado. Isso evita que o programa continue rodando em segundo plano
        bhaskara.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}