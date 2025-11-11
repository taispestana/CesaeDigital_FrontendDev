package FichaPratica04;

import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {

        //Calcule a média dos elementos de um array de 10 posições.
        //• O programa deverá solicitar ao utilizador que insira 10 números num array.
        //• Depois, deve calcular e apresentar a média dos valores inseridos.

        //Declaracao array e leitura do mesmo
        int[] numeros = new int[10];
        Scanner input = new Scanner(System.in);
        int soma = 0;
        int media = 0;

        // Ler os 10 números e somar
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Digite o número " + (i + 1) + ": ");
            numeros[i] = input.nextInt();
            soma += numeros[i];
        }

        // Calcular média
        media = soma / numeros.length;

        // Mostrar resultado
        System.out.println("A média dos numeros introduzidos é: " + media);

        input.close();
    }
}
