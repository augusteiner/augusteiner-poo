
package br.eng.augusteiner.poo.aulas;

import static br.eng.augusteiner.poo.Util.getScanner;
import static br.eng.augusteiner.poo.Util.print;
import static br.eng.augusteiner.poo.Util.println;

import java.util.Scanner;

import br.eng.augusteiner.poo.Aluno;
import br.eng.augusteiner.poo.Disciplina;
import br.eng.augusteiner.poo.Professor;
import br.eng.augusteiner.poo.Turma;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Aula_11_05_16_Correcao_Prova_e_Exercicio {

    private static final Db db = new Db();

    private static final byte OPT_MENU = 9;
    private static final byte OPT_EXIT = 0;

    private static final byte OPT_CRIA_PROF = 1;
    private static final byte OPT_CRIA_DISC = 2;
    private static final byte OPT_CRIA_TURM = 3;
    private static final byte OPT_CRIA_ALUN = 4;

    private static final byte OPT_LIST_PROF = 5;
    private static final byte OPT_LIST_DISC = 6;
    private static final byte OPT_LIST_TURM = 7;
    private static final byte OPT_LIST_ALUN = 8;

    private static final Scanner scn = getScanner();

    /**
     * @param args
     */
    public static void main(String[] args) {

        // XXX Plácido não dará aula entre 21/05 -> 06/06 (Prof. substituirá)

        byte opt = OPT_MENU;

        //Aluno aluno = new Aluno(
        //    "2015.1.001.00035",
        //    "José Augusto de A. Nascimento");
        //db.addAluno(aluno);

        print(".:: Bem vindo ao programa de registro de turmas ::.");
        println();
        imprimirMenu();

        while (opt != OPT_EXIT)
        {
            opt = lerOpcao();

            tratarOpcao(opt);
        }
    }

    private static void tratarOpcao(byte opt) {

        switch (opt)
        {
            case OPT_MENU:
                imprimirMenu();
                break;
            case OPT_EXIT:
                sairAplicacao();
                break;
            case OPT_CRIA_ALUN:
                criarAluno();
                break;
            case OPT_CRIA_PROF:
                criarProfessor();
                break;
            case OPT_CRIA_DISC:
                criarDisciplina();
                break;
            case OPT_CRIA_TURM:
                criarTurma();
                break;
            case OPT_LIST_ALUN:
                listarAlunos();
                break;
            case OPT_LIST_PROF:
                listarProfessores();
                break;
            case OPT_LIST_DISC:
                listarDisciplinas();
                break;
            case OPT_LIST_TURM:
                listarTurmas();
                break;
            default:
                opcaoNaoDefinida(opt);
                break;
        }
    }

    private static byte lerOpcao() {

        println();
        print("!! Informe a opção desejada: ");

        return scn.nextByte();
    }

    private static void imprimirMenu() {

        println();
        println("As operações suportadas são as seguintes:");
        println();

        println("\t %s - Exibir Menu", OPT_MENU);
        println();

        println("\t %s - Criar Professor", OPT_CRIA_PROF);
        println("\t %s - Criar Disciplina", OPT_CRIA_DISC);
        println("\t %s - Criar Turma", OPT_CRIA_TURM);
        println("\t %s - Criar Aluno", OPT_CRIA_ALUN);
        println();

        println("\t %s - Listar Professores", OPT_LIST_PROF);
        println("\t %s - Listar Disciplinas", OPT_LIST_DISC);
        println("\t %s - Listar Turmas", OPT_LIST_TURM);
        println("\t %s - Listar Alunos", OPT_LIST_ALUN);
        println();

        println("\t %s - Sair", OPT_EXIT);
    }

    private static void opcaoNaoDefinida(byte opt) {

        exibirMensagem(String.format(
            "Opção %s não definida",
            opt));

        imprimirMenu();
    }

    private static void sairAplicacao() {

        scn.close();
        println("Saindo da aplicação...");
    }

    private static void listarTurmas() {

        boolean empty = true;

        println();
        println(":: Lista das turmas cadastrados ::");

        for (Turma turma : db.getTurmas()) {

            empty = false;

            println("  %s", turma);
        }

        if (empty) {

            exibirMensagem("Nenhuma turma cadastrada");
        }
    }

    private static void listarDisciplinas() {

        boolean empty = true;

        println();
        println(":: Lista das disciplinas cadastrados ::");

        for (Disciplina disciplina : db.getDisciplinas()) {

            empty = false;

            println("  %s", disciplina);
        }

        if (empty) {

            exibirMensagem("Nenhuma disciplina cadastrada");
        }
    }

    private static void listarProfessores() {

        boolean empty = true;

        println();
        println(":: Lista dos professores cadastrados ::");

        for (Professor professor : db.getProfessores()) {

            empty = false;

            println("  %s", professor);
        }

        if (empty) {

            exibirMensagem("Nenhum professor cadastrado");
        }
    }

    private static void listarAlunos() {

        boolean empty = true;

        println();
        println(":: Lista dos alunos cadastrados ::");

        for (Aluno aluno : db.getAlunos()) {

            empty = false;

            println("  %s", aluno);
        }

        if (empty) {

            exibirMensagem("Nenhum aluno cadastrado");
        }
    }

    private static void criarTurma() {

        Turma turma = lerTurma();

        db.addTurma(turma);

        exibirMensagem("Turma cadastrada com sucesso");
    }

    private static Turma lerTurma() {

        Turma turma = new Turma();
        Disciplina disciplina = null;
        String codigoDisciplina;

        println();
        println(":: Cadastro de Turma ::");
        println();

        print(" ~> Informe o código: ");
        turma.setCodigo(lerString());

        while (disciplina == null) {

            print(" ~> Informe o código da Disciplina: ");
            codigoDisciplina = lerString();

            disciplina = db.disciplina(codigoDisciplina);

            if (disciplina != null) {

                turma.setDisciplina(disciplina);
            } else {

                exibirMensagem("Disciplina não encontrada, tente novamente");
            }
        }

        return turma;
    }

    private static void criarDisciplina() {

        Disciplina disciplina = lerDisciplina();

        db.addDisciplina(disciplina);

        exibirMensagem("Disciplina cadastrada com sucesso");
    }

    private static Disciplina lerDisciplina() {

        Disciplina professor = new Disciplina();

        println();
        println(":: Cadastro de Disciplina ::");
        println();

        print("  ~> Informe a matrícula: ");
        professor.setCodigo(lerString());
        print("  ~> Informe o nome: ");
        professor.setNome(lerString());

        return professor;
    }

    private static void criarProfessor() {

        Professor professor = lerProfessor();

        db.addProfessor(professor);

        exibirMensagem("Professor cadastrado com sucesso");
    }

    private static Professor lerProfessor() {

        Professor professor = new Professor();

        println();
        println(":: Cadastro de Professor ::");
        println();

        print("  ~> Informe a matrícula: ");
        professor.setMatricula(lerString());
        print("  ~> Informe o nome: ");
        professor.setNome(lerString());

        return professor;
    }

    private static void criarAluno() {

        Aluno aluno = lerAluno();

        db.addAluno(aluno);

        exibirMensagem("Aluno cadastrado com sucesso");
    }

    private static void exibirMensagem(String mensagem) {

        println();
        println(
            "!! %s !!",
            mensagem);
    }

    private static Aluno lerAluno() {

        Aluno aluno = new Aluno();

        println();
        println(":: Cadastro de Aluno ::");
        println();

        print("  ~> Informe a matrícula: ");
        aluno.setMatricula(lerString());
        print("  ~> Informe o nome: ");
        aluno.setNome(lerString());

        return aluno;
    }

    private static String lerString() {

        String line = "";

        while (line.length() == 0) {

            line = scn.nextLine().trim();
        }

        return line;
    }
}
