package ex02;

public class Converter {
    
    public static void main(String[] args) {
        
        double preco = 19.99;

        // Converter o preço de double para int
        int precoInteiro = (int) preco;

        System.out.println("O preço em inteiro é: " + precoInteiro);

        System.out.println("Preço arredondado: " + Math.round(preco));
    }
}
