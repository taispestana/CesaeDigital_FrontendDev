package ex03;

public class Main {
    public static void main(String[] args) {
        // Criando um objeto da classe Triangulo
        Triangulo triangulo1 = new Triangulo(10, 5);
        Triangulo triangulo2 = new Triangulo(7.5, 3.5);

        // Calculando e exibindo a área do triângulo
        System.out.println("A área do triângulo é: " + triangulo1.calcularArea());
        System.out.println("A área do triângulo é: " + triangulo2.calcularArea());

        //Mostrar resultados com mais detalhes
        System.out.println("Area do triângulo com base 10 e altura 5: " + triangulo1.calcularArea());
        System.out.println("Area do triângulo com base 7.5 e altura 3.5: " + triangulo2.calcularArea());

        //comparar as areas e indicar qual é maior
        if (triangulo1.calcularArea() > triangulo2.calcularArea()) {
            System.out.println("O triângulo 1 tem a maior área.");
        } else if (triangulo1.calcularArea() < triangulo2.calcularArea()) {
            System.out.println("O triângulo 2 tem a maior área.");
        } else {
            System.out.println("Os triângulos têm a mesma área.");
        }
    }

}
