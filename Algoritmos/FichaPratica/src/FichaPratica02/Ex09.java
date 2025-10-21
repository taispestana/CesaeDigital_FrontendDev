package FichaPratica02;

import java.util.Scanner;

public class Ex09 {
   public static void main(String[] args) {
        //Importar o Scanner - Leitura do Teclado
        Scanner input = new Scanner(System.in);

        //Declarar as variaveis
        int num1, num2, num3;

        //Ler numeros
        System.out.println("Introduza o 1o numero: ");
        num1 = input.nextInt();
        System.out.println("Introduza o 2o numero: ");
        num2 = input.nextInt();
        System.out.println("Introduza o 3o numero: ");
        num3 = input.nextInt();

        if(num1 < num2 && num1 < num3){
            System.out.println("O numero menor introduzido é: "+ num1);
        }if(num2 < num1 && num2 < num3){
           System.out.println("O numero menor introduzido é: "+ num2);
       }if(num3 < num1 && num3 < num2){
           System.out.println("O numero menor introduzido é: "+ num3);
       }
    }
}
