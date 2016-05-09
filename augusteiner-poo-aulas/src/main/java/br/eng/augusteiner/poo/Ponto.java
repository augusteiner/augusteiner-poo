
package br.eng.augusteiner.poo;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Ponto {

    /**
     * Ponto (0.0, 0.0)
     */
    public static final Ponto ORIGEM = new Ponto(0, 0);

    private double x;
    private double y;

    public Ponto(double x, double y) {

        this.x = x;
        this.y = y;
    }

    public double getX() {

        return x;
    }

    public double getY() {

        return y;
    }

    public double distanciaOrigem() {

        return distancia(ORIGEM);
    }

    public double distancia(Ponto outro) {

        return sqrt(pow(getX() - outro.getX(), 2) + pow(getY() - outro.getY(), 2));
    }

    @Override
    public String toString() {

        return String.format("(%s, %s)", getX(), getY());
    }
}
