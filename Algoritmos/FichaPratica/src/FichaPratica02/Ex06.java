package FichaPratica02;

import java.util.Scanner;

public class Ex06 {
    public static void main(String[] args) {
        //Importar o Scanner - Leitura do Teclado
        Scanner input = new Scanner(System.in);

        //Declarar as variaveis
        int numero1, numero2;

        //Ler valores numericos
        System.out.println("Introduza um numero: ");
        numero1 = input.nextInt();
        System.out.println("Introduza um numero: ");
        numero2 = input.nextInt();

        if(numero2 > numero1){
            System.out.println(numero2 + " " + numero1);
        }else{
            System.out.println(numero1+ " " +numero2);
        }
    }
}
