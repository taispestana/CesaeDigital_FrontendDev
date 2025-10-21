package FichaPratica02;

import java.util.Scanner;

public class Ex10_v2 {
    public static void main(String[] args) {
        //Importar o Scanner - Leitura do Teclado
        Scanner input = new Scanner(System.in);

        //Declarar as variaveis
        double num1, num2, resultado;
        String operacao;

        //Ler numeros
        System.out.println("Introduza o 1o numero: ");
        num1 = input.nextDouble();
        System.out.println("Introduza o 2o numero: ");
        num2 = input.nextDouble();

        System.out.println("Qual operação aritmética que quer realizar (+, -, * ou /)");
        operacao = input.next();


        switch (operacao) {
            case "+":
                resultado = num1 + num2;
                System.out.println("A soma de " + num1 + " e " + num2 + " é: " + resultado);
                break;
            case "-":
                resultado = num1 - num2;
                System.out.println("A subtracao de " + num1 + " e " + num2 + " é: " + resultado);
                break;
            case "*":
                resultado = num1 * num2;
                System.out.println("A multiplicacao de " + num1 + " e " + num2 + " é: " + resultado);
                break;
            case "/":
                if (num2 != 0) {
                    resultado = num1 / num2;
                    System.out.println("A divisao de " + num1 + " e " + num2 + " é: " + resultado);
                } else {
                    System.out.println("Erro: Divisao por zero nao é permitida.");
                }
                break;
            default:
                System.out.println("Erro: Operador inválido. Use apenas +, -, *, ou /");
                break;
        }
    }
}
