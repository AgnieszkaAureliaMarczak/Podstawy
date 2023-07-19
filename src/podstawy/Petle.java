package podstawy;

import java.util.Random;
import java.util.Scanner;

public class Petle {
    public static void main(String[] args) {
      /* Ćwiczenie 1
         wersja a)

        int a = 1;
        System.out.println("Zaczynamy losowanie!");
        Random random = new Random();
        while(a >=1 && a <10){
           a = random.nextInt(10) + 1;
           System.out.println(a);
        }
        System.out.println("Trafione");

        wersja b)
        int wylosowana = 1;
        int iloscLosowan = 0;
        System.out.println("Zaczynamy losowanie!");
        Random random = new Random();
        while( wylosowana !=10 ) {  // powtarzaj tak długo jeśli wylosowana to nie 10
            wylosowana = random.nextInt(10) + 1;
            System.out.println(wylosowana);
            iloscLosowan ++;
        }
        System.out.println("Trafione");
        System.out.println("Ilosc prob: " + iloscLosowan);

        Cwiczenie 2

        Scanner scanner = new Scanner(System.in);
        int podanePunkty;
        int wszystkiePunkty = 0;
        System.out.println("Wprowadzaj uzyskane punkty cząstkowe. Aby zakończyć wpisz 0. Policzę dla Ciebie ich sumę :)");
        while(true){
            System.out.println("Wprowadź liczbę");
            podanePunkty = scanner.nextInt();
            wszystkiePunkty = wszystkiePunkty + podanePunkty;
            if (podanePunkty == 0) {
                System.out.println("Uzyskane punkty: " + wszystkiePunkty);
                break;
            }
        }
        scanner.close();
        wersja b)

        Scanner scanner = new Scanner(System.in);
        int podanePunkty = 0;
        int wszystkiePunkty = 0;
        System.out.println("Wprowadzaj uzyskane punkty cząstkowe. Aby zakończyć wpisz -1. Policzę dla Ciebie ich sumę :)");
        while(podanePunkty != -1){
            System.out.println("Wprowadź liczbę");
            podanePunkty = scanner.nextInt();
            wszystkiePunkty = podanePunkty + wszystkiePunkty;
        }
        wszystkiePunkty +=1;
        System.out.println("Uzyskane punkty: " + wszystkiePunkty);
        scanner.close();*/
    }
}
