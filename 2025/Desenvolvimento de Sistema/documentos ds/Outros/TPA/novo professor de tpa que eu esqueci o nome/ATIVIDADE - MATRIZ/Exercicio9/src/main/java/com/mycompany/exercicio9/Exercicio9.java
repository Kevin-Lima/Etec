/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.exercicio9;

import java.util.Scanner;

public class Exercicio9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Criando o tabuleiro 3x3, inicialmente vazio
        char[][] tabuleiro = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };

        boolean jogoAtivo = true; // Controla se o jogo continua ou termina
        char jogadorAtual = 'X'; // O jogador X começa
        int jogadas = 0; // Conta o número de jogadas realizadas

        // Loop principal do jogo
        while (jogoAtivo) {
            // Exibindo o tabuleiro
            exibirTabuleiro(tabuleiro);

            // Solicitando a jogada do jogador atual
            System.out.println("\nVez do jogador: " + jogadorAtual);
            System.out.println("Escolha a posição onde deseja jogar (linha e coluna entre 0 e 2):");
            System.out.print("Linha: ");
            int linha = sc.nextInt();
            System.out.print("Coluna: ");
            int coluna = sc.nextInt();

            // Verifica se a posição é válida e está vazia
            if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2 || tabuleiro[linha][coluna] != ' ') {
                System.out.println("\n⚠️ Jogada inválida! Certifique-se de escolher uma posição vazia entre 0 e 2. Tente novamente.");
                continue; // Pula para o próximo loop sem alterar o jogador
            }

            // Marca a jogada no tabuleiro
            tabuleiro[linha][coluna] = jogadorAtual;
            jogadas++; // Incrementa o número de jogadas

            // Verifica se o jogador atual venceu
            if (verificarVencedor(tabuleiro, jogadorAtual)) {
                exibirTabuleiro(tabuleiro);
                System.out.println("\n🎉 Parabéns! O jogador " + jogadorAtual + " venceu o jogo!");
                jogoAtivo = false; // Encerra o jogo
            } else if (jogadas == 9) { // Verifica empate (todos os espaços preenchidos)
                exibirTabuleiro(tabuleiro);
                System.out.println("\n⚖️ Empate! O tabuleiro está cheio e ninguém venceu.");
                jogoAtivo = false; // Encerra o jogo
            } else {
                // Alterna o jogador (se ninguém venceu)
                jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
            }
        }

        sc.close(); // Fecha o scanner
    }

    // Função para exibir o tabuleiro
    public static void exibirTabuleiro(char[][] tabuleiro) {
        System.out.println("\nTabuleiro Atual:");
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print(" " + tabuleiro[i][j] + " ");
                if (j < tabuleiro[i].length - 1) {
                    System.out.print("|"); // Coloca separador entre colunas
                }
            }
            System.out.println();
            if (i < tabuleiro.length - 1) {
                System.out.println("---+---+---"); // Coloca separador entre linhas
            }
        }
    }

    // Função para verificar se o jogador atual venceu
    public static boolean verificarVencedor(char[][] tabuleiro, char jogador) {
        // Verifica linhas
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador) {
                return true;
            }
        }

        // Verifica colunas
        for (int j = 0; j < 3; j++) {
            if (tabuleiro[0][j] == jogador && tabuleiro[1][j] == jogador && tabuleiro[2][j] == jogador) {
                return true;
            }
        }

        // Verifica diagonal principal
        if (tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador) {
            return true;
        }

        // Verifica diagonal secundária
        if (tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador) {
            return true;
        }

        return false; // Nenhuma condição de vitória encontrada
    }
}
