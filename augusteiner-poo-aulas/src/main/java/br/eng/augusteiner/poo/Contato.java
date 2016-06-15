
package br.eng.augusteiner.poo;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Contato implements IContato {

    private String nome;
    private String fone;

    public Contato() { }

    public Contato(String nome) {

        this.nome = nome;
    }

    public Contato(String nome, String fone) {

        this(nome);

        this.fone = fone;
    }

    @Override
    public String getFone() {

        return this.fone;
    }

    @Override
    public String getNome() {

        return this.nome;
    }

    public void setFone(String fone) {

        this.fone = fone;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public String toString() {

        return String.format(
            "%s: %s",
            this.getNome(),
            this.getFone());
    }
}
