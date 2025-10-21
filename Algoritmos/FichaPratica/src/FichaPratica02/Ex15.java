package FichaPratica02;

import java.util.Arrays;
import java.util.Scanner;

public class Ex15 {
    public static void main(String[] args) {

        //Importar o Scanner - Leitura do Teclado
        Scanner input = new Scanner(System.in);

        //Declarar as variaveis
        int num1, num2, num3,aux;

        //Ler numeros
        System.out.println("Insira o 1o numero: ");
        num1 = input.nextInt();
        System.out.println("Insira o 2o numero: ");
        num2 = input.nextInt();
        System.out.println("Insira o 3o numero: ");
        num3 = input.nextInt();


        if(num1 > num2){
            aux = num1;
            num1 = num2;
            num2 = aux;
        }if(num1 > num3){
            aux = num1;
            num1 = num3;
            num3 = aux;
        }if(num2 > num3){
            aux = num2;
            num2 = num3;
            num3 = aux;
        }

        //Perguntar ordem desejada
        System.out.println("Digite C para ordem crescente e D para ordem decrescente");
        String escolha = input.next();

        switch (escolha){
            case "C":
                System.out.println("Os numeros em ordem crescente: "+ num1 + ", " + num2 + ", " +num3);
break;
            case "D":
                System.out.println("Os numeros em ordem decrescente: "+ num3 + ", " + num2 + ", " + num1);
                break;
        }
    }

}
