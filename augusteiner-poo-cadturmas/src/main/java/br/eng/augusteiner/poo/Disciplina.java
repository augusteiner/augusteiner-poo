
package br.eng.augusteiner.poo;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Disciplina {

    private String codigo;
    private String nome;

    public Disciplina() { }

    public Disciplina(
        String codigo,
        String nome) {

        this.codigo = codigo;
        this.nome = nome;
    }

    public String getCodigo() {

        return codigo;
    }

    public void setCodigo(String codigo) {

        this.codigo = codigo;
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
            this.getCodigo(),
            this.getNome());
    }
}
