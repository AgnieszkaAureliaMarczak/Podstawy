package obiektowosc.dom;

import java.util.Arrays;

public class Pokoj {
    private Okno[] okna;
    private Lozko lozko;

    public Okno[] getOkna() {
        return okna;
    }

    public void setOkna(Okno[] okna){
        this.okna = okna;
    }

    public Lozko getLozko(){
        return lozko;
    }

    public void setLozko(Lozko lozko) {
        this.lozko = lozko;
    }

    public Pokoj(Okno[] okna1, Lozko lozko1){
       okna = okna1;
       lozko = lozko1;
    }

    public Pokoj(){

    }

    @Override
    public String toString() {
        return "Pokoj{" +
                "okna=" + Arrays.toString(okna) +
                ", lozko=" + lozko +
                '}';
    }

    public void posprzatajPokoj(){
        lozko.setIleDniOdOstatniejWymianyPoscieli(0);
        for (int i = 0; i < okna.length; i++) {
            okna[i].otworzOkno();
        }
    }
}
