package FichaPratica03;

import java.util.Scanner;

public class Ex08 {
    public static void main(String[] args) {

        //Importar o Scanner - Leitura do Teclado
        Scanner input = new Scanner(System.in);

        //Declarar as variaveis
        int num;

        //Ler numeros
        System.out.println("Introduza um número: ");
        num=input.nextInt();

        for (int i=num-5; i<num; i++){
            System.out.println(i);
        }
        for (int i=num+1; i<=num+5; i++){
            System.out.println(i);
        }

    }
}
