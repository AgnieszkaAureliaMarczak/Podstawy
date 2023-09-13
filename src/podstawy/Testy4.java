package podstawy;

import java.util.Random;

public class Testy4 {
    static char[][] planszaUzytkownika = new char[10][10];
    public static void main(String[] args) {
        System.out.println("");
    }
    static int[][] narysujStatek() {
        int[][] maszty = new int[4][2];
        for (int i = 0; i < 4; i++) {
            Random wypelnienie = new Random();
            int kolumnaStatku = wypelnienie.nextInt(0,10);
            int wierszStatku = wypelnienie.nextInt(0,10);;
            planszaUzytkownika[wierszStatku][kolumnaStatku] = 'C';
              /*int[] maszt = new int[2];
                maszt[0] = wierszStatku;
                maszt[1] = kolumnaStatku;
                maszty[iloscMasztow] = maszt;*/
            maszty[i] = new int[]{wierszStatku, kolumnaStatku};
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
