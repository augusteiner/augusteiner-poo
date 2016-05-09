
package br.eng.augusteiner.poo.lista2;

import static br.eng.augusteiner.poo.Util.println;

import br.eng.augusteiner.poo.Comparavel;

/**
 * @author José Nascimento joseaugustodearaujonascimento@gmail.com
 */
public class Q22_Comparavel_Multiplos_Valores {

    public static final double VALOR_TESTE = 5.0;

    public static void main(String[] args) {

        Comparavel cp1 = new Comparavel(VALOR_TESTE);
        Object[] valores = new Object[]{
            cp1.getValor(), // VALOR_TESTE + 1,
            VALOR_TESTE + 2,
            VALOR_TESTE + 3,
            VALOR_TESTE + 4,
            VALOR_TESTE + 5 };
        Object[] arguments = new Object[valores.length + 2];

        for (int i = 0; i < valores.length; i++) {

            arguments[i + 1] = valores[i];
        }
        arguments[0] = cp1.getValor();
        arguments[arguments.length - 1] = cp1.eIgualAQualquerUmDe(
            valores[0],
            valores[1],
            valores[2],
            valores[3],
            valores[4]);


        println(
            "%.2f == (%.2f || %.2f || %.2f || %.2f || %.2f) == (%s)",
            arguments);
    }
}
