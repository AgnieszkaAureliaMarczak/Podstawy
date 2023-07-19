package metody;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Mastermind {

    static char[] pulaZnakowHasla = {'g', 'j', 'k', 'f', 'r', 'd', 'a', 'e'};
    static char[] wylosowaneHaslo;
    static char[] hasloUzytkownika;
    static int liczbaProb = 0;
    static int iloscCzarnych = 0;
    static int iloscBialych = 0;
    static int dlugoscHasla = 4;

    public static void main(String[] args) {
        System.out.println("Zaczynamy grę!");
        System.out.println("Losuję hasło...");
        wylosowaneHaslo = losujHaslo();
        System.out.println(wylosowaneHaslo);
        System.out.println("Hasło gotowe. Spróbuj je odgadnąć. Masz 10 prób. Powodzenia!");
        System.out.println("Dostępne litery to: " + Arrays.toString(pulaZnakowHasla));

        do {
            System.out.println("Podaj hasło");
            hasloUzytkownika = podajHaslo();
            System.out.println("Sprawdzam podane hasło...");
            sprawdzHaslo();
        } while (liczbaProb <= 10 && iloscCzarnych != dlugoscHasla);
    }

    static char[] losujHaslo() {
        Random losowanie = new Random();
        char[] haslo = new char[dlugoscHasla];
        for (int i = 0; i < dlugoscHasla; i++) {
            int pozycjaWtablicy = losowanie.nextInt(pulaZnakowHasla.length);
            haslo[i] = pulaZnakowHasla[pozycjaWtablicy];
        }
        return haslo;
    }

    static char[] podajHaslo() {
        Scanner podawaneHaslo = new Scanner(System.in);
        String hasloString = podawaneHaslo.nextLine();
        char[] probaHasla = new char[dlugoscHasla];
        for (int i = 0; i < dlugoscHasla; i++) {
            probaHasla[i] = hasloString.charAt(i);
        }
        return probaHasla;
    }

    static void sprawdzHaslo() {
        // biala pinezka - trafiona literka + niewlasciwa pozycja literki
        //czarna pinezka - trafiona literka + trafiona pozycja literki

        boolean[] bialaPinezka = new boolean[dlugoscHasla], czarnaPinezka = new boolean[dlugoscHasla];
        iloscBialych = 0;
        iloscCzarnych = 0;
        for (int i = 0; i < czarnaPinezka.length; i++) {
            if (hasloUzytkownika[i] == wylosowaneHaslo[i]) {
                czarnaPinezka[i] = true;
                iloscCzarnych++;
                continue;
            }
            for (int j = 0; j < czarnaPinezka.length; j++) {
                if (hasloUzytkownika[i] == wylosowaneHaslo[j]) {
                    bialaPinezka[i] = true;
                    iloscBialych++;
                }
            }
        }

        System.out.println(Arrays.toString(czarnaPinezka));
        System.out.println(Arrays.toString(bialaPinezka));
        System.out.println("Czarne pinezki: " + iloscCzarnych + ". Białe pinezki: " + iloscBialych + ".");
        liczbaProb++;
        if (iloscCzarnych == dlugoscHasla) {
            System.out.println("Brawo. Odgadłeś hasło. Liczba prób: " + liczbaProb);
        }
    }
}
