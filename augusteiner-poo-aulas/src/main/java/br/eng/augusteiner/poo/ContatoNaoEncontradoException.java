
package br.eng.augusteiner.poo;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class ContatoNaoEncontradoException extends Exception {

    private static final long serialVersionUID = 3963926888309800426L;

    public ContatoNaoEncontradoException(String nome) {

        super(String.format(
            "Contato '%s' não encontrado",
            nome));
    }
}
