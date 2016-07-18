
package generics.aula.funcoes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import generics.aula.basico.Funcao;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class StringEmbaralhada implements Funcao<String> {

    @Override
    public String calcular(String entrada) {

        List<String> letters = Arrays.asList(entrada.split(""));

        Collections.shuffle(letters);

        String shuffled = "";

        for (String letter : letters) {

            shuffled += letter;
        }

        return shuffled;
    }
}
