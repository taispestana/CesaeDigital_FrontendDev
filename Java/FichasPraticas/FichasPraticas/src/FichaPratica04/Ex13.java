package FichaPratica04;

import java.util.Scanner;

public class Ex13 {
    public static void main(String[] args) {
        //13. Some os elementos da diagonal principal de uma matriz 4x4.
        //• O programa deverá solicitar ao utilizador 16 valores para preencher uma matriz 4x4.
        //• Depois, deverá calcular a soma dos elementos localizados na diagonal principal (posição [0][0], [1][1], [2][2],
        //etc.).

        //Pedir ao utilizador
        Scanner input = new Scanner(System.in);

        //Criar array
        int[][] matriz = new int[4][4];
        int somaDiagonal = 0;

        // Ler os 16 valores do utilizador
        System.out.println("Digite 16 números para preencher a matriz 4x4:");
        for (int linha = 0; linha < 4; linha++) {
            for (int coluna = 0; coluna < 4; coluna++) {
                System.out.print("Elemento [" + linha + "][" + coluna + "]: ");
                matriz[linha][coluna] = input.nextInt();
            }
        }

        // Calcular a soma dos elementos da diagonal principal
        for (int i = 0; i < 4; i++) {
            somaDiagonal += matriz[i][i]; // elementos onde linha == coluna
        }

        // Mostrar a matriz
        System.out.println("\nMatriz 4x4:");
        for (int linha = 0; linha < 4; linha++) {
            for (int coluna = 0; coluna < 4; coluna++) {
                System.out.print(matriz[linha][coluna] + "\t");
            }
            System.out.println(); // quebra de linha
        }

        // Mostrar o resultado
        System.out.println("\nA soma dos elementos da diagonal principal é: " + somaDiagonal);

        input.close();
    }
}
