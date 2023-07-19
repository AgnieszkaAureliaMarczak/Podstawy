package metody;

import java.util.Scanner;

public class Rekurencja {
    public static void main(String[] args) {
        System.out.println(podajLiczbe2());
    }

    public static int podajLiczbe() {
        System.out.println("Podaj liczbę");
        Scanner sc = new Scanner(System.in);
        int liczba;
        boolean niepoprawna;
        do {
            liczba = sc.nextInt();
            niepoprawna = liczba > 100;
            if (niepoprawna) {
                System.out.println("Podana liczba jest wieksza niz 100. Podaj inna liczbę mniejszą bądź równą 100.");
            }
        }
        while (niepoprawna);
        return liczba;
    }

    public static int podajLiczbe2() {
        System.out.println("Podaj liczbę");
        Scanner sc = new Scanner(System.in);
        int liczba = sc.nextInt();
        if (liczba > 100) {
            System.out.println("Podana liczba jest wieksza niz 100. Podaj inna liczbę mniejszą bądź równą 100.");
          return  podajLiczbe2();
        }
        return liczba;
    }
}
