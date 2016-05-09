
package br.eng.augusteiner.poo;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Segmento {

    private Ponto p1;
    private Ponto p2;

    public Segmento(Ponto p1, Ponto p2) {

        this.p1 = p1;
        this.p2 = p2;
    }

    public Ponto getP1() {

        return p1;
    }

    public Ponto getP2() {

        return p2;
    }

    public double tamanho() {

        return tamanho(this);
    }

    public static double tamanho(Segmento segmento) {

        return tamanho(segmento.getP1(), segmento.getP2());
    }

    public static double tamanho(Ponto p1, Ponto p2) {

        return p1.distancia(p2);
    }
}
