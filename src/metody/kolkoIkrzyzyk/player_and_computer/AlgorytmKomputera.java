package metody.kolkoIkrzyzyk.player_and_computer;

import java.util.Random;

public class AlgorytmKomputera {
    static boolean znaleziony = false;
    static int[] wyliczonaPozycja = new int[2];

    static int[] pobierzRuchKomputera() {
        znaleziony = false;
        sprawdzSrodek();
        if (znaleziony) return wyliczonaPozycja;
        sprawdzRzad();
        if (znaleziony) return wyliczonaPozycja;
        sprawdzKolumne();
        if (znaleziony) return wyliczonaPozycja;
        losujRandomowo();
        if (znaleziony) return wyliczonaPozycja;
        return wyliczonaPozycja;
    }

    static void sprawdzSrodek() {
        if (KolkoIKrzyzyk.wielkoscPlanszy == 3 && KolkoIKrzyzyk.planszaUzytkownika[1][1] == 0) {
            System.out.println("Ruch komputera: 1, 1");
            wyliczonaPozycja[0] = 1;
            wyliczonaPozycja[1] = 1;
            znaleziony = true;
        }
    }

    static void sprawdzRzad() {
        for (int wiersz = 0; wiersz < KolkoIKrzyzyk.planszaUzytkownika.length; wiersz++) {
            for (int kolumna = 0; kolumna < KolkoIKrzyzyk.planszaUzytkownika.length; kolumna++) {
                if (KolkoIKrzyzyk.planszaUzytkownika[wiersz][kolumna] == KolkoIKrzyzyk.SYMBOL_CZLOWIEKA) {
                    break;
                }
                if (kolumna == KolkoIKrzyzyk.wielkoscPlanszy - 1 && KolkoIKrzyzyk.planszaUzytkownika[wiersz][kolumna] == 0) {
                    System.out.println("Ruch komputera: " + wiersz + ", " + kolumna);
                    wyliczonaPozycja[0] = wiersz;
                    wyliczonaPozycja[1] = kolumna;
                    znaleziony = true;
                    return;
                }
            }
        }
    }

    static void sprawdzKolumne() {
        for (int kolumna = 0; kolumna < KolkoIKrzyzyk.planszaUzytkownika.length; kolumna++) {
            for (int wiersz = 0; wiersz < KolkoIKrzyzyk.planszaUzytkownika.length; wiersz++) {
                if (KolkoIKrzyzyk.planszaUzytkownika[wiersz][kolumna] == KolkoIKrzyzyk.SYMBOL_CZLOWIEKA) {
                    break;
                }
                if (wiersz == KolkoIKrzyzyk.wielkoscPlanszy - 1 && KolkoIKrzyzyk.planszaUzytkownika[wiersz][kolumna] == 0) {
                    System.out.println("Ruch komputera: " + wiersz + ", " + kolumna);
                    wyliczonaPozycja[0] = wiersz;
                    wyliczonaPozycja[1] = kolumna;
                    znaleziony = true;
                    return;
                }
            }
        }
    }

    static void losujRandomowo() {
        int wierszKomputera;
        int kolumnaKomputera;
        Random losowanie = new Random();
        do {
            wierszKomputera = losowanie.nextInt(KolkoIKrzyzyk.wielkoscPlanszy);
            wyliczonaPozycja[0] = wierszKomputera;
            kolumnaKomputera = losowanie.nextInt(KolkoIKrzyzyk.wielkoscPlanszy);
            wyliczonaPozycja[1] = kolumnaKomputera;
        } while (KolkoIKrzyzyk.planszaUzytkownika[wierszKomputera][kolumnaKomputera] != 0);
        znaleziony = true;
    }
}
