package FichaPratica02;

import java.util.Scanner;

public class Ex11 {
    public static void main(String[] args) {
        //Importar o Scanner - Leitura do Teclado
        Scanner input = new Scanner(System.in);

        //Declarar as variaveis
        double saldoMedio, valorMovimentar, saldoAtual;

        //Ler saldo
        System.out.println("Introduza o saldo médio: ");
        saldoMedio = input.nextDouble();

        //Ler movimento
        System.out.println("Introduza o valor a movimentar (+ ou -): ");
        valorMovimentar = input.nextDouble();

        saldoAtual = saldoMedio + valorMovimentar;
        if (saldoAtual >= 0) {
            System.out.println("Saldo Atual: " + saldoAtual);
        }else {
            System.out.println("Operacao invalida. Saldo insuficiente.");
        }
        }

    }

