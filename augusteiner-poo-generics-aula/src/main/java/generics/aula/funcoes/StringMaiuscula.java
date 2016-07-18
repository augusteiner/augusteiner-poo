
package generics.aula.funcoes;

import generics.aula.basico.Funcao;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class StringMaiuscula implements Funcao<String> {

    @Override
    public String calcular(String entrada) {

        return entrada.toUpperCase();
    }
}
