package ex03;

public class ArrayNomes {
    
    public static void main(String[] args) {
        String[] nomes = {"Ana", "Bruno", "Carlos", "Diana", "Eduardo"};

        //imprimir primeiro nome
        System.out.println("Primeiro nome: " + nomes[0]);

        //imprimir último nome
        System.out.println("Último nome: " + nomes[nomes.length - 1]);

        //imprimir tamanho da string do segundo nome
        System.out.println("Tamanho do segundo nome: " + nomes[1].length());

    }
}
