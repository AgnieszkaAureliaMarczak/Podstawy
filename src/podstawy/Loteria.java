package podstawy;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Loteria {
    public static void main(String[] args) {
        int[] tablica = podawanieLiczb();
        int[] wylosowaneLiczby1 = wylosujLiczby();

        System.out.println(Arrays.toString(wylosowaneLiczby1));
        int trafioneLiczby = policzTrafione(tablica, wylosowaneLiczby1);
        policzNagrode(trafioneLiczby);


    }

    static int[] podawanieLiczb() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj 6 liczb od 1 do 24. Liczby nie mogą się powtarzać.");
        int[] tablicaLiczb = new int[6];
        int podanaLiczba;
        for (int i = 0; i < 6; i++) {
            podanaLiczba = scanner.nextInt();
            if (podanaLiczba < 1 || podanaLiczba > 24) {
                System.out.println("Wprowadzona liczba wykracza poza zakres 1-24. Podaj nową liczbę.");
                i--;
                continue;
            }

            boolean powtorka = czyPowtorka(tablicaLiczb, podanaLiczba);
            System.out.println(powtorka);
            if (powtorka){
                i--;
                continue;
            }
            tablicaLiczb[i] = podanaLiczba;
        }
        System.out.println(Arrays.toString(tablicaLiczb));
        scanner.close();
        return tablicaLiczb;
    }




    static int policzTrafione(int[] podaneLiczby, int[] wylosowaneLiczby) {
        int trafioneLiczby = 0;
        for (int i = 0; i < podaneLiczby.length; i++) {
            for (int j = 0; j < wylosowaneLiczby.length; j++) {
                if (podaneLiczby[i] == wylosowaneLiczby[j]) {
                    trafioneLiczby++;
                }
            }
        }
        return trafioneLiczby;
    }

    static int[] wylosujLiczby() {
        System.out.println("Losuje 6 liczb od 1 do 24.");
        Random losowanie = new Random();
        int[] wylosowaneLiczby = new int[6];
        int wylosowanaLiczba = 0;

        for (int i = 0; i < 6; i++) {
            wylosowanaLiczba = losowanie.nextInt(1, 25);
            for (int sprawdzanaLiczba : wylosowaneLiczby) {
                if (wylosowanaLiczba == sprawdzanaLiczba) {
                    wylosowanaLiczba = losowanie.nextInt(1, 25);
                    i--;
                }
            }
            wylosowaneLiczby[i] = wylosowanaLiczba;
        }
        return wylosowaneLiczby;
    }

    static void policzNagrode(int trafione) {
        System.out.println("Trafiles " + trafione + " liczb.");
        System.out.print("Twoja nagroda wynosi: ");
        if (trafione <= 2) {
            System.out.println("0zł.");
        } else if (trafione == 3) {
            System.out.println("16zł.");
        } else if (trafione == 4) {
            System.out.println("200zł.");
        } else if (trafione == 5) {
            System.out.println("4_000zl.");
        } else {
            System.out.println("1_500_000zł.");
        }
    }

    static boolean czyPowtorka(int[] tablica, int podanaLiczba) {

        for (int sprawdzanaLiczba : tablica) {
            if (podanaLiczba == sprawdzanaLiczba) {
                System.out.println("Wprowadzona liczba powtarza się. Podaj inną liczbę od 1 do 24.");
                return true;
            }
        }
        return false;
    }

}
