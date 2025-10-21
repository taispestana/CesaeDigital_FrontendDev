package FichaPratica02;

import java.util.Scanner;

public class Ex12 {
    public static void main(String[] args) {

        //Importar o Scanner - Leitura do Teclado
        Scanner input = new Scanner(System.in);

        //Declarar as variaveis
        int opcoes;

        //Ler opcoes
        System.out.println("Opcoes do menu: 1.Criar 2.Atualizar 3.~Eliminar 4.Sair");
        opcoes=input.nextInt();

        switch (opcoes){
            case 1:
                System.out.println("Opcao de Criar selecionada.");
                break;
            case 2:
                System.out.println("Opcao de Atualizar selecionada");
                break;
            case 3:
                System.out.println("Opcao de Eliminar selecionada");
                break;
            case 4:
                break;
            default:
                System.out.println("Erro: Opcao inválida.");
                break;
        }
        }
    }

