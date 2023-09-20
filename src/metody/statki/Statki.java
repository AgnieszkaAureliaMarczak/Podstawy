package metody.statki;

import metody.Narzedzia;

public class Statki {
    static String graczPierwszy = "Gracz Pierwszy";
    static String graczDrugi = "Gracz Drugi";
    static String aktualnyGracz = graczPierwszy;
    static char[] zbiorAlfabetyczny = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
    static int[][] planszaUzytkownika = new int[10][10];
    static int[][] zbiorWszystkichPoprawnychMasztow = new int[20][2];
    static int[][] planszaGraczaPierwszego = new int[10][10];
    static int[][] zbiorWszystkichPoprawnychMasztowGraczaPierwszego = new int[20][2];
    static int[][] planszaGraczaDrugiego = new int[10][10];
    static int[][] zbiorWszystkichPoprawnychMasztowGraczaDrugiego = new int[20][2];
    static int liczbaWszystkichMasztow = 20;
    static int liczbaPoprawnieWpisanychMasztow = 0;
    static int wielkoscStatku;
    public static final int PUSTE = 0;
    public static final int STATEK = 1;
    public static final int TRAFIONY = 2;
    public static final int PUDLO = 3;
    public static final int ROBOCZY_STATEK = 4;
    public static final char PUSTE_SYMBOL = ' ';
    public static final char STATEK_SYMBOL = '\u25A1';
    public static final char TRAFIONY_SYMBOL = 'X';
    public static final char PUDLO_SYMBOL = '*';
    public static final char ROBOCZY_STATEK_SYMBOL = '\u2713';


    public static void main(String[] args) {
//        char letter = 'A';
//        letter++;
//        System.out.println(letter);
        przygotujObiePlanszeDoGry();
        System.out.println("Zaczynamy gre!");
        pobierzRuchGracza();
    }

    static void przygotujObiePlanszeDoGry(){
        for (int i = 0; i < 2; i++) {
            System.out.println(aktualnyGracz + ", witaj w grze w statki!\nOto twoja plansza:");
            wydrukujPlansze();
            System.out.println("Narysuj swoje statki.\nDo dyspozycji masz:\n- 1 czteromasztowiec\n- 2 trzymasztowce " +
                    "\n- 3 dwumasztowce\n- 4 jednomasztowce\nStatki możesz dowolnie ustawić, obrócić i wygiąć z zachowaniem zasady,\n" +
                    "że każdy maszt jednego statku musi stykać się z jego kolejnym masztem ścianką boczną \n(nie może łączyć się na ukos)" +
                    " oraz dwa statki nie mogę “dotykać” się żadnym bokiem masztu.\n" +
                    "Zaczynamy grę!");
            Narzedzia.uzupelnijTabliceDwuwymiarowaLiczba(zbiorWszystkichPoprawnychMasztow, 100);
            uzupelnijPlanszeStatkami();
            if (aktualnyGracz.equals(graczPierwszy)){
                System.out.println("Twoja plansza jest gotowa. Czas na drugiego gracza.");
            }
            aktualnyGracz = aktualnyGracz.equals(graczPierwszy) ? graczDrugi : graczPierwszy;
        }
    }

    static int[] pobierzRuchGracza(){
        int[] pobranyRuch = new int[2];
        System.out.println(aktualnyGracz + " twój ruch.");
        int kolumnaMasztu = RysowanieStatku.ustalKolumne();
        pobranyRuch[1] = kolumnaMasztu;
        int wierszMasztu = RysowanieStatku.ustalWiersz();
        pobranyRuch[0] = wierszMasztu;
        return pobranyRuch;
    }

    static void wydrukujPlansze() {
        System.out.print("\t");
        for (int i = 0; i < zbiorAlfabetyczny.length; i++) {
            System.out.print(zbiorAlfabetyczny[i] + " | ");
        }
        System.out.println();
        for (int wiersz = 1; wiersz < 11; wiersz++) {
            if (wiersz <= 9) {
                System.out.print("0" + wiersz + "| ");
            } else {
                System.out.print(wiersz + "| ");
            }
            for (int kolumna = 1; kolumna < 11; kolumna++) {
                int pole = planszaUzytkownika[wiersz - 1][kolumna - 1];
                char poleSymbol = switch (pole) {
                    case PUSTE -> PUSTE_SYMBOL;
                    case STATEK -> STATEK_SYMBOL;
                    case TRAFIONY -> TRAFIONY_SYMBOL;
                    case PUDLO -> PUDLO_SYMBOL;
                    default -> 0;
                };
                System.out.print(poleSymbol + " | ");
            }
            System.out.println();
        }
    }

