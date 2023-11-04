package obiektowosc.dom;

import java.util.Arrays;

public class Pokoj {
    private Okno[] okna;
    private Lozko lozko;

    public Pokoj(Okno[] okna1, Lozko lozko1){
        okna = okna1;
        lozko = lozko1;
    }

    public Pokoj(){
        Okno[] tablicaOkien = new Okno[2];
        for (int i = 0; i < tablicaOkien.length; i++) {
            tablicaOkien[i] = new Okno();
        }
        okna = tablicaOkien;
        lozko = new Lozko(5);
    }

    public void posprzataj(){
        lozko.posciel();
        for (Okno okno : okna) {
            okno.otworz();
        }
    }

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

    @Override
    public String toString() {
        return "Pokoj{" +
                "okna=" + Arrays.toString(okna) +
                ", lozko=" + lozko +
                '}';
    }
}
