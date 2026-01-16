package poo_ex1;

public class main {
    public static void main(String[] args) {
        // Cria um objeto Pessoa
        Pessoa pessoa1 = new Pessoa("João", 25, 1.75);
        Pessoa pessoa2 = new Pessoa("Maria", 30, 1.65);
        Pessoa pessoa3 = new Pessoa("Pedro", 20, 1.80);

        // Exibe as informações da pessoa
        pessoa1.exibirInfo();
        pessoa2.exibirInfo();
        pessoa3.exibirInfo();
    }
}
