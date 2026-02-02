package ex07;

public class Main {
    public static void main(String[] args) {

        //1. Criar dois objetos Filme
        Filme filme1 = new Filme("Inception", "Christopher Nolan", "Sci-Fi", 148, 16);
        Filme filme2 = new Filme("Rei Leão", "Roger Allers", "Animação", 88, 6);


        //2. Mostrar as informações dos filmes
        System.out.println("--- Informação dos Filmes ---");
        filme1.MostrarInformacao();
        System.out.println();
        filme2.MostrarInformacao();
        System.out.println();

        //3. Testar acesso com idade fixa
        System.out.println("--- Teste de Acesso (Idade 10) ---");
        int idadeEspectador = 10;
        System.out.println("Idade do Espectador: " + idadeEspectador + " anos");

        //4. Verificar e imprimir se o espectador pode ver cada filme
        testarAcesso(filme1, idadeEspectador);
        testarAcesso(filme2, idadeEspectador);
    }

    // Método auxiliar para testar o acesso ao filme
    public static void testarAcesso(Filme f, int idade) {
        if (f.podeVerFilme(idade)) {
            System.out.println("Pode ver o filme: " + f.getTitulo());
        } else {
            System.out.println("Não pode ver o filme: " + f.getTitulo() + " Classificação demasiado alta.");
        }
    }
}