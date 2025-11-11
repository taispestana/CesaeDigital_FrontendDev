package FichaPratica05;

import java.util.Scanner;

public class Ex02 {
    /**
     * Metodo para pedir ao usuario  um numero de 0 a 100
     * @return numero inteiro positivo
     */
    public static int lerValordoUser(){
        Scanner input = new Scanner(System.in);
        int num;

        do {
            System.out.println("Digite um numero de 0 a 100: ");
            num = input.nextInt();
        }while (num >= 0 || num <= 100);{
            return num;
        }
    }

    /**
     * metodo para imprimir asteriscos
     * @param numero
     */
    public static void imprimirAsteriscos(int numero){

        for (int i = 0; i <= numero; i++){
            System.out.println("*");
        }
    }

    public static void main(String[] args) {
//Implemente uma função que solicite um número inteiro positivo ao utilizador e imprima o número
//correspondente de asteriscos.
//Crie uma função void imprimirAsteriscos(int numero) que receba um número inteiro como argumento.
//A função deve imprimir na mesma linha uma quantidade de asteriscos igual ao número introduzido.
//O programa deve garantir que o número seja positivo:
//o Caso o utilizador introduza um valor negativo ou zero, deve solicitar novamente até que seja um número
//positivo.
//Após a inserção correta, invoque a função que imprime os asteriscos.

        int numInteiro = lerValordoUser();

        imprimirAsteriscos(numInteiro);
    }

}

