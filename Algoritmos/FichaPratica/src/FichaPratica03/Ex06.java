package FichaPratica03;

import java.util.Scanner;

public class Ex06 {
    public static void main(String[] args) {

        //Importar o Scanner - Leitura do Teclado
        Scanner input = new Scanner(System.in);

        //Declarar as variaveis
        int num1, num2;

        //Ler numeros
        System.out.println("Introduza um número de inicio: ");
        num1=input.nextInt();
        System.out.println("Introduza um número de final: ");
        num2=input.nextInt();

        for (int i=num1; i<=num2; i++){
            System.out.println(i);
        }
    }
}
