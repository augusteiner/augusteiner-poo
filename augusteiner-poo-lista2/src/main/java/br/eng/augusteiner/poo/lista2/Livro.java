
package br.eng.augusteiner.poo.lista2;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Livro {

    private Autor autor;
    private int anoPublicacao;
    private int edicao;

    private String titulo;

    public Livro(Autor autor, int anoPublicacao, int edicao, String titulo) {

        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.edicao = edicao;
        this.titulo = titulo;
    }

    public Autor getAutor() {

        return autor;
    }

    public void setAutor(Autor autor) {

        this.autor = autor;
    }

    public int getAnoPublicacao() {

        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {

        this.anoPublicacao = anoPublicacao;
    }

    public int getEdicao() {

        return edicao;
    }

    public void setEdicao(int edicao) {

        this.edicao = edicao;
    }

    public String getTitulo() {

        return titulo;
    }

    public void setTitulo(String titulo) {

        this.titulo = titulo;
    }

    public String toString() {

        return String.format("%s, %s. %s. %d ed", getAutor().getUltimoNome().toUpperCase(), getAutor()
            .getPrimeiroNome(), getTitulo(), getEdicao());
    }
}
