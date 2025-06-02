/* Este comando importa todas as classes do pacote javax.swing,
   que é usado para criar interfaces gráficas em Java */
import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

/* Este comando importa todas as classes do pacote java.awt,
   que também é usado para construir interfaces gráficas, permitindo adicionar cor,
   tamanho das fontes, estilo das fontes, etc */
import java.awt.*;

/* Este comando importa todas as classes do pacote java.awt.event, que são usadas para
   capturar eventos, como cliques de botão, teclas, movimentação do mouse, etc */
import java.awt.event.*;

//importa os estilos de bordar
import javax.swing.border.*;

public class Calculadora extends JFrame {
    // O JLabel é um rótulo de texto exibido na interface gráfica. Ele não permite entrada de dados, apenas exibe informações para o usuário
    JLabel rotulo1, rotulo2,exibir;

    // O JTextField é uma caixa de texto onde o usuário pode digitar informações, como números ou palavras
    JTextField texto1, texto2;

    //O JButton representa um botão interativo. Quando o usuário clica nele, alguma ação pode ser executada, como somar dois números
    JButton somar, subtrair, multiplicar, dividir, restoDivisao, dobro, quadrado, cubo,  raizQuadrada,  porcentagem, sair, limpar, ocultar;

    // Essa variável é tipo um "interruptor" que diz se o layout newLayout tá ligado ou não
    // - Quando tá `true`: O newLayout tá ativo, e aí o `rotulo2` fica escondido
    // - Quando tá `false`: O layout normal tá rolando, e tudo fica visível
    // Ela é importante pro botao "Ocultar" saber se ele pode mexer só no `rotulo1`
    // ou se precisa mexer em tudo. Basicamente, ela evita que o botao faça bagunça no layout
    private boolean isNewLayoutActive = false;

