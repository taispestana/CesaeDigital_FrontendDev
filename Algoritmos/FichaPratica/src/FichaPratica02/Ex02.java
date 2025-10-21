package FichaPratica02;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {

        //Importar o Scanner - Leitura do Teclado
        Scanner input = new Scanner(System.in);

        //Declarar as variaves
        double salario, taxa;

        //Ler salario anual
        System.out.println("Introduza o salario anual: ");
        salario = input.nextDouble();

        if(salario <= 15000){
            taxa = salario * 0.2;
            System.out.println("Paga taxa de 20%: "+ taxa + " €");
        }else {
            taxa = salario * 0.3;
            System.out.println("Paga taxa de 30%: " + taxa + " €");
        }

    }
}
