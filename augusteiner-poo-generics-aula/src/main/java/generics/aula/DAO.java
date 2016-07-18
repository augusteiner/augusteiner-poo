
package generics.aula;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class DAO<T> {

    private Collection<T> lista;

    public DAO() {

        this.lista = new ArrayList<T>();
    }

    public void salvar(T objeto) {

        lista.add(objeto);
    }

    public void remover(T objeto) {

        lista.remove(objeto);
    }

    public Iterable<T> listar() {

        return lista;
    }
}
