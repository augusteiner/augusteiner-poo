
package br.eng.augusteiner.poo;

/**
 * @author José Nascimento joseaugustodearaujonascimento@gmail.com
 */
public class Comparavel {

    private Object valor;

    public Comparavel(Object valor) {

        this.valor = valor;
    }

    public boolean eIgualAQualquerUmDe(
        Comparavel cp1,
        Comparavel cp2) {

        return eIgualAQualquerUmDe(
            cp1.getValor(),
            cp2.getValor());
    }

    public boolean eIgualAQualquerUmDe(
        Comparavel cp1,
        Comparavel cp2,
        Comparavel cp3) {

        return eIgualAQualquerUmDe(cp1, cp2) ||
            eIgualAQualquerUmDe(cp2, cp3);
    }

    public boolean eIgualAQualquerUmDe(
        Comparavel cp1,
        Comparavel cp2,
        Comparavel cp3,
        Comparavel cp4) {

        return eIgualAQualquerUmDe(cp1, cp2) ||
            eIgualAQualquerUmDe(cp3, cp4);
    }

    public boolean eIgualAQualquerUmDe(
        Comparavel cp1,
        Comparavel cp2,
        Comparavel cp3,
        Comparavel cp4,
        Comparavel cp5) {

        return eIgualAQualquerUmDe(cp1, cp2) ||
            eIgualAQualquerUmDe(cp3, cp4, cp5);
    }

    public boolean eIgualAQualquerUmDe(
        Object valor1,
        Object valor2) {

        return getValor().equals(valor1) ||
            getValor().equals(valor2);
    }

    public boolean eIgualAQualquerUmDe(
        Object valor1,
        Object valor2,
        Object valor3) {

        return eIgualAQualquerUmDe(valor1, valor2) ||
            eIgualAQualquerUmDe(valor2, valor3);
    }

    public boolean eIgualAQualquerUmDe(
        Object valor1,
        Object valor2,
        Object valor3,
        Object valor4) {

        return eIgualAQualquerUmDe(valor1, valor2) ||
            eIgualAQualquerUmDe(valor3, valor4);
    }

    public boolean eIgualAQualquerUmDe(
        Object valor1,
        Object valor2,
        Object valor3,
        Object valor4,
        Object valor5) {

        return eIgualAQualquerUmDe(valor1, valor2, valor3) ||
            eIgualAQualquerUmDe(valor4, valor5);
    }

    public Object getValor() {

        return this.valor;
    }

    @Override
    public String toString() {

        return String.format(
            "%s: %s",
            super.toString().split("@")[1],
            (String) getValor());
    }
}
