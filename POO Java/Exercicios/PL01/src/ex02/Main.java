package ex02;

public class Main {
    public static void main(String[] args) {
        // Criando objetos da classe Gato
        Gato gato1 = new Gato("Felix", "Preto", "Miau");
        Gato gato2 = new Gato("Garfield", "Laranja", "Miau");

        // Acessando atributos e chamando métodos para o gato1
        System.out.println("Informações do Gato 1:");
        System.out.println("Nome: " + gato1.getNome());
        System.out.println("Cor do Pelo: " + gato1.getCorPelo());
        gato1.miar();
        gato1.brincar();

        System.out.println("\nInformações do Gato 2:");
        System.out.println("Nome: " + gato2.getNome());
        System.out.println("Cor do Pelo: " + gato2.getCorPelo());
        gato2.miar();
        gato2.brincar();

        //Modificar o som do gato 2
        gato2.setSom("Miau miau");
        System.out.println("\nApós modificar o som do Gato 2:");
        gato2.miar();
    }

}
