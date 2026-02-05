package ex05;

public class Telemovel {

    // Atributos Privados
    private String marca;
    private String modelo;
    private int bateria;
    private boolean ligado;

    // Construtor telemovel com parâmetros para inicializar os atributos
    public Telemovel(String marca, String modelo, int bateria) {
        this.marca = marca;
        this.modelo = modelo;
    
        if (bateria > 100) {
            this.bateria = 100;
        } else if(bateria < 0) {
            this.bateria = 0;
        } else {
            this.bateria = bateria;
        }
        this.ligado = false; 
    }

    // Método para ligar o telemóvel
    public void ligar() {
        if (bateria > 0) {
            ligado = true;
            System.out.println(marca + " " + modelo + " ligado com sucesso (" + bateria + "% de bateria).");
        } else {
            System.out.println("Não é possível ligar o " + marca + " " + modelo + ": Bateria a 0%.");
        }
    }

    // Método para desligar o telemóvel
    public void desligar() {
        if (!ligado) {
            System.out.println("O " + marca + " " + modelo + " já está desligado.");
        } else {
            ligado = false;
            System.out.println(marca + " " + modelo + " desligado com sucesso.");
        }
    }

    
    //Simula o uso do telemóvel, consumindo bateria
    //Consome 1% de baeria por cada 10 minuto de uso
    
    public void usarTelemovel(int minutos) {
         if (!ligado) {
            System.out.println("O " + marca + " " + modelo + " está desligado.");
            return;
        }

        // Calcular o consumo de bateria com base nos minutos usados
        int consumo = minutos / 10;

        if (consumo == 0 && minutos > 0) {
            System.out.println(marca + " " + modelo + " foi usado por " + minutos + " minutos e não consumiu bateria.");
            return;
        }

        // Reduzir a bateria com base no consumo calculado
        bateria -= consumo;
        if (bateria <= 0) {
            bateria = 0;
            ligado = false;
            System.out.println(marca + " " + modelo + " usado por " + minutos + " minutos. Bateria esgotada. O telemóvel desligou-se.");
        } else {
            System.out.println(marca + " " + modelo + " usado por " + minutos + " minutos. Bateria atual: " + bateria + "%.");
        }
    }


    // Getters para os atributos privados
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getBateria() {
        return bateria;
    }

    public boolean isLigado() {
        return ligado;
    }
    
}