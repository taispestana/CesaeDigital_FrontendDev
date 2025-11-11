package FichaPratica04;

import java.util.Scanner;

public class Ex08 {
    public static void main(String[] args){

        //8. Crie e imprimir uma matriz 3x3 preenchida por números inteiros introduzidos pelo utilizador.
        //• O programa deverá solicitar ao utilizador que insira 9 números, que serão armazenados numa matriz de 3x3.
        //• Após a inserção, deverá imprimir a matriz no formato de uma tabela.

        //Pedir ao utilizador
        Scanner input = new Scanner(System.in);

        //Criar array com 10 gavetas
        int[][] matriz = new int[3][3];

        //Criar um  ciclo para preencher os valores nas gavetas
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna <3; coluna++) {
                System.out.print("Insira um valor na matriz [" + linha + "]["+ coluna +"]:");
                matriz[linha][coluna] = input.nextInt();
            }
        }

        // Imprimir a matriz em formato de tabela
        System.out.println("\nMatriz 3x3:");

        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                System.out.print(matriz[linha][coluna] + "\t"); // \t = tabulação (alinha as colunas)
            }
            System.out.println(); // quebra de linha a cada linha da matriz
        }

        input.close();

    }
}
