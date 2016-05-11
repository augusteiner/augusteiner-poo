
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

    public Iterable<Aluno> getAlunos() {

        return alunos;
    }

    public Iterable<Disciplina> getDisciplinas() {

        return disciplinas;
    }

    public Iterable<Professor> getProfessores() {

        return professores;
    }

    public Iterable<Turma> getTurmas() {

        return turmas;
    }

    public void addAluno(Aluno aluno) {

        this.alunos.add(aluno);
    }

    public void addDisciplina(Disciplina disciplina) {

        this.disciplinas.add(disciplina);
    }

    public void addProfessor(Professor professor) {

        this.professores.add(professor);
    }

    public void addTurma(Turma turma) {

        this.turmas.add(turma);
    }

    public Disciplina disciplina(String codigoDisciplina) {

        for (Disciplina disciplina : this.getDisciplinas()) {

            if (disciplina.getCodigo().equals(codigoDisciplina)) {

                return disciplina;
            }
        }

        return null;
    }
}
