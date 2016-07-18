
package generics.aula.funcoes;

import generics.aula.basico.Funcao;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class StringInversa implements Funcao<String> {

    @Override
    public String calcular(String entrada) {

        StringBuffer buffer = new StringBuffer();

        for (int i = entrada.length() - 1; i >= 0; i--) {

            buffer.append(entrada.charAt(i));
        }

        return buffer.toString();
    }
}
