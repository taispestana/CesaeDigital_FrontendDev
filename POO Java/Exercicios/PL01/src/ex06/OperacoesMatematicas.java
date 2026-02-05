package ex06;

// Classe para realizar operações matemáticas básicas
public class OperacoesMatematicas {

    // Construtor padrão
    public OperacoesMatematicas() {
       
    }

    // Método para calcular a potência de um número
    public double potencia(double base, double expoente) {
        return Math.pow(base, expoente);
    }

    // Método para calcular a raiz quadrada de um número
    public double raizQuadrada (double num) {
        return Math.sqrt(num);
    }

    // Método para calcular a média de três números

    public double media(double n1, double n2, double n3) {
        return (n1+n2+n3) / 3;
    }
}