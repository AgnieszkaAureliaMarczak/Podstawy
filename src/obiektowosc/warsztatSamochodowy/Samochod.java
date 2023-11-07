package obiektowosc.warsztatSamochodowy;

import java.util.Arrays;
import java.util.Random;

public class Samochod {

    private Kolo[] kola;

    public Samochod(Kolo[] kola) {
        this.kola = kola;
    }

    public void zlapGume() {
        Random random = new Random();
        Kolo koloFlak = kola[random.nextInt(0, 4)];
        koloFlak.przebijKolo();
    }

    public Kolo[] getKola() {
        return kola;
    }

    @Override
    public String toString() {
        return "Samochod{" +
                "kola=" + Arrays.toString(kola) +
                '}';
    }
}
