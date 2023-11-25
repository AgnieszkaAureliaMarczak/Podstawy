package obiektowosc.makao;

import java.util.ArrayList;
import java.util.List;

public class Gracz {
     List<Karta> karty = new ArrayList<>();

    public void otrzymajKarte(Karta karta) {
        karty.add(karta);
    }

    public int dajIloscKart() {
        return karty.size();
    }

    public void wyswietlKarty() {
        System.out.println("Twoje karty:");
        for (int i = 0; i < dajIloscKart(); i++) {
            System.out.println((i + 1) + ": " + karty.get(i));
        }
    }

    public Karta dajKarteZWybranejPozycji(int index) {
        return karty.get(index);
    }

    public Karta wylozKarteCz(int numerKarty) {
        return karty.remove(numerKarty - 1);
    }

    public Karta wylozKarteKomp(int indexKarty){
        return karty.remove(indexKarty);
    }

    public void wykonajRuch(Karta odslonietaKarta,Karta kartaZtalii, List<Gracz> gracze) {
        for (Gracz aktualny : gracze) {
            if (!aktualny.czyMozeszZagracNa(odslonietaKarta)){
                System.out.println("Gracz nie mogl nic zagrac, dobiera kartę.");
                aktualny.otrzymajKarte(kartaZtalii);
                continue;
            }
            aktualny.wybierzKarte(odslonietaKarta); // stos, komunikaty, jak gra czlowiek
        }
    }
    //metody czlowieka

    /*    public void wykonajRuch() {
            Gracz aktualny = getAktualnyGracz();
            if (!czyMozeCosZagracz(aktualny)) {
                System.out.println("Gracz nie mogl nic zagrac, dobiera karte");
                return;
            }
            Karta wybrana = aktualny.wybierzKarte();
            zareagujNaZagranaKarte(wybrana);
        }*/
    public boolean czyMozeszZagracNa(Karta kartaZeStosu){
        Karta dopasowanaKarta = dajPasujacaKarteDoZagrania(kartaZeStosu);
        return dopasowanaKarta != null;
    }

     Karta dajPasujacaKarteDoZagrania(Karta kartaZeStosu){
        for (Karta kartaZReki : karty) {
            if (kartaZReki.getKolor() == kartaZeStosu.getKolor() ||
                    kartaZReki.getNumerycznaWartosc() == kartaZeStosu.getNumerycznaWartosc()){
                return kartaZReki;
            }
        }
        return null;
    }

    public Karta wybierzKarte(Karta kartaZeStosu) {
        System.out.println("Gracz robi ruch");
        return null;
    }
}
