package FichaPratica04;

import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {

        //Encontre o menor elemento de um array de 10 posições.
        //• O programa deverá solicitar ao utilizador que insira 10 números num array.
        //• Depois, deverá determinar e apresentar o menor valor encontrado no array.

        //Declaracao array e leitura do mesmo
        int[] numeros = new int[10];
        Scanner input = new Scanner(System.in);

        // Ler os 10 números
        for (int i = 0; i < 10; i++) {
            System.out.print("Digite o número " + (i + 1) + ": ");
            numeros[i] = input.nextInt();
        }

        // Encontrar o menor número
        int menor = numeros[0];
        for (int i = 1; i < 10; i++) {
            if (numeros[i] < menor) {
                menor = numeros[i];
            }
        }

        // Mostrar resultado
        System.out.println("O menor número digitado é: " + menor);

        input.close();

    }
}
