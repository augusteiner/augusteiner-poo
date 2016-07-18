
package generics.aula;

import generics.aula.comum.IVeiculo;
import generics.aula.modelo.Carro;
import generics.aula.modelo.Moto;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Generics_01_Intro {

    public static void main(String[] args) {

        DAO<? extends IVeiculo> veiculos = new DAO<IVeiculo>();

        Carro fitao = new Carro();
        fitao.setNome("Fiat Uno");

        Moto ninja = new Moto();
        ninja.setNome("Ninja 300");

        veiculos.salvar(fitao);
        veiculos.salvar(ninja);

        for (Object c : veiculos.listar()) {

            System.out.println(c);
        }
    }
}
