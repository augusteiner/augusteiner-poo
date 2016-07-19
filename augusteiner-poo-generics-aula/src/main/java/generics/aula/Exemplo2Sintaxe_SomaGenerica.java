
package generics.aula;

import java.math.BigDecimal;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Exemplo2Sintaxe_SomaGenerica {

    public static <T extends Number> Number soma(T arg1, T arg2) {

        return arg1.doubleValue() + arg2.doubleValue();
    }

    public static void main(String[] args) {

        println("Soma int: " + soma(1, 1));

        println("Soma double: " + soma(2.0, 3.0));

        println("Soma decimal: " + soma(BigDecimal.ONE, BigDecimal.TEN));
    }

    public static void println(Object arg) { System.out.println(arg); }
}
