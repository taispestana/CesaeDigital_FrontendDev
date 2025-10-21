package FichaPratica01;

import java.util.Scanner;

public class Ex07 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double preco1, preco2, preco3, precoDesc1, precoDesc2, precoDesc3;

        System.out.println("Introduza o valor do primeiro produto: ");
        preco1 = input.nextInt();

        System.out.println("Introduza o valor do segundo produto: ");
        preco2 = input.nextInt();

        System.out.println("Introduza o valor do terceiro produto: ");
        preco3 = input.nextInt();

        precoDesc1 = preco1 * 0.1;
        precoDesc2 = preco2 * 0.1;
        precoDesc3 = preco3 * 0.1;

        precoDesc1 = preco1 - precoDesc1;
        precoDesc2 = preco2 - precoDesc2;
        precoDesc3 = preco3 - precoDesc3;

        System.out.println("O valor do primeiro produto é: " + precoDesc1);
        System.out.println("O valor do segundo produto é: " + precoDesc2);
        System.out.println("O valor do terceiro produto é: " + precoDesc3);
    }
}
