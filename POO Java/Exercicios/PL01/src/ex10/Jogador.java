package ex10;

public class Jogador {

    // Atributos
    private String nome;
    private int pontos;;
    private int nivel;
    private String equipa;

    // Construtor
    public Jogador(String nome, String equipa) {
        this.nome = nome;
        this.equipa = equipa;
        this.pontos = 0;
        this.nivel = 0;
    }

    // Método para ganhar pontos
    public void ganharPontos(int quantidade) {
        if (quantidade > 0) {
            this.pontos += quantidade;
            this.nivel = this.pontos / 100;
            
            System.out.println("Jogador " + nome + " ganhou " + quantidade + " pontos. Total: " + pontos + " pontos, Nível: " + nivel);
        }
    }

    // Método para mostrar estatísticas
    public void mostrarEstatisticas() {
        System.out.println("Estatísticas do Jogador:");
        System.out.println("   > Nome: " + nome);
        System.out.println("   > Equipa: " + equipa);
        System.out.println("   > Pontos Totais: " + pontos);
        System.out.println("   > Nível: " + nivel);
    }


    // Getters
    public String getNome() {
        return nome;
    }

    public String getEquipa() {
        return equipa;
    }

    public int getNivel() {
        return nivel;
    }

    public int getPontos() {
        return pontos;
    }
}