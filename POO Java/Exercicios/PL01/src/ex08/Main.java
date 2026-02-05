package ex08;

public class Main {

    public static void main(String[] args) {

        //1. Criar objeto ContaBancaria
        ContaBancaria conta1 = new ContaBancaria("Mário Amorim", "PT50 0001 0002 0003");

        System.out.println("Titular: " + conta1.getTitular());
        System.out.println("Saldo inicial: " + conta1.getSaldo() + " euros");
        System.out.println("Estado inicial: " + conta1.estadoConta());

        System.out.println("------------------------------");

        //2. Fazer depósito de 1000 euros
        conta1.depositar(1000);

        //3. Mostrar saldo e estado atual
        System.out.println("Saldo atual: " + conta1.getSaldo() + " euros");
        System.out.println("Estado atual: " + conta1.estadoConta());

        //4. Tentar depósito de valor negativo
        conta1.depositar(-500);

    }

}