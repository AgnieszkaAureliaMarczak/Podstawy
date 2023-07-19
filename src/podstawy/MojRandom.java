package podstawy;

import java.util.Scanner;
import java.util.Random;

public class MojRandom {
    public static void main(String[] args) {
        /* Wersja a.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Program rzuci dla Ciebie kostką do gry i wylosuje liczbę!");
       System.out.println("Proszę, podaj ile ścianek ma mieć kostka która rzucasz? 4, 6, 10 a może 20?");
        int scianki = scanner.nextInt();
        System.out.println("Rzucam kostką o ilości ścianek: " + scianki + ".");
        Random losowanie = new Random();
        System.out.print("Wyszło mi: ");
        int los;

        if (scianki == 4) {
            los = losowanie.nextInt(4);
        } else if (scianki == 6) {
            los = losowanie.nextInt(6);
        } else if (scianki == 10) {
            los = losowanie.nextInt(10);
        } else if (scianki == 20) {
            los = losowanie.nextInt(20);
        } else {
            System.out.println("podano złą ilość ścianek!");
            return;
        }

        los += 1;
        System.out.println(los);
        Wersja b.*/

        Scanner scanner = new Scanner(System.in);
        Random noweLosowanie = new Random();
        System.out.println("Program wylosuje dla Ciebie liczbę. Podaj jaka ma być najmniejsza i największa wartość losowania.");
        int najmniejszaLiczba = scanner.nextInt();
        int najwiekszaLiczba = scanner.nextInt();
        int iloscLosowan = 0;
        System.out.println("Wylosowałem liczby: ");
      /*  while(iloscLosowan<5){
            int nowaLiczba = noweLosowanie.nextInt(najmniejszaLiczba,najwiekszaLiczba);
            System.out.println(nowaLiczba);
            iloscLosowan++;
        }*/
        for (int i = 0; i < 5 ; i++) {
            int nowaLiczba = noweLosowanie.nextInt(najmniejszaLiczba,najwiekszaLiczba + 1);
            System.out.println(nowaLiczba);
        }

        scanner.close();
    }
}
