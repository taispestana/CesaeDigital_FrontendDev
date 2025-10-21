package FichaPratica01;

import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {

        Scanner input =  new Scanner(System.in);

        int largura, altura, perimetro, area;

        System.out.print("Introduza a largura em metros: ");
        largura = input.nextInt();

        System.out.print("Introduza a altura em metros: ");
        altura = input.nextInt();

        area = largura * altura;
        System.out.println("A area do retangulo é: " + area + " M2");

        perimetro = 2 * (largura + altura);
        System.out.println("O perimetro do retangulo é: " + perimetro + " M2");

    }
}
