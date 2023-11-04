package obiektowosc.dom;

public class Lozko {
    private int ileDniOdOstatniejWymianyPoscieli;

    /*public Lozko(int posciel) {
        ileDniOdOstatniejWymianyPoscieli = posciel;
    }*/
    public Lozko(int ileDniOdOstatniejWymianyPoscieli) {
        this.ileDniOdOstatniejWymianyPoscieli = ileDniOdOstatniejWymianyPoscieli;
    }

    public void posciel() {
        this.ileDniOdOstatniejWymianyPoscieli = 0;
    }

    public int getIleDniOdOstatniejWymianyPoscieli() {
        return ileDniOdOstatniejWymianyPoscieli;
    }

    public void setIleDniOdOstatniejWymianyPoscieli(int ileDniOdOstatniejWymianyPoscieli) {
        this.ileDniOdOstatniejWymianyPoscieli = ileDniOdOstatniejWymianyPoscieli;
    }

    @Override
    public String toString() {
        return "Lozko{" +
                "ileDniOdOstatniejWymianyPoscieli=" + ileDniOdOstatniejWymianyPoscieli +
                '}';
    }
}
