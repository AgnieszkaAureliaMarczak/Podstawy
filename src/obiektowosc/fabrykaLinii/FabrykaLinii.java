package obiektowosc.fabrykaLinii;

import java.util.Random;

public class FabrykaLinii {

    private Random random = new Random();

    public Linia stworzLinieLosowejDlugosciZwybranymZnakiem(char wypelnienie) {
        return new Linia(random.nextInt(1, 51), wypelnienie);
    }

    public Linia stworzLinieWybranejDlugosciIzLosowymZnakiem(int dlugosc) {
        int asciiCode = random.nextInt(1, 140_000);
        char symbol = (char) (asciiCode);
        return new Linia(dlugosc, symbol);
    }

    public Linia stworzLinieZlosowaDlugosciaIzLosowymZnakiem() {
        int asciiCode = random.nextInt(1, 140_000);
        char symbol = (char) (asciiCode);
        return new Linia(random.nextInt(1, 51), symbol);
    }

    public Linia[] stworzOkreslonaIloscLiniiZlosowaDlugosciaIznakiem(int iloscLinii) {
        Linia[] tablicaLinii = new Linia[iloscLinii];
        for (int i = 0; i < iloscLinii; i++) {
            tablicaLinii[i] = stworzLinieZlosowaDlugosciaIzLosowymZnakiem();
        }
        return tablicaLinii;
    }

    public Linia stworzLinie2razyWiekszaOdPoprzedniej(int dlugoscPoprzedniejLinii) {
        int asciiCode = random.nextInt(1, 140_000);
        char symbol = (char) (asciiCode);
        int dlugosc = dlugoscPoprzedniejLinii * 2;
        return new Linia(dlugosc, symbol);
    }
}
