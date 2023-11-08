package obiektowosc.ogrod;

import java.util.Arrays;

public class OgrodDemo {
    public static void main(String[] args) {
       /* Drzewo jablon = new Drzewo();
        System.out.println(jablon);
        jablon.owocuj();
        System.out.println(jablon.zbierajOwoce());
        System.out.println(jablon);*/

        String[] tablicaSztuczek = {"Siad", "Stój", "Do mnie", "Daj łapę", "Połóż się",
                "Zostaw", "Aport", "Pies - miejsce", "Chodź - pies", "Daj glos",
                "Przynies gazetę", "Podnieś nogę"};
        Pies pies = new Pies("Azor");
        pies.bawSie();

        Lawka lawka = new Lawka("drewno");
        Kwiat[] kwietnik = new Kwiat[10];
        for (int i = 0; i < kwietnik.length; i++) {
            kwietnik[i] = new Kwiat();
        }

        Ogrod mojOgrod = new Ogrod(lawka, kwietnik, 2);
        System.out.println(mojOgrod);

        mojOgrod.wejdzDoOgrodu();

        mojOgrod.podlejKwiaty();
        System.out.println(Arrays.toString(kwietnik));

        mojOgrod.odpocznij();
        mojOgrod.zbierajOwoce();
        mojOgrod.zbierajOwoce();

        mojOgrod.wyjdzZogrodu();
        System.out.println(mojOgrod);
        System.out.println();
        mojOgrod.pracujWogrodzie();
        System.out.println();
        mojOgrod.pracujWogrodzie(30);

    }
}
