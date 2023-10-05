package metody.statki;

import java.util.Random;

public class AlgorytmKomputera {

    public static int wylosujWiersz() {
        Random losowanie = new Random();
        return losowanie.nextInt(10);
    }

    public static int wylosujKolumne() {
        Random losowanie = new Random();
        return losowanie.nextInt(10);
    }
}
