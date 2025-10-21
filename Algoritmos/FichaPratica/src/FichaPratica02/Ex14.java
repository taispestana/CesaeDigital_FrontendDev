package FichaPratica02;

import java.util.Scanner;

public class Ex14 {
    public static void main(String[] args) {

        //Importar o Scanner - Leitura do Teclado
        Scanner input = new Scanner(System.in);

        //Declarar as variaveis
        int a, b, c;

        //Ler numeros
        System.out.println("Insira o 1o numero: ");
        a = input.nextInt();
        System.out.println("Insira o 2o numero: ");
        b = input.nextInt();
        System.out.println("Insira o 3o numero: ");
        c = input.nextInt();


        if(a<b && a<c){ //a...
            if (b<c){ //a b c
                System.out.println(a + " " + b + " " + c);
            }else{// a c b
                System.out.println(a + " " + c + " " + b);
            }
        }

        if(b<a && b<c){ //b...
            if (a<c){ //b a c
                System.out.println(b + " " + a + " " + c);
            }else{// b c a
                System.out.println(b + " " + c + " " + a);
            }
        }

        if(c<a && c<b){ //c...
            if (a<b){ //c a b
                System.out.println(c + " " + a + " " + b);
            }else{// c b a
                System.out.println(c + " " + b + " " + a);
            }
        }
    }
}
