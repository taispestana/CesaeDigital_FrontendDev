package FichaPratica03;

import java.util.Scanner;

public class Ex12 {
    public static void main(String[] args) {

        //Importar o Scanner - Leitura do Teclado
        Scanner input = new Scanner(System.in);

        //Declarar a variavel
        int numero, contador0_25=0, contador26_50=0, contador51_75=0, contador76_100=0;

        System.out.println("Digite números inteiros positivos (um número negativo encerra):");

        while (true) {
            System.out.print("Número: ");
            numero = input.nextInt();

            if (numero < 0) {
                break; // termina o loop se número for negativo
            }

            if (numero <=25){
                contador0_25++;
            } else if (numero >= 26 && numero <=50){
                contador26_50++;
            } else if (numero >= 51 && numero <=75){
                contador51_75++;
            } else if (numero >= 76 && numero <=100){
                contador76_100++;
            }

            // Exibe o resultado
            System.out.println("\nContagem por intervalos:");
            System.out.println("[0, 25]: " + contador0_25);
            System.out.println("[26, 50]: " + contador26_50);
            System.out.println("[51, 75]: " + contador51_75);
            System.out.println("[76, 100]: " + contador76_100);
        }
    }
}
