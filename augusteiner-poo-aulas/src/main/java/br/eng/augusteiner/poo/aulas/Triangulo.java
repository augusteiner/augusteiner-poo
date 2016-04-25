
package br.eng.augusteiner.poo.aulas;

import static java.lang.Math.sqrt;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Triangulo {

    private Ponto p1;
    private Ponto p2;
    private Ponto p3;

    public Triangulo(Ponto p1, Ponto p2, Ponto p3) {

        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public Ponto getP1() {

        return p1;
    }

    public Ponto getP2() {

        return p2;
    }

    public Ponto getP3() {

        return p3;
    }

    public double getA() {

        return getP1().distancia(getP2());
    }

    private double getB() {

        return getP2().distancia(getP3());
    }

    private double getC() {

        return getP3().distancia(getP1());
    }

    public double perimetro() {

        return getA() + getB() + getC();
    }

    private double getSemiperimetro() {

        return perimetro() / 2;
    }

    public double area() {

        // Semiperímetro do triângulo
        double s = getSemiperimetro();

        // XXX https://en.wikipedia.org/wiki/Heron%27s_formula
        return sqrt(s * (s - getA()) * (s - getB()) * (s - getC()));
    }

    @Override
    public String toString() {

        return getClass().getSimpleName();
    }
}
