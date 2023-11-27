package obiektowosc.makao;

import java.util.Scanner;

public class Czlowiek extends Gracz {
    Scanner scanner = new Scanner(System.in);

    public Czlowiek(int indeks){
        super(indeks);
    }

    public Karta wybierzKarte(Karta kartaZeStosu) {
        wyswietlKarty();
        Karta wybranaKarta = ustalKarte();
        System.out.println("Wybrana karta to: " + wybranaKarta);
        System.out.println();
        return wybranaKarta;
    }

    private Karta ustalKarte() {
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
         numerKarty -= 1;
        return karty.get(numerKarty);
    }
}
