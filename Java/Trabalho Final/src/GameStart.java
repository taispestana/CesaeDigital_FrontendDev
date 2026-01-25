import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameStart {

    // Constantes para as colunas do ficheiro CSV
    static final int COL_ID_VENDA = 0;
    static final int COL_ID_CLIENTE = 1;
    static final int COL_NOME_CLIENTE = 2;
    static final int COL_CONTACTO = 3;
    static final int COL_EMAIL = 4;
    static final int COL_EDITORA = 5;
    static final int COL_CATEGORIA = 6;
    static final int COL_JOGO = 7;
    static final int COL_VALOR = 8;
    static final int TOTAL_COLUNAS = 9;

    // Constantes de texto
    static final String TIPO_ADMIN = "ADMIN";
    static final String TIPO_CLIENTE = "CLIENTE";
    static final String SENHA_ADMIN = "0805";

    public static void main(String[] args) throws FileNotFoundException {

        // Carregar os dados do ficheiro CSV
        String[][] tabelaVendas = lerArquivoCsv("src/resources/GameStart_V2(in).csv");
        Scanner teclado = new Scanner(System.in);
        String modoUsuario;

        // Menu para selecionar o tipo de utilizador
        do {
            System.out.println("\n<3 <3 <3 Bem-vindo à GameStart <3 <3 <3");
            System.out.println("Escolha o tipo de Utilizador: ");
            System.out.print("ADMIN, CLIENTE ou SAIR: ");

            modoUsuario = teclado.next().toUpperCase();

            // Verificação de senha para ADMIN
            if (modoUsuario.equals(TIPO_ADMIN)) {
                System.out.print("Digite sua senha: ");
                String senhaAdmin = teclado.next();
                if (senhaAdmin.equals(SENHA_ADMIN)) {
                    menuAdmin(tabelaVendas, teclado);
                } else {
                    System.out.println("Senha Incorreta! Por favor, tente novamente.");
                }
            } else if (modoUsuario.equals(TIPO_CLIENTE)) {
                menuCliente(tabelaVendas, teclado);
            }

        } while (!modoUsuario.equals("SAIR"));

        System.out.println("Saindo...");
    }

    // Menu do Administrador
    public static void menuAdmin(String[][] dados, Scanner teclado) {
        String escolha;
        do {
            System.out.println("\n<3 <3 <3 MENU ADMIN <3 <3 <3");
            System.out.println("1. Exibir Conteúdo do Arquivo");
            System.out.println("2. Exibir Total de Vendas e Valor Acumulado");
            System.out.println("3. Calcular Lucro Total");
            System.out.println("4. Pesquisar por cliente");
            System.out.println("5. Exibir jogos mais caros e seus compradores");
            System.out.println("0. Sair");
            System.out.print("Digite o numero correspondente à uma das opções acima: ");
            System.out.println();
            escolha = teclado.next();
            // Consumir a quebra de linha pendente para evitar erros de leitura futuros
            teclado.nextLine();

            // Laço de repetição de escolha
            switch (escolha) {
                case "1":
                    exibirConteudoArquivo(dados);
                    System.out.println();
                    break;
                case "2":
                    exibirTotalVendas(dados);
                    System.out.println();
                    break;
                case "3":
                    exibirLucroTotal(dados);
                    System.out.println();
                    break;
                case "4":
                    buscarClientePorId(dados, teclado);
                    System.out.println();
                    break;
                case "5":
                    exibirJogoMaisCaro(dados);
                    System.out.println();
                    break;
                case "0":
                    System.out.println("Saindo...");
                    System.out.println();
                    break;
                default:
                    System.out.println("Opção Inválida! Por favor, tente novamente.");
                    System.out.println();
            }
        } while (!escolha.equals("0"));
    }

    // Carregar dados do ficheiro CSV para uma matriz
    public static String[][] lerArquivoCsv(String pathArquivo) throws FileNotFoundException {
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

        // Pular a linha do cabeçalho
        if (scanDados.hasNextLine()) {
            scanDados.nextLine();
        }

        // Preencher a matriz com os dados do ficheiro
        int idx = 0;
        while (scanDados.hasNextLine()) {
            String linha = scanDados.nextLine();
            if (linha.trim().isEmpty()) {
                continue;
            }

            String[] cols = linha.split(";");

            // Segurança: Verificar se a linha tem todas as colunas necessárias
            if (cols.length >= TOTAL_COLUNAS) {
                for (int col = 0; col < cols.length && col < TOTAL_COLUNAS; col++) {
                    matriz[idx][col] = cols[col];
                }
                idx++;
            }
        }
        scanDados.close();
        return matriz;
    }

    // Menu ADMIN Opção 1. Exibir Conteúdo do Arquivo
    public static void exibirConteudoArquivo(String[][] dados) {
        for (int i = 0; i < dados.length; i++) {
            for (int j = 0; j < dados[i].length; j++) {
                System.out.print(dados[i][j] + " | ");
            }
            System.out.println();
        }
    }

    // Menu ADMIN Opção 2. Exibir Total de Vendas e Valor Acumulado
    public static void exibirTotalVendas(String[][] dados) {
        double valorAcumulado = 0;
        for (int i = 0; i < dados.length; i++) {
            valorAcumulado += Double.parseDouble(dados[i][COL_VALOR]);
        }
        System.out.println("Total de Vendas: " + dados.length);
        System.out.println("Valor Total Acumulado: " + valorAcumulado + "€");
    }

    // Menu ADMIN Opção 3. Calcular lucro Total
    public static void exibirLucroTotal(String[][] dados) {
        double somaTotal = 0;

        // Soma todos os valores dos jogos
        for (int i = 0; i < dados.length; i++) {
            somaTotal += Double.parseDouble(dados[i][COL_VALOR]);
        }
        // Calcula o lucro total da loja com uma margem de 20%
        double margem = somaTotal * 0.20;
        System.out.println("Lucro Total da Loja: " + margem + "€");
    }

    // Menu ADMIN Opção 4. Pesquisar por cliente
    public static void buscarClientePorId(String[][] dados, Scanner teclado) {
        System.out.print("Digite o ID do Cliente desejado: ");
        String idAlvo = teclado.next();
        boolean achou = false;

        for (int i = 0; i < dados.length; i++) {
            if (dados[i][COL_ID_CLIENTE].equalsIgnoreCase(idAlvo)) {
                System.out.println("\n<3 Informações do Cliente <3");
                System.out.println("Nome: " + dados[i][COL_NOME_CLIENTE]);
                System.out.println("Contacto: " + dados[i][COL_CONTACTO]);
                System.out.println("Email: " + dados[i][COL_EMAIL]);
                achou = true;
                break;
            }
        }

        if (!achou) {
            System.out.println("Cliente com ID " + idAlvo + " não encontrado. Tente novamente.");
        }
    }

    // Menu ADMIN Opção 5. Exibir jogos mais caros e seu compradores
    public static void exibirJogoMaisCaro(String[][] dados) {
        double maxPreco = 0;

        // Encontrar o maior valor na coluna COL_VALOR
        for (int i = 0; i < dados.length; i++) {
            double precoJogo = Double.parseDouble(dados[i][COL_VALOR]);
            if (precoJogo > maxPreco) {
                maxPreco = precoJogo;
            }
        }

        System.out.println("Jogo Mais Caro: " + maxPreco + "€");

        // Mostra os jogos e clientes que tem o valor máximo
        for (int i = 0; i < dados.length; i++) {
            double precoJogo = Double.parseDouble(dados[i][COL_VALOR]);
            if (precoJogo == maxPreco) {
                System.out.println("Jogo: " + dados[i][COL_JOGO] + " | Comprador: " + dados[i][COL_NOME_CLIENTE]);
            }
        }
    }

    // Menu Cliente
    public static void menuCliente(String[][] dados, Scanner teclado) {
        String escolha;
        do {
            System.out.println("\n<3 <3 <3 MENU CLIENTE <3 <3 <3");
            System.out.println("1. Fazer Registro");
            System.out.println("2. Verificar Vagas de Estacionamento disponíveis");
            System.out.println("3. Títulos de Jogos Disponíveis");
            System.out.println("4. Catálogo por Editora");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            escolha = teclado.next();
            teclado.nextLine();

            switch (escolha) {
                case "1":
                    inserirNovoCliente(teclado);
                    System.out.println();
                    break;
                case "2":
                    verificarVagasDisponiveis();
                    System.out.println();
                    break;
                case "3":
                    listarJogosUnicos(dados);
                    System.out.println();
                    break;
                case "4":
                    listarJogosPorEditora(dados, teclado);
                    System.out.println();
                    break;
                case "0":
                    System.out.println("Volta para o menu principal");
                    System.out.println();
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    System.out.println();
            }
        } while (!escolha.equals("0"));
    }

    // Menu CLIENTE Opção 1. Registar Novo Cliente
    public static void inserirNovoCliente(Scanner teclado) {
        System.out.println("\n<3 Inserir Cliente <3");
        System.out.print("Nome: ");
        String nomeCli = teclado.nextLine();
        System.out.print("Contacto: ");
        String contatoCli = teclado.nextLine();
        System.out.print("E-mail: ");
        String emailCli = teclado.nextLine();

        System.out.println("Cliente Inserido com Sucesso: " + nomeCli + " | " + contatoCli + " | " + emailCli);
    }

    // Menu CLIENTE Opção 2. Exibir Vagas Estacionamento
    public static void verificarVagasDisponiveis() {
        System.out.println("\n<3 Vagas Disponíveis <3");

        // Fórmula do número triangular
        for (int n = 1; ; n++) {
            int numVaga = (n * (n + 1)) / 2;
            if (numVaga > 121) break;
            if (numVaga % 5 == 0) {
                System.out.print(+numVaga + " | ");
            }
        }
    }

    // Menu CLIENTE Opção 3. Exibir Jogos Sem Repetir
    public static void listarJogosUnicos(String[][] dados) {
        System.out.println("\n<3 Catálogo de Jogos <3");

        for (int i = 0; i < dados.length; i++) {
            boolean duplicado = false;

            // Compara o jogo atual com todos os anteriores na matriz
            for (int j = 0; j < i; j++) {
                if (dados[i][COL_JOGO].equals(dados[j][COL_JOGO])) {
                    duplicado = true;
                    break;
                }
            }
            if (!duplicado) {
                System.out.println("- " + dados[i][COL_JOGO]);
            }
        }
    }

    // Menu CLIENTE Opção 4. Pesquisar por Editora
    public static void listarJogosPorEditora(String[][] dados, Scanner teclado) {
        System.out.print("Editora a pesquisar: ");
        String editoraBusca = teclado.nextLine();
        System.out.println("\n<3 " + editoraBusca + " <3");

        String catAnterior = "";

        // Vetor auxiliar para saber quais categorias já imprimimos
        boolean editoraExiste=false;
        for (int i = 0; i < dados.length; i++) {
            if (dados[i][COL_EDITORA].equalsIgnoreCase(editoraBusca)) {
                editoraExiste=true;
                String catAtual = dados[i][COL_CATEGORIA];
                String jogo = dados[i][COL_JOGO];

                if (!catAtual.equalsIgnoreCase(catAnterior)) {
                    System.out.println("<3 " + catAtual + " <3");
                    catAnterior = catAtual;
                }

                System.out.println(jogo);
            }
        }
        if (!editoraExiste){
            System.out.println("<3 Editora nao encontrada <3");
        }
    }

}