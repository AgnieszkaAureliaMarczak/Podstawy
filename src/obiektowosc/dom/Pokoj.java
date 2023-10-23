package obiektowosc.dom;

import java.util.Arrays;

public class Pokoj {
    private Okno[] okna;
    private Lozko lozko;

    public Pokoj(Okno[] okna1, Lozko lozko1){
       okna = okna1;
       lozko = lozko1;
    }

    @Override
    public String toString() {
        return "Pokoj{" +
                "okna=" + Arrays.toString(okna) +
                ", lozko=" + lozko +
                '}';
    }
}
