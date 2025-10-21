package FichaPratica02;

import java.util.Scanner;

public class Ex08 {
    public static void main(String[] args) {
        //Importar o Scanner - Leitura do Teclado
        Scanner input = new Scanner(System.in);

        //Declarar as variaveis
        double nota1, nota2, nota3, media1, media2, media3, mediaTotal;

        //Ler notas
        System.out.println("Introduza a 1o nota (0-20): ");
        nota1 = input.nextDouble();
        System.out.println("Introduza a 2o nota (0-20): ");
        nota2 = input.nextDouble();
        System.out.println("Introduza a 3o nota (0-20): ");
        nota3 = input.nextDouble();

        /*media1 = nota1 * 0.25;
        media2 = nota2 * 0.35;
        media3 = nota3 * 0.40;*/
        mediaTotal = nota1*0.25 + nota2*0.35 + nota3*0.4;

        if(mediaTotal > 9.5){
            System.out.println("O aluno está aprovado!");
        }else {
            System.out.println("O aluno está reprovado!");
        }
    }
}
