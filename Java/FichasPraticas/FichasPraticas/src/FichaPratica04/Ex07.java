package FichaPratica04;

import java.util.Scanner;

public class Ex07 {
    public static void main(String[] args){

        //7. Encontre o maior número par inserido num array de 10 posições.
        //• O programa deverá solicitar ao utilizador que insira 10 números num array.
        //• Em seguida, o programa deve determinar e apresentar o maior número par inserido.
        //• Se não houver números pares, o programa deverá informar o utilizador.

        //Pedir ao utilizador
        Scanner input = new Scanner(System.in);

        //Criar array com 10 gavetas
        int[] gavetas = new int[10];
        Integer maiorPar = null;

        //Criar um  ciclo para preencher os valores nas gavetas
        for (int i = 0; i < gavetas.length; i++) {
            System.out.print("Insira um valor na gaveta [" + i + "]:");
            gavetas[i] = input.nextInt();
        }

        // Procurar o maior número par
        for (int i = 0; i < gavetas.length; i++) {
            if (gavetas[i] % 2 == 0) { // se for par
                if (maiorPar == null || gavetas[i] > maiorPar) {
                    maiorPar = gavetas[i];
                }
            }
        }

        // Mostrar o resultado
        if (maiorPar != null) {
            System.out.println("O maior número par inserido foi: " + maiorPar);
        } else {
            System.out.println("Não foi inserido nenhum número par.");
        }

        input.close();
    }
}
