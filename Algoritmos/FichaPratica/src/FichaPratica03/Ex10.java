package FichaPratica03;

import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args) {

        //Importar o Scanner - Leitura do Teclado
        Scanner input = new Scanner(System.in);

        //Declarar a variavel
        int num;

        //Ler numero
        System.out.println("Digite um número inteiro maior que 2: ");
        num = input.nextInt();

        int i = 2; //começa com o primeiro numero par
        while (i <= num) {
            System.out.println(i);
            i += 2; //incrementa de 2 em 2 para obter apenas numeros pares
        }
    }
}
