package ex02;

public class Tabuada {
    public static void main(String[] args) {
        // Cria um objeto Scanner para ler a entrada do usuário      
        System.out.println("Tabuada de 1 a 10:");

        // Loop para os números de 1 a 10
        for (int numero = 1; numero <= 10; numero++) {
            System.out.println("Tabuada do " + numero + ":");
            // Loop para multiplicar o número atual por 1 a 10
            for (int j = 1; j <= 10; j++) {
                System.out.println(numero + " x " + j + " = " + (numero * j));
            }
            System.out.println(); // Linha em branco para separar as tabuadas
        }
    }
}
