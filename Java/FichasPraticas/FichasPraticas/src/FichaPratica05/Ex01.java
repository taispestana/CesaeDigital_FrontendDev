package FichaPratica05;

import java.util.Scanner;

public class Ex01 {
    //metodo para fazer o animal emitir um barulho

    public static void fazerBarulho(String animal){

        switch (animal){
            case "cao":
                System.out.println("Au au");
                break;
            case "gato":
                System.out.println("Miauu");
                break;
            case "peixe":
                System.out.println("Glub Glub");
                break;
            case "vaca":
                System.out.println("Muuuu");
                break;
            case "porco":
                System.out.println("Oinc oinc");
            default:
                System.out.println("Animal não reconhecido! Digite novamente");
        }
    }

    public static void main(String[] args) {
        //Pedir ao user o nome do animal
        Scanner input = new Scanner(System.in);

        String animalEscolhido;
        System.out.println("Introduza um animal: ");
        animalEscolhido = input.nextLine();

        //chamar o metodo
        fazerBarulho(animalEscolhido);
    }
}
