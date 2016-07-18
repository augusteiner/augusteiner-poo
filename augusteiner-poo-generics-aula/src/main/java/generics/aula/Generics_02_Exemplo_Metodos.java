
package generics.aula;

import generics.aula.basico.Carro;
import generics.aula.basico.Metodo;
import generics.aula.metodos.PintarCarroAmarelo;
import generics.aula.metodos.PintarCarroAzul;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Generics_02_Exemplo_Metodos {

    public static void main(String[] args) {

        Carro carro1 = new Carro();

        Metodo<Carro> pintarDeAmarelo = new PintarCarroAmarelo();
        Metodo<Carro> pintarDeAzul = new PintarCarroAzul();

        pintarDeAmarelo.executar(carro1); // Exibe 'Carro Amarelo'
        System.out.println(carro1);

        pintarDeAzul.executar(carro1); // Exibe 'Carro Azul'
        System.out.println(carro1);
    }
}
