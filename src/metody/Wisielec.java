package metody;

import java.util.Random;
import java.util.Scanner;

public class Wisielec {
    static String[] polscyAktorzyIAktorki = {"Andrzej Grabowski", "Janusz Gajos", "Anna Przybylska", "Franciszek Pieczka", "Pola Negri", "Borys Szyc", "Joanna Kulig", "Jan Englert", "Joanna Koroniewska",
            "Anita Sokołowska", "Katarzyna Figura", "Anna Dereszowska", "Małgorzata Kożuchowska", "Adrianna Biedrzyńska", "Barbara Brylska", "Wacław Kowalski", "Artur Żmijewski", "Adam Fidusiewicz",
            "Jerzy Cnota", "Mieczysław Hryniewicz"};

    static char[] wylosowaneHaslo;
    static char[] hasloDoOperacji;
    static int iloscNietrafionychProb = 0;

    public static void main(String[] args) {
        System.out.println("Witaj w grze w wisielca!\nZgadnij hasło. Kategoria: Polscy Aktorzy i Aktorki.\nPowodzenia!");
        wyswietlWisielca();
        String haslo = losujHaslo();
        wylosowaneHaslo = haslo.toCharArray();
        hasloDoOperacji = new char[wylosowaneHaslo.length];
        wypelnijTablicePodkreslnikami();
        System.out.println(wylosowaneHaslo);
        wyswietlHasloDoZgadywania();
        Scanner scanner = new Scanner(System.in);
        do {
            char litera = podajLitere();
           if (sprawdzCzyPoprawnaLitera(litera)){
               wpiszPodanaLitere(litera);
               wyswietlHasloDoZgadywania();
               System.out.println("Zgadnij hasło lub wciśnij \"Enter\"");
               String probaHasla = scanner.nextLine();
               if (probaHasla.equals(haslo)){
                   System.out.println("Brawo.");
                   wyswietlHaslo();
                   return;
               }
           } else {
               iloscNietrafionychProb++;
               wyswietlWisielca();
           }
        } while ((iloscNietrafionychProb < 9) &&(!czyHasloOdgadniete()));
    }

    static String losujHaslo() {
        Random losowanie = new Random();
        int pozycjaHasla = losowanie.nextInt(20);
        String haslo = polscyAktorzyIAktorki[pozycjaHasla];
        return haslo.toUpperCase();
    }

    static void wypelnijTablicePodkreslnikami() {
        for (int i = 0; i < wylosowaneHaslo.length; i++) {
            switch (wylosowaneHaslo[i]) {
                case ' ' -> hasloDoOperacji[i] = ' ';
                case '-' -> hasloDoOperacji[i] = '-';
                default -> hasloDoOperacji[i] = '_';
            }
        }
        System.out.println();
    }

    static void wyswietlHasloDoZgadywania() {
            for (char litera : hasloDoOperacji) {
                System.out.print(litera);
            }
        System.out.println();
        System.out.println();
    }

    static char podajLitere() {
        System.out.println("Podaj literę (użyj drukowanych liter):");
        Scanner scanner = new Scanner(System.in);
        String podanaLitera = scanner.nextLine();
        return podanaLitera.charAt(0);
    }
    static boolean sprawdzCzyPoprawnaLitera(char podanaLitera){
        for (int i = 0; i < wylosowaneHaslo.length; i++) {
            if (wylosowaneHaslo[i] == podanaLitera) {
                return true;
            }
        }
        return false;
    }

    static void wpiszPodanaLitere(char podanaLitera) {
        for (int i = 0; i < wylosowaneHaslo.length; i++) {
            if (wylosowaneHaslo[i] == podanaLitera) {
                hasloDoOperacji[i] = podanaLitera;
            }
        }
    }

    static boolean czyHasloOdgadniete(){
        for (int i = 0; i < hasloDoOperacji.length; i++) {
            if (hasloDoOperacji[i] == '_'){
                return false;
            }
        }
        return true;
    }

    static void wyswietlHaslo() {
        for (char litera : wylosowaneHaslo) {
            System.out.print(litera);
        }
        System.out.println();
        System.out.println();
    }

    static void wyswietlWisielca() {
        for (int i = 0; i < 40; i++) {
            System.out.print("—");
        }
        for (int wiersz = 0; wiersz < 15; wiersz++) {
            System.out.println();
            System.out.print("|");
            for (int kolumna = 0; kolumna < 38; kolumna++) {
                System.out.print(" ");
            }
            System.out.print("|");
        }
        System.out.println();
        for (int i = 0; i < 40; i++) {
            System.out.print('—');
        }
    }
}
