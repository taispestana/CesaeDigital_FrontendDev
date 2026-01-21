package ex04;

public class Cilindro {
    
    private double raio;
    private double altura;

    public Cilindro(double raio, double altura) {
        this.raio = raio;
        this.altura = altura;
    }

    public double calcularVolume() {
        return Math.PI * Math.pow(raio, 2) * altura;
    }

    public double calcularAreaSuperficial() {
        return 2 * Math.PI * raio * (raio + altura);
    }

    public double getRaio() {
        return raio;
    }

    public double getAltura() {
        return altura;
    }
}
