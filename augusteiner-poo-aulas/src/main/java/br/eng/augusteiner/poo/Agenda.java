
package br.eng.augusteiner.poo;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Agenda implements IAgenda {

    private Collection<IContato> contatos;

    public Agenda() {

        contatos = new ArrayList<IContato>();
    }

    @Override
    public IContato buscar(String nome) throws ContatoNaoEncontradoException {

        for (IContato contato : this.getContatos()) {

            if (contato.getNome().equals(nome)) {

                return contato;
            }
        }

        throw new ContatoNaoEncontradoException(nome);
    }

    public Iterable<IContato> getContatos() {

        return contatos;
    }

    @Override
    public void inserir(IContato contato) {

        this.contatos.add(contato);
    }

    @Override
    public int quantidadeContatos() {

        return 0;
    }

    @Override
    public void remover(String nome) throws ContatoNaoEncontradoException {

        IContato contato = buscar(nome);

        contatos.remove(contato);
    }
}
