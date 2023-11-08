package obiektowosc.warsztatSamochodowy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Kolo[] kola = new Kolo[4];
        for (int i = 0; i < kola.length; i++) {
            kola[i] = new Kolo();
        }
        System.out.println(Arrays.toString(kola));

        Samochod samochod = new Samochod(kola);
        samochod.zlapGume();
        samochod.zlapGume();
        samochod.zlapGume();
        samochod.zlapGume();
        System.out.println(samochod);

        Warsztat warsztat = new Warsztat();
        System.out.println(warsztat.naprawSamochod(samochod));
        System.out.println(warsztat);
    }
}
