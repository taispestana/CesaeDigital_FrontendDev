package FichaPratica03;

import java.util.Scanner;

public class Ex07 {
    public static void main(String[] args) {

        int soma = 0;

        for (int i=1; i<=100;i++){
            System.out.println(i);
            soma += i;
        }
        System.out.println("Somatorio: " + soma);
    }
}
