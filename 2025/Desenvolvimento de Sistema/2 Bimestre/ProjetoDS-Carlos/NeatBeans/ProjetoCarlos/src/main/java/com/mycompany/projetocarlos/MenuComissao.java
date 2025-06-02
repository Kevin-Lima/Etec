package com.mycompany.projetocarlos;

// Importa bibliotecas para interface gráfica
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.geom.RoundRectangle2D;

// Classe que representa a janela principal, herdando de JFrame
public class MenuComissao extends JFrame {

    
 
    
    // Declaração de uma lista que vai guardar todos os objetos do tipo Vendedor cadastrados
    // A interface List permite armazenar vários elementos em ordem, e o tipo genérico <Vendedor>
    // indica que só objetos (nome e salario) da classe Vendedor podem ser adicionados a essa lista
    private List<Vendedor> vendedores;

    // Variável usada para gerar um número único (ID) para cada novo vendedor
    // Isso ajuda a identificar cada vendedor de forma exclusiva
    private int nextId;

    // Construtor da classe Telinha
    public MenuComissao() {
        // Aqui, estamos inicializando a lista com uma implementação chamada ArrayList
        // O ArrayList é uma estrutura que guarda os dados em ordem e permite acessar,
        // adicionar ou remover elementos de forma eficiente
        vendedores = new ArrayList<>();

        // A variável nextId começa em 1. Sempre que um novo vendedor for cadastrado,
        // ele vai receber esse valor de ID, e depois o número será incrementado
        nextId = 1;
    }

    public void exibirMenuPrincipal(){
        // Cria a janela principal
        JFrame tela = new JFrame("Controle de Comissão de Vendedores");
        // Configura o que acontece quando clica no X para fechar
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Define o tamanho da janela
        tela.setSize(600, 400);
        tela.setLocationRelativeTo(null);       // Centraliza na tela
        tela.setVisible(true);                  // Torna visível
       
        // Aqui a gente define como os componentes vão se organizar na janela
        // O BorderLayout divide a tela em 5 pedaços:
        // - Norte (topo)
        // - Sul (embaixo)
        // - Leste (direita)
        // - Oeste (esquerda)
        // - Centro (meio - que estica pra preencher o espaço)
        tela.setLayout(new BorderLayout());

        // Cria o cabeçalho (parte de cima da janela)
        //O JPanel é um container flexível que ajuda a organizar os componentes na interface gráfica
        JPanel headerPanel = criarHeader(); // Cria um painel pro cabeçalho
        tela.add(headerPanel, BorderLayout.NORTH);

        // Cria o painel com os botões do menu
        JPanel menuPanel = criarPainelMenu();
        tela.add(menuPanel, BorderLayout.CENTER);

        // Cria o rodapé (parte de baixo da janela)
        JPanel footerPanel = criarFooter();
        tela.add(footerPanel, BorderLayout.SOUTH);

        // Torna a janela visível
        tela.setVisible(true);
    }

    //esse metodo só pode ser usado dentro desta mesma classe
 private JPanel criarHeader() {
    // Cria o painel com layout para centralizar
    JPanel panel = new JPanel(new GridBagLayout());
    panel.setBackground(new Color(255, 183, 130));
    panel.setPreferredSize(new Dimension(600, 80));

    // Cria os elementos
    JLabel titleLabel = new JLabel("Sistema de Controle de Comissão");
    titleLabel.setForeground(Color.WHITE);
    titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

    // Carrega e redimensiona a imagem
    ImageIcon iconOriginal = new ImageIcon("src/main/java/com/mycompany/projetocarlos/imagens/vendedor_transparente_laranja.png");
    Image imagemRedimensionada = iconOriginal.getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH);
    ImageIcon iconRedimensionado = new ImageIcon(imagemRedimensionada);
    JLabel iconLabel = new JLabel(iconRedimensionado);

    // Configurações de layout
    GridBagConstraints gbc = new GridBagConstraints();

    // Adiciona a imagem à esquerda
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.insets = new Insets(0, -40, 0, 10); // margem para a direita da imagem
    panel.add(iconLabel, gbc);

    // Adiciona o texto à direita da imagem
    gbc.gridx = 1;
    gbc.gridy = 0;
    gbc.insets = new Insets(0, 0, 0, 0); // texto um pouco mais para cima
    panel.add(titleLabel, gbc);

