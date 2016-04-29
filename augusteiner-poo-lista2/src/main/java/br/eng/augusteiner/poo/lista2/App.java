
package br.eng.augusteiner.poo.lista2;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class App {

    private static final String SEPARADOR = "------------------------";

    public static void main(String[] args) {

        Autor autor1 = new Autor("Nascimento", "José Augusto de Araújo");
        Livro livro1 = new Livro(autor1, 2016, 5, "Como criar classes em Java");

        sysout(
            "Livro 1: %s",
            livro1);

        sysout(SEPARADOR);

        EquacaoSegundoGrau equacao1 = new EquacaoSegundoGrau(1, -6, -27);
        double raizes[] = equacao1.raizes();

        sysout(
            "Equação: %s ~> (x': %s, x'': %s)",
            equacao1,
            raizes[0],
            raizes[1]);

        sysout(SEPARADOR);

        Contador contador1 = new Contador(2);

        sysout(
            "Contador: %s",
            contador1.decrementar(false));

        sysout(
            "Contador: %s",
            contador1.decrementar(false));
        sysout(
            "Contador: %s",
            contador1);

        sysout(
            "Contador: %s",
            contador1.decrementar());

        sysout(SEPARADOR);

        Lampada lampada1 = new Lampada();

        sysout(
            "Lâmpada: %s",
            lampada1);

        sysout(SEPARADOR);

        Lampada lampada2 = new LampadaContador();

        lampada2.acender();
        lampada2.acender();
        sysout(
            "Lâmpada: %s",
            lampada2);
        lampada2.apagar();
        lampada2.acender();
        lampada2.meiaLuz();
        sysout(
            "Lâmpada: %s",
            lampada2);
    }

    private static void sysout(
        String formato,
        Object... args) {

        System.out.println(String.format(
            formato,
            args));
    }

    private static void sysout(Object texto) {

        System.out.println(texto);
    }
}
