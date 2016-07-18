
package generics.aula;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Collection;

import generics.aula.basico.Carro;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Generics_01_Introducao {

    private static void sysout(Object... args) { out.println(args); }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main1(String[] args) {

        // XXX Antes do Java 5

        Collection objetos = new ArrayList();

        objetos.add("eu sou uma string");
        objetos.add(1.5);
        objetos.add(1);
        objetos.add(new Carro());

        for (Object objeto : objetos) {

            // TODO Devo checar para todas as possibilidades??
            if (objeto instanceof Carro) {

                sysout(((Carro) objeto).getQuantidadeRodas());
            }
        }
    }

    public static void main(String[] args) {

        Collection<Carro> carros = new ArrayList<Carro>();

        //carros.add("eu sou uma string"); // XXX Erro em compile-time
        //carros.add(1.5); // XXX Erro em compile-time
        //carros.add(1); // XXX Erro em compile-time

        carros.add(new Carro());

        for (Carro carro : carros) {

            sysout(carro.getQuantidadeRodas());
        }
    }
}
