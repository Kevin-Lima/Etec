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


public class Pitagoras extends JFrame {

    // O JLabel é um rótulo de texto exibido na interface gráfica. Ele não permite entrada de dados, apenas exibe informações para o usuário
    JLabel rotulo1, rotulo2, resultado, titulo, erro;

    // O JTextField é uma caixa de texto onde o usuário pode digitar informações, como números ou palavras
    JTextField texto1, texto2;

    //O JButton representa um botão interativo. Quando o usuário clica nele, alguma ação pode ser executada, como somar dois números
    JButton calcular,sair,limpar;


    // Esse é o metodo construtor, ele serve para criar o objeto e definir os valores iniciais.
    public Pitagoras() {
        // O Container é o "painel invisível" que armazena os elementos visuais dentro da janela
        Container tela = getContentPane();

        // isso significa que agnte vai ter que posicionar cada elemento manualmente: setBounds(x, y, largura, altura);
        setLayout(null);

        titulo = new JLabel("Teorema de Pitágoras");
        rotulo1 = new JLabel("Cateto 1: ");
        rotulo2 = new JLabel("Cateto 2: ");

        texto1 = new JTextField(5);
        texto2 = new JTextField(5);

        resultado = new JLabel("Hipotenusa:");

        erro = new JLabel("");

        //cria um botao com o texto e quando clicado vai executar uma ação (que ainda não foi definida)
        calcular = new JButton("Calcular");
        sair = new JButton("Sair");
        limpar = new JButton("Limpar");

        // Essa função define a posiçao e o tamanho de cada componente na tela: componente.setBounds(posiçãoX, posiçãoY, largura, altura);

        titulo.setBounds(60,20,200,25);

        rotulo1.setBounds(50, 65, 80, 25);
        rotulo2.setBounds(50,95,80,25);

        texto1.setBounds(120,67,150,20);
        texto2.setBounds(120,97,150,20);

        calcular.setBounds(130,150,100,25);
        sair.setBounds(250,200,60,25);
        limpar.setBounds(160,200,80,25);


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

        titulo.setFont(new Font("Arial", Font.PLAIN,19));

        rotulo1.setFont(new Font("Arial", Font.PLAIN, 17));
        rotulo2.setFont(new Font("Arial", Font.PLAIN, 17));

        texto1.setFont(new Font("Arial", Font.PLAIN, 15));
        texto2.setFont(new Font("Arial", Font.PLAIN, 15));

        resultado.setFont(new Font("Arial", Font.PLAIN, 17));

        erro.setForeground(Color.RED);

        calcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                rotulo1.setBounds(50, 65, 80, 25);
                rotulo2.setBounds(50,95,80,25);

                texto1.setBounds(120,67,150,20);
                texto2.setBounds(120,97,150,20);

                calcular.setBounds(130,200,100,25);
                sair.setBounds(250,280,60,25);
                limpar.setBounds(160,280,80,25);

                resultado.setBounds(50,150,150,25);

                erro.setBounds(20,230,400,25);

                setSize(350,370);

                try {
                    erro.setVisible(false);

                    // Pegando a entrada do usuário
                    double cateto1 = Double.parseDouble(texto1.getText());
                    double cateto2 = Double.parseDouble(texto2.getText());

                    // Verificando se os valores são positivos
                    if (cateto1 <= 0 || cateto2 <= 0) {
                        erro.setText("Erro: Os catetos devem ser positivos!");
                        erro.setVisible(true);
                        resultado.setText("Resultado: -");
                        return;
                    }

                    // Calculando a hipotenusa
                    // 'Math.sqrt' = raiz   'Math.pow' = potencia
                    double hipotenusa = Math.sqrt(Math.pow(cateto1, 2) + Math.pow(cateto2, 2));

                    // Exibindo o resultado
                    // o String.format arredonda pra dois numeros dps da virgula
                    resultado.setText("Hipotenusa: " + String.format("%.2f", hipotenusa));

                } catch (NumberFormatException ex) {
                    // Tratando erro de entrada inválida
                    erro.setText("Erro: Digite números válidos!");
                    erro.setVisible(true);
                    resultado.setText("Resultado: -");
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
        tela.add(texto1);
        tela.add(texto2);
        tela.add(resultado);
        tela.add(calcular);
        tela.add(erro);
        tela.add(sair);
        tela.add(limpar);

        //definindo o tamanho da tela 400 = largura 250 = altura
        setSize(350,300);

        //tornando a janela visivel
        setVisible(true);
    }

    public static void main(String[] args) {
         Pitagoras pitagoras = new Pitagoras();

        //definindo que ao fechar a janela, o programa será encerrado. Isso evita que o programa continue rodando em segundo plano
        pitagoras.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}