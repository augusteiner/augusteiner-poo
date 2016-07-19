
package generics.aula;

import generics.aula.basico.Carro;

public class Exemplo1Sintaxe_TypeInference<T1, T2> {

    public static <T3, T4> void metodoGenerico(T3 arg1, T4 arg2) {

        println(arg1.getClass());
        println(arg2.getClass());
    }

    public static void main(String[] args) {

        println("Exemplo 1");
        // XXX O Java infere o tipo dos argumentos (Type Inference)
        metodoGenerico(1, 2);

        println();
        println("Exemplo 2");
        // XXX Mesmo método, outros tipos de argumentos
        metodoGenerico(new Carro(), 2.0);
    }

    public static void println(Object arg) { System.out.println(arg); }
    public static void println() { println(""); }
}
