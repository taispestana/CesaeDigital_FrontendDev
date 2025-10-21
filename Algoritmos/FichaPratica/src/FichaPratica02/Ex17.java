package FichaPratica02;

import java.util.Scanner;

public class Ex17 {
    public static void main(String[] args) {

        //Importar o Scanner - Leitura do Teclado
        Scanner input = new Scanner(System.in);

        //Declarar as variaveis
        double saldoMedio, credito;

        //Ler saldo medio
        System.out.println("Digite o saldo medio do cliente: ");
        saldoMedio = input.nextDouble();
        credito = 0.0;

        //Calculo do credito com base na tabela
        if(saldoMedio <= 2000){
            credito = 0;
        }else if(saldoMedio <= 4000){
            credito = saldoMedio * 0.2;
        }else if(saldoMedio <= 6000) {
            credito = saldoMedio * 0.3;
        }else {
            credito = saldoMedio * 0.4;
        }

        //Exibicao do resultado
        System.out.printf("\nSaldo médio: €%.2f\n", saldoMedio);
        System.out.printf("Crédito especial concedido: €%.2f\n", credito);
}}
