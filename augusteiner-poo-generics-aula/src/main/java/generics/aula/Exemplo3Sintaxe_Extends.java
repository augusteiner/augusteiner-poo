
package generics.aula;

import java.util.ArrayList;
import java.util.List;

import generics.aula.basico.Carro;
import generics.aula.basico.Funcao;
import generics.aula.funcoes.FuncaoQuadratica;
import generics.aula.funcoes.StringInversa;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Exemplo3Sintaxe_Extends {

    public static void main(String[] args) {

        listaDeFuncoes();
    }

    public static <T extends Carro> void alterarCor(T carro, int cor) {

        carro.setCor(cor);
    }

    public static void listaDeFuncoes() {

        List<Funcao<? extends Object>> funcoes = new ArrayList<Funcao<?>>();

        funcoes.add(new FuncaoQuadratica(0.0, 0.0, 0.0));
        funcoes.add(new StringInversa());

        for (Funcao<?> f : funcoes) {

            System.out.println(f.getClass().getSimpleName());
        }
    }
}
