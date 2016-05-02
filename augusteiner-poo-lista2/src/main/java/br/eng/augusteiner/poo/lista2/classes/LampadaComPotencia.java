
package br.eng.augusteiner.poo.lista2.classes;

/**
 * @author José Nascimento joseaugustodearaujonascimento@gmail.com
 */
public class LampadaComPotencia extends Lampada {

    public static final int POTENCIA_PADRAO = 60;

    private int potencia;

    public LampadaComPotencia() {

        this(POTENCIA_PADRAO);
    }

    public LampadaComPotencia(int potencia) {

        this.potencia = potencia;
    }

    public int getPotencia() {

        return potencia;
    }

    public void setPotencia(int potencia) {

        this.potencia = potencia;
    }

    @Override
    public String toString() {

        return String.format(
            "%sW (%s)",
            this.getPotencia(),
            super.toString());
    }
}