    public Calculadora () {
        super("Calculadora");

        // O Container é o "painel invisível" que armazena os elementos visuais dentro da janela
        Container tela = getContentPane();

        // isso significa que agnte vai ter que posicionar cada elemento manualmente: setBounds(x, y, largura, altura);
        setLayout(null);

        rotulo1 = new JLabel("1 Numero: ");
        rotulo2 = new JLabel("2 Numero: ");

        // Criando campos de texto para entrada de dados, com largura para 5 caracteres, ou seja, passou de 5 o usuario não vai mais conseguir ver
        texto1 = new JTextField(5);
        texto2 = new JTextField(5);

        //Cria um JLabel vazio (""), que vai ser usado para mostrar o resultado depois
        exibir = new JLabel ("");

        //cria um botao com o texto e quando clicado vai executar uma ação (que ainda não foi definida)
        somar = new JButton("Somar");
        subtrair = new JButton("Subtrair");
        multiplicar = new JButton("Multiplicar");
        dividir = new JButton("Dividir");
        restoDivisao = new JButton("Resto da Divisão");
        dobro = new JButton("Dobro");
        quadrado = new JButton("Quadrado");
        cubo = new JButton("Cubo");
        raizQuadrada = new JButton("Raiz Quadrada");
        porcentagem = new JButton("Porecentagem");

        sair = new JButton("Sair");
        limpar = new JButton("Limpar");
        ocultar = new JButton("Ocultar");

// Essa função define a posiçao e o tamanho de cada componente na tela: componente.setBounds(posiçãoX, posiçãoY, largura, altura);


        rotulo1.setBounds(50, 20, 100, 25);
        rotulo2.setBounds(50, 60, 100, 25);


        texto1.setBounds(140, 20, 600, 25);
        texto2.setBounds(140, 60, 600, 25);


        exibir.setBounds(50, 200, 500, 20);

        somar.setBounds(50, 100, 130, 25);
        subtrair.setBounds(190, 100, 130, 25);
        multiplicar.setBounds(330, 100, 130, 25);
        dividir.setBounds(470, 100, 130, 25);
        restoDivisao.setBounds(610, 100, 130, 25);

        porcentagem.setBounds(50, 150, 130, 25);
        dobro.setBounds(190, 150, 130, 25);
        quadrado.setBounds(330, 150, 130, 25);
        cubo.setBounds(470, 150, 130, 25);
        raizQuadrada.setBounds(610, 150, 130, 25);

        sair.setBounds(330,250,130,25);
        limpar.setBounds(470,250,130,25);
        ocultar.setBounds(190,250,130,25);


        //Aumentando o tamanho do texto
        rotulo1.setFont(new Font("Arial", Font.PLAIN, 16));
        rotulo2.setFont(new Font("Arial", Font.PLAIN, 16));

        texto1.setFont(new Font("Arial", Font.PLAIN, 15));
        texto2.setFont(new Font("Arial", Font.PLAIN, 15));

        exibir.setFont(new Font("Arial", Font.BOLD, 15));
        //exibir.setForeground(new Color(0,206,209));

        sair.setFont(new Font("Arial", Font.BOLD, 16));
        sair.setForeground(Color.RED);

        tela.setBackground(new Color(240,248,255));

        //aqui a gente ta criando uma Array, e tamo adicionando todos os botoes
        JButton[] botoes = {somar, subtrair, multiplicar, dividir, restoDivisao, dobro, quadrado, cubo,  raizQuadrada,  porcentagem, sair, limpar, ocultar};
        //esse for vai passar por todos os botoes e vai executar oq tiver especificado dentro dele
        for(JButton botao : botoes){
            botao.setBackground(new Color(176,196,222));
            botao.setForeground(new Color(65,105,225));
        }


        //adicionando um ouvinte (listener) para o botão somar. O addActionListener é usado para definir uma ação (evento) que será executada quando o usuário clicar no botão somar
        ActionListener operacao = new ActionListener() {
                /*está criando uma instância anônima(basicamente esse metodo so vai funcionar dentro desse codigo, com as mesmas caracteristicas que eu coloquei. entao ele existe so
                na classe Calculadora) de um ActionListener, ou seja, uma implementação direta de como o botão vai agir quando clicado. Criar uma instância anônima do ActionListener
                é uma forma prática de implementar eventos sem a necessidade de criar uma classe separada.*/
            //new ActionListener()

            // ele basicamente ta reescrevendo um metodo. Se tiver algum erro, o @Override ajuda a apontar onde ta
            @Override

            // esse metodo é chamado automaticamente quando um botão é clicado. o "ActionEvent e" tem informações sobre o evento que ocorreu, como qual botão foi clicado e qual comando está ligado a ele
            public void actionPerformed(ActionEvent e) {// Ele guarda informações sobre um evento (como um clique em um botão), permitindo identificar qual botão foi clicado e executar a função correspondente

                //O bloco try-catch é usado para capturar e tratar erros (exceções). Isso não deixa que o programa pare de funcionar de forma inesperada caso ocorra um problema
                try {
                    // Código que pode gerar um erro


                    //aqui ta pegando a entrada do usuario que é String e ta passando pra double
                    double numero1 = Double.parseDouble(texto1.getText());
                    double numero2 = Double.parseDouble(texto2.getText());

                    double resultado = 0;
                    String operacao = "";

                    //esse "e.getSource()" vai no OBJETO somar e verifica se ele foi acionado
                    if (e.getSource() == somar) {
                        resultado = numero1 + numero2;
                        operacao = "A Soma é: ";
                    }
                    else if (e.getSource() == subtrair) {
                        resultado = numero1 - numero2;
                        operacao = "A Subtração é: ";
                    }
                    else if (e.getSource() == multiplicar) {
                        resultado = numero1 * numero2;
                        operacao = "A Multiplicação é: ";
                    }
                    else if (e.getSource() == dividir) {
                        if (numero2 == 0) {
                            exibir.setText("Erro: Divisão por zero!");
                            exibir.setVisible(true);
                            return;//ele ja retorna o valor pra que caso o if seja verdadeiro a conta não continua
                        }
                        resultado = numero1 / numero2;
                        operacao = "A Divisão é: ";
                    }
                    else if (e.getSource() == restoDivisao) {
                        if (numero2 == 0) {
                            exibir.setText("Erro: Divisão por zero!");
                            exibir.setVisible(true);
                            return;
                        }
                        resultado = numero1 % numero2;
                        operacao = "O Resto da Divisão é: ";
                    }
                    else if (e.getSource() == dobro) {
                        resultado = numero1 * 2;
                        operacao = "O Dobro é: ";
                    }
                    else if (e.getSource() == quadrado) {
                        resultado = Math.pow(numero1, 2);
                        operacao = "O Quadrado é: ";
                    }
                    else if (e.getSource() == cubo) {
                        resultado = Math.pow(numero1, 3);
                        operacao = "O Cubo é: ";
                    }
                    else if(e.getSource() == raizQuadrada){
                        if(numero1 < 0){
                            exibir.setText("Erro: Raiz de número negativo!");
                            exibir.setVisible(true);
                            return;
                        }
                        resultado = Math.sqrt(numero1);
                        operacao = "A Raiz Quadrada é: ";
                    }
                    else if (e.getSource() == porcentagem) {
                        // Verifica se o primeiro numero (total) não é zero para evitar divisão por zero
                        if (numero1 == 0) {
                            exibir.setText("Erro: Total não pode ser zero!");
                            exibir.setVisible(true);
                            return;
                        }
                        resultado = (numero1 * numero2) / 100;
                        operacao = numero2 + "% de " + numero1 + " é: ";
                    }



                    //exibindo o resultado da soma
                    exibir.setText(operacao + resultado);
                } catch (NumberFormatException ex) {//NumberFormatException (erro ao converter texto para número). ex é um objeto que tem detalhes sobre o erro
                    // Código a ser executado caso ocorra um erro
                    // Se o usuário digitou algo inválido, mostra um aviso
                    exibir.setText("Erro: Digite números válidos!");
                }
                //esta deixando o exibir visivel
                exibir.setVisible(true);
            }
        };

        // Associando o ActionListener aos botões
        somar.addActionListener(operacao);
        subtrair.addActionListener(operacao);
        multiplicar.addActionListener(operacao);
        dividir.addActionListener(operacao);
        restoDivisao.addActionListener(operacao);
        porcentagem.addActionListener(operacao);
        dobro.addActionListener(operacao);
        quadrado.addActionListener(operacao);
        cubo.addActionListener(operacao);
        raizQuadrada.addActionListener(operacao);



// Aqui agente está adicionando um outro metodo para os botões que só precisam de um número pra realizar o cálculo.
// Quando o usuário clicar em um botão, a conta vai ser feita e tudo que tiver dentro desse metodo também vai ser executado.
        ActionListener newLayout = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Liga o "interruptor" do newLayout, basicamento qaundo apertar o ocultar vai ocultar e desocultar apenas o rotulo1
                isNewLayoutActive = true;

                // Como na raiz quadrada agente só usa 1 número, os campos do segundo número eu vou tirar temporariamente
                texto2.setVisible(false);
                rotulo2.setVisible(false);

                //o setText e pra alterar o texto ja existente
                rotulo1.setText("1 Numero: ");

                // Ajustando as posições dos outros elementos e redimensionar a janela

                texto1.setBounds(140, 20, 460, 25);

                // Botões de operações básicas (soma, subtração, multiplicação, divisão)
                somar.setBounds(50, 60, 130, 25);
                subtrair.setBounds(190, 60, 130, 25);
                multiplicar.setBounds(330, 60, 130, 25);
                dividir.setBounds(470, 60, 130, 25);

                restoDivisao.setBounds(50, 100, 130, 25);
                porcentagem.setBounds(190, 100, 130, 25);
                dobro.setBounds(330, 100, 130, 25);
                quadrado.setBounds(470, 100, 130, 25);

                // Botão Resto da Divisão
                cubo.setBounds(50, 140, 130, 25); // Resto da Divisão
                raizQuadrada.setBounds(190, 140, 130, 25);

                // Campo de exibição do resultado
                exibir.setBounds(50, 180, 480, 25); // Ajusta a posição do resultado

                ocultar.setBounds(120,230,130,25);
                sair.setBounds(260,230,130,25);
                limpar.setBounds(400,230,130,25);


                // Redimensionar a janela para acomodar todos os componentes
                setSize(650, 330);

            }
        };

        //adicionando funcionalidades exclusivas pro botao porcentagem
        porcentagem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isNewLayoutActive = false;
                // Restaurar visibilidade e posição dos elementos
                texto2.setVisible(true);
                rotulo2.setVisible(true);
                texto1.setVisible(true);
                rotulo1.setVisible(true);

                //o setText e pra alterar o texto ja existente
                rotulo1.setText("1 Numero - total: ");
                rotulo2.setText("2 Numero - porcentagem: ");

                rotulo1.setBounds(50, 20, 200, 25);
                rotulo2.setBounds(50, 60, 200, 25);


                texto1.setBounds(170, 20, 570, 25);
                texto2.setBounds(230, 60, 510, 25);


                exibir.setBounds(50, 200, 500, 20);

                somar.setBounds(50, 100, 130, 25);
                subtrair.setBounds(190, 100, 130, 25);
                multiplicar.setBounds(330, 100, 130, 25);
                dividir.setBounds(470, 100, 130, 25);
                restoDivisao.setBounds(610, 100, 130, 25);

                porcentagem.setBounds(50, 150, 130, 25);
                dobro.setBounds(190, 150, 130, 25);
                quadrado.setBounds(330, 150, 130, 25);
                cubo.setBounds(470, 150, 130, 25);
                raizQuadrada.setBounds(610, 150, 130, 25);

                sair.setBounds(330,250,130,25);
                limpar.setBounds(470,250,130,25);
                ocultar.setBounds(190,250,130,25);

                // Redimensionar a janela
                setSize(810, 350);
            }
        });

        //vai fazer a restauração do Layout quando algum botao que seja ligado a esse metodo for acionado
        ActionListener resetLayout = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                isNewLayoutActive = false;
                // Restaurar visibilidade e posição dos elementos
                texto2.setVisible(true);
                rotulo2.setVisible(true);
                texto1.setVisible(true);
                rotulo1.setVisible(true);

                //o setText e pra alterar o texto ja existente
                rotulo1.setText("1 Numero: ");
                rotulo2.setText("2 Numero: ");

                rotulo1.setBounds(50, 20, 100, 25);
                rotulo2.setBounds(50, 60, 100, 25);

                texto1.setBounds(140, 20, 600, 25);
                texto2.setBounds(140, 60, 600, 25);

                exibir.setBounds(50, 200, 500, 20);

                somar.setBounds(50, 100, 130, 25);
                subtrair.setBounds(190, 100, 130, 25);
                multiplicar.setBounds(330, 100, 130, 25);
                dividir.setBounds(470, 100, 130, 25);
                restoDivisao.setBounds(610, 100, 130, 25);

                porcentagem.setBounds(50, 150, 130, 25);
                dobro.setBounds(190, 150, 130, 25);
                quadrado.setBounds(330, 150, 130, 25);
                cubo.setBounds(470, 150, 130, 25);
                raizQuadrada.setBounds(610, 150, 130,25);

                sair.setBounds(330,250,130,25);
                limpar.setBounds(470,250,130,25);
                ocultar.setBounds(190,250,130,25);

                // Redimensionar a janela
                setSize(810, 350);
            }
        };

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

        ocultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isNewLayoutActive) {
                    // Se o newLayout estiver ativo, só alterna a visibilidade do rotulo1
                    rotulo1.setVisible(!rotulo1.isVisible());
                } else {
                    // Caso contrário, alterna a visibilidade dos rótulos
                    rotulo1.setVisible(!rotulo1.isVisible());
                    rotulo2.setVisible(!rotulo2.isVisible());
                }
            }
        });


        //como esse botoes precisam de dois numeros, entao o Layout volta ao normal
        dobro.addActionListener(newLayout);
        quadrado.addActionListener(newLayout);
        cubo.addActionListener(newLayout);
        raizQuadrada.addActionListener(newLayout);

        //como esse botoes precisam de dois numeros, entao o Layout volta ao normal
        somar.addActionListener(resetLayout);
        subtrair.addActionListener(resetLayout);
        multiplicar.addActionListener(resetLayout);
        dividir.addActionListener(resetLayout);
        restoDivisao.addActionListener(resetLayout);

        //Esta linha torna o exibir invisível quando a janela é aberta. Isso impede que uma mensagem indesejada apareça antes do usuário interagir
        exibir.setVisible(false);

        //aqui agente so esta adicionando as coisas no container
        tela.add(rotulo1);
        tela.add(rotulo2);

        tela.add(texto1);
        tela.add(texto2);

        tela.add(exibir);
        tela.add(somar);
        tela.add(subtrair);
        tela.add(multiplicar);
        tela.add(dividir);
        tela.add(restoDivisao);
        tela.add(dobro);
        tela.add(quadrado);
        tela.add(cubo);
        tela.add(raizQuadrada);
        tela.add(porcentagem);

        tela.add(sair);
        tela.add(limpar);
        tela.add(ocultar);;

        //definindo o tamanho da tela 400 = largura 250 = altura
        setSize(810,350);

        //toda vez que executar, o frame vai ficar centralizado no centro da tela
        setLocationRelativeTo(null);

        //faz com que o usuario não consiga redimensionar a tela
        setResizable(false);

        //tornando a janela visivel
        setVisible(true);
    }

    public static void main(String[] args) {
        //agente esta instanciando a classe ddcalculaadora pra que agente possa usar os elementos dela no metodo main
        Calculadora calculadora = new Calculadora();

        //definindo que ao fechar a janela, o programa será encerrado. Isso evita que o programa continue rodando em segundo plano
        calculadora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}