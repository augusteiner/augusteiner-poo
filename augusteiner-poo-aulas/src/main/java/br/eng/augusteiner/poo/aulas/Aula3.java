
package br.eng.augusteiner.poo.aulas;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Aula3 {

    public static void main(String[] args) {

        Ponto p1 = new Ponto(0, 4);
        Ponto p2 = new Ponto(4, 0);
        Triangulo t1 = new Triangulo(p1, p2, Ponto.ORIGEM);

        System.out.println(String.format("Distancia do ponto %s a origem: %s", p1, p1.distanciaOrigem()));

        System.out.println(String.format("Distancia do ponto %s ao ponto %s: %s", p1, p2, p1.distancia(p2)));

        System.out.println(String.format("Perímetro do triângulo %s é: %s", t1, t1.perimetro()));

        System.out.println(String.format("Area do triângulo %s é: %s", t1, t1.area()));
    }
}
