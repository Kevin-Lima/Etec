package com.mycompany.testeswing;
import javax.swing.*;

public class JanelaTamanho extends JFrame {
    
    // Variáveis de controle
    private boolean redimensionavel;  // Define se a janela será redimensionável
    private boolean maximizada;       // Define se a janela será maximizada ou minimizada

    // Construtor da classe e parâmetros que ele recebe
    public JanelaTamanho(boolean redimensionavel, boolean maximizada) {
        
        // Chama o construtor da classe JFrame com o título
        super("Exibição de janela");

        // Atribui os valores dos parâmetros às variáveis de controle da classe
        // O "this" é usado para referenciar as variáveis de instância da classe
        this.redimensionavel = redimensionavel;
        this.maximizada = maximizada;

        // Define o tamanho da janela
        setSize(300, 150);

        // Estrutura condicional para definir se a janela será redimensionável ou não
        if (redimensionavel) {
            setResizable(true);  // Permite redimensionar
        } 
        else {
            setResizable(false); // Impede o redimensionamento
        }

        // Estrutura condicional para definir o estado da janela (maximizada ou minimizada)
        if (maximizada) {
            setExtendedState(MAXIMIZED_BOTH);  // Maximiza a janela
        } 
        else {
            setExtendedState(JFrame.ICONIFIED);  // Minimiza a janela
        }

        // Torna a janela visível
        setVisible(true);
        
        // Centraliza a janela na tela
        setLocationRelativeTo(null);
    }

    // Método principal
    public static void main(String args[]) {
        // Cria a nova instância da classe, passando os parâmetros para o construtor
        JanelaTamanho app = new JanelaTamanho(true, false);  // Alterar os valores para testar
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define o comportamento ao fechar a janela
    }
}
