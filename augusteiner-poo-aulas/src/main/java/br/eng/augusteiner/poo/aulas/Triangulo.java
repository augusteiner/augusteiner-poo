
package br.eng.augusteiner.poo.aulas;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Triangulo {

    private Ponto a;
    private Ponto b;
    private Ponto c;

    public Triangulo(Ponto a, Ponto b, Ponto c) {

        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Ponto getA() {

        return a;
    }

    public Ponto getB() {

        return b;
    }

    public Ponto getC() {

        return c;
    }

    public double perimetro() {

        return a.distancia(b) + b.distancia(c) + c.distancia(a);
    }

    public double area() {

        // TODO implementar
        return 0;
    }

    @Override
    public String toString() {

        return getClass().getSimpleName();
    }
}
