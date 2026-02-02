package ex12;

public class Jogo {

    // Atributos Privados
    private String titulo;
    private String plataforma;
    private double preco;
    private double horasJogadas;
    private int classificacao;

    // Construtor
    public Jogo(String titulo, String plataforma, double preco) {
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.preco = preco;
        this.horasJogadas = 0;
        this.classificacao = 0;
    }

    // Métodos Públicos
    public void jogar(double horas) {
        if (horas > 0) {
            this.horasJogadas += horas;
            System.out.println("Adicionadas " + horas + " horas ao jogo \"" + this.titulo + "\". Total: " + this.horasJogadas + " horas.");
        } else {
            System.out.println("Erro: O número de horas deve ser positivo.");
        }
    }

    // Método para avaliar o jogo
    public void avaliar(int classificacao) {
        if (classificacao >= 0 && classificacao <= 10) {
            this.classificacao = classificacao;
            System.out.println("Jogo \"" + this.titulo + "\" avaliado com " + classificacao + "/10.");
        } else {
            System.out.println("Erro: A classificação deve estar entre 0 e 10.");
        }
    }

    // Método para calcular o valor por hora jogada
    public String calcularValorPorHora() {
        if (this.horasJogadas > 0) {
            double valorPorHora = this.preco / this.horasJogadas;
            return String.format("%.2f", valorPorHora) + "€/hora";
        } else {
            return "Ainda não jogado";
        }
    }

    // Método para obter valor por hora como número (para comparação)
    public double obterValorPorHoraNumerico() {
        if (this.horasJogadas > 0) {
            return this.preco / this.horasJogadas;
        } else {
            return -1; 
        }
    }

    // Método para mostrar detalhes do jogo
    public void mostrarDetalhes() {
        System.out.println("╔══════════════════════════════════════════════════════════");
        System.out.println("║ DETALHES DO JOGO");
        System.out.println("╠══════════════════════════════════════════════════════════");
        System.out.println("║ Título: " + this.titulo);
        System.out.println("║ Plataforma: " + this.plataforma);
        System.out.println("║ Preço: " + String.format("%.2f", this.preco) + "€");
        System.out.println("║ Horas Jogadas: " + String.format("%.1f", this.horasJogadas) + "h");
        System.out.println("║ Classificação: " + this.classificacao + "/10");
        System.out.println("║ Valor por Hora: " + calcularValorPorHora());
        System.out.println("╚══════════════════════════════════════════════════════════");
    }

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public double getPreco() {
        return preco;
    }

    public double getHorasJogadas() {
        return horasJogadas;
    }

    public int getClassificacao() {
        return classificacao;
    }

    // Setters
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setHorasJogadas(double horasJogadas) {
        this.horasJogadas = horasJogadas;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }
}