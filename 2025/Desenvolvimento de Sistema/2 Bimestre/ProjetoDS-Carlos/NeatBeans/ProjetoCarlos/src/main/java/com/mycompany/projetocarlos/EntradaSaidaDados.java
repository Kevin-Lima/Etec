/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetocarlos;

import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EntradaSaidaDados {

    //vai pegar uma mensagem pronta e vai colocar em um JOptionPane
    public static String entradaString(String mensagem) {
        return JOptionPane.showInputDialog(null, mensagem);
    }

    // Cria uma função que mostra uma janela com uma mensagem que a gente mandar
    public static void saidaMensagem(String mensagem) {
        // Aqui a gente manda aparecer uma janela na tela com o texto
        JOptionPane.showMessageDialog(
                null,  // "null" só quer dizer que a janelinha vai abrir no meio da tela
                mensagem,         // esse é o texto que vai aparecer na janela
                "Informação",     // esse é o título que aparece em cima da janela
                JOptionPane.INFORMATION_MESSAGE // isso aqui é só pra colocar um ícone de info
        );
    }

    public static void saidaErro(String mensagem) {
        JOptionPane.showMessageDialog(
                null,
                mensagem,
                "Erro",
                JOptionPane.ERROR_MESSAGE);
    }

    public static void saidaAviso(String mensagem) {
        JOptionPane.showMessageDialog(
                null,
                mensagem,
                "Aviso",
                JOptionPane.WARNING_MESSAGE);
    }

    public static String entradaSelecao(String mensagem, String[] opcoes) {
        // Abre uma janela perguntando alguma coisa, tipo: "Escolha o vendedor"
        // E mostra uma lista de opções pro usuário clicar
        return (String) JOptionPane.showInputDialog(
                null,               // Não tem uma janela principal por trás, então é null mesmo
                mensagem,           // Mensagem que aparece lá em cima da janelinha
                "Seleção",          // Título da janelinha (aparece na barra de cima)
                JOptionPane.PLAIN_MESSAGE, // Tipo da mensagem (sem ícone, só texto)
                null,               // Não tem ícone personalizado
                opcoes,             // Aqui vão todas as opções que a pessoa pode escolher
                opcoes[0]);         // Essa é a opção que já vai estar selecionada quando a janela abrir
    }


    public static String obterDataAtual() {
        // Aqui a gente junta a palavra "Data: " com a data de hoje formatada
        // 'new Date()' pega a data e hora do momento
        // 'new SimpleDateFormat("dd/MM/yyyy")' cria um jeito pra mostrar a data no estilo "dia/mês/ano"
        // '.format(new Date())' pega a data atual e aplica esse formato
        // No final, tudo isso é juntado e virando uma frase tipo: "Data: 23/04/2025"
        return "Data: " + new SimpleDateFormat("dd/MM/yyyy").format(new Date());
    }
}
