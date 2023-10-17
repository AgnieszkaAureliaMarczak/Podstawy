package metody.bankomat;

import java.util.Scanner;

public class Bankomat {
    static String[] tablicaKomunikatow;
    static int numerJezyka;
    private static final int pinUzytkownika = 5236;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        przygotujBankomatDoObslugi();
        zweryfikujPinUzytkownika();
        wybierzOperacje();
    }

    static void przygotujBankomatDoObslugi() {
        wyswietlJezykiDoWyboru();
        tablicaKomunikatow = ustalJezykWyswietlania();
    }

    static void wyswietlJezykiDoWyboru() {
        System.out.println("Dzień dobry. Wybierz język, podając liczbę od 1 do 4:\n" +
                "1. Polski\n" +
                "2. English\n" +
                "3. Deutsch\n" +
                "4. Français");
    }

    static String[] ustalJezykWyswietlania() {
        numerJezyka = scanner.nextInt();
        return tablicaKomunikatow = switch (numerJezyka) {
            case 1 -> Polski.polskieKomunikaty;
            case 2 -> Angielski.angielskieKomunikaty;
            case 3 -> Niemiecki.niemieckieKomunikaty;
            case 4 -> Francuski.francuskieKomunikaty;
            default -> Polski.polskieKomunikaty;
        };
    }

    static void zweryfikujPinUzytkownika() {
        wyswietlProsbeOPin();
        boolean poprawnyPin = sprawdzPinUzytkownika();
        if (!poprawnyPin) {
            System.out.println(tablicaKomunikatow[2]);// blokada karty
            System.exit(0);
        }
    }

    static void wyswietlProsbeOPin() {
        System.out.println(tablicaKomunikatow[0]); // podaj PIN
        System.out.println("____");
    }

    static boolean sprawdzPinUzytkownika() {
        boolean czyPoprawnyPin = true;
        int podanyPin;
        int iloscNiepoprawnychProbPin = 0;
        do {
            podanyPin = pobierzPinOdUzytkownika();
            if (podanyPin != dajPoprawnyPinUzytkownika()) {
                iloscNiepoprawnychProbPin++;
                if (iloscNiepoprawnychProbPin == 3) {
                    czyPoprawnyPin = false;
                    break;
                }
                System.out.println(tablicaKomunikatow[1]); // niepoprawny PIN
                System.out.println("____");
            }
        } while (podanyPin != dajPoprawnyPinUzytkownika());
        return czyPoprawnyPin;
    }

    static int pobierzPinOdUzytkownika() {
        return scanner.nextInt();
    }

    static int dajPoprawnyPinUzytkownika() {
        return pinUzytkownika;
    }

    static void wybierzOperacje() {
        System.out.println(tablicaKomunikatow[3]); // wybor operacji
        int wyborOperacji = scanner.nextInt();
        switch (wyborOperacji) {
            case 1 -> Operacje.wyplacGotowke();
            case 2 -> Operacje.wyplacZblizeniowo();
            case 3 -> Operacje.wyplacBlikiem();
            case 4 -> Operacje.sprawdzSaldo();
            default -> zareagujNaNiewlasciwyWyborOperacji();
        }
    }

    static void zareagujNaNiewlasciwyWyborOperacji() {
        System.out.println(tablicaKomunikatow[4]);// nie wybrano operacji
        int operacjaCzyExit = scanner.nextInt();
        if (operacjaCzyExit == 1) {
            wybierzOperacje();
        } else if (operacjaCzyExit == 2) {
            System.out.println(tablicaKomunikatow[5]);// odbierz karte
            System.exit(0);
        } else {
            System.out.println(tablicaKomunikatow[6]);
            System.exit(0);//niepoprawna wartosc
        }
    }
}
