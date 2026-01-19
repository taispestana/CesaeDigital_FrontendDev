import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameStart {

    public static void main(String[] args) throws FileNotFoundException {
        // Caminho do ficheiro para ser carregado a matriz assim que iniciar do programa
        String[][] matrizVendas = carregarMatriz("resources/GameStart_V2(in).csv");
        Scanner input = new Scanner(System.in);
        String tipoUtilizador;

        // Ciclo para selecionar o utilizador
        do {
            System.out.println("\n********** GameStart **********");
            System.out.print("Tipo de Utilizador (ADMIN | CLIENTE | SAIR): ");
            tipoUtilizador = input.next().toUpperCase();

            if (tipoUtilizador.equals("ADMIN")) {
                // Verificação password para ADMIN
                System.out.print("PASSWORD: ");
                String pass = input.next();
                if (pass.equals("1234")) {
                    menuAdmin(matrizVendas, input);
                } else {
                    System.out.println("Password Incorreta!");
                }
            } else if (tipoUtilizador.equals("CLIENTE")) {
                menuCliente(matrizVendas, input);
            }

        } while (!tipoUtilizador.equals("SAIR"));

        System.out.println("Programa encerrado.");
    }

    /**
     * Método para o Menu do Administrador (ADMIN)
     */
    public static void menuAdmin(String[][] matriz, Scanner input) {
        int opcao;
        do {
            System.out.println("\n--- MENU ADMIN ---");
            System.out.println("1. Exibir Conteúdo do Arquivo");
            System.out.println("2. Total de Vendas e Valor Acumulado");
            System.out.println("3. Lucro Total (20%)");
            System.out.println("4. Pesquisar Cliente por ID");
            System.out.println("5. Jogo mais Caro e Compradores");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    imprimirMatriz(matriz);
                    break;
                case 2:
                    exibirTotais(matriz);
                    break;
                case 3:
                    calcularLucro(matriz);
                    break;
                case 4:
                    pesquisarCliente(matriz, input);
                    break;
                case 5:
                    jogoMaisCaro(matriz);
                    break;
                case 0:
                    System.out.println("A sair do menu Admin...");
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        } while (opcao != 0);
    }

    /**
     * Método para carregar os dados do ficheiro CSV para uma matriz
     */
    public static String[][] carregarMatriz(String caminhoFicheiro) throws FileNotFoundException {
        File ficheiro = new File(caminhoFicheiro);

        // Contagem de linhas para definir o tamanho da matriz (Aula 08) [cite: 8]
        int totalLinhas = 0;
        Scanner leitorContagem = new Scanner(ficheiro);
        while (leitorContagem.hasNextLine()) {
            String linha = leitorContagem.nextLine();
            if (!linha.trim().isEmpty()) {
                totalLinhas++;
            }
        }
        leitorContagem.close();

        // Criar matriz excluindo o cabeçalho (9 colunas conforme o PDF)
        // Se totalLinhas for 0 ou 1, evita criar matriz com tamanho negativo
        if (totalLinhas < 2) {
            return new String[0][9];
        }

        String[][] matriz = new String[totalLinhas - 1][9];
        Scanner leitorDados = new Scanner(ficheiro);

        if (leitorDados.hasNextLine()) {
            leitorDados.nextLine(); // Ignorar cabeçalho
        }

        int linhaAtual = 0;
        while (leitorDados.hasNextLine()) {
            String linha = leitorDados.nextLine();
            if (linha.trim().isEmpty()) {
                continue;
            }

            String[] partes = linha.split(";");
            for (int col = 0; col < partes.length && col < 9; col++) {
                matriz[linhaAtual][col] = partes[col];
            }
            linhaAtual++;
        }
        leitorDados.close();
        return matriz;
    }

    /** Opção Menu 1. Exibir Conteúdo do Arquivo **/
    public static void imprimirMatriz(String[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " | ");
            }
            System.out.println();
        }
    }

    /** Opção Menu 2. Total de Vendas e Valor Acumulado **/
    public static void exibirTotais(String[][] matriz) {
        double totalValor = 0;
        for (int i = 0; i < matriz.length; i++) {
            // A coluna 8 contém o valor do jogo
            totalValor += Double.parseDouble(matriz[i][8]);
        }
        System.out.println("Total de Vendas: " + matriz.length);
        System.out.println("Valor Total Acumulado: " + totalValor + "€");
    }

    /** Opção Menu 3. Lucro Total (20%) **/
    public static void calcularLucro(String[][] matriz) {
        double totalValor = 0;
        for (int i = 0; i < matriz.length; i++) {
            totalValor += Double.parseDouble(matriz[i][8]);
        }
        // Lucro de 20% conforme o enunciado
        double lucro = totalValor * 0.20;
        System.out.println("Lucro Total da Loja (20%): " + lucro + "€");
    }

    /** Opção Menu 4. Pesquisar Cliente por ID **/
    public static void pesquisarCliente(String[][] matriz, Scanner input) {
        System.out.print("Introduza o ID do Cliente: ");
        String idProcurado = input.next();
        boolean encontrado = false;

        for (int i = 0; i < matriz.length; i++) {
            // A coluna 1 contém o idCliente
            if (matriz[i][1].equalsIgnoreCase(idProcurado)) {
                System.out.println("\n--- Dados do Cliente ---");
                System.out.println("Nome: " + matriz[i][2]);
                System.out.println("Contacto: " + matriz[i][3]);
                System.out.println("Email: " + matriz[i][4]);
                encontrado = true;
                break; // Para no primeiro que encontrar para impedir a repetição de dados iguais
            }
        }

        if (!encontrado) {
            System.out.println("Cliente com ID " + idProcurado + " não encontrado.");
        }
    }

    /** Opção Menu 5. Jogo mais Caro e Compradores **/
    public static void jogoMaisCaro(String[][] matriz) {
        double valorMaximo = 0;

        // Encontrar o maior valor na coluna 8
        for (int i = 0; i < matriz.length; i++) {
            double valorAtual = Double.parseDouble(matriz[i][8]);
            if (valorAtual > valorMaximo) {
                valorMaximo = valorAtual;
            }
        }

        System.out.println("\n*** Jogo Mais Caro (" + valorMaximo + "€) ***");

        // Listar os jogos e clientes que têm esse valor máximo
        for (int i = 0; i < matriz.length; i++) {
            double valorAtual = Double.parseDouble(matriz[i][8]);
            if (valorAtual == valorMaximo) {
                System.out.println("Jogo: " + matriz[i][7] + " | Cliente: " + matriz[i][2]);
            }
        }
    }

    /**
     * Método para o Menu do Cliente (CLIENTE)
     */
    public static void menuCliente(String[][] matriz, Scanner input) {
        int opcao;
        do {
            System.out.println("\n--- MENU CLIENTE ---");
            System.out.println("1. Registrar Novo Cliente");
            System.out.println("2. Verificar Vagas de Estacionamento");
            System.out.println("3. Títulos de Jogos Disponíveis");
            System.out.println("4. Catálogo por Editora");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();
            input.nextLine(); // Limpar o buffer após ler número

            switch (opcao) {
                case 1:
                    registarNovoCliente(input);
                    break;
                case 2:
                    exibirVagasEstacionamento();
                    break;
                case 3:
                    exibirJogosSemRepetir(matriz);
                    break;
                case 4:
                    pesquisarPorEditora(matriz, input);
                    break;
                case 0:
                    System.out.println("Volta para o menu principal");
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        } while (opcao != 0);
    }

    /** Simular o registo de um novo cliente **/
    public static void registarNovoCliente(Scanner input) {
        System.out.println("\n> Inserir Cliente");
        System.out.print("Nome: ");
        String nome = input.nextLine();
        System.out.print("Contacto: ");
        String contato = input.nextLine();
        System.out.print("E-mail: ");
        String email = input.nextLine();

        System.out.println("Cliente Inserido com Sucesso: " + nome + " | " + contato + " | " + email);
    }

    public static void exibirVagasEstacionamento() {
        System.out.println("\n--- Vagas Disponíveis (Triangulares Múltiplos de 5) ---");
        for (int n = 1;; n++) {
            int vaga = (n * (n + 1)) / 2; // Fórmula do número triangular
            if (vaga > 121)
                break;
            if (vaga % 5 == 0) {
                System.out.print(+vaga + " | ");
            }
        }
    }

    public static void exibirJogosSemRepetir(String[][] matriz) {
        System.out.println("\n--- Catálogo de Jogos ---");
        //
        for (int i = 0; i < matriz.length; i++) {
            boolean jaExiste = false;
            // Compara o jogo atual com todos os anteriores na matriz
            for (int j = 0; j < i; j++) {
                if (matriz[i][7].equals(matriz[j][7])) {
                    jaExiste = true;
                    break;
                }
            }
            if (!jaExiste) {
                System.out.println("- " + matriz[i][7]);
            }
        }
    }

    public static void pesquisarPorEditora(String[][] matriz, Scanner input) {
        System.out.print("Editora a pesquisar: ");
        String editoraAlvo = input.nextLine();
        System.out.println("**** " + editoraAlvo + " ****");

        // Vetor auxiliar para saber quais categorias já imprimimos (evita repetição do
        // título da categoria)
        String categoriaImpressa = "";

        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][5].equalsIgnoreCase(editoraAlvo)) {
                String categoriaAtual = matriz[i][6];
                String jogo = matriz[i][7];

                // Se a categoria desta linha for diferente da última que imprimimos, mostra o
                // novo título
                if (!categoriaAtual.equalsIgnoreCase(categoriaImpressa)) {
                    System.out.println("\n" + "__" + categoriaAtual + "__");
                    categoriaImpressa = categoriaAtual; // Atualiza a categoria "marcada"
                }

                // Imprime o jogo logo abaixo da categoria correspondente
                System.out.println(jogo);
            }
        }

    }

}