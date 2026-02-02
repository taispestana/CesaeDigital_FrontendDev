package ex06;

public class Main {

    // Método principal para testar a classe OperacoesMatematicas
    public static void main(String[] args) {

        // 1. Criar um objecto da classe OperacoesMatematicas
        OperacoesMatematicas op = new OperacoesMatematicas();

        // 2. Realizar as operações e guardar os resultados
        double resultPot = op.potencia(2, 3); 
        double resultRaiz = op.raizQuadrada(16); 
        double resultMedia = op.media(10, 15, 20); 

        // 3. Imprimir os resultados na consola
        System.out.println("Resultados das Operações Matemáticas:");
        System.out.println("Potência (2^3): " + resultPot);
        System.out.println("Raiz Quadrada de 16: " + resultRaiz);
        System.out.println("Média (10, 15, 20): " + resultMedia);
    }
}