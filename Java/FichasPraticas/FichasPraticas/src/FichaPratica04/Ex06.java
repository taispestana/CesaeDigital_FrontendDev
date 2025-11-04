package FichaPratica04;

import java.util.Arrays;
import java.util.Scanner;

public class Ex06 {
    public static void main(String[] args) {

        //Verifique se os elementos de um array de 10 posições estão em ordem crescente.
        //• O programa deverá solicitar ao utilizador que insira 10 números num array.
        //• Em seguida, o programa deve verificar se os números estão organizados em ordem crescente, apresentando
        //uma mensagem com o resultado da verificação.

        //Pedir ao utilizador
        Scanner input = new Scanner(System.in);

        //Criar array com 10 gavetas
        int[] gavetas = new int [10];
        boolean crescente= true;

        //Criar um  ciclo para preencher os valores nas gavetas
        for (int i = 0; i < gavetas.length; i ++){
            System.out.print("Insira um valor na gaveta [" +i+ "]:");
            gavetas[i] = input.nextInt();
        }

        // Verifica se o array está em ordem crescente
        for (int i = 0; i < gavetas.length - 1; i++) {
            if (gavetas[i] > gavetas[i + 1]) {
                crescente = false;
                break; // já pode parar se encontrar uma quebra na ordem
            }
        }

        // Mostra o resultado
        if (crescente) {
            System.out.println("Os números estão em ordem crescente!" + Arrays.toString(gavetas));
        } else {
            System.out.println("Os números NÃO estão em ordem crescente." + Arrays.toString(gavetas));
        }

        input.close();

    }
}