    static void wydrukujPlansze(int[][] roboczyStatek) {
        System.out.print("\t");
        for (int i = 0; i < zbiorAlfabetyczny.length; i++) {
            System.out.print(zbiorAlfabetyczny[i] + " | ");
        }
        System.out.println();
        for (int wiersz = 1; wiersz < 11; wiersz++) {
            if (wiersz <= 9) {
                System.out.print("0" + wiersz + "| ");
            } else {
                System.out.print(wiersz + "| ");
            }
            for (int kolumna = 1; kolumna < 11; kolumna++) {
                int pole = -2;
                for (int maszt = 0; maszt < roboczyStatek.length; maszt++) {
                    if (roboczyStatek[maszt][0] == wiersz - 1 && roboczyStatek[maszt][1] == kolumna - 1) {
                        pole = ROBOCZY_STATEK;
                    }
                }
                if (pole != ROBOCZY_STATEK) {
                    pole = planszaUzytkownika[wiersz - 1][kolumna - 1];
                }
                char poleSymbol = switch (pole) {
                    case PUSTE -> PUSTE_SYMBOL;
                    case STATEK -> STATEK_SYMBOL;
                    case TRAFIONY -> TRAFIONY_SYMBOL;
                    case PUDLO -> PUDLO_SYMBOL;
                    case ROBOCZY_STATEK -> ROBOCZY_STATEK_SYMBOL;
                    default -> 0;
                };
                System.out.print(poleSymbol + " | ");
            }
            System.out.println();
        }
    }

    static void uzupelnijPlanszeStatkami() {
        wielkoscStatku = 4;
        int iloscTakichSamychStatkow;
        do {
            iloscTakichSamychStatkow = ustalIloscTakichSamychStatkow();
            for (int nrStatku = 0; nrStatku < iloscTakichSamychStatkow; nrStatku++) {
                System.out.println("Narysuj statek. Ilosc masztów: " + wielkoscStatku);
                int[][] wspolrzedneStatku = RysowanieStatku.narysujStatek();
                wpiszStatekDoPlanszy(wspolrzedneStatku);
                wpiszStatekDoZbioruPoprawnychMasztow(wspolrzedneStatku);
                wydrukujPlansze();
            }
            wielkoscStatku--;
        } while (wielkoscStatku > 0);
    }

    static int ustalIloscTakichSamychStatkow() {
        return switch (wielkoscStatku) {
            case 4 -> 1;
            case 3 -> 2;
            case 2 -> 3;
            case 1 -> 4;
            default -> 0;
        };
    }

    public static void wpiszStatekDoPlanszy(int[][] wspolrzedneStatku) {
        for (int maszt = 0; maszt < wspolrzedneStatku.length; maszt++) {
            int wierszMasztu = wspolrzedneStatku[maszt][0];
            int kolumnaMasztu = wspolrzedneStatku[maszt][1];
            Statki.planszaUzytkownika[wierszMasztu][kolumnaMasztu] = Statki.STATEK;
        }
    }

    public static void wpiszStatekDoZbioruPoprawnychMasztow(int[][] maszty) {
        for (int wiersz = 0; wiersz < maszty.length; wiersz++) {
            for (int kolumna = 0; kolumna < maszty[wiersz].length; kolumna++) {
                zbiorWszystkichPoprawnychMasztow[liczbaPoprawnieWpisanychMasztow][kolumna] = maszty[wiersz][kolumna];
            }
            liczbaPoprawnieWpisanychMasztow++;
        }
    }

    static void usunNiepoprawnyStatek(int[][] wspolrzedneStatku) {
        for (int wiersz = 0; wiersz < wspolrzedneStatku.length; wiersz++) {
            int[] maszt = wspolrzedneStatku[wiersz];
            int wierszStatku = maszt[0];
            int kolumnaStatku = maszt[1];
            planszaUzytkownika[wierszStatku][kolumnaStatku] = PUSTE;
        }
        wydrukujPlansze();
    }

}
