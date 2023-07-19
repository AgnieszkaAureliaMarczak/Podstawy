package metody;

import java.util.Random;
import java.util.Scanner;

public class InstrukcjeWarunkoweSwitch2 {
    public static void main(String[] args) {
        System.out.println(losujZezbioru(5, 39, 99, 87, 103, 2156, 3218, -147));
        System.out.println(pobierzLiczbe(0, 120));
    }

    public static int losujZezbioru(int... zmienne) {
        Random losujLiczbe = new Random();
        int pozycja = losujLiczbe.nextInt(zmienne.length);
        return zmienne[pozycja];
    }

    public static int pobierzLiczbe(int min, int max) {
        System.out.println("Podaj liczbę z zakresu: " + min + " - " + max + ".");
        Scanner sc = new Scanner(System.in);
        int pobranaLiczba = sc.nextInt();
        while (pobranaLiczba < min || pobranaLiczba > max) {
            System.out.println("Podana liczba wykracza poza zakres. Podaj liczbę z zakresu: " + min + " - " + max + ".");
            pobranaLiczba = sc.nextInt();
        }
        sc.close();
        return pobranaLiczba;
    }
}
