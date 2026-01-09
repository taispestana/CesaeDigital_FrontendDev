package ex03;

import java.util.Scanner;

public class Area {
    public static void main(String[] args) {
     
    //area do retangulo
    int area;
    int altura;
    int largura;

    System.out.println("Cálculo da área de um retângulo");
    System.out.println("Digite a altura: ");
    Scanner alturaInput = new Scanner(System.in);
    altura = alturaInput.nextInt();

    System.out.println("Digite a largura: ");
    Scanner larguraInput = new Scanner(System.in);
    largura = larguraInput.nextInt();

    area = altura * largura;
    System.out.println("Área do retângulo: " + area);

    System.out.println("*******************************************");

    //area do triangulo
    double baseTriangulo;
    double alturaTriangulo;

    System.out.println("Cálculo da área de um triângulo");
    System.out.println("Digite a base: ");
    Scanner baseInput = new Scanner(System.in);
    baseTriangulo = baseInput.nextDouble();

    System.out.println("Digite a altura: ");
    Scanner alturaTrianguloInput = new Scanner(System.in);
    alturaTriangulo = alturaTrianguloInput.nextDouble();

    double areaTriangulo = (baseTriangulo * alturaTriangulo) / 2;
    System.out.println("Área do triângulo: " + areaTriangulo);

    System.out.println("*******************************************");

    //area do circulo
    double raio;

    System.out.println("Cálculo da área de um círculo");
    System.out.println("Digite o raio: ");
    Scanner raioInput = new Scanner(System.in);
    raio = raioInput.nextDouble();
    double areaCirculo = Math.PI * Math.pow(raio, 2);
    System.out.println("Área do círculo: " + areaCirculo);

    }
}
