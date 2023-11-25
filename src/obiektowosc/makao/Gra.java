package obiektowosc.makao;

import java.util.*;

public class Gra {
    private List<Karta> stos = new ArrayList<>();
    private List<Gracz> gracze = new ArrayList<>();
    private int liczbaGraczy;
    static Scanner scanner = new Scanner(System.in);

    public Gracz dajGracza(int indeks) {
        return gracze.get(indeks);
    }

    public List<Gracz> dajGraczy(){
        return gracze;
    }

    public void powitaj() {
        System.out.println("Witaj w grze w makao!");
    }

    public void ustalLiczbeGraczy() {
        boolean wlasciwaLiczbaGraczy;
        do {
            System.out.println("Podaj liczbę graczy (od 2 do 6).");
            liczbaGraczy = FajniejszyScanner.pobierzLiczbe();
            wlasciwaLiczbaGraczy = true;
            if (liczbaGraczy < 2 || liczbaGraczy > 6) {
                System.out.println("Podana liczba graczy wykracza poza zakres 2-6.");
                wlasciwaLiczbaGraczy = false;
            }
        } while (!wlasciwaLiczbaGraczy);
        gracze.add(new Czlowiek());
        for (int i = 1; i < liczbaGraczy; i++) {
            gracze.add(new Komputer());
        }
    }

    public void rozdajKarty(List<Karta> taliaKart) {
        for (int i = 0; i < 5; i++) {
            for (Gracz gracz : gracze) {
                gracz.otrzymajKarte(taliaKart.remove(0));
            }
        }
    }

    public void wyswietlKartyPierwszegoGracza() {
        dajPierwszegoGracza().wyswietlKarty();
    }

    public Gracz dajPierwszegoGracza() {
        return gracze.get(0);
    }

    public void rozpocznijGre(){
        System.out.println();
        System.out.println("Zaczynamy grę.");
    }

    public void dolozKarteDoStosu(Karta pierwszaKarta) {
        System.out.println("Karta na stole to: " + pierwszaKarta);
        System.out.println();
        stos.add(pierwszaKarta);
    }

    private Karta dajOstatniaKarteZeStosu() {
        return stos.get(stos.size() - 1);
    }





    /*private void zareagujNaWylozonaKarte(int numerKarty, Karta odslonietaKarta) {
        Karta kartaWylozonaPrzezGracza = dajPierwszegoGracza().dajKarteZWybranejPozycji(numerKarty - 1);
        if ((kartaWylozonaPrzezGracza.getNumerycznaWartosc() !=
                odslonietaKarta.getNumerycznaWartosc()) &&
                (kartaWylozonaPrzezGracza.getKolor() != odslonietaKarta.getKolor())) {
            System.out.println("Podana karta nie pasuje. Straciłeś ruch.");
        } else {
            dolozKarteDoStosu(dajPierwszegoGracza().wylozKarteCz(numerKarty));
            dajPierwszegoGracza().wyswietlKarty();
            for (Karta karta : stos) {
                System.out.println(karta);
            }
        }
    }*/

    /// metody komputera
   /* public void wykonajRuch2() {
        boolean wylozonaKarta = wylozKarte(sprawdzKolor(dajOstatniaKarteZeStosu()));
        if (!wylozonaKarta) {
            wylozonaKarta = wylozKarte(sprawdzNominal(dajOstatniaKarteZeStosu()));
        }
        if (!wylozonaKarta) {
            gracze.get(1).otrzymajKarte(taliaKart.remove(0));
        }

        gracze.get(1).wyswietlKarty();
        System.out.println();
        for (Karta karta : stos) {
            System.out.println(karta);
        }
    }*/

    /*private boolean wylozKarte(Karta karta) {
        if (karta != null) {
            dolozKarteDoStosu(karta);
            return true;
        }
        return false;
    }*/

    private Karta sprawdzKolor(Karta karta) {
        for (int i = 0; i < gracze.get(1).dajIloscKart(); i++) {
            if (karta.getKolor() == gracze.get(1).dajKarteZWybranejPozycji(i).getKolor()) {
                return gracze.get(1).wylozKarteKomp(i);
            }
        }
        return null;
    }

    private Karta sprawdzNominal(Karta karta) {
        for (int i = 0; i < gracze.get(1).dajIloscKart(); i++) {
            if (karta.getNumerycznaWartosc() == gracze.get(1).dajKarteZWybranejPozycji(i).getNumerycznaWartosc()) {
                return gracze.get(1).wylozKarteKomp(i);
            }
        }
        return null;
    }
}
