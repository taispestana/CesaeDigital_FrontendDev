/**
 * Classe UnidadeCurricular
 * * Representa uma disciplina ou módulo no sistema do CESAE Digital.
 * * @author [Taís Pestana]
 * @version 1.0
 */
public class UnidadeCurricular {
    // ========== ATRIBUTOS PRIVADOS ==========
    private String nome;
    private String codigo;
    private int cargaHoraria;
    private Professor professor;

    // ========== CONSTRUTOR ==========
    /**
     * Construtor da Unidade Curricular.
     * * @param nome          Nome da UC (ex: Programação Orientada a Objetos)
     * @param codigo        Código identificador (ex: POO-101)
     * @param cargaHoraria  Total de horas da disciplina
     */
    public UnidadeCurricular(String nome, String codigo, int cargaHoraria) {
        this.nome = nome;
        this.codigo = codigo;
        setCargaHoraria(cargaHoraria); // Validação via setter
    }

    // ========== MÉTODOS ESPECÍFICOS ==========

    /**
     * Exibe as informações básicas da UC na consola.
     */
    public void exibirInformacoes() {
        System.out.println("UC: " + nome + " [" + codigo + "]");
        System.out.println("Carga Horária: " + cargaHoraria + "h");
        if (professor != null) {
            System.out.println("Professor Responsável: " + professor.getNome());
        } else {
            System.out.println("Professor: Pendente de atribuição.");
        }
    }

    // ========== GETTERS E SETTERS ==========

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    /**
     * Define a carga horária, garantindo que seja um valor positivo.
     */
    public void setCargaHoraria(int cargaHoraria) {
        if (cargaHoraria > 0) {
            this.cargaHoraria = cargaHoraria;
        } else {
            System.out.println("Erro: A carga horária deve ser superior a zero.");
            this.cargaHoraria = 1; // Valor mínimo padrão
        }
    }

    public Professor getProfessor() {
        return professor;
    }

    /**
     * Associa um professor responsável à UC.
     */
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return nome + " (" + codigo + ")";
    }
}