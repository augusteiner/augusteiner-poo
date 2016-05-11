
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
public class Aula_11_05_16_Correcao_Prova {

    private static final Db db = new Db();

    private static final byte OPT_CRIA_PROF = 1;
    private static final byte OPT_CRIA_DISC = 2;
    private static final byte OPT_CRIA_TURM = 3;
    private static final byte OPT_CRIA_ALUN = 4;

    private static final byte OPT_LIST_PROF = 5;
    private static final byte OPT_LIST_DISC = 6;
    private static final byte OPT_LIST_TURM = 7;
    private static final byte OPT_LIST_ALUN = 8;

    private static final byte OPT_MENU = 0;
    private static final byte OPT_EXIT = 9;

    private static final Scanner scn = getScanner();

    /**
     * @param args
     */
    public static void main(String[] args) {

        // XXX Plácido não dará aula entre 21/05 -> 06/06 (Prof. substituirá)

        byte opt = OPT_MENU;

        print(".:: Bem vindo ao programa de registro de turmas ::.");
        println();
        imprimirMenu();

        while (opt != OPT_EXIT)
        {
            opt = perguntarOpcao();

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

    private static void opcaoNaoDefinida(byte opt) {

        println(String.format(
            "Opção %s não definida",
            opt));
        imprimirMenu();
    }

    private static void sairAplicacao() {

        scn.close();
        println("Saindo da aplicação...");
    }

    private static void listarTurmas() {

        for (Turma turma : db.getTurmas()) {

            println(turma);
        }
    }

    private static void listarDisciplinas() {

        for (Disciplina disciplina : db.getDisciplinas()) {

            println(disciplina);
        }
    }

    private static void listarProfessores() {

        for (Professor professor : db.getProfessores()) {

            println(professor);
        }
    }

    private static void listarAlunos() {

        for (Aluno aluno : db.getAlunos()) {

            println(aluno);
        }
    }

    private static void criarTurma() {

        Turma turma = lerTurma();

        db.addTurma(turma);
    }

    private static Turma lerTurma() {

        return null;
    }

    private static void criarDisciplina() {

        Disciplina disciplina = lerDisciplina();

        db.addDisciplina(disciplina);
    }

    private static Disciplina lerDisciplina() {

        return null;
    }

    private static void criarProfessor() {

        Professor professor = lerProfessor();

        db.addProfessor(professor);
    }

    private static Professor lerProfessor() {

        return null;
    }

    private static void criarAluno() {

        Aluno aluno = lerAluno();

        db.addAluno(aluno);
    }

    private static Aluno lerAluno() {

        return null;
    }

    private static byte perguntarOpcao() {

        println();
        print("Informe a opção desejada: ");

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
}
