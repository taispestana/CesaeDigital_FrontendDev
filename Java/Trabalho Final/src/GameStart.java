import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameStart {

    public static void main(String[] args) throws FileNotFoundException {
        // Ler o ficheiro CSV e carregar os dados para a matriz
        String[][] tabelaVendas = carregarMatriz("src/resources/GameStart_V2(in).csv");
        Scanner teclado = new Scanner(System.in);
        String modoUsuario;

        // Menu para selecionar o tipo de utilizador
        do {
            System.out.println("\n<3 <3 <3 Bem-vindo à GameStart <3 <3 <3");
            System.out.print("Escolha e digite o tipo de Utilizador (ADMIN , CLIENTE ou SAIR): ");
            modoUsuario = teclado.next().toUpperCase();

            if (modoUsuario.equals("ADMIN")) {
                // Verificação de senha para ADMIN
                System.out.print("Digite sua senha: ");
                String senhaAdmin = teclado.next();
                if (senhaAdmin.equals("0805")) {
                    menuAdmin(tabelaVendas, teclado);
                } else {
                    System.out.println("Senha Incorreta! Por favor, tente novamente.");
                }
            } else if (modoUsuario.equals("CLIENTE")) {
                menuCliente(tabelaVendas, teclado);
            }

        } while (!modoUsuario.equals("SAIR"));

        System.out.println("Saindo...");
    }

    // Menu do Administrador
    public static void menuAdmin(String[][] dados, Scanner teclado) {
        int escolha;
        do {
            System.out.println("\n<3 <3 <3 MENU ADMIN <3 <3 <3");
            System.out.println("1. Exibir Conteúdo do Arquivo");
            System.out.println("2. Exibir Total de Vendas e Valor Acumulado");
            System.out.println("3. Calcular Lucro Total");
            System.out.println("4. Pesquisar por cliente");
            System.out.println("5. Exibir jogos mais caros e seu compradores");
            System.out.println("0. Sair");
            System.out.print("Digite o numero correspondente à uma das opções acima: ");
            escolha = teclado.nextInt();

            //Laço de repetição para escolha do usuário
            switch (escolha) {
                case 1:
                    imprimirMatriz(dados);
                    break;
                    //Opção que imprime
                case 2:
                    exibirTotais(dados);
                    break;
                case 3:
                    calcularLucro(dados);
                    break;
                case 4:
                    pesquisarCliente(dados, teclado);
                    break;
                case 5:
                    jogoMaisCaro(dados);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção Inválida! Por favor, tente novamente.");
            }
        } while (escolha != 0);
    }

    // Carregar dados do ficheiro CSV para uma matriz
    public static String[][] carregarMatriz(String pathArquivo) throws FileNotFoundException {
        File ficheiro = new File(pathArquivo);

        // Definir o tamanho da matriz
        int numLinhas = 0;
        Scanner scanContagem = new Scanner(ficheiro);
        while (scanContagem.hasNextLine()) {
            String linha = scanContagem.nextLine();
            if (!linha.trim().isEmpty()) {
                numLinhas++;
            }
        }
        scanContagem.close();

        // Se o ficheiro tiver menos de 2 linhas, retornar uma matriz vazia
        if (numLinhas < 2) {
            return new String[0][9];
        }

        String[][] matriz = new String[numLinhas - 1][9];
        Scanner scanDados = new Scanner(ficheiro);

        if (scanDados.hasNextLine()) {
            scanDados.nextLine();
        }

        int idx = 0;
        while (scanDados.hasNextLine()) {
            String linha = scanDados.nextLine();
            if (linha.trim().isEmpty()) {
                continue;
            }

            String[] cols = linha.split(";");
            for (int col = 0; col < cols.length && col < 9; col++) {
                matriz[idx][col] = cols[col];
            }
            idx++;
        }
        scanDados.close();
        return matriz;
    }

    // Menu Opção 1. Exibir Conteúdo do Arquivo
    public static void imprimirMatriz(String[][] dados) {
        for (int i = 0; i < dados.length; i++) {
            for (int j = 0; j < dados[i].length; j++) {
                System.out.print(dados[i][j] + " | ");
            }
            System.out.println();
        }
    }

    // Menu Opção 2. Exibir Total de Vendas e Valor Acumulado
    public static void exibirTotais(String[][] dados) {
        double valorAcumulado = 0;
        for (int i = 0; i < dados.length; i++) {
            // A coluna 8 contém o valor do jogo
            valorAcumulado += Double.parseDouble(dados[i][8]);
        }
        System.out.println("Total de Vendas: " + dados.length);
        System.out.println("Valor Total Acumulado: " + valorAcumulado + "€");
    }

    // Menu Opção 3. Calcular lucro Total
    public static void calcularLucro(String[][] dados) {
        double somaTotal = 0;
        for (int i = 0; i < dados.length; i++) {
            somaTotal += Double.parseDouble(dados[i][8]);
        }
        // Calcula o lucro total da loja (20%)
        double margem = somaTotal * 0.20;
        System.out.println("Lucro Total da Loja (20%): " + margem + "€");
    }

    // Menu Opção 4. Pesquisar por cliente
    public static void pesquisarCliente(String[][] dados, Scanner teclado) {
        System.out.print("Digite o ID do Cliente desejado: ");
        String idAlvo = teclado.next();
        boolean achou = false;

        for (int i = 0; i < dados.length; i++) {
            if (dados[i][1].equalsIgnoreCase(idAlvo)) {
                System.out.println("\n<3 <3 <3 Informações do Cliente <3 <3 <3");
                System.out.println("Nome: " + dados[i][2]);
                System.out.println("Contacto: " + dados[i][3]);
                System.out.println("Email: " + dados[i][4]);
                achou = true;
                break;
            }
        }

        if (!achou) {
            System.out.println("Cliente com ID " + idAlvo + " não encontrado. Tente novamente.");
        }
    }

    // Menu Opção 5. Exibir jogos mais caros e seu compradores
    public static void jogoMaisCaro(String[][] dados) {
        double maxPreco = 0;

        // Encontrar o maior valor na coluna 8
        for (int i = 0; i < dados.length; i++) {
            double precoJogo = Double.parseDouble(dados[i][8]);
            if (precoJogo > maxPreco) {
                maxPreco = precoJogo;
            }
        }

        System.out.println("\n*** Jogo Mais Caro (" + maxPreco + "€) ***");

        // Mostra os jogos e clientes que tem o valor máximo
        for (int i = 0; i < dados.length; i++) {
            double precoJogo = Double.parseDouble(dados[i][8]);
            if (precoJogo == maxPreco) {
                System.out.println("Jogo: " + dados[i][7] + " | Comprador: " + dados[i][2]);
            }
        }
    }

    // Menu Opção 6. Menu Cliente
    public static void menuCliente(String[][] dados, Scanner teclado) {
        int escolha;
        do {
            System.out.println("\n<3 <3 <3 MENU CLIENTE <3 <3 <3");
            System.out.println("1. Fazer Registro");
            System.out.println("2. Verificar Vagas de Estacionamento disponíveis");
            System.out.println("3. Títulos de Jogos Disponíveis");
            System.out.println("4. Catálogo por Editora");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            escolha = teclado.nextInt();
            teclado.nextLine();

            switch (escolha) {
                case 1:
                    registarNovoCliente(teclado);
                    break;
                case 2:
                    exibirVagasEstacionamento();
                    break;
                case 3:
                    exibirJogosSemRepetir(dados);
                    break;
                case 4:
                    pesquisarPorEditora(dados, teclado);
                    break;
                case 0:
                    System.out.println("Volta para o menu principal");
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        } while (escolha != 0);
    }

    // Menu Opção 6.1. Registar Novo Cliente
    public static void registarNovoCliente(Scanner teclado) {
        System.out.println("\n> Inserir Cliente");
        System.out.print("Nome: ");
        String nomeCli = teclado.nextLine();
        System.out.print("Contacto: ");
        String contatoCli = teclado.nextLine();
        System.out.print("E-mail: ");
        String emailCli = teclado.nextLine();

        System.out.println("Cliente Inserido com Sucesso: " + nomeCli + " | " + contatoCli + " | " + emailCli);
    }

    // Menu Opção 6.2. Exibir Vagas Estacionamento
    public static void exibirVagasEstacionamento() {
        System.out.println("\n--- Vagas Disponíveis (Triangulares Múltiplos de 5) ---");
        for (int n = 1;; n++) {
            int numVaga = (n * (n + 1)) / 2; // Fórmula do número triangular
            if (numVaga > 121)
                break;
            if (numVaga % 5 == 0) {
                System.out.print(+numVaga + " | ");
            }
        }
    }

    // Menu Opção 6.3. Exibir Jogos Sem Repetir
    public static void exibirJogosSemRepetir(String[][] dados) {
        System.out.println("\n--- Catálogo de Jogos ---");
        //
        for (int i = 0; i < dados.length; i++) {
            boolean duplicado = false;
            // Compara o jogo atual com todos os anteriores na matriz
            for (int j = 0; j < i; j++) {
                if (dados[i][7].equals(dados[j][7])) {
                    duplicado = true;
                    break;
                }
            }
            if (!duplicado) {
                System.out.println("- " + dados[i][7]);
            }
        }
    }

    // Menu Opção 6.4. Pesquisar por Editora
    public static void pesquisarPorEditora(String[][] dados, Scanner teclado) {
        System.out.print("Editora a pesquisar: ");
        String editoraBusca = teclado.nextLine();
        System.out.println("**** " + editoraBusca + " ****");

        // Vetor auxiliar para saber quais categorias já imprimimos (evita repetição do
        // título da categoria)
        String catAnterior = "";

        for (int i = 0; i < dados.length; i++) {
            if (dados[i][5].equalsIgnoreCase(editoraBusca)) {
                String catAtual = dados[i][6];
                String jogo = dados[i][7];

                // Se a categoria desta linha for diferente da última que imprimimos, mostra o
                // novo título
                if (!catAtual.equalsIgnoreCase(catAnterior)) {
                    System.out.println("\n" + "__" + catAtual + "__");
                    catAnterior = catAtual; // Atualiza a categoria "marcada"
                }

                // Imprime o jogo logo abaixo da categoria correspondente
                System.out.println(jogo);
            }
        }

    }

}