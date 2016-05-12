
package br.eng.augusteiner.poo.store;

import java.util.ArrayList;
import java.util.List;

import br.eng.augusteiner.poo.Aluno;
import br.eng.augusteiner.poo.Disciplina;
import br.eng.augusteiner.poo.Professor;
import br.eng.augusteiner.poo.Turma;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class DataStore {

    private List<Aluno> alunos;
    private List<Disciplina> disciplinas;
    private List<Professor> professores;
    private List<Turma> turmas;

    public DataStore() {

        this.alunos = new ArrayList<Aluno>();
        this.disciplinas = new ArrayList<Disciplina>();
        this.professores = new ArrayList<Professor>();
        this.turmas = new ArrayList<Turma>();
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

    public Aluno aluno(String matricula) {

        for (Aluno aluno : this.alunos) {

            if (aluno.getMatricula().equals(matricula)) {

                return aluno;
            }
        }

        return null;
    }

    public Disciplina disciplina(String codigo) {

        for (Disciplina disciplina : this.disciplinas) {

            if (disciplina.getCodigo().equals(codigo)) {

                return disciplina;
            }
        }

        return null;
    }

    public Iterable<Aluno> getAlunos() {

        return this.alunos;
    }

    public Iterable<Disciplina> getDisciplinas() {

        return this.disciplinas;
    }

    public Iterable<Professor> getProfessores() {

        return this.professores;
    }

    public Iterable<Turma> getTurmas() {

        return this.turmas;
    }

    public Professor professor(String matricula) {

        for (Professor professor : this.professores) {

            if (professor.getMatricula().equals(matricula)) {

                return professor;
            }
        }

        return null;
    }

    public Turma turma(String codigo) {

        for (Turma turma : this.turmas) {

            if (turma.getCodigo().equals(codigo)) {

                return turma;
            }
        }

        return null;
    }
}
