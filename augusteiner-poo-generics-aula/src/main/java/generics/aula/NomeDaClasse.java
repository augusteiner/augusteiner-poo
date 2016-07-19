
package generics.aula;

import generics.aula.basico.Carro;

public class NomeDaClasse<T1, T2> {

    public static <A1, A2> void nomeDoMetodo(A1 arg1, A2 arg2) {

    }

    public static void testeMetodoGenerico() {

        // XXX O Java sabe o tipo dos argumentos
        nomeDoMetodo(1, 2);

        // XXX Mesmo método, outros tipos de argumentos
        nomeDoMetodo(new Carro(), 2.0);
    }
}
