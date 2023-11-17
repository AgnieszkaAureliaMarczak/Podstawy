package obiektowosc.makao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Gra {
    private ArrayList<Karta> taliaKart = new ArrayList<>();
    private ArrayList<Karta> stos = new ArrayList<>();
    private List<Gracz> gracze = new ArrayList<>();
    private int liczbaGraczy;
    static Scanner scanner = new Scanner(System.in);


    public void powitaj() {
        System.out.println("Witaj w grze w makao!");
    }

    public void ustalLiczbeGraczyIprzygotujIchTabliceKart() {
        System.out.println("Podaj liczbę graczy (od 2 do 6)");
        liczbaGraczy = scanner.nextInt();
        for (int i = 0; i < liczbaGraczy; i++) {
            gracze.add(new Gracz());
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

    public void potasujTalieKart(ArrayList<Karta> taliaDoTasowania) {
        Random random = new Random();
        for (int i = 0; i < 52; i++) {
            int wylosowanaKarta = random.nextInt(taliaDoTasowania.size());
            taliaKart.add(taliaDoTasowania.get(wylosowanaKarta));
            taliaDoTasowania.remove(wylosowanaKarta);
        }
    }

    public void rozdajKarty() {
        for (int i = 0; i < 5; i++) {
            for (Gracz gracz : gracze) {
                gracz.otrzymajKarte(taliaKart.remove(0));
            }
        }
    }

    public void wyswietlKartyGracza() {
        System.out.println("Zaczynamy grę.");
        System.out.println("Twoje karty:");
        dajPierwszegoGracza().wyswietlKarty();
    }

    private Gracz dajPierwszegoGracza() {
        return gracze.get(0);
    }

    public void rozpocznijGre() {
        System.out.println();
        System.out.println("Karta na stole to: " + taliaKart.get(0));
        System.out.println();
        stos.add(taliaKart.remove(0));
    }

    public void wykonajRuch() {
        boolean wlasciwyRuch = true;
        int numerKarty;
        do {
            System.out.println("Twoj ruch. \nWpisz liczbę odpowiadającej karcie, którą chcesz wyłożyć.\n" +
                    "Jeśli nie masz pasującej karty, wpisz 0.");
            numerKarty = scanner.nextInt();
            if (numerKarty > dajPierwszegoGracza().dajIloscKart()) {
                System.out.println("Podana karta nie istnieje.\nSpróbuj jeszcze raz.");
                wlasciwyRuch = false;
            }
        } while (!wlasciwyRuch);

    }
}
