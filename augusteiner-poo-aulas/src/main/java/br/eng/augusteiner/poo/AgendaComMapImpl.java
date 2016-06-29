
package br.eng.augusteiner.poo;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class AgendaComMapImpl implements IAgenda {

    private Map<String, IContato> contatos;

    public AgendaComMapImpl() {

        this.contatos = new Hashtable<String, IContato>();
    }

    @Override
    public IContato buscar(String nome) throws ContatoNaoEncontradoException {

        if (this.contatos.containsKey(nome)) {

            return this.contatos.get(nome);
        } else {

            throw new ContatoNaoEncontradoException(nome);
        }
    }

    @Override
    public Iterable<IContato> buscarTodos(String nome) throws ContatoNaoEncontradoException {

        return AgendaUtils.buscarTodos(
            nome,
            this.getContatos());
    }

    @Override
    public Iterable<IContato> getContatos() {

        return this.contatos.values();
    }

    @Override
    public void inserir(IContato contato) {

        this.contatos.put(contato.getNome(), contato);
    }

    @Override
    public int quantidadeContatos() {

        return this.contatos.values().size();
    }

    @Override
    public void remover(String nome) throws ContatoNaoEncontradoException {

        IContato contato = this.buscar(nome);

        this.contatos.remove(contato.getNome());
    }
}
