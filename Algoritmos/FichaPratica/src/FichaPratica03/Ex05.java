package FichaPratica03;

import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {

        //Importar o Scanner - Leitura do Teclado
        Scanner input = new Scanner(System.in);

        //Declarar as variaveis
        int inicio = 1, limite, salto=1;
        String mensagem;

        //Ler limite
        System.out.println("Quantas vezes quer imprimir a mensagem: ");
        limite= input.nextInt();

        //Ler mensagem
        System.out.println("Introduza uma mensagem: ");
        input.nextLine(); //Limpeza de buffer
        mensagem= input.nextLine();

        while (inicio <=limite){
            System.out.println(mensagem);
            inicio = inicio + salto;
        }
    }
}
