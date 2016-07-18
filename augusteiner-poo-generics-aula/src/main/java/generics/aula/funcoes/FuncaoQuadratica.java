
package generics.aula.funcoes;

import generics.aula.basico.Funcao;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class FuncaoQuadratica implements Funcao<Double> {

    public final Double a;
    public final Double b;
    public final Double c;

    public FuncaoQuadratica(Double a, Double b, Double c) {

        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public Double calcular(Double x) {

        return (a * Math.pow(x, 2)) + (b * x) + c;
    }
}
