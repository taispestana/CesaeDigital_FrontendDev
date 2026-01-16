package ex02;

public class TabuadaInput {
    public static void main(String[] args) {
        // Cria um objeto Scanner para ler a entrada do usuário
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        
        System.out.print("Digite um número para ver a tabuada: ");
        int numero = scanner.nextInt();
        
        System.out.println("Tabuada do " + numero + ":");
        // Loop para multiplicar o número atual por 1 a 10
        for (int j = 1; j <= 10; j++) {
            System.out.println(numero + " x " + j + " = " + (numero * j));
        }
        
        // Fecha o scanner
        scanner.close();
    }

}
