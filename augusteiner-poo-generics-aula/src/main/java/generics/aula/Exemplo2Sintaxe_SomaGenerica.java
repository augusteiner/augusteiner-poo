
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

        println("Soma de inteiros: " + soma(1, 1));

        println("Soma de doubles: " + soma(2.0, 3.0));

        println("Soma de BigDecimals: " + soma(BigDecimal.ONE, BigDecimal.TEN));
    }

    public static void println(Object arg) { System.out.println(arg); }
}
