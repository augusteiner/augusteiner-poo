
package br.eng.augusteiner.poo.lista2.questoes;

import static br.eng.augusteiner.poo.lista2.Util.sysout;

import br.eng.augusteiner.poo.lista2.classes.Comparavel;

/**
 * @author José Nascimento joseaugustodearaujonascimento@gmail.com
 */
public class Q21_Comparavel_Dois_Valores {

    private static final String VALOR_TESTE = "Eu sou assim";

    public static void main(String[] args) {

        Comparavel cp1 = new Comparavel(VALOR_TESTE);
        Comparavel cp2 = new Comparavel(VALOR_TESTE);
        Comparavel cp3 = new Comparavel(VALOR_TESTE + "!");

        sysout(
            "\"%s\" == (\"%s\" || \"%s\") ~> (%s)",
            cp1,
            cp2,
            cp3,
            cp1.eIgualAQualquerUmDe(cp1, cp2));
    }
}
