package FichaPratica04;

import java.util.Scanner;

public class Ex12 {
    public static void main(String[] args){

        //12. Gere uma matriz 10x2 a partir de dois arrays de tamanho 10.
        //• O programa deverá solicitar ao utilizador dois arrays de 10 posições.
        //• Depois, deverá gerar uma matriz 10x2, onde cada linha da matriz contém os valores correspondentes dos dois
        //arrays.

        //Pedir ao utilizador
        Scanner input = new Scanner(System.in);

        //Criar array
        int[] array1 = new int[10];
        int[] array2 = new int[10];

        // Solicitar ao utilizador os valores para o primeiro array
        System.out.println("Digite 10 números para o primeiro array:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            array1[i] = input.nextInt();
        }

        // Solicitar ao utilizador os valores para o segundo array
        System.out.println("\nDigite 10 números para o segundo array:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            array2[i] = input.nextInt();
        }

        // Criar e preencher a matriz 10x2
        int[][] matriz = new int[10][2];
        for (int i = 0; i < 10; i++) {
            matriz[i][0] = array1[i]; // Preenche a primeira coluna com o array1
            matriz[i][1] = array2[i]; // Preenche a segunda coluna com o array2
        }

        // Imprimir a matriz 10x2
        System.out.println("\nMatriz 10x2 gerada a partir dos dois arrays:");
        for (int i = 0; i < 10; i++) {
            System.out.println("[" + matriz[i][0] + ", " + matriz[i][1] + "]");
        }

        input.close();
    }
}
