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

        // 1. Criar Cursos
        Curso c1 = new Curso("Software Developer", TipoCurso.FORMACAO, 12);
        Curso c2 = new Curso("Data Science", TipoCurso.POS_GRADUACAO, 9);
        Curso c3 = new Curso("Cibersegurança", TipoCurso.FORMACAO, 12);
        cursos.add(c1);
        cursos.add(c2);
        cursos.add(c3);

        // 2. Criar Unidades Curriculares
        UnidadeCurricular uc1 = new UnidadeCurricular("Programação Orientada a Objetos", "POO", 80);
        UnidadeCurricular uc2 = new UnidadeCurricular("Bases de Dados", "BD", 60);
        UnidadeCurricular uc3 = new UnidadeCurricular("Redes de Computadores", "REDES", 50);
        UnidadeCurricular uc4 = new UnidadeCurricular("Desenvolvimento Web", "WEB", 90);
        UnidadeCurricular uc5 = new UnidadeCurricular("Matemática Discreta", "MD", 40);
        ucs.add(uc1);
        ucs.add(uc2);
        ucs.add(uc3);
        ucs.add(uc4);
        ucs.add(uc5);

        // Associar UCs aos cursos
        c1.adicionarUC(uc1);
        c1.adicionarUC(uc2);
        c1.adicionarUC(uc4);
        c2.adicionarUC(uc2);
        c2.adicionarUC(uc5);
        c3.adicionarUC(uc3);

        // 3. Criar Professores
        Professor p1 = new Professor("Luís Antunes", "luis@cesae.pt", "912345678", 45, "Engenharia de Software", 2500);
        Professor p2 = new Professor("Ana Pereira", "ana@cesae.pt", "923456789", 38, "Bases de Dados", 2300);
        Professor p3 = new Professor("Carlos Mendes", "carlos@cesae.pt", "934567890", 52, "Redes e Segurança", 2800);
        Professor p4 = new Professor("Sofia Costa", "sofia@cesae.pt", "965432109", 41, "Ciência de Dados", 2600);
        professores.add(p1);
        professores.add(p2);
        professores.add(p3);
        professores.add(p4);

        // Associar Professores às UCs
        p1.adicionarUC(uc1);
        uc1.setProfessor(p1);
        p1.adicionarUC(uc4);
        uc4.setProfessor(p1);
        p2.adicionarUC(uc2);
        uc2.setProfessor(p2);
        p3.adicionarUC(uc3);
        uc3.setProfessor(p3);
        p4.adicionarUC(uc5);
        uc5.setProfessor(p4);

        // 4. Criar Turmas
        Turma t1 = new Turma("SD-2024-A", 15, c1);
        c1.adicionarTurma(t1);
        Turma t2 = new Turma("SD-2024-B", 15, c1);
        c1.adicionarTurma(t2);
        Turma t3 = new Turma("DS-2024-A", 12, c2);
        c2.adicionarTurma(t3);
        Turma t4 = new Turma("DS-2024-B", 12, c2);
        c2.adicionarTurma(t4);
        Turma t5 = new Turma("CS-2024-A", 10, c3);
        c3.adicionarTurma(t5);
        Turma t6 = new Turma("CS-2024-B", 10, c3);
        c3.adicionarTurma(t6);
        turmas.add(t1);
        turmas.add(t2);
        turmas.add(t3);
        turmas.add(t4);
        turmas.add(t5);
        turmas.add(t6);

        // 5. Criar Alunos e distribuí-los
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

        alunos.add(a1);
        alunos.add(a2);
        alunos.add(a3);
        alunos.add(a4);
        alunos.add(a5);
        alunos.add(a6);
        alunos.add(a7);
        alunos.add(a8);
        alunos.add(a9);
        alunos.add(a10);

        // Inscrever alunos nas turmas
        t1.inscreverAluno(a1);
        t1.inscreverAluno(a2);
        t1.inscreverAluno(a3);
        t2.inscreverAluno(a4);
        t2.inscreverAluno(a5);
        t3.inscreverAluno(a6);
        t3.inscreverAluno(a7);
        t4.inscreverAluno(a8);
        t5.inscreverAluno(a9);
        t5.inscreverAluno(a10);

        // Adicionar algumas notas para os relatórios
        a1.adicionarNota(15.5);
        a1.adicionarNota(18.0);
        a2.adicionarNota(12.0);
        a2.adicionarNota(13.5);
        a4.adicionarNota(19.0);
        a4.adicionarNota(17.5);
        a5.adicionarNota(16.0);
        a5.adicionarNota(16.0);
        a6.adicionarNota(10.0);
        a6.adicionarNota(11.5);
        a7.adicionarNota(14.0);
        a7.adicionarNota(15.0);
        a9.adicionarNota(9.5);
        a9.adicionarNota(12.0);
        a10.adicionarNota(13.0);
        a10.adicionarNota(16.5);

        System.out.println("\n>>> Sistema iniciado com dados de exemplo completos.");
    }

    public void menuPrincipal() {
        int opcao = -1;
        while (opcao != 7) {
            String menu = """
                    ╔══════════════════════════════════════════════╗
                    ║     CESAE DIGITAL - GESTÃO ACADÉMICA         ║
                    ╠══════════════════════════════════════════════╣
                    ║  1. Gestão de Cursos                         ║
                    ║  2. Gestão de Turmas                         ║
                    ║  3. Gestão de Unidades Curriculares          ║
                    ║  4. Gestão de Professores                    ║
                    ║  5. Gestão de Alunos                         ║
                    ║  6. Estatísticas e Relatórios                ║
                    ║                                              ║
                    ║  7. Sair                                     ║
                    ╚══════════════════════════════════════════════╝
                    Escolha uma opção: """;
            opcao = lerInteiro(menu);
            switch (opcao) {
                case 1 -> gerirCursos();
                case 2 -> gerirTurmas();
                case 3 -> gerirUCs();
                case 4 -> gerirProfessores();
                case 5 -> gerirAlunos();
                case 6 -> gerirEstatisticas();
                case 7 -> System.out.println("\nA encerrar... Obrigado!");
                default -> System.out.println("Opção inválida!");
            }
            if (opcao != 7)
                pausar();
        }
    }

    // ========== SUB-MENUS ==========

    /**
     * Menu de gestão de alunos com opções CRUD e específicas.
     */
    private void gerirAlunos() {
        int op;
        do {
            System.out.println("\n--- GESTÃO DE ALUNOS ---");
            System.out.println("1. Registar Aluno");
            System.out.println("2. Listar Todos os Alunos");
            System.out.println("3. Listar Alunos por Turma");
            System.out.println("4. Pesquisar Aluno");
            System.out.println("5. Alterar Estado do Aluno");
            System.out.println("6. Registar Notas");
            System.out.println("7. Emitir Certificado de Conclusão");
            System.out.println("0. Voltar ao Menu Principal");
            op = lerInteiro("Opção: ");

            switch (op) {
                case 1:
                    registarAluno();
                    break;
                case 2:
                    listarAlunos();
                    break;
                case 3:
                    listarAlunosPorTurma();
                    break;
                case 4:
                    pesquisarAluno();
                    break;
                case 5:
                    alterarEstadoAluno();
                    break;
                case 6:
                    registarNotasAluno();
                    break;
                case 7:
                    emitirCertificado();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (op != 0);
    }

    // Método para pesquisar um aluno por ID, nome ou email
    private void pesquisarAluno() {
        System.out.println("\n--- PESQUISAR ALUNO ---\n1. Por ID\n2. Por Nome\n3. Por Email\n0. Voltar");
        int op = lerInteiro("Opção: ");
        if (op == 0)
            return;

        String termo = (op == 1) ? "" : lerStringNaoVazia("Pesquisar por: ");
        switch (op) {
            case 1 -> {
                Aluno a = procurarAlunoPorId(lerInteiro("ID: "));
                if (a != null)
                    a.mostrarDetalhes();
                else
                    System.out.println("Não encontrado.");
            }
            case 2 -> alunos.stream().filter(a -> a.getNome().toLowerCase().contains(termo.toLowerCase()))
                    .forEach(Aluno::mostrarDetalhes);
            case 3 -> alunos.stream().filter(a -> a.getEmail().toLowerCase().contains(termo.toLowerCase()))
                    .forEach(Aluno::mostrarDetalhes);
            default -> System.out.println("Opção inválida.");
        }
    }

    // Método para registar um novo aluno, com validação de entrada
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

    /**
     * Lista todos os alunos registados.
     */
    private void listarAlunos() {
        System.out.println("\n--- LISTA DE ALUNOS ---");
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno registado.");
        } else {
            for (Aluno a : alunos)
                a.mostrarDetalhes();
        }
    }

    /**
     * Lista alunos de uma turma específica selecionada pelo utilizador.
     */
    private void listarAlunosPorTurma() {
        Turma t = selecionarTurma();
        if (t != null) {
            System.out.println("\n--- ALUNOS DA TURMA " + t.getNome() + " ---");
            t.listarAlunos();
        }
    }

    /**
     * Altera o estado (Enum) de um aluno específico.
     */
    private void alterarEstadoAluno() {
        Aluno a = procurarAlunoPorId(lerInteiro("Introduza o ID do aluno: "));
        if (a == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        System.out.println("Estado atual: " + a.getEstado());
        EstadoAluno novo = selecionarEstadoAluno();
        if (novo != null) {
            a.setEstado(novo);
            System.out.println(">>> Estado alterado para " + novo);
        }
    }

    /**
     * Regista uma nova nota para um aluno, com validação de 0 a 20.
     */
    private void registarNotasAluno() {
        Aluno a = procurarAlunoPorId(lerInteiro("Introduza o ID do aluno: "));
        if (a == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        double nota = lerDoublePositivo("Introduza a nota (0-20): ");
        if (nota <= 20) {
            a.adicionarNota(nota);
            System.out.println(">>> Nota registada com sucesso.");
        } else {
            System.out.println("Erro: A nota deve ser no máximo 20.");
        }
    }

    /**
     * Menu de gestão de cursos com operações CRUD.
     */
    private void gerirCursos() {
        int op;
        do {
            op = lerInteiro(
                    "\n--- GESTÃO DE CURSOS ---\n1. Criar\n2. Listar\n3. Editar\n4. Remover\n0. Voltar\nOpção: ");
            switch (op) {
                case 1 -> criarCurso();
                case 2 -> listarCursos();
                case 3 -> editarCurso();
                case 4 -> removerCurso();
                case 0 -> {
                }
                default -> System.out.println("Opção inválida!");
            }
        } while (op != 0);
    }

    // Método para criar um novo curso, com validação de entrada
    private void criarCurso() {
        System.out.println("\n--- CRIAR NOVO CURSO ---");
        String nome = lerStringNaoVazia("Nome do Curso: ");
        TipoCurso tipo = selecionarTipoCurso();
        int duracao = lerInteiroPositivo("Duração (meses): ");

        Curso novo = new Curso(nome, tipo, duracao);
        cursos.add(novo);
        System.out.println(">>> Curso '" + nome + "' criado com sucesso.");
    }

    // Método para listar todos os cursos
    private void listarCursos() {
        System.out.println("\n--- LISTA DE CURSOS ---");
        if (cursos.isEmpty()) {
            System.out.println("Nenhum curso registado.");
        } else {
            for (Curso c : cursos)
                c.mostrarDetalhes();
        }
    }

    // Método para editar um curso
    private void editarCurso() {
        System.out.println("\n--- EDITAR CURSO ---");
        Curso c = selecionarCurso();
        if (c == null)
            return;

        System.out.println("A editar: " + c.getNome());
        String novoNome = lerString("Novo Nome (Vazio para manter): ");
        if (!novoNome.isEmpty())
            c.setNome(novoNome);

        System.out.println("Deseja alterar o tipo?");
        c.setTipo(selecionarTipoCurso());

        int novaDuracao = lerInteiro("Nova Duração (meses, 0 para manter): ");
        if (novaDuracao > 0)
            c.setDuracaoMeses(novaDuracao);

        System.out.println(">>> Curso atualizado.");
    }

    // Método para remover um curso
    private void removerCurso() {
        System.out.println("\n--- REMOVER CURSO ---");
        Curso c = selecionarCurso();
        if (c != null) {
            cursos.remove(c);
            System.out.println(">>> Curso removido.");
        }
    }

    /**
     * Menu de gestão de turmas.
     */
    private void gerirTurmas() {
        int op;
        do {
            op = lerInteiro(
                    "\n--- GESTÃO DE TURMAS ---\n1. Criar\n2. Listar\n3. Adicionar Aluno\n4. Remover Aluno\n5. Adicionar UC\n6. Remover UC\n0. Voltar\nOpção: ");
            switch (op) {
                case 1 -> criarTurma();
                case 2 -> listarTurmasGeral();
                case 3 -> inscreverAlunoEmTurma();
                case 4 -> removerAlunoDeTurma();
                case 5 -> associarUCTurma();
                case 6 -> removerUCTurma();
                case 0 -> {
                }
                default -> System.out.println("Opção inválida!");
            }
        } while (op != 0);
    }

    // Método para criar uma nova turma
    private void criarTurma() {
        System.out.println("\n--- CRIAR NOVA TURMA ---");
        Curso c = selecionarCurso();
        if (c == null)
            return;

        String nome = lerStringNaoVazia("Nome da Turma (ex: SD-2025-A): ");
        int capacidade = lerInteiroPositivo("Capacidade Máxima: ");

        Turma nova = new Turma(nome, capacidade, c);
        turmas.add(nova);
        c.adicionarTurma(nova);
        System.out.println(">>> Turma '" + nome + "' criada e associada ao curso " + c.getNome());
    }

    // Método para listar todas as turmas
    private void listarTurmasGeral() {
        System.out.println("\n--- LISTA DE TURMAS (TODAS) ---");
        if (turmas.isEmpty()) {
            System.out.println("Nenhuma turma registada.");
        } else {
            for (Turma t : turmas) {
                System.out.println("- " + t.getNome() + " | Curso: " + t.getCurso().getNome() + " | Alunos: "
                        + t.getAlunos().size() + "/" + t.getCapacidadeMaxima());
            }
        }
    }

    // Método para inscrever um aluno em uma turma
    private void inscreverAlunoEmTurma() {
        System.out.println("\n--- INSCREVER ALUNO EM TURMA ---");
        Aluno a = procurarAlunoPorId(lerInteiro("ID do Aluno: "));
        if (a == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }
        Turma t = selecionarTurma();
        if (t != null)
            t.inscreverAluno(a);
    }

    // Método para remover um aluno de uma turma
    private void removerAlunoDeTurma() {
        System.out.println("\n--- REMOVER ALUNO DE TURMA ---");
        Turma t = selecionarTurma();
        if (t == null)
            return;

        t.listarAlunos();
        Aluno a = procurarAlunoPorId(lerInteiro("ID do Aluno a remover: "));
        if (a != null)
            t.removerAluno(a);
    }

    // Método para associar uma UC a uma turma
    private void associarUCTurma() {
        System.out.println("\n--- ASSOCIAR UC A TURMA ---");
        Turma t = selecionarTurma();
        if (t == null)
            return;

        UnidadeCurricular uc = selecionarUC();
        if (uc != null) {
            t.adicionarUC(uc);
            System.out.println(">>> UC " + uc.getNome() + " associada à turma " + t.getNome());
        }
    }

    // Método para remover uma UC de uma turma
    private void removerUCTurma() {
        System.out.println("\n--- REMOVER UC DE TURMA ---");
        Turma t = selecionarTurma();
        if (t == null)
            return;

        UnidadeCurricular uc = selecionarUC();
        if (uc != null) {
            t.removerUC(uc);
        }
    }

    /**
     * Menu de gestão de Unidades Curriculares.
     */
    private void gerirUCs() {
        int op;
        do {
            op = lerInteiro("\n--- GESTÃO DE UCs ---\n1. Criar\n2. Listar\n3. Associar Professor\n0. Voltar\nOpção: ");
            switch (op) {
                case 1 -> criarUC();
                case 2 -> listarUCsGeral();
                case 3 -> associarProfessorUC();
                case 0 -> {
                }
                default -> System.out.println("Opção inválida!");
            }
        } while (op != 0);
    }

    // Método para criar uma nova UC
    private void criarUC() {
        System.out.println("\n--- CRIAR NOVA UNIDADE CURRICULAR ---");
        String nome = lerStringNaoVazia("Nome da UC: ");
        String codigo = lerStringNaoVazia("Código (ex: POO-101): ");
        int carga = lerInteiroPositivo("Carga Horária: ");

        UnidadeCurricular nova = new UnidadeCurricular(nome, codigo, carga);
        ucs.add(nova);
        System.out.println(">>> UC '" + nome + "' criada com sucesso.");
    }

    // Método para listar todas as UCs
    private void listarUCsGeral() {
        System.out.println("\n--- LISTA DE UCs ---");
        if (ucs.isEmpty()) {
            System.out.println("Nenhuma UC registada.");
        } else {
            for (UnidadeCurricular uc : ucs)
                uc.exibirInformacoes();
        }
    }

    // Método para associar um professor a uma UC
    private void associarProfessorUC() {
        System.out.println("\n--- ASSOCIAR PROFESSOR A UC ---");
        UnidadeCurricular uc = selecionarUC();
        if (uc == null)
            return;

        Professor p = procurarProfessorPorId(lerInteiro("ID do Professor: "));
        if (p != null) {
            p.adicionarUC(uc);
            uc.setProfessor(p);
        } else {
            System.out.println("Professor não encontrado.");
        }
    }

    /**
     * Menu de gestão de professores.
     */
    private void gerirProfessores() {
        int op;
        do {
            op = lerInteiro(
                    "\n--- GESTÃO DE PROFESSORES ---\n1. Registar\n2. Listar\n3. Pesquisar\n4. Atribuir UC\n5. Remover UC\n0. Voltar\nOpção: ");
            switch (op) {
                case 1 -> registarProfessor();
                case 2 -> listarProfessores();
                case 3 -> pesquisarProfessor();
                case 4 -> atribuirUCProfessor();
                case 5 -> removerUCProfessor();
                case 0 -> {
                }
                default -> System.out.println("Opção inválida!");
            }
        } while (op != 0);
    }

    private void atribuirUCProfessor() {
        Professor p = procurarProfessorPorId(lerInteiro("ID do Professor: "));
        if (p == null) {
            System.out.println("Professor não encontrado.");
            return;
        }
        UnidadeCurricular uc = selecionarUC();
        if (uc != null) {
            p.adicionarUC(uc);
            uc.setProfessor(p);
        }
    }

    private void removerUCProfessor() {
        Professor p = procurarProfessorPorId(lerInteiro("ID do Professor: "));
        if (p == null) {
            System.out.println("Professor não encontrado.");
            return;
        }
        p.listarUCs();
        UnidadeCurricular uc = selecionarUC();
        if (uc != null)
            p.removerUC(uc);
    }

    // Método para registar um novo professor, com validação de entrada
    private void pesquisarProfessor() {
        System.out.println("\n--- PESQUISAR PROFESSOR ---\n1. Por ID\n2. Por Nome\n3. Por Email\n0. Voltar");
        int op = lerInteiro("Opção: ");
        if (op == 0)
            return;

        String termo = (op == 1) ? "" : lerStringNaoVazia("Pesquisar por: ");
        switch (op) {
            case 1 -> {
                Professor p = procurarProfessorPorId(lerInteiro("ID: "));
                if (p != null)
                    p.mostrarDetalhes();
                else
                    System.out.println("Não encontrado.");
            }
            case 2 -> professores.stream().filter(p -> p.getNome().toLowerCase().contains(termo.toLowerCase()))
                    .forEach(Professor::mostrarDetalhes);
            case 3 -> professores.stream().filter(p -> p.getEmail().toLowerCase().contains(termo.toLowerCase()))
                    .forEach(Professor::mostrarDetalhes);
            default -> System.out.println("Opção inválida.");
        }
    }

    // Método para registar um novo professor, com validação de entrada
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
        System.out.println(
                ">>> Professor " + nome + " registado com sucesso com o ID: " + novoProfessor.getNumeroProfessor());
    }

    // Método para listar todos os professores
    private void listarProfessores() {
        System.out.println("\n--- LISTA DE PROFESSORES ---");
        if (professores.isEmpty()) {
            System.out.println("Nenhum professor registado.");
        } else {
            for (Professor p : professores)
                p.mostrarDetalhes();
        }
    }

    // ========== ESTATÍSTICAS E RELATÓRIOS ==========

    /**
     * Menu de acesso a todos os relatórios estatísticos exigidos.
     */
    private void gerirEstatisticas() {
        int op;
        do {
            op = lerInteiro(
                    "\n--- ESTATÍSTICAS ---\n1. Geral\n2. Média Aluno\n3. Média Turma\n4. Alunos > Média\n5. Professor c/ mais UCs\n6. Turmas +/- Alunos\n7. Alunos p/ Estado\n8. Taxa Ocupação\n0. Voltar\nOpção: ");
            switch (op) {
                case 1 -> exibirContagensGerais();
                case 2 -> consultarMediaAluno();
                case 3 -> consultarMediaTurma();
                case 4 -> listarAlunosAcimaDaMedia();
                case 5 -> encontrarProfessorComMaisUCs();
                case 6 -> encontrarTurmasExtremosAlunos();
                case 7 -> listarAlunosPorEstado();
                case 8 -> exibirTaxaOcupacaoTurmas();
                case 0 -> {
                }
                default -> System.out.println("Opção inválida!");
            }
        } while (op != 0);
    }

    // Método para exibir as contagens gerais do sistema
    private void exibirContagensGerais() {
        System.out.println("\n--- NÚMEROS GERAIS DO SISTEMA ---");
        System.out.println("Total de Alunos: " + alunos.size());
        System.out.println("Total de Professores: " + professores.size());
        System.out.println("Total de Cursos: " + cursos.size());
        System.out.println("Total de Turmas: " + turmas.size());
    }

    // Método para consultar a média de um aluno específico
    private void consultarMediaAluno() {
        System.out.println("\n--- CONSULTAR MÉDIA DE ALUNO ---");
        if (alunos.isEmpty()) {
            System.out.println("Não há alunos registados.");
            return;
        }
        int id = lerInteiro("Introduza o ID do aluno: ");
        Aluno aluno = procurarAlunoPorId(id);
        if (aluno != null) {
            System.out.printf("A média do aluno %s (ID: %d) é: %.2f%n", aluno.getNome(), aluno.getNumeroAluno(),
                    aluno.calcularMedia());
        } else {
            System.out.println("Erro: Aluno com ID " + id + " não encontrado.");
        }
    }

    // Método para consultar a média de uma turma
    private void consultarMediaTurma() {
        Turma t = selecionarTurma();
        if (t == null || t.getAlunos().isEmpty())
            return;
        double media = t.getAlunos().stream().mapToDouble(Aluno::calcularMedia).average().orElse(0);
        System.out.printf("A média da turma %s é: %.2f%n", t.getNome(), media);
    }

    // Método para listar alunos com média acima de um valor
    private void listarAlunosAcimaDaMedia() {
        double min = lerDoublePositivo("Média mínima: ");
        alunos.stream().filter(a -> a.calcularMedia() > min)
                .forEach(a -> System.out.printf("- %s (Média: %.2f)%n", a.getNome(), a.calcularMedia()));
    }

    // Método para encontrar o professor com mais UCs
    private void encontrarProfessorComMaisUCs() {
        professores.stream().max(
                (p1, p2) -> Integer.compare(p1.getUnidadesCurriculares().size(), p2.getUnidadesCurriculares().size()))
                .ifPresentOrElse(
                        p -> System.out.printf("O professor com mais UCs é %s (%d UCs)%n", p.getNome(),
                                p.getUnidadesCurriculares().size()),
                        () -> System.out.println("Sem professores."));
    }

    // Método para encontrar a turma com mais e menos alunos
    private void encontrarTurmasExtremosAlunos() {
        System.out.println("\n--- TURMAS COM MAIS E MENOS ALUNOS ---");
        if (turmas.size() < 2) {
            System.out.println("São necessárias pelo menos duas turmas para comparar.");
            return;
        }

        Turma turmaMaisCheia = turmas.get(0);
        Turma turmaMaisVazia = turmas.get(0);

        for (Turma t : turmas) {
            if (t.getAlunos().size() > turmaMaisCheia.getAlunos().size())
                turmaMaisCheia = t;
            if (t.getAlunos().size() < turmaMaisVazia.getAlunos().size())
                turmaMaisVazia = t;
        }

        System.out.printf("Turma com mais alunos: %s (%d alunos)%n", turmaMaisCheia.getNome(),
                turmaMaisCheia.getAlunos().size());
        System.out.printf("Turma com menos alunos: %s (%d alunos)%n", turmaMaisVazia.getNome(),
                turmaMaisVazia.getAlunos().size());
    }

    // Método para listar alunos por estado
    private void listarAlunosPorEstado() {
        EstadoAluno estado = selecionarEstadoAluno();
        if (estado == null)
            return;
        alunos.stream().filter(a -> a.getEstado() == estado)
                .forEach(a -> System.out.printf("- %s (ID: %d)%n", a.getNome(), a.getNumeroAluno()));
    }

    // Método para exibir a taxa de ocupação das turmas
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
            System.out.printf("- Turma %s: %d/%d alunos (%.1f%% de ocupação)%n", t.getNome(), (int) inscritos,
                    (int) capacidade, taxa);
        }
    }

    // ========== MÉTODOS AUXILIARES ==========

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
            int valor = lerInteiro(prompt);
            if (valor >= 0) {
                return valor;
            } else {
                System.out.println("Erro: O valor não pode ser negativo.");
                System.out.print(prompt);
            }
        }
    }

    // Método para ler um double positivo, com validação de formato e valor
    private double lerDoublePositivo(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
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
            input = lerString(prompt);
            if (input.isEmpty()) {
                System.out.println("Erro: O campo não pode ser vazio.");
            }
        } while (input.isEmpty());
        return input;
    }

    // Método para ler uma string (pode ser vazia)
    private String lerString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
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

    // Método para ler um telefone válido, com validação de formato simples (apenas
    // dígitos)
    private String lerTelefoneValido(String prompt) {
        String telefone;
        while (true) {
            System.out.print(prompt);
            telefone = scanner.nextLine().trim();
            if (telefone.isEmpty()) {
                System.out.println("Erro: O campo não pode ser vazio.");
                continue;
            }
            if (telefone.matches("\\d+")) {
                return telefone;
            } else {
                System.out.println("Erro: O telefone deve conter apenas números.");
            }
        }
    }

    // Método para ler uma string apenas com letras e espaços, com validação de
    // formato
    private String lerStringApenasLetras(String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Erro: O campo não pode ser vazio.");
                continue;
            }
            if (input.matches("[a-zA-Z\\s]+")) {
                return input;
            } else {
                System.out.println("Erro: Este campo deve conter apenas letras e espaços.");
            }
        }
    }

    // Método para emitir um certificado para um aluno concluído
    private void emitirCertificado() {
        System.out.println("\n--- EMISSÃO DE CERTIFICADO ---");
        int id = lerInteiro("Introduza o ID do aluno concluído: ");
        Aluno aluno = procurarAlunoPorId(id);

        if (aluno == null) {
            System.out.println("Erro: Aluno com ID " + id + " não encontrado.");
            return;
        }

        if (aluno.getEstado() != EstadoAluno.CONCLUIDO) {
            System.out.println("Erro: O aluno " + aluno.getNome() + " não tem o estado 'CONCLUIDO'. Estado atual: "
                    + aluno.getEstado());
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

    // Método para procurar um aluno por ID
    private Aluno procurarAlunoPorId(int id) {
        return alunos.stream().filter(a -> a.getNumeroAluno() == id).findFirst().orElse(null);
    }

    // Método para procurar um professor por ID
    private Professor procurarProfessorPorId(int id) {
        return professores.stream().filter(p -> p.getNumeroProfessor() == id).findFirst().orElse(null);
    }

    // Método para selecionar uma turma
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

    // Método genérico para selecionar um item de uma lista
    private <T> T selecionarItem(String prompt, ArrayList<T> lista) {
        if (lista.isEmpty()) {
            System.out.println("Lista vazia.");
            return null;
        }
        for (int i = 0; i < lista.size(); i++)
            System.out.printf("%d. %s%n", i + 1, lista.get(i).toString());
        int esc = lerInteiro(prompt);
        return (esc > 0 && esc <= lista.size()) ? lista.get(esc - 1) : null;
    }

    // Método para selecionar um estado de aluno
    private EstadoAluno selecionarEstadoAluno() {
        return selecionarItem("Estado: ", new ArrayList<>(java.util.Arrays.asList(EstadoAluno.values())));
    }

    // Método para selecionar um tipo de curso
    private TipoCurso selecionarTipoCurso() {
        TipoCurso res = selecionarItem("Tipo: ", new ArrayList<>(java.util.Arrays.asList(TipoCurso.values())));
        return res != null ? res : TipoCurso.FORMACAO;
    }

    // Método para selecionar um curso
    private Curso selecionarCurso() {
        return selecionarItem("Curso: ", cursos);
    }

    // Método para selecionar uma unidade curricular
    private UnidadeCurricular selecionarUC() {
        return selecionarItem("UC: ", ucs);
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