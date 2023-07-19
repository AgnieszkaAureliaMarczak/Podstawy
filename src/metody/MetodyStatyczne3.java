package metody;

import java.util.Arrays;

public class MetodyStatyczne3 {
    static int[] mojeLiczby = {5, 8, 0, 59};

    public static void main(String[] args) {
        if (sprawdzTrzyLiczby(5, 5, 5)) {
            System.out.println("Takie same");
        } else {
            System.out.println("Inne");
        }
        System.out.println(zwrocSume(mojeLiczby));

        System.out.println(sprawdzCzyWieksza(mojeLiczby, 10));
        System.out.println(Arrays.toString(zwrocLiczbypierwsze(199)));

    }

    static boolean sprawdzTrzyLiczby(int pierwsza, int druga, int trzecia) {
        return pierwsza == druga && pierwsza == trzecia;
       /* if () {
            System.out.println("Takie same");
            return true;
        } else {
            System.out.println("Inne");
            return false;
        }*/
    }

    static int zwrocSume(int[] liczby) {
        int suma = 0;
//        for (int i = 0; i < liczby.length; i++) {
//            suma += liczby[i];
//        }
        for (int liczba : liczby) {
            suma += liczba;
        }

        return suma;
    }

    static boolean sprawdzCzyWieksza(int[] liczby, int calkowita) {
        boolean wieksza = false;
        for (int liczba : liczby) {
            wieksza = liczba > calkowita;
        }
        return wieksza;
    }

    static int[] zwrocLiczbypierwsze(int calkowita) {
        int[] liczbyPierwsze = new int[1500];
        int iloscLiczbPierwszych = 0;

        for (int i = 2; i <= calkowita; i++) { //10      // 2-10
            boolean czyLiczbaPierwsza = true;
            for (int j = 2; j <= i - 1; j++) {   //8
                if (i % j == 0) {
                    czyLiczbaPierwsza = false;
                }
            }
            if (czyLiczbaPierwsza) {
                liczbyPierwsze[iloscLiczbPierwszych] = i;
                iloscLiczbPierwszych++;
            }
        }
        //skroc tablice do faktycznej wielkosci i stworz nowa dopasowa tablice
    /*   int[] dopasowanaTablica = new int[iloscLiczbPierwszych];
       for (int i = 0; i < dopasowanaTablica.length; i++) {
           dopasowanaTablica[i] = liczbyPierwsze[i];
           if (liczbyPierwsze[i] == 0) break;
       }*/

        return Narzedzia.skrocTablice(liczbyPierwsze, iloscLiczbPierwszych);
    }


}
