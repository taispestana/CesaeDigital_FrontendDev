package FichaPratica04;

import java.util.Scanner;

public class Ex11 {
    public static void main(String[] args){

        //11. Encontre o maior e o menor valor numa matriz 3x3.
        //• O programa deverá solicitar ao utilizador que insira valores numa matriz de 3x3.
        //• Em seguida, deverá identificar e apresentar o maior e o menor valor da matriz.
        //• Por fim, deverá imprimir o conteúdo completo da matriz.

        //Pedir ao utilizador
        Scanner input = new Scanner(System.in);

        //Criar array com 10 gavetas
        int[][] matriz = new int[3][3];

        int maior = Integer.MIN_VALUE; // Inicializa com o menor valor possível
        int menor = Integer.MAX_VALUE; // Inicializa com o maior valor possível


        //Criar um  ciclo para preencher os valores nas gavetas
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna <3; coluna++) {
                System.out.print("Insira um valor na matriz [" + linha + "]["+ coluna +"]:");
                matriz[linha][coluna] = input.nextInt();

                // Atualiza o maior e o menor valor conforme a inserção
                if (matriz[linha][coluna] > maior) {
                    maior = matriz[linha][coluna];
                }
                if (matriz[linha][coluna] < menor) {
                    menor = matriz[linha][coluna];
                }
            }
        }

        // Mostrar o maior e o menor valor
        System.out.println("\nO maior valor da matriz é: " + maior);
        System.out.println("O menor valor da matriz é: " + menor);

        // Imprimir a matriz
        System.out.println("\nMatriz 3x3:");
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                System.out.print(matriz[linha][coluna] + "\t");
            }
            System.out.println(); // Quebra de linha para a próxima linha da matriz
        }

        input.close();

    }
}
