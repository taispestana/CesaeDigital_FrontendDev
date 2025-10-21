package FichaPratica04;

import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {

        //Adicione 10 números inteiros a um array e imprimir os valores na ordem de inserção.
        //• O programa deve solicitar ao utilizador que insira 10 números inteiros, um para cada posição do array.
        //• Depois de inseridos os valores, o programa deverá imprimi-los na ordem em que foram introduzidos.

        //Pedir ao utilizador
        Scanner input = new Scanner(System.in);

        //Criar array com 10 gavetas
       int[] gavetas = new int [10];

        //Criar um  ciclo para preencher os valores nas gavetas
        for (int i = 0; i < gavetas.length; i ++){
            System.out.print("Insira um valor na gaveta [" +i+ "]:");
            gavetas[i] = input.nextInt();
        }
        //Ciclo para imprimir os valores guardados na gaveta
        for (int i = 0; i < gavetas.length; i++){
            System.out.println("Na gaveta da posiçao [" +i+ "]" + " tenho o valor de: "+ gavetas[i]);
        }
    }
}
