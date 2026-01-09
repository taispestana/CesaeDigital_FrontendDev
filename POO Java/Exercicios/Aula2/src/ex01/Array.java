package ex01;

public class Array {
    
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};

        int soma = 0;

        for (int i = 0; i < numbers.length; i++) {
            soma = soma + numbers[i];
        }

        System.out.println("A soma dos elementos do array é: " + soma);
    }
}
