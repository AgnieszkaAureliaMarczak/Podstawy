package obiektowosc.makao;

import java.util.ArrayList;
import java.util.Random;

public class Gra {
    static ArrayList<Karta> taliaKart = new ArrayList<>();
    static int liczbaGraczy = 4;
    static ArrayList<Karta> kartyGracza1 = new ArrayList<>();
    static ArrayList<Karta> kartyGracza2 = new ArrayList<>();
    static ArrayList<Karta> kartyGracza3 = new ArrayList<>();
    static ArrayList<Karta> kartyGracza4 = new ArrayList<>();


    public static void main(String[] args) {
        stworzTalieKart();
        rozdajKarty();

    }

    public static void stworzTalieKart() {
        //As == nominal 14, Krol == 13, Dama == 12, Walet == 11
        String[] tablicaKolorow = {"trefl", "karo", "kier", "pik"};
        for (int kolor = 0; kolor < 4; kolor++) {
            for (int nominal = 2; nominal < 15; nominal++) {
                taliaKart.add(new Karta(tablicaKolorow[kolor], nominal));
            }
        }
    }

    public static void rozdajKarty() {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < liczbaGraczy; j++) {
                int wylosowanaKarta = random.nextInt(taliaKart.size() + 1);
                switch (j) {
                    case 0 -> {
                        kartyGracza1.add(taliaKart.get(wylosowanaKarta));
                        taliaKart.remove(wylosowanaKarta);
                    }
                    case 1 -> {
                        kartyGracza2.add(taliaKart.get(wylosowanaKarta));
                        taliaKart.remove(wylosowanaKarta);
                    }
                    case 2 -> {
                        kartyGracza3.add(taliaKart.get(wylosowanaKarta));
                        taliaKart.remove(wylosowanaKarta);
                    }
                    case 3 ->{
                        kartyGracza4.add(taliaKart.get(wylosowanaKarta));
                        taliaKart.remove(wylosowanaKarta);
                    }
                }
            }
        }
    }
}
