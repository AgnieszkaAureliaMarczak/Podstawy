package metody;

public class Narzedzia {
    public static int[] skrocTablice(int[] tablicaLiczb, int docelowaWielkosc) {
        int[] dopasowanaTablica = new int[docelowaWielkosc];
        for (int i = 0; i < dopasowanaTablica.length; i++) {
            dopasowanaTablica[i] = tablicaLiczb[i];
            //if (tablicaLiczb[i] == 0) break;
        }
        return dopasowanaTablica;
    }

    public static int[] sortujBabelkowo(int[] tablicaDoSortowania) {
        int tymczasowaZmienna;
        for (int i = 0; i < tablicaDoSortowania.length; i++) {
            for (int j = 1; j < tablicaDoSortowania.length - i; j++) {
                if (tablicaDoSortowania[j] < tablicaDoSortowania[j - 1]) {
                    tymczasowaZmienna = tablicaDoSortowania[j - 1];
                    tablicaDoSortowania[j - 1] = tablicaDoSortowania[j];
                    tablicaDoSortowania[j] = tymczasowaZmienna;
                }
            }
        }
        return tablicaDoSortowania;
    }

    public static int[] wydzielTabliceJednowymiarowaZkolumny(int[][] tablicaDoSortowania, int kolumnaDoSortowania){
        int [] tablicaZkolumny = new int[tablicaDoSortowania.length];
        for (int wiersz = 0; wiersz < tablicaDoSortowania.length; wiersz++) {
               tablicaZkolumny[wiersz] = tablicaDoSortowania[wiersz][kolumnaDoSortowania];
        }
        return tablicaZkolumny;
    }
}