
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

        return this.p1;
    }

    public Ponto getP2() {

        return this.p2;
    }

    public Ponto getP3() {

        return this.p3;
    }

    public double getTamanhoA() {

        return Segmento.tamanho(getP1(), getP2());
    }

    public double getTamanhoB() {

        return Segmento.tamanho(getP2(), getP3());
    }

    public double getTamanhoC() {

        return Segmento.tamanho(getP3(), getP1());
    }

    public double perimetro() {

        return getTamanhoA() + getTamanhoB() + getTamanhoC();
    }

    /**
     * Semiperímetro do triângulo
     *
     * @return
     */
    public double getSemiperimetro() {

        return perimetro() / 2;
    }

    public double area() {

        double s = getSemiperimetro();

        // XXX https://en.wikipedia.org/wiki/Heron%27s_formula
        return sqrt(s * (s - getTamanhoA()) * (s - getTamanhoB()) * (s - getTamanhoC()));
    }

    @Override
    public String toString() {

        return String.format("{%s; %s; %s}", getP1(), getP2(), getP3());
    }
}
