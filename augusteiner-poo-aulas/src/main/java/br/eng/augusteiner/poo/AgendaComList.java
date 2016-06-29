
package br.eng.augusteiner.poo;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class AgendaComList implements IAgenda {

    private Collection<IContato> contatos;

    public AgendaComList() {

        this.contatos = new ArrayList<IContato>();
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

    @Override
    public Iterable<IContato> buscarTodos(String nome) throws ContatoNaoEncontradoException {

        return AgendaUtils.buscarTodos(
            nome,
            this.getContatos());
    }

    public Iterable<IContato> getContatos() {

        return this.contatos;
    }

    @Override
    public void inserir(IContato contato) {

        this.contatos.add(contato);
    }

    @Override
    public int quantidadeContatos() {

        return this.contatos.size();
    }

    @Override
    public void remover(String nome) throws ContatoNaoEncontradoException {

        IContato contato = buscar(nome);

        this.contatos.remove(contato);
    }
}
