package podstawy;

import java.util.Random;
import java.util.Scanner;

public class Petle4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random zgadywanie = new Random();
        int podanaLiczba = 11;
        int iloscLosowan = 0;
        System.out.println("Wylosuję dla Ciebie liczbę od 1 do 10.");
        int wylosowanaLiczba = zgadywanie.nextInt(10) + 1;
        System.out.println("Zgadnij wylosowana liczbę.");

        while (podanaLiczba != wylosowanaLiczba) {
            podanaLiczba = scanner.nextInt();
            //    if ( podanaLiczba < wylosowanaLiczba ){
            //        System.out.println("Za nisko.");
            //    } else {
            //       System.out.println("Za wysoko.");
            //   }
            if (podanaLiczba == wylosowanaLiczba + 1 || podanaLiczba == wylosowanaLiczba - 1) {
                System.out.println("Gorąco!");
            } else {
                System.out.println("Zimno!");
            }
            iloscLosowan++;
        }
        System.out.println("Trafiona. Ilość prób: " + iloscLosowan);
        scanner.close();
    }
}
