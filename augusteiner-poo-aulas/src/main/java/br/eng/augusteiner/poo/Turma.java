/**
 *
 */
package br.eng.augusteiner.poo;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 *
 */
public class Turma {

    private String codigo;

    private Disciplina disciplina;

    private Professor[] professores;
    private Aluno[] alunos;

    public Turma() { }

    public Turma(
        String codigo,
        Disciplina disciplina,
        Professor[] professores,
        Aluno[] alunos) {

        this.codigo = codigo;
        this.disciplina = disciplina;
        this.professores = professores;
        this.alunos = alunos;
    }

    public String getCodigo() {

        return codigo;
    }

    public void setCodigo(String codigo) {

        this.codigo = codigo;
    }

    public Disciplina getDisciplina() {

        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {

        this.disciplina = disciplina;
    }

    public Aluno[] getAlunos() {

        return alunos;
    }

    public void setAlunos(Aluno[] alunos) {

        this.alunos = alunos;
    }

    public Professor[] getProfessores() {

        return professores;
    }

    public void setProfessores(Professor[] professores) {

        this.professores = professores;
    }
}
