
package br.eng.augusteiner.poo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Turma {

    private String codigo;

    private Disciplina disciplina;

    private List<Professor> professores;
    private List<Aluno> alunos;

    public Turma() {

        this.codigo = "";
        this.disciplina = null;
        this.professores = new ArrayList<Professor>();
        this.alunos = new ArrayList<Aluno>();
    }

    public Turma(
        String codigo,

        Disciplina disciplina,

        Professor[] professores,
        Aluno[] alunos) {

        this();

        this.codigo = codigo;
        this.disciplina = disciplina;

        this.addProfessores(professores);
        this.addAlunos(alunos);
    }

    public void addAluno(Aluno aluno) {

        this.alunos.add(aluno);
    }

    public void addAlunos(Aluno[] alunos) {

        for (Aluno aluno : alunos) {

            this.addAluno(aluno);
        }
    }

    public void addProfessor(Professor professor) {

        this.professores.add(professor);
    }

    public void addProfessores(Professor[] professores) {

        for (Professor professor : professores) {

            this.addProfessor(professor);
        }
    }

    public Iterable<Aluno> getAlunos() {

        return this.alunos;
    }

    public String getCodigo() {

        return codigo;
    }

    public Disciplina getDisciplina() {

        return disciplina;
    }

    public Iterable<Professor> getProfessores() {

        return this.professores;
    }

    public void setCodigo(String codigo) {

        this.codigo = codigo;
    }

    public void setDisciplina(Disciplina disciplina) {

        this.disciplina = disciplina;
    }

    @Override
    public String toString() {

        return String.format(
            "#%s - (%s)",
            this.getCodigo(),
            this.getDisciplina());
    }
}
