
package br.eng.augusteiner.poo;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Lampada {

    private final static double potencia = 0;

    private final boolean ligada;

    public Lampada() {

        ligada = false;
    }

    public Lampada(boolean ligada) {

        this.ligada = ligada;
    }

    public static double getPotencia() {

        return potencia;
    }

    public boolean isLigada() {

        return ligada;
    }
}
