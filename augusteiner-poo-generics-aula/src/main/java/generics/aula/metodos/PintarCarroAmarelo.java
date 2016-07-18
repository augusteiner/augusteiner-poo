
package generics.aula.metodos;

import generics.aula.basico.Carro;
import generics.aula.basico.Metodo;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class PintarCarroAmarelo implements Metodo<Carro> {

    @Override
    public void executar(Carro objeto) {

        objeto.setCor(Carro.COR_AMARELA);
    }
}
