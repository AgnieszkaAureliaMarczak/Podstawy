package asystent;

import java.util.Random;
import java.util.Scanner;

public class ZgadnijLiczbe {
    static int wylosowanaLiczba;
    static int iloscProb;

    public static void rozpocznijGre() {
        wylosowanaLiczba = wylosujLiczbe();
      //  System.out.println(wylosowanaLiczba);
        zgadnijLiczbe();
    }

    static int wylosujLiczbe() {
        System.out.println("Wylosuję dla Ciebie liczbę od 1 do 10.");
        Random losowanie = new Random();
        return losowanie.nextInt(10) + 1;
    }

    static void zgadnijLiczbe() {
        System.out.println("Zgadnij wylosowana liczbę.");
        sprawdzPodanaLiczbe();
    }

    static boolean sprawdzPodanaLiczbe() {
        Scanner scanner = new Scanner(System.in);
        int podanaLiczba = scanner.nextInt();
        if (podanaLiczba != wylosowanaLiczba){
            if (podanaLiczba == wylosowanaLiczba + 1 || podanaLiczba == wylosowanaLiczba - 1) {
                System.out.println("Gorąco!");
            } else {
                System.out.println("Zimno!");
            }
            iloscProb++;
            return sprawdzPodanaLiczbe();
        } else {
            System.out.println("Trafiona. Ilość prób: " + iloscProb);
            return true;
        }
    }
}
