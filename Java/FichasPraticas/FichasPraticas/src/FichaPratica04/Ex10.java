package FichaPratica04;

import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args){

        //10. Conte a ocorrência de um número numa matriz 3x5.
        //• O programa deverá solicitar ao utilizador que insira valores para preencher uma matriz de 3 linhas e 5 colunas.
        //• Depois, deverá solicitar um número adicional e indicar quantas vezes esse número aparece na matriz.

        //Pedir ao utilizador
        Scanner input = new Scanner(System.in);

        //Criar array com 10 gavetas
        int[][] matriz = new int[3][5];
        int contador = 0;

        //Criar um  ciclo para preencher os valores nas gavetas
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna <5; coluna++) {
                System.out.print("Insira um valor na matriz [" + linha + "]["+ coluna +"]:");
                matriz[linha][coluna] = input.nextInt();
            }
        }
        // Solicitar o número a ser contado
        System.out.print("Digite um número para contar as ocorrências na matriz: ");
        int numeroParaContar = input.nextInt();

        //Contar quantas vezes o número aparece na matriz
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 5; coluna++) {
                if (matriz[linha][coluna] == numeroParaContar) {
                    contador++;
                }
            }
        }

        // Mostrar o resultado
        System.out.println("O número " + numeroParaContar + " aparece " + contador + " vezes na matriz.");

        input.close();
    }
}
