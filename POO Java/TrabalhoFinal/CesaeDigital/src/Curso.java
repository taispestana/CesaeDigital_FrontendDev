import java.util.ArrayList;

/**
 * Classe Curso
 * Representa a estrutura macro de um curso no sistema.
 * * @author [Taís Pestana]
 */
public class Curso {
    // ========== ATRIBUTOS PRIVADOS ==========
    private String nome;
    private TipoCurso tipo;
    private int duracaoMeses;
    private ArrayList<Turma> turmas;
    private ArrayList<UnidadeCurricular> unidadesCurriculares;

    // ========== CONSTRUTOR ==========
    public Curso(String nome, TipoCurso tipo, int duracaoMeses) {
        this.nome = nome;
        this.tipo = tipo;
        setDuracaoMeses(duracaoMeses);
        this.turmas = new ArrayList<>();
        this.unidadesCurriculares = new ArrayList<>();
    }

    // ========== MÉTODOS DE GESTÃO ==========

    /**
     * Adiciona uma turma à lista do curso.
     */
    public void adicionarTurma(Turma turma) {
        if (turma != null && !turmas.contains(turma)) {
            turmas.add(turma);
        }
    }

    /**
     * Adiciona uma Unidade Curricular ao plano curricular do curso.
     */
    public void adicionarUC(UnidadeCurricular uc) {
        if (uc != null && !unidadesCurriculares.contains(uc)) {
            unidadesCurriculares.add(uc);
        }
    }

    /**
     * Lista todas as turmas associadas a este curso.
     */
    public void listarTurmas() {
        System.out.println("Turmas do Curso " + nome + ":");
        if (turmas.isEmpty()) {
            System.out.println("- Nenhuma turma registada.");
        } else {
            for (Turma t : turmas) {
                System.out.println("- " + t.getNome() + " (Capacidade: " + t.getCapacidadeMaxima() + ")");
            }
        }
    }

    /**
     * Apresenta toda a informação detalhada do curso, incluindo o plano de estudos.
     */
    public void mostrarDetalhes() {
        System.out.println("\n========================================");
        System.out.println("DETALHES DO CURSO: " + nome.toUpperCase());
        System.out.println("Tipo: " + tipo);
        System.out.println("Duração: " + duracaoMeses + " meses");
        System.out.println("----------------------------------------");
        
        System.out.println("PLANO CURRICULAR (UCs):");
        if (unidadesCurriculares.isEmpty()) {
            System.out.println("- Nenhuma UC definida.");
        } else {
            for (UnidadeCurricular uc : unidadesCurriculares) {
                System.out.println("  > " + uc.getNome() + " (" + uc.getCargaHoraria() + "h)");
            }
        }
        
        System.out.println("----------------------------------------");
        listarTurmas();
        System.out.println("========================================\n");
    }

    // ========== GETTERS E SETTERS ==========

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public TipoCurso getTipo() { return tipo; }
    public void setTipo(TipoCurso tipo) { this.tipo = tipo; }

    public int getDuracaoMeses() { return duracaoMeses; }

    public void setDuracaoMeses(int duracaoMeses) {
        if (duracaoMeses > 0) {
            this.duracaoMeses = duracaoMeses;
        } else {
            System.out.println("Erro: Duração deve ser positiva.");
            this.duracaoMeses = 1;
        }
    }

    public ArrayList<Turma> getTurmas() { return new ArrayList<>(turmas); }
    public ArrayList<UnidadeCurricular> getUnidadesCurriculares() { return new ArrayList<>(unidadesCurriculares); }
}