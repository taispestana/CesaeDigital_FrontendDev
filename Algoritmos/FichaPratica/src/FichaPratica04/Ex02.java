package FichaPratica04;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {

        //Adicione comissões mensais a um array de 12 posições e calcular o total anual.
        //• O programa deverá solicitar ao utilizador 12 valores, cada um representando a comissão mensal para cada mês
        //do ano.
        //• No final, o programa deve calcular e apresentar o total das comissões anuais.

        //Declaracao array e leitura do mesmo
        double[] comissoes = new double[12];
        Scanner scanner = new Scanner(System.in);

        // Ler as comissões mensais
        for (int i = 0; i < 12; i++) {
            System.out.print("Digite a comissão do mês " + (i + 1) + ": ");
            comissoes[i] = scanner.nextDouble();
        }

        // Calcular total anual
        double totalAnual = 0;
        for (int i = 0; i < 12; i++) {
            totalAnual += comissoes[i];
        }

        // Mostrar resultado
        System.out.println("O total de comissões do ano é: " + totalAnual);

        scanner.close();

    }
}
