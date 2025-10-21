package FichaPratica02;

import java.util.Scanner;

public class Ex07 {
    public static void main(String[] args) {
        //Importar o Scanner - Leitura do Teclado
        Scanner input = new Scanner(System.in);

        //Declarar as variaveis
        double numero;

        //Ler numero
        System.out.println("Insira um numero: ");
        numero = input.nextDouble();

        if(numero %2 == 0){
            System.out.println("O numero inserido é par!");
        }else{
            System.out.println("O numero inserido é impar!");
        }
    }
}
