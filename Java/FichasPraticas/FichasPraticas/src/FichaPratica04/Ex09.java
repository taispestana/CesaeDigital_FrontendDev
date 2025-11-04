package FichaPratica04;

import java.util.Scanner;

public class Ex09 {
    public static void main(String[] args){

        //9. Some todos os elementos de uma matriz 5x5.
        //• O programa deverá solicitar ao utilizador 25 valores para preencher uma matriz 5x5.
        //• Após a inserção, deverá calcular e apresentar a soma de todos os elementos da matriz.

        //Pedir ao utilizador
        Scanner input = new Scanner(System.in);

        //Criar array com 10 gavetas
        int[][] matriz = new int[5][5];

        int soma = 0;

        System.out.println("Digite 25 números inteiros para preencher a matriz 5x5:");

        //Criar um  ciclo para preencher os valores nas gavetas
        for (int linha = 0; linha < 5; linha++) {
            for (int coluna = 0; coluna <5; coluna++) {
                System.out.print("Insira um valor na matriz [" + linha + "]["+ coluna +"]:");
                matriz[linha][coluna] = input.nextInt();
                soma += matriz[linha][coluna]; // já soma aqui
            }
        }

        // Mostrar a matriz formatada (opcional, mas ajuda a visualizar)
        System.out.println("\nMatriz 5x5:");
        for (int linha = 0; linha < 5; linha++) {
            for (int coluna = 0; coluna < 5; coluna++) {
                System.out.print(matriz[linha][coluna] + "\t");
            }
            System.out.println();
        }

        // Mostrar o resultado da soma
        System.out.println("\nA soma de todos os elementos da matriz é: " + soma);

        input.close();

    }
}
