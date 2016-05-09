
package br.eng.augusteiner.poo;

import static java.lang.Math.PI;
import static java.lang.Math.pow;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Circulo {

    private Ponto centro;
    private Ponto p1;

    public Circulo(Ponto centro, Ponto p1) {

        this.centro = centro;
        this.p1 = p1;
    }

    public Ponto getP1() {

        return p1;
    }

    public Ponto getCentro() {

        return centro;
    }

    public double raio() {

        return getCentro().distancia(getP1());
    }

    public double permimetro() {

        return 2 * PI * raio();
    }

    public double area() {

        return PI * pow(raio(), 2);
    }

    public String toString() {

        return String.format("%s ~> %s", getCentro(), raio());
    }
}
