import java.util.ArrayList;
import java.util.Scanner;

public class CesaeDigital {
    // ========== ATRIBUTOS ==========
    private ArrayList<Curso> cursos;
    private ArrayList<Turma> turmas;
    private ArrayList<UnidadeCurricular> ucs;
    private ArrayList<Professor> professores;
    private ArrayList<Aluno> alunos;
    private Scanner scanner;

    // ========== CONSTRUTOR ==========
    public CesaeDigital() {
        this.cursos = new ArrayList<>();
        this.turmas = new ArrayList<>();
        this.ucs = new ArrayList<>();
        this.professores = new ArrayList<>();
        this.alunos = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        
        carregarDadosIniciais();
    }

    /**
     * Adiciona alguns dados para o sistema não iniciar vazio.
     */
    private void carregarDadosIniciais() {
        Curso c1 = new Curso("Software Developer", TipoCurso.FORMACAO, 12);
        cursos.add(c1);
        System.out.println(">>> Sistema iniciado com dados base.");
    }

    // ========== MENU PRINCIPAL ==========
    public void menuPrincipal() {
        int opcao = -1;
        while (opcao != 0) {
            exibirLayoutMenu(); // Chamada de método para manter o código limpo
            opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1: gerirCursos(); break;
                case 2: System.out.println("Menu Turmas - Em desenvolvimento"); break;
                case 3: System.out.println("Menu UCs - Em desenvolvimento"); break;
                case 4: gerirProfessores(); break;
                case 5: gerirAlunos(); break;
                case 0: System.out.println("\nA encerrar... Obrigado, Taís!"); break;
                default: System.out.println("Opção inválida!");
            }
        }
    }

    // ========== SUB-MENUS (Exemplos de Lógica) ==========

    private void gerirAlunos() {
        int op;
        do {
            System.out.println("\n--- GESTÃO DE ALUNOS ---");
            System.out.println("1. Registar Aluno");
            System.out.println("2. Listar Todos");
            System.out.println("0. Voltar ao Menu Principal");
            op = lerInteiro("Opção: ");

            switch (op) {
                case 1: registarAluno(); break;
                case 2: listarAlunos(); break;
                case 0: break; // Volta ao menu principal
                default: System.out.println("Opção inválida!");
            }
        } while (op != 0);
    }

    private void registarAluno() {
        System.out.println("\n--- REGISTAR NOVO ALUNO ---");
        String nome = lerStringApenasLetras("Nome: ");
        String email = lerEmailValido("Email: ");
        String telefone = lerTelefoneValido("Telefone: ");
        int idade = lerInteiroPositivo("Idade: ");

        // Por defeito, um novo aluno não tem turma e está ativo.
        Aluno novoAluno = new Aluno(nome, email, telefone, idade, null, EstadoAluno.ATIVO);
        alunos.add(novoAluno);
        System.out.println(">>> Aluno " + nome + " registado com sucesso com o ID: " + novoAluno.getNumeroAluno());
    }

    private void listarAlunos() {
        System.out.println("\n--- LISTA DE ALUNOS ---");
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno registado.");
        } else {
            for (Aluno a : alunos) a.mostrarDetalhes();
        }
    }

    private void gerirCursos() {
        System.out.println("\n--- CURSOS DISPONÍVEIS ---");
        if (cursos.isEmpty()) {
            System.out.println("Nenhum curso registado.");
        } else {
            for (Curso c : cursos) c.mostrarDetalhes();
        }
    }

    private void gerirProfessores() {
        int op;
        do {
            System.out.println("\n--- GESTÃO DE PROFESSORES ---");
            System.out.println("1. Registar Professor");
            System.out.println("2. Listar Todos");
            System.out.println("0. Voltar ao Menu Principal");
            op = lerInteiro("Opção: ");

            switch (op) {
                case 1: registarProfessor(); break;
                case 2: listarProfessores(); break;
                case 0: break;
                default: System.out.println("Opção inválida!");
            }
        } while (op != 0);
    }

    private void registarProfessor() {
        System.out.println("\n--- REGISTAR NOVO PROFESSOR ---");
        String nome = lerStringApenasLetras("Nome: ");
        String email = lerEmailValido("Email: ");
        String telefone = lerTelefoneValido("Telefone: ");
        int idade = lerInteiroPositivo("Idade: ");
        String especialidade = lerStringApenasLetras("Especialidade: ");
        double salario = lerDoublePositivo("Salário: ");

        Professor novoProfessor = new Professor(nome, email, telefone, idade, especialidade, salario);
        professores.add(novoProfessor);
        System.out.println(">>> Professor " + nome + " registado com sucesso com o ID: " + novoProfessor.getNumeroProfessor());
    }

    private void listarProfessores() {
        System.out.println("\n--- LISTA DE PROFESSORES ---");
        if (professores.isEmpty()) {
            System.out.println("Nenhum professor registado.");
        } else {
            for (Professor p : professores) p.mostrarDetalhes();
        }
    }

    // ========== MÉTODOS AUXILIARES ==========

    private void exibirLayoutMenu() {
        System.out.println("\n╔══════════════════════════════════════════════╗");
        System.out.println("║     CESAE DIGITAL - GESTÃO ACADÉMICA         ║");
        System.out.println("╠══════════════════════════════════════════════╣");
        System.out.println("║  1. Gestão de Cursos                         ║");
        System.out.println("║  4. Gestão de Professores                    ║");
        System.out.println("║  5. Gestão de Alunos                         ║");
        System.out.println("║  0. Sair                                     ║");
        System.out.println("╚══════════════════════════════════════════════╝");
    }

    private int lerInteiro(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Valor inválido! Introduza um número inteiro: ");
            }
        }
    }

    private int lerInteiroPositivo(String prompt) {
        while (true) {
            // Reutiliza o método lerInteiro mas adiciona a validação de ser positivo
            int valor = lerInteiro(prompt);
            if (valor >= 0) {
                return valor;
            } else {
                System.out.println("Erro: O valor não pode ser negativo.");
                // Pede novamente o prompt na próxima iteração do lerInteiro
                System.out.print(prompt);
            }
        }
    }

    private double lerDoublePositivo(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            // Substitui a vírgula pelo ponto para aceitar ambos os formatos decimais
            String sanitizedInput = input.replace(',', '.');
            try {
                double valor = Double.parseDouble(sanitizedInput);
                if (valor >= 0) {
                    return valor;
                } else {
                    System.out.println("Erro: O valor não pode ser negativo.");
                }
            } catch (NumberFormatException e) {
                System.out.print("Valor inválido! Introduza um número (ex: 1200.50): ");
            }
        }
    }

    private String lerStringNaoVazia(String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Erro: O campo não pode ser vazio.");
            }
        } while (input.isEmpty());
        return input;
    }

    private String lerEmailValido(String prompt) {
        String email;
        do {
            email = lerStringNaoVazia(prompt);
            if (!email.contains("@")) {
                System.out.println("Erro: Email inválido (deve conter '@').");
            }
        } while (!email.contains("@"));
        return email;
    }

    private String lerTelefoneValido(String prompt) {
        String telefone;
        while (true) {
            System.out.print(prompt);
            telefone = scanner.nextLine().trim();
            if (telefone.isEmpty()) {
                System.out.println("Erro: O campo não pode ser vazio.");
                continue; // Pede de novo
            }
            // Valida se a string contém apenas dígitos
            if (telefone.matches("\\d+")) {
                return telefone; // Válido, retorna
            } else {
                System.out.println("Erro: O telefone deve conter apenas números.");
            }
        }
    }

    private String lerStringApenasLetras(String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Erro: O campo não pode ser vazio.");
                continue;
            }
            // Valida se a string contém apenas letras e espaços.
            if (input.matches("[a-zA-Z\\s]+")) {
                return input;
            } else {
                System.out.println("Erro: Este campo deve conter apenas letras e espaços.");
            }
        }
    }

    public static void main(String[] args) {
        CesaeDigital app = new CesaeDigital();
        app.menuPrincipal();
    }
}