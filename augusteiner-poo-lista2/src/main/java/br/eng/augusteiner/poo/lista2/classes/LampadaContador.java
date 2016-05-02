
package br.eng.augusteiner.poo.lista2.classes;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class LampadaContador extends Lampada {

    private Contador contadorAcesa;
    private Contador contadorApagada;
    private Contador contadorMeiaLuz;

    public LampadaContador() {

        this(
            Contador.novo(),
            Contador.novo(),
            Contador.novo());
    }

    public LampadaContador(
        Contador contadorAcesa,
        Contador contadorApagada,
        Contador contadorMeiaLuz) {

        this.contadorAcesa = contadorAcesa;
        this.contadorApagada = contadorApagada;
        this.contadorMeiaLuz = contadorMeiaLuz;
    }

    public Contador getContadorAcesa() {

        return contadorAcesa;
    }

    public Contador getContadorApagada() {

        return contadorApagada;
    }

    public Contador getContadorMeiaLuz() {

        return contadorMeiaLuz;
    }

    @Override
    public void acender() {

        if (!estaAcesa()) {

            getContadorAcesa().incrementar();
        }

        super.acender();
    }

    @Override
    public void apagar() {

        if (!estaApagada()) {

            getContadorApagada().incrementar();
        }

        super.apagar();
    }

    @Override
    public void meiaLuz() {

        if (!estaAMeiaLuz()) {

            getContadorMeiaLuz().incrementar();
        }

        super.meiaLuz();
    }

    @Override
    public String toString() {

        return String.format(
            "(L: %s, D: %s, M: %s)",
            getContadorAcesa(),
            getContadorApagada(),
            getContadorMeiaLuz());
    }
}
