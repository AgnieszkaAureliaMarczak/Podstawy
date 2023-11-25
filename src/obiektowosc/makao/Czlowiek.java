package obiektowosc.makao;

import java.util.Scanner;

public class Czlowiek extends Gracz {
    Scanner scanner = new Scanner(System.in);

    public Karta wybierzKarte(Karta kartaZeStosu) {
        wyswietlKomunikat();


        return null;
    }

    private void wyswietlKomunikat() {
        System.out.println("Twoj ruch.");
    }

    private int ustalIndeksKarty() {
        boolean kartaWzakresie;
        int numerKarty;
        do {
            kartaWzakresie = true;
            System.out.println("Wpisz liczbę odpowiadającej karcie, którą chcesz wyłożyć.");
            numerKarty = FajniejszyScanner.pobierzLiczbe();
            if (numerKarty < 1 || numerKarty > dajIloscKart()) {
                System.out.println("Podana liczba wykracza poza zakres twoich kart.");
                kartaWzakresie = false;
            }
        } while (!kartaWzakresie);
        return numerKarty - 1;
    }
}
