package obiektowosc.fabrykaLinii;

import java.util.Random;

public class FabrykaLinii {

    private int dlugoscOstaniejLinii = 1;

    private Random random = new Random();

    public Linia stworzLinieLosowejDlugosciZwybranymZnakiem(char wypelnienie) {
        return new Linia(wylosujDlugosc(), wypelnienie);
    }

    public Linia stworzLinieWybranejDlugosciIzLosowymZnakiem(int dlugosc) {
        return new Linia(dlugosc, wylosujZnak());
    }

    public Linia stworzLinieZlosowaDlugosciaIzLosowymZnakiem() {
        return new Linia(wylosujDlugosc(), wylosujZnak());
    }

    private char wylosujZnak(){
        int asciiCode = random.nextInt(1, 140_000);
        return (char) (asciiCode);
    }

    private int wylosujDlugosc(){
     return random.nextInt(1, 51);
    }

    public Linia[] stworzOkreslonaIloscLiniiZlosowaDlugosciaIznakiem(int iloscLinii) {
        Linia[] tablicaLinii = new Linia[iloscLinii];
        for (int i = 0; i < iloscLinii; i++) {
            tablicaLinii[i] = stworzLinieZlosowaDlugosciaIzLosowymZnakiem();
        }
        return tablicaLinii;
    }

    public Linia stworzLinie2razyWiekszaOdPoprzedniej() {
        int dlugoscTejLinii = dlugoscOstaniejLinii * 2;
        dlugoscOstaniejLinii = dlugoscTejLinii;
        return new Linia(dlugoscTejLinii, wylosujZnak());
    }
}
