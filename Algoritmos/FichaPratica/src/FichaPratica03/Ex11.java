package FichaPratica03;

import java.util.Scanner;

public class Ex11 {
    public static void main(String[] args) {

        //Importar o Scanner - Leitura do Teclado
        Scanner input = new Scanner(System.in);

        //Declarar a variavel
        int limite, salto;

        //Ler limite e salto
        System.out.println("Digite um limite: ");
        limite = input.nextInt();
        System.out.println("Digite um salto: ");
        salto = input.nextInt();

        int inicio = 0; //começa com o primeiro numero par
        while (inicio <= limite) {
            System.out.println(inicio);
            inicio += salto; //incrementa o salto em cada numero
        }
    }
}
