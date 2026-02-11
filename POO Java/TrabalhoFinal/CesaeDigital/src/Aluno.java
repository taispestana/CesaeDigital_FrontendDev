import java.util.ArrayList;

/**
 * Classe Aluno
 * * Representa um estudante no sistema. Herda de Pessoa.
 */
public class Aluno extends Pessoa {
    // ========== ATRIBUTOS ESTÁTICOS ==========
    private static int contadorAlunos = 1000; // Inicia a contagem em 1000

    // ========== ATRIBUTOS PRIVADOS ==========
    private int numeroAluno;
    private Turma turma;
    private ArrayList<Double> notas;
    private EstadoAluno estado;

    // ========== CONSTRUTORES ==========
    /**
     * Construtor completo da classe Aluno.
     */
    public Aluno(String nome, String email, String telefone, int idade, Turma turma, EstadoAluno estado) {
        super(nome, email, telefone, idade); // Chama o construtor da classe Pessoa

        // Geração automática do número do aluno
        this.numeroAluno = ++contadorAlunos;

        this.turma = turma;
        this.estado = estado;
        this.notas = new ArrayList<>(); // Inicializa a lista de notas vazia
    }

    /**
     * Construtor simplificado da classe Aluno (sobrecarga).
     * Útil quando o aluno é registado sem uma turma inicial.
     */
    public Aluno(String nome, String email, String telefone, int idade) {
        // Chama o construtor completo com valores padrão para turma e estado
        this(nome, email, telefone, idade, null, EstadoAluno.ATIVO);
    }

    // ========== MÉTODOS ESPECÍFICOS ==========

    /**
     * Adiciona uma nota à lista do aluno.
     * Valida se a nota está entre 0 e 20.
     */
    public void adicionarNota(double nota) {
        if (nota >= 0 && nota <= 20) {
            this.notas.add(nota);
        } else {
            System.out.println("Erro: Nota " + nota + " inválida. Deve estar entre 0 e 20.");
        }
    }

    /**
     * Calcula a média aritmética das notas.
     * 
     * @return A média ou 0.0 se não houver notas.
     */
    public double calcularMedia() {
        if (notas.isEmpty()) {
            return 0.0;
        }

        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma / notas.size();
    }

    // ========== IMPLEMENTAÇÃO DO MÉTODO ABSTRACTO ==========

    @Override
    public void mostrarDetalhes() {
        System.out.println("===== DETALHES DO ALUNO =====");
        System.out.println("ID Aluno: " + numeroAluno);
        System.out.println(super.toString()); // Chama o toString da classe Pessoa
        System.out.println("Turma: " + (turma != null ? turma.getNome() : "Sem turma"));
        System.out.println("Estado: " + estado);
        System.out.printf("Média Atual: %.2f%n", calcularMedia());
        System.out.println("----------------------------");
    }

    // ========== GETTERS E SETTERS ==========

    public int getNumeroAluno() {
        return numeroAluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public ArrayList<Double> getNotas() {
        return new ArrayList<>(notas); // Retorna uma cópia por segurança
    }

    public EstadoAluno getEstado() {
        return estado;
    }

    public void setEstado(EstadoAluno estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return getNome();
    }
}