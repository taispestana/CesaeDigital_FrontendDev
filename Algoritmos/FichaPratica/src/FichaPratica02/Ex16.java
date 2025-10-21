package FichaPratica02;

import java.util.Scanner;

public class Ex16 {
    public static void main(String[] args) {

        //Importar o Scanner - Leitura do Teclado
        Scanner input = new Scanner(System.in);

        //Declarar as variaveis
        int valor, notas;

        //Ler
        System.out.println("Digite um valor em euros (multiplo de 5): ");
        valor = input.nextInt();

        //Verifica se o valor é multiplo de 5
        if (valor % 5 == 0) {

            //Exibe o valor lido
            System.out.println("\nValor lido: € " + valor);
            System.out.println("Notas necessarias: ");

            //Calculo das notas, do maior para o menor valor
            //Notas 200
            notas = valor / 200;
            System.out.println("Notas de 200: " + notas);
            //valor = valor % 200 etc etc;
            valor %= 200;

            //Notas 100
            notas = valor / 100;
            System.out.println("Notas de 100: " + notas);
            valor %= 100;

            //Notas 50
            notas = valor / 50;
            System.out.println("Notas de 50: " + notas);
            valor %= 50;

            //Notas 20
            notas = valor / 20;
            System.out.println("Notas de 20: " + notas);
            valor %= 20;

            //Notas 10
            notas = valor / 10;
            System.out.println("Notas de 10: " + notas);
            valor %= 10;

            //Notas 5
            notas = valor / 5;
            System.out.println("Notas de 5: " + notas);
            valor %= 5;
        }else{
            System.out.println("Valor inválido. O valor deve ser positivo e multiplo de 5");
        }

    }
}
