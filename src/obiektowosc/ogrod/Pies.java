package obiektowosc.ogrod;

import java.util.Arrays;
import java.util.Random;

public class Pies {
    private String imie;
    private String[] sztuczki;

    public Pies(String imie, String[] sztuczki) {
        this.imie = imie;
        this.sztuczki = sztuczki;
    }

    public Pies(String imie) {
        this(imie, new String[]{"siad"});
        /*this.imie = imie;
        sztuczki = new String[]{"siad"};*/
    }

    public void bawSie() {
        Random random = new Random();
        System.out.println(sztuczki[random.nextInt(0, sztuczki.length)]);
    }

    @Override
    public String toString() {
        return "Pies{" +
                "imie='" + imie + '\'' +
                ", sztuczki=" + Arrays.toString(sztuczki) +
                '}';
    }
}
