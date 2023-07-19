package metody;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Mastermind {

    static char[] tablicaCharow = {'g', 'j', 'k', 'f', 'r', 'd', 'a', 'e'};
    static char[] wylosowaneHaslo;
    static char[] hasloUzytkownika;
    static int liczbaProb = 0;
    static int czarna = 0;
    static int biala = 0;

    public static void main(String[] args) {
      /*  for (char i = 'a'; i <='z'; i++) {
            System.out.println(i);
            System.out.println((int)i);
        }*/

        //  for (int i = 0; i < 1000; i++) {
        //     System.out.println((char)i);
        // }
        System.out.println("Zaczynamy grę!");
        wylosowaneHaslo = losujHaslo();
        System.out.println(wylosowaneHaslo);
        System.out.println("Hasło gotowe. Spróbuj je odgadnąć. Masz 10 prób. Powodzenia!");
        System.out.println("Dostępne litery to: " + Arrays.toString(tablicaCharow));

        do {
            hasloUzytkownika = podajHaslo();
            sprawdzHaslo();
        } while (liczbaProb <=10 && czarna != 4);
    }

    static char[] losujHaslo() {
        System.out.println("Losuję hasło...");
        Random losowanie = new Random();
        char[] haslo = new char[4];
        for (int i = 0; i < 4; i++) {
            int pozycjaWtablicy = losowanie.nextInt(8);
            haslo[i] = tablicaCharow[pozycjaWtablicy];
        }
        return haslo;
    }

    static char[] podajHaslo() {
        System.out.println("Podaj hasło");
        Scanner podawaneHaslo = new Scanner(System.in);
        String hasloString = podawaneHaslo.nextLine();
        char[] probaHasla = new char[4];
        for (int i = 0; i < 4; i++) {
            probaHasla[i] = hasloString.charAt(i);
        }
        return probaHasla;
    }

    static void sprawdzHaslo() {

        // biala pinezka - trafiona literka + niewlasciwa pozycja literki
        //czarna pinezka - trafiona literka + trafiona pozycja literki
        System.out.println("Sprawdzam podane hasło...");

        boolean[] bialaPinezka = new boolean[4], czarnaPinezka = new boolean[4];
        Arrays.fill(bialaPinezka, false);
        Arrays.fill(czarnaPinezka, false);
        biala = 0;
        czarna = 0;
        for (int i = 0; i < czarnaPinezka.length; i++) {

            if (hasloUzytkownika[i] == wylosowaneHaslo[i]) {
                czarnaPinezka[i] = true;
                czarna++;
            } else if (!czarnaPinezka[i]) {
                //fkrk
                //rkee
                for (int j = 0; j < czarnaPinezka.length; j++) {
                    if (hasloUzytkownika[i] == wylosowaneHaslo[j]) {
                        bialaPinezka[i] = true;
                        biala++;
                    }
                }
            }

        }

        System.out.println(Arrays.toString(czarnaPinezka));
        System.out.println(Arrays.toString(bialaPinezka));
        System.out.println("Czarne pinezki: " + czarna + ". Białe pinezki: " + biala + ".");
        liczbaProb++;
        if (czarna == 4){
            System.out.println("Brawo. Odgadłeś hasło. Liczba prób: " + liczbaProb);
        }
    }
}
