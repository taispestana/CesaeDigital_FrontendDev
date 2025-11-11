package FichaPratica04;

import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        //Encontre o maior elemento de um array de 10 posições.
        //• O programa deverá solicitar ao utilizador que insira 10 números num array.
        //• Depois, deverá determinar e apresentar o maior valor encontrado no array.

        //Declaracao array e leitura do mesmo
        int[] numeros = new int[3];
        Scanner input = new Scanner(System.in);

        // Ler os 10 números
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Digite o número " + (i + 1) + ": ");
            numeros[i] = input.nextInt();
        }

        // Encontrar o maior número
        int maior = numeros[0];
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] > maior) {
                maior = numeros[i];
            }
        }

        // Mostrar resultado
        System.out.println("O maior número digitado é: " + maior);

        input.close();

    }
}
