
package br.eng.augusteiner.poo.lista2.classes;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Lampada {

    public static final int ESTADO_APAGADA = 0;
    public static final int ESTADO_ACESA = 1;
    public static final int ESTADO_MEIA_LUZ = 2;

    private int estado;

    public Lampada() {

        this.estado = ESTADO_APAGADA;
    }

    public int getEstado() {

        return estado;
    }

    private void setEstado(int estado) {

        this.estado = estado;
    }

    public void acender() {

        setEstado(ESTADO_ACESA);
    }

    public void apagar() {

        setEstado(ESTADO_APAGADA);
    }

    public void meiaLuz() {

        setEstado(ESTADO_MEIA_LUZ);
    }

    public boolean estaAcesa() {

        return getEstado() == ESTADO_ACESA;
    }

    public boolean estaApagada() {

        return getEstado() == ESTADO_APAGADA;
    }

    public boolean estaAMeiaLuz() {

        return getEstado() == ESTADO_MEIA_LUZ;
    }

    public String getEstadoComoString() {

        switch (getEstado()) {
            case ESTADO_ACESA:

                return "acesa";
            case ESTADO_APAGADA:

                return "apagada";
            case ESTADO_MEIA_LUZ:

                return "meia luz";
            default:

                return "<< desconhecido >>";
        }
    }

    @Override
    public String toString() {

        return String.format(
            "%s",
            getEstadoComoString());
    }
}
