
package generics.aula.funcoes;

import generics.aula.basico.Funcao;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class FuncaoComposta<T> implements Funcao<T> {

    private Funcao<T> f1;
    private Funcao<T> f2;

    public FuncaoComposta(Funcao<T> f1, Funcao<T> f2) {

        this.f1 = f1;
        this.f2 = f2;
    }

    @Override
    public T calcular(T entrada) {

        return this.f1.calcular(f2.calcular(entrada));
    }
}
