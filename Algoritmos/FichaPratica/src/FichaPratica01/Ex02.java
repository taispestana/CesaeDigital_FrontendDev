package FichaPratica01;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {

        //Importar o Scanner
        Scanner input = new Scanner(System.in);

        //Declarar as variaveis
        int num1, num2, soma, subtracao, multiplicacao, divisao;

        System.out.println("Introduza um número: ");
        num1 = input.nextInt();

        System.out.println("Introduza outro número: ");
        num2 = input.nextInt();

        soma= num1 + num2;
        System.out.println("Soma: " + soma);

        subtracao= num1 - num2;
        System.out.println("Subtracao: " + subtracao);

        multiplicacao= num1 * num2;
        System.out.println("Multiplicacao: " + multiplicacao);

        divisao= num1 / num2;
        System.out.println("Divisao: " + divisao);
    }
}
