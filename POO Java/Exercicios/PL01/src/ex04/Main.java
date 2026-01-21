package ex04;

public class Main {
    
    public static void main(String[] args) {
        // Criando objetos da classe Cilindro
        Cilindro cilindro1 = new Cilindro(5, 10);
        Cilindro cilindro2 = new Cilindro(3.5, 7.2);

        // Calculando e exibindo o volume e a área superficial do cilindro 1
        System.out.println("Cilindro 1:");
        System.out.println("Raio: " + cilindro1.getRaio() + ", Altura: " + cilindro1.getAltura());
        System.out.println("Volume: " + cilindro1.calcularVolume());
        System.out.println("Área Superficial: " + cilindro1.calcularAreaSuperficial());

        System.out.println(); // Linha em branco para separar

        // Calculando e exibindo o volume e a área superficial do cilindro 2
        System.out.println("Cilindro 2:");
        System.out.println("Raio: " + cilindro2.getRaio() + ", Altura: " + cilindro2.getAltura());
        System.out.println("Volume: " + cilindro2.calcularVolume());
        System.out.println("Área Superficial: " + cilindro2.calcularAreaSuperficial());
    }

}
