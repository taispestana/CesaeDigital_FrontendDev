import java.util.ArrayList;

/**
 * Classe Professor
 * * Representa um docente no sistema do CESAE Digital.
 * Estende a classe abstrata Pessoa.
 * * @author [Taís Pestana]
 */
public class Professor extends Pessoa {
    // ========== ATRIBUTOS ESTÁTICOS ==========
    private static int contadorProfessores = 5000; // IDs de professores começam em 5000

    // ========== ATRIBUTOS PRIVADOS ==========
    private int numeroProfessor;
    private String especialidade;
    private double salario;
    private ArrayList<UnidadeCurricular> unidadesCurriculares;

    // ========== CONSTRUTOR ==========
    public Professor(String nome, String email, String telefone, int idade, String especialidade, double salario) {
        super(nome, email, telefone, idade);
        
        // Geração automática do número do professor
        this.numeroProfessor = ++contadorProfessores;
        
        this.especialidade = especialidade;
        setSalario(salario); // Usa o setter para validação
        this.unidadesCurriculares = new ArrayList<>();
    }

    // ========== MÉTODOS DE GESTÃO DE UCs ==========

    /**
     * Adiciona uma UC ao professor.
     * Limite máximo de 5 UCs por professor.
     */
    public void adicionarUC(UnidadeCurricular uc) {
        if (uc == null) return;

        if (unidadesCurriculares.size() >= 5) {
            System.out.println("Erro: O professor " + getNome() + " já atingiu o limite máximo de 5 UCs.");
        } else if (unidadesCurriculares.contains(uc)) {
            System.out.println("Aviso: Esta UC já está associada a este professor.");
        } else {
            unidadesCurriculares.add(uc);
            System.out.println("Sucesso: UC " + uc.getNome() + " associada ao professor " + getNome());
        }
    }

    /**
     * Remove uma UC da lista do professor.
     */
    public void removerUC(UnidadeCurricular uc) {
        if (unidadesCurriculares.remove(uc)) {
            System.out.println("Sucesso: UC removida da lista do professor.");
        } else {
            System.out.println("Erro: UC não encontrada na lista deste professor.");
        }
    }

    /**
     * Lista todas as UCs que o professor leciona.
     */
    public void listarUCs() {
        System.out.println("UCs lecionadas pelo Prof. " + getNome() + ":");
        if (unidadesCurriculares.isEmpty()) {
            System.out.println("- Nenhuma UC atribuída.");
        } else {
            for (UnidadeCurricular uc : unidadesCurriculares) {
                System.out.println("- " + uc.getNome());
            }
        }
    }

    // ========== IMPLEMENTAÇÃO DO MÉTODO ABSTRACTO ==========

    @Override
    public void mostrarDetalhes() {
        System.out.println("===== DETALHES DO PROFESSOR =====");
        System.out.println("ID Professor: " + numeroProfessor);
        System.out.println(super.toString());
        System.out.println("Especialidade: " + especialidade);
        System.out.printf("Salário Mensal: %.2f€%n", salario);
        listarUCs();
        System.out.println("--------------------------------");
    }

    // ========== GETTERS E SETTERS ==========

    public int getNumeroProfessor() {
        return numeroProfessor;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario >= 0) {
            this.salario = salario;
        } else {
            System.out.println("Erro: O salário não pode ser negativo.");
            this.salario = 0;
        }
    }

    public ArrayList<UnidadeCurricular> getUnidadesCurriculares() {
        return new ArrayList<>(unidadesCurriculares);
    }
}