package metody.statki;

import java.util.Scanner;

public class RysowanieStatku {
    static int iloscPoprawnychMasztow = 0;
    static int[][] narysujStatek() {
        int[][] maszty = new int[Statki.wielkoscStatku][2];
        return narysujMaszty(maszty);
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
    static boolean czyPustePole(int wierszIndex, int kolumnaIndex) {
        return Statki.planszaUzytkownika[wierszIndex][kolumnaIndex] == 0;
    }
    static boolean sprawdzCzyMasztNiePrzylegaDoInnegoStatku(int wierszMasztu, int kolumnaMasztu) {
        boolean poprawnyMaszt = true;
        for (int wiersz = 0; wiersz < Statki.zbiorWszystkichPoprawnychMasztow.length; wiersz++) {
            if (wierszMasztu == Statki.zbiorWszystkichPoprawnychMasztow[wiersz][0]) {
                if (Statki.zbiorWszystkichPoprawnychMasztow[wiersz][1] == kolumnaMasztu + 1 || Statki.zbiorWszystkichPoprawnychMasztow[wiersz][1] == kolumnaMasztu - 1) {
                    poprawnyMaszt = false;
                    return poprawnyMaszt;
                }
            }
        }
        for (int wiersz = 0; wiersz < Statki.zbiorWszystkichPoprawnychMasztow.length; wiersz++) {
            if (kolumnaMasztu == Statki.zbiorWszystkichPoprawnychMasztow[wiersz][1]){
                if (Statki.zbiorWszystkichPoprawnychMasztow[wiersz][0] == wierszMasztu + 1 || Statki.zbiorWszystkichPoprawnychMasztow[wiersz][0] == wierszMasztu - 1){
                    poprawnyMaszt = false;
                    return poprawnyMaszt;
                }
            }
        }
        return poprawnyMaszt;
    }
    static int[][] narysujMaszty(int[][] maszty){
        for (int i = 0; i < Statki.wielkoscStatku; i++) {
            int kolumnaStatku = ustalKolumne();
            int wierszStatku = ustalWiersz();
            if (!czyWplanszy(wierszStatku, kolumnaStatku) || !czyPustePole(wierszStatku, kolumnaStatku)) {
                System.out.println("Podane pole jest niepoprawne. Spróbuj jeszcze raz.");
                return narysujMaszty(maszty);
            }
            if (!sprawdzCzyMasztNiePrzylegaDoInnegoStatku(wierszStatku,kolumnaStatku)) {
                System.out.println("Wygląda na to, że narysowany maszt przylega do innego statku. \nPamętaj, że statki nie mogę “dotykać” się żadnym bokiem masztu. \nSpróbuj jeszcze raz.");
                return narysujMaszty(maszty);
            }
            Statki.planszaUzytkownika[wierszStatku][kolumnaStatku] = Statki.STATEK;
              /*int[] maszt = new int[2];
                maszt[0] = wierszStatku;
                maszt[1] = kolumnaStatku;
                maszty[iloscMasztow] = maszt;*/
            maszty[iloscPoprawnychMasztow] = new int[]{wierszStatku, kolumnaStatku};
            Statki.wydrukujPlansze();
            iloscPoprawnychMasztow++;
            if (iloscPoprawnychMasztow == Statki.wielkoscStatku){
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
        return maszty;
    }
}
