
package generics.aula.metodos;

import generics.aula.basico.Carro;
import generics.aula.basico.Metodo;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class PintarCarroAzul implements Metodo<Carro> {

    @Override
    public void executar(Carro carro) {

        carro.setCor(Carro.COR_AZUL);
    }
}
