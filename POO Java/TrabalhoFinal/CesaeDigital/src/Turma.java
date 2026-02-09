import java.util.ArrayList;

/**
 * Classe Turma
 * * Gere as inscrições de alunos e as Unidades Curriculares associadas.
 */
public class Turma {
    // ========== ATRIBUTOS PRIVADOS ==========
    private String nome;
    private int capacidadeMaxima;
    private ArrayList<Aluno> alunos;
    private ArrayList<UnidadeCurricular> unidadesCurriculares;
    private Curso curso;

    // ========== CONSTRUTOR ==========
    public Turma(String nome, int capacidadeMaxima, Curso curso) {
        this.nome = nome;
        this.capacidadeMaxima = capacidadeMaxima;
        this.curso = curso;
        this.alunos = new ArrayList<>();
        this.unidadesCurriculares = new ArrayList<>();
    }

    // ========== MÉTODOS DE GESTÃO DE ALUNOS ==========

    /**
     * Inscreve um aluno se houver vaga e ele não estiver já na lista.
     */
    public void inscreverAluno(Aluno aluno) {
        if (aluno == null) return;

        if (alunos.size() >= capacidadeMaxima) {
            System.out.println("Erro: A turma " + nome + " já atingiu a capacidade máxima.");
        } else if (alunos.contains(aluno)) {
            System.out.println("Aviso: O aluno " + aluno.getNome() + " já está inscrito nesta turma.");
        } else {
            alunos.add(aluno);
            aluno.setTurma(this); // Atualiza a referência da turma no objeto Aluno
            System.out.println("Sucesso: " + aluno.getNome() + " inscrito na turma " + nome);
        }
    }

    /**
     * Remove um aluno da lista.
     */
    public void removerAluno(Aluno aluno) {
        if (alunos.remove(aluno)) {
            aluno.setTurma(null); // Remove a referência da turma no aluno
            System.out.println("Sucesso: Aluno removido da turma " + nome);
        } else {
            System.out.println("Erro: Aluno não encontrado nesta turma.");
        }
    }

    /**
     * Imprime a lista de todos os alunos inscritos.
     */
    public void listarAlunos() {
        System.out.println("\n--- Lista de Alunos da Turma " + nome + " ---");
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno inscrito.");
        } else {
            for (Aluno a : alunos) {
                // Aqui usamos o mostrarDetalhes() que você criou na classe Aluno
                a.mostrarDetalhes();
            }
        }
    }

    // ========== MÉTODOS DE GESTÃO DE UCs ==========

    /**
     * Adiciona uma Unidade Curricular à turma.
     */
    public void adicionarUC(UnidadeCurricular uc) {
        if (uc != null && !unidadesCurriculares.contains(uc)) {
            unidadesCurriculares.add(uc);
        }
    }

    // ========== GETTERS E SETTERS ==========

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getCapacidadeMaxima() { return capacidadeMaxima; }
    
    public ArrayList<Aluno> getAlunos() { return new ArrayList<>(alunos); }

    public Curso getCurso() { return curso; }
    public void setCurso(Curso curso) { this.curso = curso; }
}