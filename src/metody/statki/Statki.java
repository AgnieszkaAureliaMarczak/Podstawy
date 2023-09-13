package metody.statki;

public class Statki {
    static char[] zbiorAlfabetyczny = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
    static int[][] planszaUzytkownika = new int[10][10];
    static int liczbaWszystkichMasztow = 20;
    static int[][] zbiorWszystkichPoprawnychMasztow = new int[20][2];
    static int wielkoscStatku;
    public static final int PUSTE = 0;
    public static final int STATEK = 1;
    public static final int TRAFIONY = 2;
    public static final int PUDLO = 3;
    public static final char PUSTE_SYMBOL = ' ';
    public static final char STATEK_SYMBOL = '\u25A1';
    public static final char TRAFIONY_SYMBOL = 'X';
    public static final char PUDLO_SYMBOL = '*';


    public static void main(String[] args) {
//        char letter = 'A';
//        letter++;
//        System.out.println(letter);
        System.out.println("Witaj w grze w statki!\nOto twoja plansza:");
        wydrukujPlansze();
        System.out.println("Narysuj swoje statki.\nDo dyspozycji masz:\n- 1 czteromasztowiec\n- 2 trzymasztowce " +
                "\n- 3 dwumasztowce\n- 4 jednomasztowce\nStatki możesz dowolnie ustawić, obrócić i wygiąć z zachowaniem zasady,\n" +
                "że każdy maszt jednego statku musi stykać się z jego kolejnym masztem ścianką boczną \n(nie może łączyć się na ukos)" +
                " oraz dwa statki nie mogę “dotykać” się żadnym bokiem masztu.\n" +
                "Zaczynamy grę!");
        uzupelnijTabliceMasztow();
        uzupelnijPlanszeStatkami();
    }
    static void uzupelnijPlanszeStatkami() {
        wielkoscStatku = 4;
        int iloscTakichSamychStatkow;
        int iloscTakichSamychPoprawnychStatkow = 0;
        int iloscPoprawnieWpisanychMasztow = 0;
        do {
            switch (wielkoscStatku) {
                case 4 -> iloscTakichSamychStatkow = 1;
                case 3 -> iloscTakichSamychStatkow = 2;
                case 2 -> iloscTakichSamychStatkow = 3;
                case 1 -> iloscTakichSamychStatkow = 4;
                default -> iloscTakichSamychStatkow = 0;
            }
            boolean poprawnyStatek = false;
            for (int j = 0; j < iloscTakichSamychStatkow; j++) {
                System.out.println("Narysuj statek. Ilosc masztów: " + wielkoscStatku);
                int[][] wspolrzedneStatku = RysowanieStatku.narysujStatek();
                if (sprawdzCzyMasztyPrzylegajaDoSiebie(wspolrzedneStatku, wielkoscStatku)) {
                    for (int i = 0; i < wspolrzedneStatku.length; i++) {
                        for (int k = 0; k < wspolrzedneStatku[i].length; k++) {
                            zbiorWszystkichPoprawnychMasztow[iloscPoprawnieWpisanychMasztow][k] = wspolrzedneStatku[i][k];
                        }
                        iloscPoprawnieWpisanychMasztow++;
                    }
                    iloscTakichSamychPoprawnychStatkow++;
                    poprawnyStatek = true;
                    if (iloscTakichSamychPoprawnychStatkow == iloscTakichSamychStatkow) {
                        break;
                    }
                } else {
                    System.out.println("Ups. Narysowany statek jest niepoprawny. Każdy maszt statku musi stykać się z jego kolejnym masztem ścianką boczną. Spróbuj jeszcze raz.");
                    poprawnyStatek = false;
                    usunNiepoprawnyStatek(wspolrzedneStatku);
                    break;
                }
            }
            if (poprawnyStatek) {
                wielkoscStatku--;
                iloscTakichSamychPoprawnychStatkow = 0;
            }
        }
        while (wielkoscStatku > 0);
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
    static int[][] uzupelnijTabliceMasztow(){
        int wypelnienieTablicy = 100;
        for (int wiersz = 0; wiersz < zbiorWszystkichPoprawnychMasztow.length; wiersz++) {
            for (int kolumna = 0; kolumna < zbiorWszystkichPoprawnychMasztow[wiersz].length; kolumna++) {
                zbiorWszystkichPoprawnychMasztow[wiersz][kolumna] = wypelnienieTablicy;
            }
        }
        return zbiorWszystkichPoprawnychMasztow;
    }
    static boolean sprawdzCzyMasztyPrzylegajaDoSiebie(int[][] wspolrzedneStatku, int wielkoscStatku) {
        boolean poprawneMaszty = true;
        if (wielkoscStatku == 4) {
            poprawneMaszty = czyPoprawneMaszty(wspolrzedneStatku, 4);
        } else if (wielkoscStatku == 3) {
            poprawneMaszty = czyPoprawneMaszty(wspolrzedneStatku, 3);
        } else if (wielkoscStatku == 2) {
            poprawneMaszty = czyPoprawneDwaMaszty(wspolrzedneStatku);
        }
        return poprawneMaszty;
    }
    static boolean czyPoprawneDwaMaszty(int[][] tablicaDwumasztowca) {
        boolean poprawneDwaMaszty = false;
        if (tablicaDwumasztowca[0][0] == tablicaDwumasztowca[1][0]) {
            if ((tablicaDwumasztowca[0][1] == tablicaDwumasztowca[1][1] + 1) || (tablicaDwumasztowca[0][1] == tablicaDwumasztowca[1][1] - 1)) {
                poprawneDwaMaszty = true;
            }
        } else if (tablicaDwumasztowca[0][1] == tablicaDwumasztowca[1][1]) {
            if ((tablicaDwumasztowca[0][0] == tablicaDwumasztowca[1][0] + 1) || (tablicaDwumasztowca[0][0] == tablicaDwumasztowca[1][0] - 1)) {
                poprawneDwaMaszty = true;
            }
        }
        return poprawneDwaMaszty;
    }
    static boolean czyPoprawneMaszty(int[][] wspolrzedneStatku, int wielkoscStatku) {
        boolean poprawneMaszty = false;
        int[][] posortowaneWspolrzedneStatkuWgKolumny = sortujMasztyWgIchKolumny(wspolrzedneStatku, 1);
        int[][] posortowaneWspolrzedneStatkuWgWiersza = sortujMasztyWgIchWiersza(wspolrzedneStatku, 0);
        boolean czyMasztyPrzylegajaWwierszu = sprawdzCzyMasztyPrzylegajaWwierszu(posortowaneWspolrzedneStatkuWgKolumny);
        if (czyMasztyPrzylegajaWwierszu) {
            if (policzMasztyPrzylegajaceWwierszu(posortowaneWspolrzedneStatkuWgKolumny) == wielkoscStatku) {
                poprawneMaszty = true;
                return poprawneMaszty;
            }
        }
        boolean czyMasztyPrzylegajaWkolumnie = sprawdzCzyMasztyPrzylegajaWkolumnie(posortowaneWspolrzedneStatkuWgWiersza);
        if (czyMasztyPrzylegajaWkolumnie) {
            if (policzMasztyPrzylegajaceWkolumnie(posortowaneWspolrzedneStatkuWgKolumny) == wielkoscStatku) {
                poprawneMaszty = true;
                return poprawneMaszty;
            }
        }
        if (czyMasztyPrzylegajaWwierszu && czyMasztyPrzylegajaWkolumnie){
            int przylegajacyWiersz = ustalPrzylegajacyWiersz(posortowaneWspolrzedneStatkuWgKolumny);
            if (sprawdzCzyWierszIkolumnaPrzylegajaDoSiebie(posortowaneWspolrzedneStatkuWgWiersza, przylegajacyWiersz)){
                poprawneMaszty = true;
                return poprawneMaszty;
            }
        }
        return poprawneMaszty;
    }
    public static int[][] sortujMasztyWgIchKolumny(int[][] tablicaDoSortowania, int kolumna) {
        int[] tymczasowaTablica = new int[2];
        for (int wiersz = 0; wiersz < tablicaDoSortowania.length; wiersz++) {
            for (int kolejnyWiersz = 1; kolejnyWiersz < tablicaDoSortowania.length - wiersz; kolejnyWiersz++) {
                if (tablicaDoSortowania[kolejnyWiersz][kolumna] < tablicaDoSortowania[kolejnyWiersz - 1][kolumna]) {
                    tymczasowaTablica[0] = tablicaDoSortowania[kolejnyWiersz - 1][kolumna - 1];
                    tymczasowaTablica[1] = tablicaDoSortowania[kolejnyWiersz - 1][kolumna];
                    tablicaDoSortowania[kolejnyWiersz - 1][kolumna] = tablicaDoSortowania[kolejnyWiersz][kolumna];
                    tablicaDoSortowania[kolejnyWiersz - 1][kolumna - 1] = tablicaDoSortowania[kolejnyWiersz][kolumna - 1];
                    tablicaDoSortowania[kolejnyWiersz][kolumna - 1] = tymczasowaTablica[0];
                    tablicaDoSortowania[kolejnyWiersz][kolumna] = tymczasowaTablica[1];
                }
            }
        }
        return tablicaDoSortowania;
    }
    public static int[][] sortujMasztyWgIchWiersza(int[][] tablicaDoSortowania, int kolumna) {
        int[] tymczasowaTablica = new int[2];
        for (int wiersz = 0; wiersz < tablicaDoSortowania.length; wiersz++) {
            for (int kolejnyWiersz = 1; kolejnyWiersz < tablicaDoSortowania.length - wiersz; kolejnyWiersz++) {
                if (tablicaDoSortowania[kolejnyWiersz][kolumna] < tablicaDoSortowania[kolejnyWiersz - 1][kolumna]) {
                    tymczasowaTablica[0] = tablicaDoSortowania[kolejnyWiersz - 1][kolumna];
                    tymczasowaTablica[1] = tablicaDoSortowania[kolejnyWiersz - 1][kolumna + 1];
                    tablicaDoSortowania[kolejnyWiersz - 1][kolumna] = tablicaDoSortowania[kolejnyWiersz][kolumna];
                    tablicaDoSortowania[kolejnyWiersz - 1][kolumna + 1] = tablicaDoSortowania[kolejnyWiersz][kolumna + 1];
                    tablicaDoSortowania[kolejnyWiersz][kolumna] = tymczasowaTablica[0];
                    tablicaDoSortowania[kolejnyWiersz][kolumna + 1] = tymczasowaTablica[1];
                }
            }
        }
        return tablicaDoSortowania;
    }
    static boolean sprawdzCzyMasztyPrzylegajaWwierszu(int[][] posortowanaTablicaWgKolumnyMasztu) {
        boolean poprawnyWiersz = false;
        for (int wierszPosortowanejTablicy = 0; wierszPosortowanejTablicy < wielkoscStatku; wierszPosortowanejTablicy++) {
            int wierszMasztu = posortowanaTablicaWgKolumnyMasztu[wierszPosortowanejTablicy][0];
            for (int kolejnyWierszPosortowanejTablicy = wierszPosortowanejTablicy + 1; kolejnyWierszPosortowanejTablicy < wielkoscStatku; kolejnyWierszPosortowanejTablicy++) {
                if (posortowanaTablicaWgKolumnyMasztu[kolejnyWierszPosortowanejTablicy][0] == wierszMasztu) {
                    if (posortowanaTablicaWgKolumnyMasztu[kolejnyWierszPosortowanejTablicy][1] == posortowanaTablicaWgKolumnyMasztu[wierszPosortowanejTablicy][1] + 1 || posortowanaTablicaWgKolumnyMasztu[kolejnyWierszPosortowanejTablicy][1] == posortowanaTablicaWgKolumnyMasztu[wierszPosortowanejTablicy][1] - 1) {
                        poprawnyWiersz = true;
                        break;
                    } else {
                        poprawnyWiersz = false;
                        return poprawnyWiersz;
                    }
                }
            }
        }
        return poprawnyWiersz;
    }
    static int policzMasztyPrzylegajaceWwierszu(int[][] posortowanaTablicaWgKolumnyMasztu) {
        int przylegajaceMaszty = 1;
        for (int wierszPosortowanejTablicy = 0; wierszPosortowanejTablicy < wielkoscStatku; wierszPosortowanejTablicy++) {
            int wierszMasztu = posortowanaTablicaWgKolumnyMasztu[wierszPosortowanejTablicy][0];
            for (int kolejnyWierszPosortowanejTablicy = wierszPosortowanejTablicy + 1; kolejnyWierszPosortowanejTablicy < wielkoscStatku; kolejnyWierszPosortowanejTablicy++) {
                if (posortowanaTablicaWgKolumnyMasztu[kolejnyWierszPosortowanejTablicy][0] == wierszMasztu) {
                    if (posortowanaTablicaWgKolumnyMasztu[kolejnyWierszPosortowanejTablicy][1] == posortowanaTablicaWgKolumnyMasztu[wierszPosortowanejTablicy][1] + 1 || posortowanaTablicaWgKolumnyMasztu[kolejnyWierszPosortowanejTablicy][1] == posortowanaTablicaWgKolumnyMasztu[wierszPosortowanejTablicy][1] - 1) {
                        przylegajaceMaszty++;
                    }
                }
            }
        }
        System.out.println(przylegajaceMaszty);
        return przylegajaceMaszty;
    }
    static int ustalPrzylegajacyWiersz(int[][] posortowanaTablicaWgKolumnyMasztu) {
        int przylegajacyWiersz = -1;
        for (int wierszPosortowanejTablicy = 0; wierszPosortowanejTablicy < wielkoscStatku; wierszPosortowanejTablicy++) {
            int wierszMasztu = posortowanaTablicaWgKolumnyMasztu[wierszPosortowanejTablicy][0];
            for (int kolejnyWierszPosortowanejTablicy = wierszPosortowanejTablicy + 1; kolejnyWierszPosortowanejTablicy < wielkoscStatku; kolejnyWierszPosortowanejTablicy++) {
                if (posortowanaTablicaWgKolumnyMasztu[kolejnyWierszPosortowanejTablicy][0] == wierszMasztu) {
                    if (posortowanaTablicaWgKolumnyMasztu[kolejnyWierszPosortowanejTablicy][1] == posortowanaTablicaWgKolumnyMasztu[wierszPosortowanejTablicy][1] + 1 || posortowanaTablicaWgKolumnyMasztu[kolejnyWierszPosortowanejTablicy][1] == posortowanaTablicaWgKolumnyMasztu[wierszPosortowanejTablicy][1] - 1) {
                        przylegajacyWiersz = wierszMasztu;
                    }
                }
            }
        }
        System.out.println(przylegajacyWiersz);
        return przylegajacyWiersz;
    }
    static boolean sprawdzCzyWierszIkolumnaPrzylegajaDoSiebie(int[][] posortowanaTablicaWgWierszuMasztu, int przylegajacyWiersz) {
        boolean czyPrzylegajaDoSiebie = false;
        for (int wierszPosortowanejTablicy = 0; wierszPosortowanejTablicy < wielkoscStatku; wierszPosortowanejTablicy++) {
            int kolumnaMasztu = posortowanaTablicaWgWierszuMasztu[wierszPosortowanejTablicy][1];
            for (int kolejnyWierszPosortowanejTablicy = wierszPosortowanejTablicy + 1; kolejnyWierszPosortowanejTablicy < wielkoscStatku; kolejnyWierszPosortowanejTablicy++) {
                if (posortowanaTablicaWgWierszuMasztu[kolejnyWierszPosortowanejTablicy][1] == kolumnaMasztu) {
                    if (posortowanaTablicaWgWierszuMasztu[kolejnyWierszPosortowanejTablicy][0] == posortowanaTablicaWgWierszuMasztu[wierszPosortowanejTablicy][0] + 1 || posortowanaTablicaWgWierszuMasztu[kolejnyWierszPosortowanejTablicy][0] == posortowanaTablicaWgWierszuMasztu[wierszPosortowanejTablicy][0] - 1) {
                        if (posortowanaTablicaWgWierszuMasztu[kolejnyWierszPosortowanejTablicy][0] == przylegajacyWiersz || posortowanaTablicaWgWierszuMasztu[wierszPosortowanejTablicy][0] == przylegajacyWiersz) {
                            czyPrzylegajaDoSiebie = true;
                            return czyPrzylegajaDoSiebie;
                        }
                    }
                }
            }
        }
        return czyPrzylegajaDoSiebie;
    }
    static boolean sprawdzCzyMasztyPrzylegajaWkolumnie(int[][] posortowanaTablicaWgWierszuMasztu) {
        boolean poprawnaKolumna = false;
        for (int wierszPosortowanejTablicy = 0; wierszPosortowanejTablicy < wielkoscStatku; wierszPosortowanejTablicy++) {
            int kolumnaMasztu = posortowanaTablicaWgWierszuMasztu[wierszPosortowanejTablicy][1];
            for (int kolejnyWierszPosortowanejTablicy = wierszPosortowanejTablicy + 1; kolejnyWierszPosortowanejTablicy < wielkoscStatku; kolejnyWierszPosortowanejTablicy++) {
                if (posortowanaTablicaWgWierszuMasztu[kolejnyWierszPosortowanejTablicy][1] == kolumnaMasztu) {
                    if (posortowanaTablicaWgWierszuMasztu[kolejnyWierszPosortowanejTablicy][0] == posortowanaTablicaWgWierszuMasztu[wierszPosortowanejTablicy][0] + 1 || posortowanaTablicaWgWierszuMasztu[kolejnyWierszPosortowanejTablicy][0] == posortowanaTablicaWgWierszuMasztu[wierszPosortowanejTablicy][0] - 1) {
                        poprawnaKolumna = true;
                        break;
                    } else {
                        poprawnaKolumna = false;
                        return poprawnaKolumna;
                    }
                }
            }
        }
        return poprawnaKolumna;
    }
    static int policzMasztyPrzylegajaceWkolumnie(int[][] posortowanaTablicaWgWierszuMasztu) {
        int przylegajaceMaszty = 1;
        for (int wierszPosortowanejTablicy = 0; wierszPosortowanejTablicy < wielkoscStatku; wierszPosortowanejTablicy++) {
            int kolumnaMasztu = posortowanaTablicaWgWierszuMasztu[wierszPosortowanejTablicy][1];
            for (int kolejnyWierszPosortowanejTablicy = wierszPosortowanejTablicy + 1; kolejnyWierszPosortowanejTablicy < wielkoscStatku; kolejnyWierszPosortowanejTablicy++) {
                if (posortowanaTablicaWgWierszuMasztu[kolejnyWierszPosortowanejTablicy][1] == kolumnaMasztu) {
                    if (posortowanaTablicaWgWierszuMasztu[kolejnyWierszPosortowanejTablicy][0] == posortowanaTablicaWgWierszuMasztu[wierszPosortowanejTablicy][0] + 1 || posortowanaTablicaWgWierszuMasztu[kolejnyWierszPosortowanejTablicy][0] == posortowanaTablicaWgWierszuMasztu[wierszPosortowanejTablicy][0] - 1) {
                        przylegajaceMaszty++;
                    }
                }
            }
        }
        System.out.println(przylegajaceMaszty);
        return przylegajaceMaszty;
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
}
