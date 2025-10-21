package FichaPratica03;

import java.util.Scanner;

public class Ex04_v2 {
    static void main(String[] args) {

        //Importar o Scanner - Leitura do Teclado
        Scanner input = new Scanner(System.in);

        //Declarar a variavel
        int num;

        //Ler numero
        System.out.println("Introduza um número: ");
        num=input.nextInt();

        for (int i = 0; i <= num; i ++){
            System.out.println(i);
        }
    }
}
