package FichaPratica01;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Ex06 {
    public static void main(String[] args) {
        //ler o codigo
        Scanner input = new Scanner(System.in);

        int valor1, valor2;

        System.out.println("Introduza o primeiro valor: ");
        valor1 = input.nextInt();

        System.out.println("Introduza o segundo valor: ");
        valor2 = input.nextInt();

        valor1 = valor1 + valor2;
        valor2 = valor1 - valor2;
        valor1 = valor1 - valor2;

        System.out.println("O primeiro valor é: " + valor1);
        System.out.println("O segundo valor é: " + valor2);

    }

}
