package metody.statki;

import metody.Narzedzia;

import java.util.Scanner;

import static metody.statki.Statki.*;

public class RysowanieStatku {
    static int iloscPoprawnychMasztow = 0;

    static int[][] narysujStatek() {
        int[][] maszty = new int[wielkoscStatku][2];
        Narzedzia.uzupelnijTabliceDwuwymiarowaLiczba(maszty, 100);
        //jak te maszty są ok to wpisujemy w plansze uzytkownika
        narysujMaszty(maszty);
        if (!sprawdzCzyMasztyPrzylegajaDoSiebie(maszty)) {
            System.out.println("Ups. Narysowany statek jest niepoprawny. Każdy maszt statku musi " +
                    "stykać się z jego kolejnym masztem ścianką boczną. Spróbuj jeszcze raz.");
            Statki.wydrukujPlansze();
            return narysujStatek();
        }
        return maszty;
    }

    public static void narysujMaszty(int[][] maszty) {
        for (int i = 0; i < wielkoscStatku; i++) {
            int kolumnaStatku = ustalKolumne();
            int wierszStatku = ustalWiersz();
            if (!czyWplanszy(wierszStatku, kolumnaStatku) || !czyPustePole(maszty, wierszStatku, kolumnaStatku)) {
                System.out.println("Podane pole jest niepoprawne. Spróbuj jeszcze raz.");
                narysujMaszty(maszty);
                return;
            }
            if (!sprawdzCzyMasztNiePrzylegaDoInnegoStatku2(wierszStatku, kolumnaStatku)) {
                System.out.println("Wygląda na to, że chcesz narysować maszt przylegający do innego statku. \nPamętaj, że statki nie mogę “dotykać” się żadnym bokiem masztu. \nSpróbuj jeszcze raz.");
                narysujMaszty(maszty);
                return;
            }
              /*int[] maszt = new int[2];
                maszt[0] = wierszStatku;
                maszt[1] = kolumnaStatku;
                maszty[iloscMasztow] = maszt;*/
            maszty[iloscPoprawnychMasztow] = new int[]{wierszStatku, kolumnaStatku};
            Statki.wydrukujPlansze(maszty);
            iloscPoprawnychMasztow++;
            if (iloscPoprawnychMasztow == wielkoscStatku) {
                iloscPoprawnychMasztow = 0;
                break;
            }
        }
        for (int[] rzad : maszty) {
            for (int pozycja : rzad) {
                System.out.print(pozycja + " ");
            }
            System.out.println("");
        }
    }

    static int ustalKolumne() {
        Scanner rysowanie = new Scanner(System.in);
        System.out.println("Podaj indeks kolumny:");
        Character kolumnaObiekt = rysowanie.next().charAt(0);
        for (int i = 0; i < Statki.zbiorAlfabetyczny.length; i++) {
            if (kolumnaObiekt.equals(Statki.zbiorAlfabetyczny[i])) {
                return i;
            }
        }
        System.out.println("Podano niepoprawny indeks kolumny. Spróbuj jeszcze raz.");
        return ustalKolumne();
    }

    static int ustalWiersz() {
        System.out.println("Podaj indeks wiersza (pomiń \"0\" w wierszach 1-9):");
        Scanner rysowanie = new Scanner(System.in);
        return rysowanie.nextInt() - 1;
    }

    static boolean czyWplanszy(int wierszIndex, int kolumnaIndex) {
        return wierszIndex >= 0 && wierszIndex <= 9 && kolumnaIndex >= 0 && kolumnaIndex <= 9;
    }

    static boolean czyPustePole(int[][] maszty, int wierszIndex, int kolumnaIndex) {
        for (int wiersz = 0; wiersz < maszty.length; wiersz++) {
            for (int kolumna = 0; kolumna < maszty[wiersz].length; kolumna++) {
                if ((maszty[wiersz][0] == wierszIndex) && (maszty[wiersz][1] == kolumnaIndex)){
                    return false;
                }
            }
        }
        return Statki.planszaUzytkownika[wierszIndex][kolumnaIndex] != STATEK;
    }

    static boolean sprawdzCzyMasztNiePrzylegaDoInnegoStatku(int wierszMasztu, int kolumnaMasztu) {
        for (int wiersz = 0; wiersz < Statki.zbiorWszystkichPoprawnychMasztow.length; wiersz++) {
            if (wierszMasztu == Statki.zbiorWszystkichPoprawnychMasztow[wiersz][0]) {
                if (Statki.zbiorWszystkichPoprawnychMasztow[wiersz][1] == kolumnaMasztu + 1 || Statki.zbiorWszystkichPoprawnychMasztow[wiersz][1] == kolumnaMasztu - 1) {
                    return false;
                }
            }
        }
        for (int wiersz = 0; wiersz < Statki.zbiorWszystkichPoprawnychMasztow.length; wiersz++) {
            if (kolumnaMasztu == Statki.zbiorWszystkichPoprawnychMasztow[wiersz][1]) {
                if (Statki.zbiorWszystkichPoprawnychMasztow[wiersz][0] == wierszMasztu + 1 || Statki.zbiorWszystkichPoprawnychMasztow[wiersz][0] == wierszMasztu - 1) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean sprawdzCzyMasztNiePrzylegaDoInnegoStatku2(int wierszMasztu, int kolumnaMasztu) {
        for (int wiersz = wierszMasztu - 1; wiersz <= wierszMasztu + 1; wiersz++) {
            for (int kolumna = kolumnaMasztu - 1; kolumna <= kolumnaMasztu + 1; kolumna++) {
                if (wiersz < 0 || wiersz >= Statki.planszaUzytkownika.length || kolumna < 0 || kolumna >= Statki.planszaUzytkownika.length) {
                    continue;
                }
                if (Statki.planszaUzytkownika[wiersz][kolumna] == Statki.STATEK) {
                    return false;
                }
            }
        }
        return true;
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

    static boolean sprawdzCzyMasztyPrzylegajaDoSiebie(int[][] wspolrzedneStatku) {
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

    static boolean czyPoprawneMaszty(int[][] wspolrzedneStatku, int wielkoscStatku) { //refactor?
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
        if (czyMasztyPrzylegajaWwierszu && czyMasztyPrzylegajaWkolumnie) {
            int przylegajacyWiersz = ustalPrzylegajacyWiersz(posortowaneWspolrzedneStatkuWgKolumny);
            if (sprawdzCzyWierszIkolumnaPrzylegajaDoSiebie(posortowaneWspolrzedneStatkuWgWiersza, przylegajacyWiersz)) {
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
}
