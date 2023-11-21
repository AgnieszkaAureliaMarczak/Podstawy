package obiektowosc.makao;

import java.util.*;

public class Gra {
    private ArrayList<Karta> taliaKart = new ArrayList<>();
    private ArrayList<Karta> stos = new ArrayList<>();
    private List<Gracz> gracze = new ArrayList<>();
    private int liczbaGraczy;
    static Scanner scanner = new Scanner(System.in);


    public void powitaj() {
        System.out.println("Witaj w grze w makao!");
    }

    public void ustalLiczbeGraczy() {
        boolean wlasciwaLiczbaGraczy = true;
        do {
            System.out.println("Podaj liczbę graczy (od 2 do 6)");
            // try {
            liczbaGraczy = scanner.nextInt();
           /* } catch (InputMismatchException e){
                System.out.println("Podano niepoprawną wartość.");
                wlasciwaLiczbaGraczy = false;
            }*/
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

    public ArrayList<Karta> stworzTalieKart() {
        ArrayList<Karta> talia = new ArrayList<>();
        Kolor[] tablicaKolorow = Kolor.values();
        Nominal[] tablicaNominalow = Nominal.values();
        for (Kolor kolor : tablicaKolorow) {
            for (Nominal nominal : tablicaNominalow) {
                //    System.out.printf("%s %d\n",nominal,nominal.getNumerycznaWartosc());
                talia.add(new Karta(kolor, nominal));
            }
        }
        return talia;
    }

    public void potasujKartyDoGry(ArrayList<Karta> taliaDoTasowania) {
        Random random = new Random();
        for (int i = 0; i < 52; i++) {
            int wylosowanaKarta = random.nextInt(taliaDoTasowania.size());
            taliaKart.add(taliaDoTasowania.remove(wylosowanaKarta));
        }
    }

    public void rozdajKarty() {
        for (int i = 0; i < 5; i++) {
            for (Gracz gracz : gracze) {
                gracz.otrzymajKarte(taliaKart.remove(0));
            }
        }
    }

    public void wyswietlKartyPierwszegoGracza() {
        dajPierwszegoGracza().wyswietlKarty();
    }

    private Gracz dajPierwszegoGracza() {
        return gracze.get(0);
    }

    public Karta odslonPierwszaKarte() {
        System.out.println();
        System.out.println("Zaczynamy grę.");
        Karta kartaNaStole = taliaKart.get(0);
        System.out.println("Karta na stole to: " + kartaNaStole);
        System.out.println();
        dolozKarteDoStosu(taliaKart.remove(0));
        return kartaNaStole;
    }

    private void dolozKarteDoStosu(Karta karta) {
        stos.add(karta);
    }

    private Karta dajOstatniaKarteZeStosu() {
        return stos.get(stos.size() - 1);
    }
    //metody czlowieka

    public void wykonajRuch(Karta odslonietaKarta) {
        boolean wlasciwyRuch;
        int numerKarty;
        do {
            wlasciwyRuch = true;
            wyswietlKomunikat();
            numerKarty = pobierzNumerKarty();
            if (numerKarty > dajPierwszegoGracza().dajIloscKart() || numerKarty < 0) {
                wlasciwyRuch = zareagujGdyKartaPozaZakresem();
            }
        } while (!wlasciwyRuch);
        if (numerKarty == 0) {
            zareagujNaBrakPasujacejKarty();
        } else {
            zareagujNaWylozonaKarte(numerKarty, odslonietaKarta);
        }
    }

    private void wyswietlKomunikat() {
        System.out.println("Twoj ruch. \nWpisz liczbę odpowiadającej karcie, którą chcesz wyłożyć.\n" +
                "Jeśli nie masz pasującej karty, wpisz 0.");
    }

    private int pobierzNumerKarty() {
        return scanner.nextInt();
    }

    private boolean zareagujGdyKartaPozaZakresem() {
        System.out.println("Podana karta nie istnieje.\nSpróbuj jeszcze raz.");
        System.out.println();
        return false;
    }

    private void zareagujNaBrakPasujacejKarty() {
        dajPierwszegoGracza().otrzymajKarte(taliaKart.remove(0));
        System.out.println("Dostajesz dodatkową kartę.");
        dajPierwszegoGracza().wyswietlKarty();
    }

    private void zareagujNaWylozonaKarte(int numerKarty, Karta odslonietaKarta) {
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
    }

    /// metody komputera
    public void wykonajRuch2() {
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
    }

    private boolean wylozKarte(Karta karta) {
        if (karta != null) {
            dolozKarteDoStosu(karta);
            return true;
        }
        return false;
    }

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
