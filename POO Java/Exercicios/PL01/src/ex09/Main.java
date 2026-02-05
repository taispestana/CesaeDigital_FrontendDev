package ex09;

public class Main {
    public static void main(String[] args) {

        //1. Criar objeto Restaurante
        Restaurante restaurante1 = new Restaurante("Restaurante A", 50);

        //2. Reservar 20 lugares
        restaurante1.reservarMesa(20);
        System.out.println("Lugares ocupados atualmente: " + restaurante1.getLugaresOcupados());

        //3. Liberar 5 lugares
        restaurante1.libertarMesa(5);
        System.out.println("Lugares ocupados após saída: " + restaurante1.getLugaresOcupados());

        //4. Tentar reservar 40 lugares (deve falhar)
        restaurante1.reservarMesa(40);
        System.out.println("Lugares ocupados no final: " + restaurante1.getLugaresOcupados());
    }
}