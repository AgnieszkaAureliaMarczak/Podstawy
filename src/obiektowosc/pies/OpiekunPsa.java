package obiektowosc.pies;

public class OpiekunPsa {

    public void nakarmPsa(Pies pies) {
        pies.nakarm(ileJedzeniaDziennieWkg(pies.getWaga()));
    }

    public int ileJedzeniaDziennieWkg(int waga) {
        if (waga <= 3) {
            return 1;
        } else if (waga <= 6) {
            return 2;
        } else if (waga <= 10) {
            return 3;
        } else {
            return 4;
        }
    }
}
