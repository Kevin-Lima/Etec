package com.mycompany.exercicio3;

import javax.swing.JOptionPane;

public class Exercicio3 {
    public static void main(String[] args) {
        // Criando uma matriz 3x5 (3 linhas e 5 colunas)
        int[][] matriz = new int[3][5];

        // Variáveis para contar quantos números pares e ímpares a matriz tem
        int qtdPares = 0;
        int qtdImpares = 0;

        // Criando um vetor auxiliar para guardar todos os elementos da matriz
        // Esse vetor será usado para verificar se há números repetidos
        int[] elementos = new int[15]; // O tamanho é igual ao total de elementos da matriz (3 x 5 = 15)
        int posicao = 0; // Essa variável será usada como índice para preencher o vetor

        // Preenchendo a matriz com números fornecidos pelo usuário
        for (int i = 0; i < matriz.length; i++) { // Loop pelas linhas
            for (int j = 0; j < matriz[i].length; j++) { // Loop pelas colunas
                // Pedindo para o usuário digitar um número para cada posição da matriz
                int numero = Integer.parseInt(JOptionPane.showInputDialog(
                    "Digite um número para a posição [" + i + "][" + j + "] da matriz:"));

                matriz[i][j] = numero; // Guardando o número na posição correta da matriz
                elementos[posicao++] = numero; // Salvando o número no vetor auxiliar

                // Verificando se o número é par ou ímpar
                if (numero % 2 == 0) { // Se o resto da divisão por 2 for zero, é par
                    qtdPares++; // Incrementa a quantidade de pares
                } else { // Caso contrário, é ímpar
                    qtdImpares++; // Incrementa a quantidade de ímpares
                }
            }
        }

        // Verificando se existem números repetidos na matriz
        boolean temRepetidos = false; // Inicialmente, assumimos que não há repetidos
        for (int i = 0; i < elementos.length; i++) { // Percorrendo o vetor auxiliar
            for (int j = i + 1; j < elementos.length; j++) { // Comparando cada elemento com os próximos
                if (elementos[i] == elementos[j]) { // Se encontrar um número igual
                    temRepetidos = true; // Atualiza a variável indicando que há repetidos
                    break; // Sai do loop interno, já que encontramos repetição
                }
            }
            if (temRepetidos) break; // Sai do loop externo se já tiver repetidos
        }

        // Exibindo a matriz de forma organizada no terminal
        System.out.println("Matriz preenchida:");
        for (int i = 0; i < matriz.length; i++) { // Loop pelas linhas
            for (int j = 0; j < matriz[i].length; j++) { // Loop pelas colunas
                // Exibe os números com espaçamento ajustado (pra deixar visualmente alinhado)
                System.out.print(matriz[i][j] + (matriz[i][j] < 10 ? "  " : " "));
            }
            System.out.println(); // Pula para a próxima linha no terminal
        }

        // Exibindo os resultados finais no terminal
        System.out.println("\nResultados:");
        // Mostra se há números repetidos
        System.out.println("A matriz possui elementos repetidos? " + (temRepetidos ? "Sim" : "Não"));
        // Mostra a quantidade de números pares
        System.out.println("Quantidade de números pares: " + qtdPares);
        // Mostra a quantidade de números ímpares
        System.out.println("Quantidade de números ímpares: " + qtdImpares);
    }
}
