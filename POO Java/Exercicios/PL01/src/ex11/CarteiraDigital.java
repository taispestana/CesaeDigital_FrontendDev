package ex11;

public class CarteiraDigital {

    // Atributos Privados
    private String proprietario;
    private double saldo;
    private String moeda;
    private boolean ativa;

    // Construtor
    public CarteiraDigital(String proprietario, double saldo, String moeda, boolean ativa) {
        this.proprietario = proprietario;
        this.saldo = saldo;
        this.moeda = moeda;
        this.ativa = ativa;
    }

    // Método para enviar dinheiro para outra carteira digital
    public void enviarDinheiro(double valor, CarteiraDigital carteiraDestino) {

        // Verificar se a carteira de origem está ativa
        if (!this.ativa) {
            System.out.println("Erro: A carteira de " + this.proprietario + " não está ativa.");
        } else if (!carteiraDestino.ativa) {
            System.out.println("Erro: A carteira de " + carteiraDestino.proprietario + " não está ativa.");
        } else if (!this.moeda.equals(carteiraDestino.moeda)) {

            // Verificar se ambas as carteiras usam a mesma moeda
            System.out.println("Erro: As carteiras usam moedas diferentes (" + this.moeda + " e " + carteiraDestino.moeda + ").");
        } else if (valor <= 0) {

            // Verificar se o valor é positivo
            System.out.println("Erro: O valor a enviar deve ser positivo.");
        } else if (this.saldo < valor) {

            // Verificar se há saldo suficiente
            System.out.println("Erro: Saldo insuficiente. Saldo disponível: " + this.saldo + " " + this.moeda);
        } else {

            // Realizar a transferência
            this.saldo -= valor;
            carteiraDestino.saldo += valor;
            System.out.println("Transferência de " + valor + " " + this.moeda + " de " + this.proprietario + " para " + carteiraDestino.proprietario + " realizada com sucesso.");
        }
    }

    // Método para adicionar saldo à carteira
    public void adicionarSaldo(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("Adicionado " + valor + " " + this.moeda + " à carteira de " + this.proprietario + ".");
        } else {
            System.out.println("Erro: O valor a adicionar deve ser positivo.");
        }
    }

    // Método para gastar dinheiro da carteira
    public void gastar(double valor) {

        // Verificar se o valor é positivo
        if (valor <= 0) {
            System.out.println("Erro: O valor a gastar deve ser positivo.");
            return;
        }

        // Verificar se há saldo suficiente
        if (this.saldo >= valor) {
            this.saldo -= valor;
            System.out.println("Gasto de " + valor + " " + this.moeda + " realizado com sucesso.");
        } else {
            System.out.println("Erro: Saldo insuficiente para gastar " + valor + " " + this.moeda + ". Saldo disponível: " + this.saldo + " " + this.moeda);
        }
    }

    // Método para consultar o saldo da carteira
    public void consultarSaldo() {
        System.out.println("Carteira de " + this.proprietario + ": " + String.format("%.2f", this.saldo) + " " + this.moeda);
    }

    // Getters
    public String getProprietario() {
        return proprietario;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getMoeda() {
        return moeda;
    }

    public boolean isAtiva() {
        return ativa;
    }

    // Setters
    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }
}