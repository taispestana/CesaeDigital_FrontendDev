package FichaPratica03;

import java.util.Scanner;

public class Ex09 {
    public static void main(String[] args) {

        //Importar o Scanner - Leitura do Teclado
        Scanner input = new Scanner(System.in);

        //Declarar a variavel
        int num, soma=0,contador=0;
        double media;


        System.out.println("Introduza numeros (digite -1 para terminar): ");
        while(true){
            System.out.println("Numero: ");
            num=input.nextInt();

            if (num == -1){
                break;
            }
            soma += num;
            contador++;
        }

        if (contador >0){
            media = (double) soma / contador;
            System.out.printf("A media dos numeros introduzidos é: %.2f\n", media);
        }else {
            System.out.println("Nenhum numero valido foi introduzido.");
        }
    }
}
