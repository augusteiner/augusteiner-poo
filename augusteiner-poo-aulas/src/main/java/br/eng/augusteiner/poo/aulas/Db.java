package br.eng.augusteiner.poo.aulas;

import java.util.ArrayList;
import java.util.List;

import br.eng.augusteiner.poo.Aluno;
import br.eng.augusteiner.poo.Disciplina;
import br.eng.augusteiner.poo.Professor;
import br.eng.augusteiner.poo.Turma;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Db {

    private List<Aluno> alunos;
    private List<Disciplina> disciplinas;
    private List<Professor> professores;
    private List<Turma> turmas;

    public Db() {

        this.alunos = new ArrayList<Aluno>();
        this.disciplinas = new ArrayList<Disciplina>();
        this.professores = new ArrayList<Professor>();
        this.turmas = new ArrayList<Turma>();
    }

    public List<Aluno> getAlunos() {

        return alunos;
    }

    public List<Disciplina> getDisciplinas() {

        return disciplinas;
    }

    public List<Professor> getProfessores() {

        return professores;
    }

    public List<Turma> getTurmas() {

        return turmas;
    }

    public void addAluno(Aluno aluno) {

        getAlunos().add(aluno);
    }

    public void addDisciplina(Disciplina disciplina) {

        getDisciplinas().add(disciplina);
    }

    public void addProfessor(Professor professor) {

        getProfessores().add(professor);
    }

    public void addTurma(Turma turma) {

        getTurmas().add(turma);
    }
}
