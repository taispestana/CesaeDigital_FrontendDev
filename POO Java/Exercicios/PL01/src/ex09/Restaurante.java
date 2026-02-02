package ex09;

public class Restaurante {

    // Atributos
    private String nome;
    private int capacidadeMaxima;
    private int lugaresOcupados;

    // Construtor
    public Restaurante (String nome, int capacidadeMaxima) {
        this.nome = nome;
        this.capacidadeMaxima = capacidadeMaxima;
        this.lugaresOcupados = 0;
    }

    // Método para reservar lugares
    public void reservarMesa(int lugares) {
        if (lugaresOcupados + lugares <= capacidadeMaxima) {
            lugaresOcupados += lugares;
            System.out.println("Reserva de " + lugares + " lugares efectuada com sucesso" + "| Capacidade máxima: " + capacidadeMaxima);
        } else {
            System.out.println("Erro: Reserva de " + lugares + " lugares não é possível por lotação esgotada.");
        }
    }

    // Método para libertar lugares
    public void libertarMesa (int lugares) {
        if (lugares <= lugaresOcupados) {
            lugaresOcupados -= lugares;
            System.out.println("Foram libertados " + lugares + " lugares com sucesso");
        } else {
            // Se tentar libertar mais lugares do que os ocupados, reinicia para zero
            lugaresOcupados = 0;
            System.out.println("Aviso: Tentativa de libertar mais lugares do que os ocupados. Contador reiniciado a zero.");
        }
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public int getLugaresOcupados() {
        return lugaresOcupados;
    }
}