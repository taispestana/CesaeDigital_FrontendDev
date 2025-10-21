package FichaPratica02;

import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        //Importar o Scanner - Leitura do Teclado
        Scanner input = new Scanner(System.in);

        //Declarar as variaveis
        double salario, taxa;

        //Ler salario
        System.out.println("Insira o salario anual: ");
        salario = input.nextDouble();

        if(salario<=15000) {
            taxa = salario * 0.2;
            System.out.println("Paga taxa de 20%: " + taxa + " €");
        }
            if(salario >15000 && salario<=20000){
                taxa = salario * 0.3;
                System.out.println("Paga taxa de 30%: "+ taxa + " €");
            }if(salario >20000 && salario<=25000){
                taxa = salario * 0.35;
                System.out.println("Paga taxa de 35%: "+ taxa + " €");
            }if(salario > 25000){
                taxa = salario * 0.4;
                System.out.println("Paga taxa de 40%: "+ taxa + " €");
            }
        }

    }

