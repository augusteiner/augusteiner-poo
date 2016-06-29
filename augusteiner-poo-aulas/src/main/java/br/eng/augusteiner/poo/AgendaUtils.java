
package br.eng.augusteiner.poo;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class AgendaUtils {

    public static Iterable<IContato> buscarTodos(String nome, Iterable<IContato> contatos)
        throws ContatoNaoEncontradoException {

        Collection<IContato> resultado = new ArrayList<IContato>();

        for (IContato contato : contatos) {

            if (contato.getNome().contains(nome)) {

                resultado.add(contato);
            }
        }

        if (resultado.size() == 0) {

            throw new ContatoNaoEncontradoException(nome);
        }

        return resultado;
    }
}
