
package br.eng.augusteiner.poo;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Contato implements IContato {

    private String nome;

    @Override
    public String getNome() {

        return this.nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }
}
