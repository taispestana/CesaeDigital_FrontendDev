package ex03;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        // Cria um objeto Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            
            // Exibe o menu e lê a opção escolhida
            System.out.println("------ Menu ------");
            System.out.println("1. Opção 1");
            System.out.println("2. Opção 2");
            System.out.println("3. Opção 3");
            System.out.println("0. Sair");

            // Solicita ao usuário que escolha uma opção
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            // Verifica a opção escolhida e executa a ação correspondente
            switch (opcao) {
                case 1:
                    System.out.println("Executando Opção 1...");
                    break;
                case 2:
                    System.out.println("Executando Opção 2...");
                    break;
                case 3:
                    System.out.println("Executando Opção 3...");
                    break;
                case 0:
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        // Fecha o scanner
        scanner.close();
    }
}