    return panel;
}


    private JPanel criarPainelMenu() {
        // Cria um painel vazio (como uma caixa vazia)
        JPanel panel = new JPanel();

        // Organiza os itens em 4 linhas e 1 coluna, com 10px de espaço entre eles
        // Tipo uma tabela com 4 linhas empilhadas
        panel.setLayout(new GridLayout(4, 1, 10, 10));// GridLayout(linhas, colunas, espaçamentoHorizontal, espaçamentoVertical)
        
        // Coloca uma margem de 20px dentro do painel (espaço da borda até os botões)
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));// BorderFactory.createEmptyBorder(top, left, bottom, right)

        // Cria os botões estilizados usando um metodo que já faz o estilo, o metodo é o 'criarBotao'
        JButton criarVendedorB = criarBotao("1 - Criar Vendedor");
        JButton calcularComissaoB = criarBotao("2 - Calcular Comissão");
        JButton exibirVendedorB = criarBotao("3 - Exibir Vendedor");
        JButton sairB = criarBotao("0 - Sair");

        // Configura o que acontece quando clica em cada botão:
        // Botão 1 - Chama o metodo que cria vendedor
        criarVendedorB.addActionListener(e -> criarVendedor());
        // Botão 2 - Chama o metodo que calcula comissão
        calcularComissaoB.addActionListener(e -> calcularComissao());
        // Botão 3 - Chama o metodo que mostra info do vendedor
        exibirVendedorB.addActionListener(e -> exibirVendedor());
        // Botão 0 - Fecha o programa (System.exit é como apertar o X da janela)
        sairB.addActionListener(e -> System.exit(0));

        // Coloca os botões no painel, na ordem:
        // (como definimos GridLayout(4,1), cada add vai pra próxima linha)
        panel.add(criarVendedorB);      // Linha 1
        panel.add(calcularComissaoB);   // Linha 2
        panel.add(exibirVendedorB);     // Linha 3
        panel.add(sairB);               // Linha 4

        return panel;
    }

    private JPanel criarFooter() {
        JPanel panel = new JPanel();

        // Adiciona margem interna de 10 pixels
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        // Mostra a data atual no rodapé
        JLabel dateLabel = new JLabel(EntradaSaidaDados.obterDataAtual());
        panel.add(dateLabel);
        return panel;
    }

    public class RoundedButton extends JButton {
    private int borderRadius;

    public RoundedButton(String text, int borderRadius) {
        super(text);
        this.borderRadius = borderRadius;
        setContentAreaFilled(false); // Para não preencher a área padrão
        setFocusPainted(false); // Para não mostrar a borda de foco
        setBorderPainted(false); // Para não mostrar a borda padrão
        setForeground(Color.WHITE); // Cor do texto
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), borderRadius, borderRadius));
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Se você quiser adicionar uma borda, pode desenhar aqui
        // g.setColor(Color.BLACK);
        // g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, borderRadius, borderRadius);
    }
}
    
    //criando um metodo pra decorar os botoes
  private RoundedButton criarBotao(String texto) {
    // Cria um botão arredondado com o texto que veio no parâmetro
    RoundedButton button = new RoundedButton(texto, 20); // 20 é o raio da borda

        // Ajusta a letra do botão:
        // - Fonte Arial
        // - Estilo normal (sem negrito/itálico)
        // - Tamanho 16
        button.setFont(new Font("Arial", Font.PLAIN, 16));

        // Pinta o fundo do botão de azul (RGB: 70 vermelho, 130 verde, 180 azul)
        button.setBackground(new Color(230, 126, 99));

        // Coloca o texto do botão na cor branca
        button.setForeground(Color.WHITE);

        // Tira aquela borda feia que aparece quando o botão ta selecionado
        button.setFocusPainted(false);

        // Coloca um espaçamento interno de 10 pixels em todos os lados
        // (topo, esquerda, baixo, direita) pra não ficar colado nas bordas
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Retorna o botao configurado
        return button;
    }


    //metodo para cadastrar um novo vendedor
    private void criarVendedor(){
        // Pede o nome do vendedor
        //'EntradaSaidaDados' é a classe e 'entradaString' é o metodo
        String nome = EntradaSaidaDados.entradaString("Digite o nome do vendedor:");
        if (nome == null) return; // Se o usuário cancelar, não faz nada

        // Agora pede o salário (ainda como texto)
        String salarioStr = EntradaSaidaDados.entradaString("Digite o salário base:");
        if (salarioStr == null) return;     // Se cancelou de novo, volta sem fazer nada

        try{
            // Transforma o texto do salário em número com vírgula
            double salarioBase = ConversorNumeros.stringParaDouble(salarioStr);

            // Cria um vendedor novo com:
            // - ID automático (e incrementa pro próximo)
            // - Nome que a pessoa digitou
            // - Salário convertido          o id vai usar o valor quee ja tem, so dps que adiciona mais 1
            Vendedor vendedor = new Vendedor(nextId++, nome, salarioBase);

            // Guarda o vendedor na lista de vendedores
            vendedores.add(vendedor);

            // Mostra uma mensagem de sucesso com o ID do vendedor
            EntradaSaidaDados.saidaMensagem("Vendedor criado com sucesso!\nID: " + vendedor.getId());

        }catch (NumberFormatException e){
            // Se deu erro na conversão do salário (usuário digitou letras em vez de número)
            // Mostra uma mensagem de erro vermelha e feia
            EntradaSaidaDados.saidaErro("Valor inválido para salário!");
        }
    }

    private void calcularComissao() {
        // Primeiro verifica se tem vendedor cadastrado
        if (vendedores.isEmpty()) { //'isEmpty' verifica se tem algo na array, caso tenha ele volta como false
            // Se a lista tá vazia, mostra um alerta e vaza do metodo
            EntradaSaidaDados.saidaAviso("Nenhum vendedor cadastrado!");
            return;
        }

        // Pede pra escolher um vendedor na lista
        Vendedor vendedor = selecionarVendedor();

        // Se o cara clicou em cancelar, só volta sem fazer nada
        if (vendedor == null) return;

        // Pede pra digitar quanto o vendedor vendeu (em texto)
        String valorVendidoStr = EntradaSaidaDados.entradaString("Digite o valor vendido:");

        try {
            // Passa de String pra Double
            double valorVendido = ConversorNumeros.stringParaDouble(valorVendidoStr);

            // Chama metodo de calculo do vendedor pra calcular sua comissão
            double comissao = vendedor.calcularComissao(valorVendido);


            // A gente usa String.format para montar um texto com variáveis no meio dele
            // Dentro da string, usamos marcadores que indicam onde cada valor vai entrar:
            // %s  → esse marcador é pra texto (string), aqui vai entrar o nome do vendedor
            // %.2f → esse marcador é pra número decimal com 2 casas depois da vírgula (tipo dinheiro)
            // O String.format lê esses marcadores da esquerda pra direita e vai preenchendo com os valores que a gente passar na ordem
            // 1º valor (vendedor.getNome()) entra no lugar do %s
            // 2º valor (valorVendido) entra no lugar do primeiro %.2f
            // 3º valor (comissao) entra no lugar do segundo %.2f
            // Se mudar a ordem dos valores ali embaixo, o texto vai sair errado
            String mensagem = String.format("Vendedor: %s\nValor Vendido: R$ %.2f\nComissão: R$ %.2f", vendedor.getNome(), valorVendido, comissao);

            // Mostra a mensagem pro usuário
            EntradaSaidaDados.saidaMensagem(mensagem);

        }catch (NumberFormatException e){
            EntradaSaidaDados.saidaErro("Valor inválido para cálculo!");
        }
    }



    // Função que mostra a lista de vendedores e deixa o usuário escolher um
    private Vendedor selecionarVendedor() {

        // Cria um vetor de textos com o nome + ID de cada vendedor
        String[] opcoes = new String[vendedores.size()];// a gente deixa essa nova array do tamanho da nossa list

        for (int i = 0; i < vendedores.size(); i++) {
            // Tipo assim: "Maria (ID: 1)", "João (ID: 2)", etc
            /*
             * vendedores.get(i) → pega o vendedor que está na posição i da lista vendedores
             * getNome() → pega o nome desse vendedor
             * getId() → pega o ID desse vendedor
             * EX: "NomeDoVendedor (ID: númeroDoID)"
             */
            opcoes[i] = vendedores.get(i).getNome() + " (ID: " + vendedores.get(i).getId() + ")";
        }

        // Mostra uma janela perguntando "Quem você quer escolher?" com as opções
        String selecionado = EntradaSaidaDados.entradaSelecao("Selecione o vendedor:", opcoes);

        // Se o usuário apertar cancelar, já sai da função e retorna null
        if (selecionado == null) return null;


        /*
         * Pegou o texto que a pessoa escolheu, tipo: 'João (ID: 3)'. Aí cortou esse texto na parte do 'ID: ',
         * pegou só o pedaço que tinha o número, tirou o parêntese, e transformou isso num número de verdade(int) pra
         * poder comparar depois
         */
        // O metodo split é o responsável por dividir o texto onde aparece "ID: "
        // Isso gera um array com duas partes, e a segunda parte (índice 1) contém o ID com parêntese, ex: "7)"
        // O metodo replace é o responsável por remover o parêntese final da string "7)", deixando só "7"
        // O metodo Integer.parseInt é o responsável por transformar essa string "7" em um número inteiro
        // Tudo isso é guardado na variável 'id' para ser usado depois
        int id = Integer.parseInt(selecionado.split("ID: ")[1].replace(")", ""));

        // Agora a gente procura na lista quem tem esse ID
        for (Vendedor v : vendedores) {// isso é um for-each ou seja, ele percorre toda a array automaticamente
            if (v.getId() == id) {
                // Quando achar, retorna esse vendedor
                return v;
            }
        }

        // Se não achou ninguém com esse ID (o que é difícil), retorna null mesmo
        return null;
    }

    private void exibirVendedor() {
        // Verifica se existe algum vendedor cadastrado
        if (vendedores.isEmpty()) {
            EntradaSaidaDados.saidaAviso("Nenhum vendedor cadastrado!");
            return;
        }

        // Pede para selecionar um vendedor
        Vendedor vendedor = selecionarVendedor();
        if (vendedor == null) return;

        // Formata as informações do vendedor
        String info = String.format(
                "ID: %d\nNome: %s\nSalário Base: R$ %.2f",
                vendedor.getId(), vendedor.getNome(), vendedor.getSalarioBase());

        // Mostra as informações
        EntradaSaidaDados.saidaMensagem(info);
    }
}

