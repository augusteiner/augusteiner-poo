
package br.eng.augusteiner.poo;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public interface IAgenda {

    void inserir(IContato contato);

    void remover(String nome);

    IContato buscar(String nome);

    int quantidadeContatos();
}
