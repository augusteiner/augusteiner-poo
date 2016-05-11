
package br.eng.augusteiner.poo;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Aluno {

    private String matricula;
    private String nome;

    public Aluno() { }

    public String getMatricula() {

        return matricula;
    }

    public void setMatricula(String matricula) {

        this.matricula = matricula;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    @Override
    public String toString() {

        return String.format(
            "#%s - %s",
            this.getMatricula(),
            this.getNome());
    }
}
