
package generics.aula;

public class NomeDaClasse<T1, T2> {

    private T1 membro1;
    private T2 membro2;

    private NomeDaClasse(T1 arg1, T2 arg2) {

        this.membro1 = arg1;
        this.membro2 = arg2;
    }

    public T1 getMembro1() {

        return this.membro1;
    }

    public void setMembro1(T1 membro1) {

        this.membro1 = membro1;
    }

    public T2 getMembro2() {

        return this.membro2;
    }

    public void setMembro2(T2 membro2) {

        this.membro2 = membro2;
    }
}
