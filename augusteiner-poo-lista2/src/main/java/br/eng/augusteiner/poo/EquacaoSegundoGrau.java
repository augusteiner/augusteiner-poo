
package br.eng.augusteiner.poo;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class EquacaoSegundoGrau {

    private double a;
    private double b;
    private double c;

    public EquacaoSegundoGrau(
        double a,
        double b,
        double c) {

        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {

        return a;
    }

    public double getB() {

        return b;
    }

    public double getC() {

        return c;
    }

    public double[] raizes() {

        double delta;
        double x1;
        double x2;

        delta = delta();

        x1 = bascara(delta);
        x2 = bascara(-delta);

        return new double[] {
            x1,
            x2 };
    }

    public double delta() {

        // XXX sqrt(b² - 4ac)
        return sqrt(pow(getB(), 2) - 4 * getA() * getC());
    }

    public double bascara(double delta) {

        return (-getB() + delta) / (2 * getA());
    }

    @Override
    public String toString() {

        return String.format(
            "%sx² %s %sx %s %s",
            getA(),
            sinal(getB()),
            abs(getB()),
            sinal(getC()),
            abs(getC()));
    }

    public static char sinal(double num) {

        return num < 0 ? '-' : '+';
    }
}
