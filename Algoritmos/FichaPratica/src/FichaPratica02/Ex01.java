package FichaPratica02;

import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        //Importar o Scanner - Leitura do Teclado
        Scanner input = new Scanner(System.in);

        //Declarar as variaveis
        int num1, num2;

        //Ler num1
        System.out.println("Insira 1o número: ");
        num1 = input.nextInt();

        //Ler num2
        System.out.println("Insira 2o número: ");
        num2 = input.nextInt();

        //Imprimir o maior dos dois
        if(num1 > num2){
            //Aqui dentro, o número 1 é o maior
            System.out.println("Maior: "+ num1);
        }else{
            //Aqui dentro, o numero 2 é o maior
            System.out.println("Maior: "+num2);
        }

    }
}
