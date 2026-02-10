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
        // 1. Criar Cursos (3)
        Curso c1 = new Curso("Software Developer", TipoCurso.FORMACAO, 12);
        Curso c2 = new Curso("Data Science", TipoCurso.POS_GRADUACAO, 9);
        Curso c3 = new Curso("Cibersegurança", TipoCurso.FORMACAO, 12);
        cursos.add(c1);
        cursos.add(c2);
        cursos.add(c3);

        // 2. Criar Unidades Curriculares (5)
        UnidadeCurricular uc1 = new UnidadeCurricular("Programação Orientada a Objetos", "POO", 80);
        UnidadeCurricular uc2 = new UnidadeCurricular("Bases de Dados", "BD", 60);
        UnidadeCurricular uc3 = new UnidadeCurricular("Redes de Computadores", "REDES", 50);
        UnidadeCurricular uc4 = new UnidadeCurricular("Desenvolvimento Web", "WEB", 90);
        UnidadeCurricular uc5 = new UnidadeCurricular("Matemática Discreta", "MD", 40);
        ucs.add(uc1); ucs.add(uc2); ucs.add(uc3); ucs.add(uc4); ucs.add(uc5);

        // Associar UCs aos cursos
        c1.adicionarUC(uc1); c1.adicionarUC(uc2); c1.adicionarUC(uc4);
        c2.adicionarUC(uc2); c2.adicionarUC(uc5);
        c3.adicionarUC(uc3);

        // 3. Criar Professores (4)
        Professor p1 = new Professor("Luís Antunes", "luis@cesae.pt", "912345678", 45, "Engenharia de Software", 2500);
        Professor p2 = new Professor("Ana Pereira", "ana@cesae.pt", "923456789", 38, "Bases de Dados", 2300);
        Professor p3 = new Professor("Carlos Mendes", "carlos@cesae.pt", "934567890", 52, "Redes e Segurança", 2800);
        Professor p4 = new Professor("Sofia Costa", "sofia@cesae.pt", "965432109", 41, "Ciência de Dados", 2600);
        professores.add(p1); professores.add(p2); professores.add(p3); professores.add(p4);

        // Associar Professores às UCs
        p1.adicionarUC(uc1); uc1.setProfessor(p1);
        p1.adicionarUC(uc4); uc4.setProfessor(p1);
        p2.adicionarUC(uc2); uc2.setProfessor(p2);
        p3.adicionarUC(uc3); uc3.setProfessor(p3);
        p4.adicionarUC(uc5); uc5.setProfessor(p4);

        // 4. Criar Turmas (2 por curso)
        Turma t1 = new Turma("SD-2024-A", 15, c1); c1.adicionarTurma(t1);
        Turma t2 = new Turma("SD-2024-B", 15, c1); c1.adicionarTurma(t2);
        Turma t3 = new Turma("DS-2024-A", 12, c2); c2.adicionarTurma(t3);
        Turma t4 = new Turma("DS-2024-B", 12, c2); c2.adicionarTurma(t4);
        Turma t5 = new Turma("CS-2024-A", 10, c3); c3.adicionarTurma(t5);
        Turma t6 = new Turma("CS-2024-B", 10, c3); c3.adicionarTurma(t6);
        turmas.add(t1); turmas.add(t2); turmas.add(t3); turmas.add(t4); turmas.add(t5); turmas.add(t6);

        // 5. Criar Alunos (10) e distribuí-los
        Aluno a1 = new Aluno("João Silva", "joao@email.com", "911111111", 25, null, EstadoAluno.ATIVO);
        Aluno a2 = new Aluno("Maria Santos", "maria@email.com", "922222222", 22, null, EstadoAluno.ATIVO);
        Aluno a3 = new Aluno("Pedro Almeida", "pedro@email.com", "933333333", 30, null, EstadoAluno.SUSPENSO);
        Aluno a4 = new Aluno("Ana Ferreira", "ana.f@email.com", "911222333", 21, null, EstadoAluno.ATIVO);
        Aluno a5 = new Aluno("Ricardo Jorge", "ricardo@email.com", "922333444", 28, null, EstadoAluno.CONCLUIDO);
        Aluno a6 = new Aluno("Carla Dias", "carla@email.com", "933444555", 26, null, EstadoAluno.ATIVO);
        Aluno a7 = new Aluno("Bruno Martins", "bruno@email.com", "911333444", 24, null, EstadoAluno.ATIVO);
        Aluno a8 = new Aluno("Sofia Ribeiro", "sofia.r@email.com", "922444555", 29, null, EstadoAluno.DESISTENTE);
        Aluno a9 = new Aluno("Miguel Costa", "miguel@email.com", "933555666", 23, null, EstadoAluno.ATIVO);
        Aluno a10 = new Aluno("Inês Gomes", "ines@email.com", "911444555", 27, null, EstadoAluno.ATIVO);
        
        alunos.add(a1); alunos.add(a2); alunos.add(a3); alunos.add(a4); alunos.add(a5);
        alunos.add(a6); alunos.add(a7); alunos.add(a8); alunos.add(a9); alunos.add(a10);

        // Inscrever alunos nas turmas (isto atualiza a referência em ambos os lados)
        t1.inscreverAluno(a1); t1.inscreverAluno(a2); t1.inscreverAluno(a3);
        t2.inscreverAluno(a4); t2.inscreverAluno(a5);
        t3.inscreverAluno(a6); t3.inscreverAluno(a7);
        t4.inscreverAluno(a8);
        t5.inscreverAluno(a9); t5.inscreverAluno(a10);

        // Adicionar algumas notas para os relatórios fazerem sentido
        a1.adicionarNota(15.5); a1.adicionarNota(18.0);
        a2.adicionarNota(12.0); a2.adicionarNota(13.5);
        a4.adicionarNota(19.0); a4.adicionarNota(17.5);
        a5.adicionarNota(16.0); a5.adicionarNota(16.0);
        a6.adicionarNota(10.0); a6.adicionarNota(11.5);
        a7.adicionarNota(14.0); a7.adicionarNota(15.0);
        a9.adicionarNota(9.5); a9.adicionarNota(12.0);
        a10.adicionarNota(13.0); a10.adicionarNota(16.5);

        System.out.println("\n>>> Sistema iniciado com dados de exemplo completos.");
    }

    // ========== MENU PRINCIPAL ==========
    public void menuPrincipal() {
        int opcao = -1;
        while (opcao != 7) { // Alterado para 7, a nova opção de saída
            exibirLayoutMenu(); // Chamada de método para manter o código limpo
            opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1: gerirCursos(); break;
                case 2: System.out.println("\n>>> Menu 'Gestão de Turmas' em desenvolvimento."); break;
                case 3: System.out.println("\n>>> Menu 'Gestão de Unidades Curriculares' em desenvolvimento."); break;
                case 4: gerirProfessores(); break;
                case 5: gerirAlunos(); break;
                case 6: gerirEstatisticas(); break;
                case 7: System.out.println("\nA encerrar... Obrigado, Taís!"); break;
                default: System.out.println("Opção inválida!");
            }

            // Pausa para o utilizador poder ler a informação antes de mostrar o menu novamente
            if (opcao != 7) {
                pausar();
            }
        }
    }

    // ========== SUB-MENUS (Exemplos de Lógica) ==========

    private void gerirAlunos() {
        int op;
        do {
            System.out.println("\n--- GESTÃO DE ALUNOS ---");
            System.out.println("1. Registar Aluno");
            System.out.println("2. Listar Todos os Alunos");
            System.out.println("3. Pesquisar Aluno");
            System.out.println("4. Emitir Certificado de Conclusão");
            System.out.println("0. Voltar ao Menu Principal");
            op = lerInteiro("Opção: ");

            switch (op) {
                case 1: registarAluno(); break;
                case 2: listarAlunos(); break;
                case 3: pesquisarAluno(); break;
                case 4: emitirCertificado(); break;
                case 0: break; // Volta ao menu principal
                default: System.out.println("Opção inválida!");
            }
        } while (op != 0);
    }

    // Método para registar um novo aluno, com validação de entrada
    private void pesquisarAluno() {
        System.out.println("\n--- PESQUISAR ALUNO ---");
        System.out.println("1. Por ID");
        System.out.println("2. Por Nome");
        System.out.println("3. Por Email");
        System.out.println("0. Voltar");
        int op = lerInteiro("Opção: ");
    
        switch (op) {
            case 1:
                int id = lerInteiro("Introduza o ID do aluno: ");
                Aluno aluno = procurarAlunoPorId(id);
                if (aluno != null) {
                    aluno.mostrarDetalhes();
                } else {
                    System.out.println("Aluno com ID " + id + " não encontrado.");
                }
                break;
            case 2:
                String nome = lerStringNaoVazia("Introduza o nome (ou parte do nome) a pesquisar: ");
                ArrayList<Aluno> resultadosNome = new ArrayList<>();
                for (Aluno a : alunos) {
                    if (a.getNome().toLowerCase().contains(nome.toLowerCase())) {
                        resultadosNome.add(a);
                    }
                }
                if (resultadosNome.isEmpty()) {
                    System.out.println("Nenhum aluno encontrado com o nome '" + nome + "'.");
                } else {
                    System.out.println("\nResultados da pesquisa por nome:");
                    for (Aluno a : resultadosNome) a.mostrarDetalhes();
                }
                break;
            case 3:
                String email = lerStringNaoVazia("Introduza o email (ou parte do email) a pesquisar: ");
                ArrayList<Aluno> resultadosEmail = new ArrayList<>();
                for (Aluno a : alunos) {
                    if (a.getEmail().toLowerCase().contains(email.toLowerCase())) {
                        resultadosEmail.add(a);
                    }
                }
                if (resultadosEmail.isEmpty()) {
                    System.out.println("Nenhum aluno encontrado com o email '" + email + "'.");
                } else {
                    System.out.println("\nResultados da pesquisa por email:");
                    for (Aluno a : resultadosEmail) a.mostrarDetalhes();
                }
                break;
            case 0: break;
            default: System.out.println("Opção inválida.");
        }
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

    // Método para listar todos os alunos
    private void listarAlunos() {
        System.out.println("\n--- LISTA DE ALUNOS ---");
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno registado.");
        } else {
            for (Aluno a : alunos) a.mostrarDetalhes();
        }
    }

    // Método para gerir cursos, apenas listagem por enquanto
    private void gerirCursos() {
        System.out.println("\n--- CURSOS DISPONÍVEIS ---");
        if (cursos.isEmpty()) {
            System.out.println("Nenhum curso registado.");
        } else {
            for (Curso c : cursos) c.mostrarDetalhes();
        }
    }

    // Método para gerir professores, com opções de registo e listagem
    private void gerirProfessores() {
        int op;
        do {
            System.out.println("\n--- GESTÃO DE PROFESSORES ---");
            System.out.println("1. Registar Professor");
            System.out.println("2. Listar Todos os Professores");
            System.out.println("3. Pesquisar Professor");
            System.out.println("0. Voltar ao Menu Principal");
            op = lerInteiro("Opção: ");

            switch (op) {
                case 1: registarProfessor(); break;
                case 2: listarProfessores(); break;
                case 3: pesquisarProfessor(); break;
                case 0: break;
                default: System.out.println("Opção inválida!");
            }
        } while (op != 0);
    }

    // Método para registar um novo professor, com validação de entrada
    private void pesquisarProfessor() {
        System.out.println("\n--- PESQUISAR PROFESSOR ---");
        System.out.println("1. Por ID");
        System.out.println("2. Por Nome");
        System.out.println("3. Por Email");
        System.out.println("0. Voltar");
        int op = lerInteiro("Opção: ");
    
        switch (op) {
            case 1:
                int id = lerInteiro("Introduza o ID do professor: ");
                Professor professor = procurarProfessorPorId(id);
                if (professor != null) {
                    professor.mostrarDetalhes();
                } else {
                    System.out.println("Professor com ID " + id + " não encontrado.");
                }
                break;
            case 2:
                String nome = lerStringNaoVazia("Introduza o nome (ou parte do nome) a pesquisar: ");
                ArrayList<Professor> resultadosNome = new ArrayList<>();
                for (Professor p : professores) {
                    if (p.getNome().toLowerCase().contains(nome.toLowerCase())) {
                        resultadosNome.add(p);
                    }
                }
                if (resultadosNome.isEmpty()) {
                    System.out.println("Nenhum professor encontrado com o nome '" + nome + "'.");
                } else {
                    System.out.println("\nResultados da pesquisa por nome:");
                    for (Professor p : resultadosNome) p.mostrarDetalhes();
                }
                break;
            case 3:
                String email = lerStringNaoVazia("Introduza o email (ou parte do email) a pesquisar: ");
                ArrayList<Professor> resultadosEmail = new ArrayList<>();
                for (Professor p : professores) {
                    if (p.getEmail().toLowerCase().contains(email.toLowerCase())) {
                        resultadosEmail.add(p);
                    }
                }
                if (resultadosEmail.isEmpty()) {
                    System.out.println("Nenhum professor encontrado com o email '" + email + "'.");
                } else {
                    System.out.println("\nResultados da pesquisa por email:");
                    for (Professor p : resultadosEmail) p.mostrarDetalhes();
                }
                break;
            case 0: break;
            default: System.out.println("Opção inválida.");
        }
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

    // Método para listar todos os professores
    private void listarProfessores() {
        System.out.println("\n--- LISTA DE PROFESSORES ---");
        if (professores.isEmpty()) {
            System.out.println("Nenhum professor registado.");
        } else {
            for (Professor p : professores) p.mostrarDetalhes();
        }
    }

    // ========== ESTATÍSTICAS E RELATÓRIOS ==========

    private void gerirEstatisticas() {
        int op;
        do {
            System.out.println("\n--- ESTATÍSTICAS E RELATÓRIOS ---");
            System.out.println("1. Números Gerais do Sistema");
            System.out.println("2. Média de um Aluno Específico");
            System.out.println("3. Média de uma Turma");
            System.out.println("4. Listar Alunos com Média Superior a...");
            System.out.println("5. Professor com Mais UCs");
            System.out.println("6. Turma com Mais e Menos Alunos");
            System.out.println("7. Listar Alunos por Estado");
            System.out.println("8. Taxa de Ocupação das Turmas");
            System.out.println("0. Voltar ao Menu Principal");
            op = lerInteiro("Opção: ");

            switch (op) {
                case 1: exibirContagensGerais(); break;
                case 2: consultarMediaAluno(); break;
                case 3: consultarMediaTurma(); break;
                case 4: listarAlunosAcimaDaMedia(); break;
                case 5: encontrarProfessorComMaisUCs(); break;
                case 6: encontrarTurmasExtremosAlunos(); break;
                case 7: listarAlunosPorEstado(); break;
                case 8: exibirTaxaOcupacaoTurmas(); break;
                case 0: break;
                default: System.out.println("Opção inválida!");
            }
        } while (op != 0);
    }

    private void exibirContagensGerais() {
        System.out.println("\n--- NÚMEROS GERAIS DO SISTEMA ---");
        System.out.println("Total de Alunos: " + alunos.size());
        System.out.println("Total de Professores: " + professores.size());
        System.out.println("Total de Cursos: " + cursos.size());
        System.out.println("Total de Turmas: " + turmas.size());
    }

    private void consultarMediaAluno() {
        System.out.println("\n--- CONSULTAR MÉDIA DE ALUNO ---");
        if (alunos.isEmpty()) {
            System.out.println("Não há alunos registados.");
            return;
        }
        int id = lerInteiro("Introduza o ID do aluno: ");
        Aluno aluno = procurarAlunoPorId(id);
        if (aluno != null) {
            System.out.printf("A média do aluno %s (ID: %d) é: %.2f%n", aluno.getNome(), aluno.getNumeroAluno(), aluno.calcularMedia());
        } else {
            System.out.println("Erro: Aluno com ID " + id + " não encontrado.");
        }
    }

    private void consultarMediaTurma() {
        System.out.println("\n--- CONSULTAR MÉDIA DE TURMA ---");
        Turma turma = selecionarTurma();
        if (turma == null) return;

        ArrayList<Aluno> alunosDaTurma = turma.getAlunos();
        if (alunosDaTurma.isEmpty()) {
            System.out.println("A turma " + turma.getNome() + " não tem alunos.");
            return;
        }

        double somaDasMedias = 0;
        for (Aluno aluno : alunosDaTurma) {
            somaDasMedias += aluno.calcularMedia();
        }
        double mediaDaTurma = somaDasMedias / alunosDaTurma.size();
        System.out.printf("A média da turma %s é: %.2f%n", turma.getNome(), mediaDaTurma);
    }

    private void listarAlunosAcimaDaMedia() {
        System.out.println("\n--- ALUNOS COM MÉDIA SUPERIOR A... ---");
        double mediaMinima = lerDoublePositivo("Introduza a média de referência (ex: 14.5): ");
        boolean encontrou = false;
        System.out.println("\nAlunos com média superior a " + mediaMinima + ":");
        for (Aluno aluno : alunos) {
            if (aluno.calcularMedia() > mediaMinima) {
                System.out.printf("- %s (Média: %.2f)%n", aluno.getNome(), aluno.calcularMedia());
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum aluno encontrado com média superior a " + mediaMinima);
        }
    }

    private void encontrarProfessorComMaisUCs() {
        System.out.println("\n--- PROFESSOR COM MAIS UCS ---");
        if (professores.isEmpty()) {
            System.out.println("Não há professores registados.");
            return;
        }

        Professor profComMaisUCs = null;
        int maxUCs = -1;
        for (Professor p : professores) {
            int numUCs = p.getUnidadesCurriculares().size();
            if (numUCs > maxUCs) {
                maxUCs = numUCs;
                profComMaisUCs = p;
            }
        }

        if (profComMaisUCs != null && maxUCs > 0) {
            System.out.printf("O professor com mais UCs é %s, com %d UCs.%n", profComMaisUCs.getNome(), maxUCs);
        } else {
            System.out.println("Nenhum professor tem UCs atribuídas.");
        }
    }

    private void encontrarTurmasExtremosAlunos() {
        System.out.println("\n--- TURMAS COM MAIS E MENOS ALUNOS ---");
        if (turmas.size() < 2) {
            System.out.println("São necessárias pelo menos duas turmas para comparar.");
            return;
        }

        Turma turmaMaisCheia = turmas.get(0);
        Turma turmaMaisVazia = turmas.get(0);

        for (Turma t : turmas) {
            if (t.getAlunos().size() > turmaMaisCheia.getAlunos().size()) turmaMaisCheia = t;
            if (t.getAlunos().size() < turmaMaisVazia.getAlunos().size()) turmaMaisVazia = t;
        }

        System.out.printf("Turma com mais alunos: %s (%d alunos)%n", turmaMaisCheia.getNome(), turmaMaisCheia.getAlunos().size());
        System.out.printf("Turma com menos alunos: %s (%d alunos)%n", turmaMaisVazia.getNome(), turmaMaisVazia.getAlunos().size());
    }

    private void listarAlunosPorEstado() {
        System.out.println("\n--- LISTAR ALUNOS POR ESTADO ---");
        EstadoAluno estado = selecionarEstadoAluno();
        if (estado == null) return;

        System.out.println("\nAlunos com estado '" + estado + "':");
        boolean encontrou = false;
        for (Aluno aluno : alunos) {
            if (aluno.getEstado() == estado) {
                System.out.printf("- %s (ID: %d)%n", aluno.getNome(), aluno.getNumeroAluno());
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum aluno encontrado com este estado.");
        }
    }

    private void exibirTaxaOcupacaoTurmas() {
        System.out.println("\n--- TAXA DE OCUPAÇÃO DAS TURMAS ---");
        if (turmas.isEmpty()) {
            System.out.println("Nenhuma turma registada.");
            return;
        }
        for (Turma t : turmas) {
            double inscritos = t.getAlunos().size();
            double capacidade = t.getCapacidadeMaxima();
            double taxa = (capacidade > 0) ? (inscritos / capacidade) * 100 : 0;
            System.out.printf("- Turma %s: %d/%d alunos (%.1f%% de ocupação)%n", t.getNome(), (int)inscritos, (int)capacidade, taxa);
        }
    }

    // ========== MÉTODOS AUXILIARES ==========

    private void exibirLayoutMenu() {
        System.out.println("\n╔══════════════════════════════════════════════╗");
        System.out.println("║     CESAE DIGITAL - GESTÃO ACADÉMICA         ║");
        System.out.println("╠══════════════════════════════════════════════╣");
        System.out.println("║  1. Gestão de Cursos                         ║");
        System.out.println("║  2. Gestão de Turmas                         ║");
        System.out.println("║  3. Gestão de Unidades Curriculares          ║");
        System.out.println("║  4. Gestão de Professores                    ║");
        System.out.println("║  5. Gestão de Alunos                         ║");
        System.out.println("║  6. Estatísticas e Relatórios                ║");
        System.out.println("║                                              ║");
        System.out.println("║  7. Sair                                     ║");
        System.out.println("╚══════════════════════════════════════════════╝");
    }

    // Método para ler um inteiro com validação de formato
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

    // Método para ler um double com validação de formato
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

    // Método para ler um double positivo, com validação de formato e valor
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

    // Método para ler uma string não vazia, com validação de entrada
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

    // Método para ler um email válido, com validação de formato simples
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

    // Método para ler um telefone válido, com validação de formato simples (apenas dígitos)
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

    // Método para ler uma string apenas com letras e espaços, com validação de formato
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

    private void emitirCertificado() {
        System.out.println("\n--- EMISSÃO DE CERTIFICADO ---");
        int id = lerInteiro("Introduza o ID do aluno concluído: ");
        Aluno aluno = procurarAlunoPorId(id);
    
        if (aluno == null) {
            System.out.println("Erro: Aluno com ID " + id + " não encontrado.");
            return;
        }
    
        if (aluno.getEstado() != EstadoAluno.CONCLUIDO) {
            System.out.println("Erro: O aluno " + aluno.getNome() + " não tem o estado 'CONCLUIDO'. Estado atual: " + aluno.getEstado());
            return;
        }
    
        Turma turma = aluno.getTurma();
        Curso curso = (turma != null) ? turma.getCurso() : null;
    
        System.out.println("\n\n**************************************************");
        System.out.println("*                                                *");
        System.out.println("*          CERTIFICADO DE CONCLUSÃO              *");
        System.out.println("*                                                *");
        System.out.println("**************************************************");
        System.out.println("\nCertificamos que");
        System.out.println("\n  " + aluno.getNome().toUpperCase());
        System.out.println("\nconcluiu com sucesso o curso de");
        System.out.println("\n  " + (curso != null ? curso.getNome().toUpperCase() : "CURSO NÃO ESPECIFICADO"));
        System.out.printf("\ncom uma média final de: %.2f valores%n", aluno.calcularMedia());
        System.out.println("\n--------------------------------------------------");
        System.out.println("Emitido pelo Sistema de Gestão Académica CESAE Digital.");
        System.out.println("**************************************************\n\n");
    }

    private Aluno procurarAlunoPorId(int id) {
        for (Aluno aluno : alunos) {
            if (aluno.getNumeroAluno() == id) {
                return aluno;
            }
        }
        return null;
    }

    private Professor procurarProfessorPorId(int id) {
        for (Professor p : professores) {
            if (p.getNumeroProfessor() == id) {
                return p;
            }
        }
        return null;
    }

    private Turma selecionarTurma() {
        if (turmas.isEmpty()) {
            System.out.println("Não há turmas registadas.");
            return null;
        }
        System.out.println("Selecione uma turma:");
        for (int i = 0; i < turmas.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, turmas.get(i).getNome());
        }
        int escolha = lerInteiro("Opção: ");
        if (escolha > 0 && escolha <= turmas.size()) {
            return turmas.get(escolha - 1);
        } else {
            System.out.println("Seleção inválida.");
            return null;
        }
    }

    private EstadoAluno selecionarEstadoAluno() {
        EstadoAluno[] estados = EstadoAluno.values();
        System.out.println("Selecione um estado:");
        for (int i = 0; i < estados.length; i++) {
            System.out.printf("%d. %s%n", i + 1, estados[i]);
        }
        int escolha = lerInteiro("Opção: ");
        if (escolha > 0 && escolha <= estados.length) {
            return estados[escolha - 1];
        } else {
            System.out.println("Seleção inválida.");
            return null;
        }
    }

    /**
     * Pausa a execução e espera que o utilizador pressione Enter.
     */
    private void pausar() {
        System.out.print("\nPressione Enter para continuar...");
        scanner.nextLine();
    }

    // ========== MÉTODO MAIN ==========
    public static void main(String[] args) {
        CesaeDigital app = new CesaeDigital();
        app.menuPrincipal();
    }
}