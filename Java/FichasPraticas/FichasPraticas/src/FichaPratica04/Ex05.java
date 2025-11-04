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

        // Ler os 10 números
        for (int i = 0; i < 10; i++) {
            System.out.print("Digite o número " + (i + 1) + ": ");
            numeros[i] = input.nextInt();
        }

        // Somar os números
        int soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += numeros[i];
        }

        // Calcular média
        double media = soma / 10.0;

        // Mostrar resultado
        System.out.println("A média dos numeros introduzidos é: " + media);

        input.close();
    }
}
