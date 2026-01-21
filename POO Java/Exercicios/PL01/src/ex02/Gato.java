package ex02;

public class Gato {

    //Atributos privados da classe Gato
    private String nome, corPelo, som;

    /**
     * Construtor da classe Gato
     * @param nome
     * @param corPelo
     * @param som
     */
    public Gato(String nome, String corPelo, String som) {
        this.nome = nome;
        this.corPelo = corPelo;
        this.som = "Miau";
    }

    // Método para emitir o som do gato
    public void miar() {
        System.out.println(nome + " faz o som: " + som);
    }

    //Metodo brincar: imprime uma mensagem indicando que o gato está brincando
    public void brincar() {
        System.out.println(nome + " está brincando!");
    }

    /**
     * Método Getter: retorna o nome do gato
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método Getter: retorna a cor do pelo do gato
     * @return corPelo
     */
    public String getCorPelo() {
        return corPelo;
    }

    /**
     * Método Getter: retorna o som do gato
     * @return som
     */
    public String getSom() {
        return som;
    }

    /**
     * Método Setter: define o som do gato
     * @param som
     */
    public void setSom(String som) {
        this.som = som;
    }
}
