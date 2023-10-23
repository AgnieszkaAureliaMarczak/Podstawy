package obiektowosc.dom;

public class Lozko {
    private int ileDniOdOstatniejWymianyPoscieli;

    /*public Lozko(int posciel) {
        ileDniOdOstatniejWymianyPoscieli = posciel;
    }*/

    public Lozko(int ileDniOdOstatniejWymianyPoscieli) {
        this.ileDniOdOstatniejWymianyPoscieli = ileDniOdOstatniejWymianyPoscieli;
    }

 /*   public Lozko() {

    }*/

    @Override
    public String toString() {
        return "Lozko{" +
                "ileDniOdOstatniejWymianyPoscieli=" + ileDniOdOstatniejWymianyPoscieli +
                '}';
    }
}
