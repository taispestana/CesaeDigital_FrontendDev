package FichaPratica01;

import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double mediaAritmetica, mediaPonderada, valor1, valor2, valor3;

        System.out.println("Introduza o primeiro valor: ");
        valor1 = input.nextDouble();

        System.out.println("Introduza o segundo valor: ");
        valor2 = input.nextDouble();

        System.out.println("Introduza o terceiro valor: ");
        valor3 = input.nextDouble();

        mediaAritmetica = valor1 + valor2 + valor3 / 3;
        System.out.println("A media aritmetica dos valores introduzidos é: " + mediaAritmetica);

        mediaPonderada = (valor1*0.2)+(valor2*0.3)+(valor3*0.5);
        System.out.println("A media ponderada dos valores introduzidos é: " + mediaPonderada);
    }
}
