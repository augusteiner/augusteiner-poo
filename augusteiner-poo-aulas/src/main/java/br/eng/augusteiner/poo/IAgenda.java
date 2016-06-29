
package br.eng.augusteiner.poo;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public interface IAgenda {

    IContato buscar(String nome) throws ContatoNaoEncontradoException;

    Iterable<IContato> buscarTodos(String nome) throws ContatoNaoEncontradoException;

    Iterable<IContato> getContatos();

    void inserir(IContato contato);

    int quantidadeContatos();

    void remover(String nome) throws ContatoNaoEncontradoException;
}
