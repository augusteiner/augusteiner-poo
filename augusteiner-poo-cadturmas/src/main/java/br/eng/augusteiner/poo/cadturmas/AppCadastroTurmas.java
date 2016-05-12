
package br.eng.augusteiner.poo.cadturmas;

import static br.eng.augusteiner.poo.Util.print;
import static br.eng.augusteiner.poo.Util.println;

import java.util.Scanner;

import br.eng.augusteiner.poo.Aluno;
import br.eng.augusteiner.poo.Disciplina;
import br.eng.augusteiner.poo.Professor;
import br.eng.augusteiner.poo.Turma;
import br.eng.augusteiner.poo.store.DataStore;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class AppCadastroTurmas {

    private static final DataStore store = new DataStore();
    private static final Scanner scan = new Scanner(System.in);

    private static final char OP_MENU       = 'F';
    private static final char OP_SAIR       = '0';

    private static final char OP_CRIA_PROF  = '1';
    private static final char OP_CRIA_DISC  = '2';
    private static final char OP_CRIA_TURM  = '3';
    private static final char OP_CRIA_ALUN  = '4';

    private static final char OP_LIST_PROF  = '5';
    private static final char OP_LIST_DISC  = '6';
    private static final char OP_LIST_TURM  = '7';
    private static final char OP_LIST_ALUN  = '8';

    private static final char OP_ADD_ALUN   = '9';
    private static final char OP_ADD_PROF   = 'A';
    private static final char OP_DET_TURM   = 'B';

    private static void adicionarAluno() {

        Turma turma = buscarTurma();
        Aluno aluno = buscarAluno();

        turma.addAluno(aluno);
        exibirAlerta(
            "Aluno adicionado com sucesso à Turma %s",
           turma);

    }

    private static void adicionarProfessor() {

        Turma turma = buscarTurma();
        Professor professor = buscarProfessor();

        turma.addProfessor(professor);
        exibirAlerta(
            "Professor %s adicionado com sucesso à Turma %s",
            professor,
            turma);
    }

    private static Aluno buscarAluno() {

        Aluno aluno = null;
        String matricula;

        while (aluno == null) {

            print("!! Informe a matrícula do Aluno: ");
            matricula = lerString();

            aluno = store.aluno(matricula);

            if (aluno == null) {

                exibirAlerta(
                    "Aluno #%s não encontrado",
                   matricula);
            }
        }

        return aluno;
    }

    private static Professor buscarProfessor() {

        String matricula;
        Professor professor = null;

        while (professor == null) {

            print("!! Informe a matrícula do Professor: ");
            matricula = lerString();

            professor = store.professor(matricula);

            if (professor == null) {

                exibirAlerta(
                    "Professor #%s não encontrado",
                   matricula);
            }
        }

        return professor;
    }

    private static Turma buscarTurma() {

        Turma turma = null;
        String codigoTurma;

        while (turma == null) {

            println();
            print("!! Informe o código da Turma: ");
            codigoTurma = lerString();

            turma = store.turma(codigoTurma);

            if (turma == null) {

                exibirAlerta(
                    "Turma #%s não encontrada",
                   codigoTurma);
            }
        }

        return turma;
    }

    private static void criarAluno() {

        Aluno aluno = lerAluno();

        store.addAluno(aluno);

        exibirAlerta("Aluno cadastrado com sucesso");
    }

    private static void criarDisciplina() {

        Disciplina disciplina = lerDisciplina();

        store.addDisciplina(disciplina);

        exibirAlerta("Disciplina cadastrada com sucesso");
    }

    private static void criarProfessor() {

        Professor professor = lerProfessor();

        store.addProfessor(professor);

        exibirAlerta("Professor cadastrado com sucesso");
    }

    private static void criarTurma() {

        Turma turma = lerTurma();

        store.addTurma(turma);

        exibirAlerta("Turma cadastrada com sucesso");
    }

    private static void detalhesTurma() {

        Turma turma = buscarTurma();

        exibirTitulo("Disciplina da Turma");
        println("  %s", turma.getDisciplina());

        listarAlunos(turma.getAlunos());

        listarProfessores(turma.getProfessores());
    }

    private static void exibirAlerta(String mensagem) {

        println();
        println(
            "!! %s !!",
            mensagem);
    }

    private static void exibirAlerta(
        String format,
        Object... args) {

        exibirAlerta(String.format(
            format,
            args));
    }

    private static void exibirMenu() {

        println();
        println("As operações suportadas são as seguintes:");
        println();

        println("\t%s - Exibir Menu", OP_MENU);
        println();

        println("\t%s - Criar Professor", OP_CRIA_PROF);
        println("\t%s - Criar Disciplina", OP_CRIA_DISC);
        println("\t%s - Criar Turma", OP_CRIA_TURM);
        println("\t%s - Criar Aluno", OP_CRIA_ALUN);
        println();

        println("\t%s - Listar Professores", OP_LIST_PROF);
        println("\t%s - Listar Disciplinas", OP_LIST_DISC);
        println("\t%s - Listar Turmas", OP_LIST_TURM);
        println("\t%s - Listar Alunos", OP_LIST_ALUN);
        println();

        println("\t%s - Adicionar Aluno à Turma", OP_ADD_ALUN);
        println("\t%s - Adicionar Professor à Turma", OP_ADD_PROF);
        println("\t%s - Ver detalhes da Turma", OP_DET_TURM);
        println();

        println("\t%s - Sair", OP_SAIR);
    }

    private static void exibirOpcaoNaoDefinida(char opt) {

        exibirAlerta(String.format(
            "Opção %s não definida",
            opt));

        exibirMenu();
    }

    private static void exibirTitulo(String titulo) {

        println(
            ":: %s ::",
            titulo);
    }

    private static Aluno lerAluno() {

        Aluno aluno = new Aluno();

        println();
        exibirTitulo("Cadastro de Aluno");
        println();

        print("  ~> Informe a matrícula: ");
        aluno.setMatricula(lerString());
        print("  ~> Informe o nome: ");
        aluno.setNome(lerString());

        return aluno;
    }

    private static Disciplina lerDisciplina() {

        Disciplina professor = new Disciplina();

        println();
        exibirTitulo("Cadastro de Disciplina");
        println();

        print("  ~> Informe o código: ");
        professor.setCodigo(lerString());
        print("  ~> Informe o nome: ");
        professor.setNome(lerString());

        return professor;
    }

    private static char lerOpcao() {

        println();
        print("!! Informe a opção desejada: ");

        return lerString().toUpperCase().charAt(0);
    }

    private static Professor lerProfessor() {

        Professor professor = new Professor();

        println();
        exibirTitulo("Cadastro de Professor");
        println();

        print("  ~> Informe a matrícula: ");
        professor.setMatricula(lerString());
        print("  ~> Informe o nome: ");
        professor.setNome(lerString());

        return professor;
    }

    private static String lerString() {

        String line = "";

        while (line.length() == 0) {

            line = scan.nextLine().trim();
        }

        return line;
    }

    private static Turma lerTurma() {

        Turma turma = new Turma();
        Disciplina disciplina = null;
        String codigo;

        println();
        exibirTitulo("Cadastro de Turma");
        println();

        print(" ~> Informe o código: ");
        turma.setCodigo(lerString());

        while (disciplina == null) {

            print(" ~> Informe o código da Disciplina: ");
            codigo = lerString();

            disciplina = store.disciplina(codigo);

            if (disciplina != null) {

                turma.setDisciplina(disciplina);
            } else {

                exibirAlerta("Disciplina não encontrada, tente novamente");
            }
        }

        return turma;
    }

    private static void listarAlunos() {

        listarAlunos(store.getAlunos());
    }

    private static void listarAlunos(Iterable<Aluno> alunos) {

        boolean empty = true;

        println();
        exibirTitulo("Lista dos alunos");

        for (Aluno aluno : alunos) {

            empty = false;

            println("  %s", aluno);
        }

        if (empty) {

            exibirAlerta("Nenhum aluno cadastrado");
        }
    }

    private static void listarDisciplinas() {

        listarDisciplinas(store.getDisciplinas());
    }

    private static void listarDisciplinas(Iterable<Disciplina> disciplinas) {

        boolean empty = true;

        println();
        exibirTitulo("Lista das disciplinas");

        for (Disciplina disciplina : disciplinas) {

            empty = false;

            println("  %s", disciplina);
        }

        if (empty) {

            exibirAlerta("Nenhuma disciplina cadastrada");
        }
    }

    private static void listarProfessores() {

        listarProfessores(store.getProfessores());
    }

    private static void listarProfessores(Iterable<Professor> professores) {

        boolean empty = true;

        println();
        exibirTitulo("Lista dos professores");

        for (Professor professor : professores) {

            empty = false;

            println("  %s", professor);
        }

        if (empty) {

            exibirAlerta("Nenhum professor cadastrado");
        }
    }

    private static void listarTurmas() {

        boolean empty = true;

        println();
        exibirTitulo("Lista das turmas cadastrados");

        for (Turma turma : store.getTurmas()) {

            empty = false;

            println("  %s", turma);
        }

        if (empty) {

            exibirAlerta("Nenhuma turma cadastrada");
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        // XXX Plácido não dará aula entre 21/05 -> 06/06 (Prof. substituirá)

        char opt = OP_MENU;

        print(".:: Bem vindo ao programa de registro de turmas ::.");
        println();
        exibirMenu();

        while (opt != OP_SAIR) {

            opt = lerOpcao();

            tratarOpcao(opt);
        }
    }

    private static void sairAplicacao() {

        scan.close();

        exibirAlerta("Saindo da aplicação...");
    }

    private static void tratarOpcao(char opt) {

        switch (opt) {

            case OP_MENU:
                exibirMenu();
                break;
            case OP_SAIR:
                sairAplicacao();
                break;
            case OP_CRIA_ALUN:
                criarAluno();
                break;
            case OP_CRIA_PROF:
                criarProfessor();
                break;
            case OP_CRIA_DISC:
                criarDisciplina();
                break;
            case OP_CRIA_TURM:
                criarTurma();
                break;
            case OP_LIST_ALUN:
                listarAlunos();
                break;
            case OP_LIST_PROF:
                listarProfessores();
                break;
            case OP_LIST_DISC:
                listarDisciplinas();
                break;
            case OP_LIST_TURM:
                listarTurmas();
                break;

            case OP_DET_TURM:
                detalhesTurma();
                break;

            case OP_ADD_ALUN:
                adicionarAluno();
                break;
            case OP_ADD_PROF:
                adicionarProfessor();
                break;

            default:
                exibirOpcaoNaoDefinida(opt);
                break;
        }
    }
}
