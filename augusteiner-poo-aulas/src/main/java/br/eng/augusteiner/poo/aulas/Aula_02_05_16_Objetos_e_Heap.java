
package br.eng.augusteiner.poo.aulas;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Aula_02_05_16_Objetos_e_Heap {

    public static void main(String[] args) {

        // String s = new String("IFRN");
        String nome = new String("João da Silva");

        char[] array = nome.toCharArray();

        for (int i = 0; i < array.length; i++) {

            System.out.print(array[i] + " ");
        }

        System.out.println();

        System.out.println(nome);

        String outroNome = nome + " Carvalho";
        System.out.println(outroNome);
        System.out.println(outroNome.toUpperCase().trim());
    }
}
