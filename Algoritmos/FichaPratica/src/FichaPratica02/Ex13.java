package FichaPratica02;

import java.util.Scanner;

public class Ex13 {
    public static void main(String[] args) {

        //Importar o Scanner - Leitura do Teclado
        Scanner input = new Scanner(System.in);

        //Declarar as variaveis
        int horas, minutos;

        //Ler horas
        System.out.println("Introduza as horas (0-23): ");
        horas = input.nextInt();

        //Ler minutos
        System.out.println("Introduza os minutos (0-59): ");
        minutos = input.nextInt();

        if (horas > 12){
            //PM
            horas = horas - 12;
            System.out.println(horas + ":" +minutos+ "PM");
        }else{
            //AM
            System.out.println(horas + ":" +minutos+ "AM");
        }

    }
}
