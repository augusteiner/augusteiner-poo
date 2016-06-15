
package br.eng.augusteiner.poo;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public interface IAgenda {

    IContato buscar(String nome) throws ContatoNaoEncontradoException;

    void inserir(IContato contato);

    int quantidadeContatos();

    void remover(String nome) throws ContatoNaoEncontradoException;
}
