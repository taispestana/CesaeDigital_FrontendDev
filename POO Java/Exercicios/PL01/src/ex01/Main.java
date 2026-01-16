package ex01;

public class Main {
    static void main(String[] args) {
        // Criando objetos da classe Aluno
        Aluno aluno1 = new Aluno("João", 12345, 85);
        Aluno aluno2 = new Aluno("Maria", 67890, 92);
        Aluno aluno3 = new Aluno("Pedro", 11223, 76);

        // Exibindo informações dos alunos
        aluno1.exibirInfo();
        aluno2.exibirInfo();
        aluno3.exibirInfo();
    }
    
} 

