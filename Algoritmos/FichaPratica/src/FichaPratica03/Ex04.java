package FichaPratica03;

import java.util.Scanner;

public class Ex04 {
     public static void main(String[] args) {

         //Importar o Scanner - Leitura do Teclado
         Scanner input = new Scanner(System.in);

         //Declarar as variaveis
         int inicio = 0, fim, salto=1;

         //Ler fim
         System.out.println("Introduza o fim do intervalo: ");
         fim= input.nextInt();

         while (inicio <=fim){
             System.out.println(inicio);
             inicio = inicio + salto;
         }
    }
}
