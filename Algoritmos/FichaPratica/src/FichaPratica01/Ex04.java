package FichaPratica01;

import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double raio, area;

        System.out.println("Introduza o raio da circunferencia: ");
        raio = input.nextDouble();

        area = Math.PI * raio * raio;

        System.out.println("A area da circunferencia é: " + area + " CM2");
    }
}
