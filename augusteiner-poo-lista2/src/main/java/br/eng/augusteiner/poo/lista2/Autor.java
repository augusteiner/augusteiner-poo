
package br.eng.augusteiner.poo.lista2;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Autor {

    private String ultimoNome;
    private String primeiroNome;

    public Autor(String ultimoNome, String primeiroNome) {

        this.ultimoNome = ultimoNome;
        this.primeiroNome = primeiroNome;
    }

    public String getNome() {

        return String.format("%s %s", getPrimeiroNome(), getUltimoNome());
    }

    public String getPrimeiroNome() {

        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {

        this.primeiroNome = primeiroNome;
    }

    public String getUltimoNome() {

        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {

        this.ultimoNome = ultimoNome;
    }

    public String toString() {

        return getNome();
    }
}
