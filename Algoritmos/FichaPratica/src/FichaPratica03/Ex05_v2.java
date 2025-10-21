package FichaPratica03;

import java.util.Scanner;

public class Ex05_v2 {
    public static void main(String[] args) {

        //Importar o Scanner - Leitura do Teclado
        Scanner input = new Scanner(System.in);

        //Declarar as variaveis
        int num;
        String mensagem;

        //Ler numero
        System.out.println("Introduza um número: ");
        num=input.nextInt();

        //Ler mensagem
        System.out.println("Introduza uma mensagem: ");
        input.nextLine(); //Limpeza de buffer
        mensagem= input.nextLine();

       for (int i = 0; i <num; i++){
           System.out.println(mensagem);
       }
    }
}
