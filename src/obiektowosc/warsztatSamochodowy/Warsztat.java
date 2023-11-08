package obiektowosc.warsztatSamochodowy;

public class Warsztat {

    public Paragon naprawSamochod(Samochod samochod) {
        int iloscNapraw = 0;
        int cenaUslugi = 10;
        Kolo[] kola = samochod.getKola();
        for (Kolo kolo : kola) {
            if (kolo.isPrzebite()) {
                kolo.naprawKolo();
                iloscNapraw++;
            }
        }
        return new Paragon("naprawa koła", iloscNapraw, cenaUslugi * iloscNapraw); //todo
    }
}
