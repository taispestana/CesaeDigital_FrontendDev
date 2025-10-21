package FichaPratica03;

public class Ex03 {
    public static void main(String[] args) {
        int num = 531;

        while(num <=750){
            if(num % 2 != 0){
                System.out.println(num);
            }
            num = num + 1;

            //Exemplos iguais a linha acima (segue a mesma logica para subtrair etc)
            //num = num + 1;
            //num += 1;
        }
    }
}
