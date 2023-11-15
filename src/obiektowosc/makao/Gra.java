package obiektowosc.makao;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Gra {
    static ArrayList<Karta> taliaKart = new ArrayList<>();
    static ArrayList<Karta> stos = new ArrayList<>();
    static int liczbaGraczy = 4;
    static ArrayList<Karta> kartyGracza1 = new ArrayList<>();
    static ArrayList<Karta> kartyGracza2 = new ArrayList<>();
    static ArrayList<Karta> kartyGracza3 = new ArrayList<>();
    static ArrayList<Karta> kartyGracza4 = new ArrayList<>();

    // static ArrayList<ArrayList> kartyGraczy = new ArrayList<>(); ????

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        powitaj();
        //   ustalLiczbeGraczyIprzygotujIchTabliceKart();
        potasujTalieKart(stworzTalieKart());
        rozdajKarty();
        wyswietlKartyGracza();
        rozpocznijGre();
        wykonajRuch();
    }

    public static void powitaj() {
        System.out.println("Witaj w grze w makao!");
    }

    public static void ustalLiczbeGraczyIprzygotujIchTabliceKart() {
        System.out.println("Podaj liczbę graczy (od 2 do 6)");
        liczbaGraczy = scanner.nextInt();
        /*for (int i = 0; i < liczbaGraczy; i++) {
            new ArrayList<>(); // ??????
        }*/
    }

    public static ArrayList<Karta> stworzTalieKart() {
        //As == nominal 14, Krol == 13, Dama == 12, Walet == 11
        ArrayList<Karta> talia = new ArrayList<>();
        String[] tablicaKolorow = {"trefl", "karo", "kier", "pik"};
        for (int kolor = 0; kolor < 4; kolor++) {
            for (int nominal = 2; nominal < 15; nominal++) {
                talia.add(new Karta(tablicaKolorow[kolor], nominal));
            }
        }
        return talia;
    }

    public static void potasujTalieKart(ArrayList<Karta> taliaDoTasowania) {
        Random random = new Random();
        for (int i = 0; i < 52; i++) {
            int wylosowanaKarta = random.nextInt(taliaDoTasowania.size());
            taliaKart.add(taliaDoTasowania.get(wylosowanaKarta));
            taliaDoTasowania.remove(wylosowanaKarta);
        }
    }

    public static void rozdajKarty() {

        for (int i = 0; i < 5; i++) {
            for (int gracz = 0; gracz < liczbaGraczy; gracz++) {
                switch (gracz) {
                    case 0 -> kartyGracza1.add(taliaKart.get(0));
                    case 1 -> kartyGracza2.add(taliaKart.get(0));
                    case 2 -> kartyGracza3.add(taliaKart.get(0));
                    case 3 -> kartyGracza4.add(taliaKart.get(0));
                }
                taliaKart.remove(0);
            }
        }
    }

    public static void wyswietlKartyGracza() {
        System.out.println("Zaczynamy grę.");
        System.out.println("Twoje karty:");
        for (int i = 0; i < kartyGracza1.size(); i++) {
            System.out.println((i + 1) + ": " + kartyGracza1.get(i));
        }
    }

    public static void rozpocznijGre() {
        System.out.println();
        System.out.println("Karta na stole to: " + taliaKart.get(0));
        System.out.println();
        stos.add(taliaKart.get(0));
        taliaKart.remove(0);
    }

    public static void wykonajRuch() {
        boolean wlasciwyRuch = true;
        int numerKarty;
        do {
            System.out.println("Twoj ruch. \nWpisz liczbę odpowiadającej karcie, którą chcesz wyłożyć.\n" +
                    "Jeśli nie masz pasującej karty, wpisz 0.");
            numerKarty = scanner.nextInt();
            if (numerKarty > kartyGracza1.size()) {
                System.out.println("Podana karta nie istnieje.\nSpróbuj jeszcze raz.");
                wlasciwyRuch = false;
            }
        } while (!wlasciwyRuch);

    }
}
