package metody.bankomat;

import java.util.Scanner;

public class Bankomat {
    static String[] tablicaKomunikatow;
    public static int numerJezyka;
    private static final int pinUzytkownika = 5236;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        wyswietlJezykiDoWyboru();
        tablicaKomunikatow = ustalJezykWyswietlania();
        wyswietlProsbeOPin();
        boolean poprawnyPin = sprawdzPinUzytkownika();
        if (!poprawnyPin) {
            System.out.println(tablicaKomunikatow[2]);// blokada karty
            return;
        }
        wybierzOperacje();
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

    static void wyswietlProsbeOPin() {
        System.out.println(tablicaKomunikatow[0]); // podaj PIN
        System.out.println("____");
    }

    static int pobierzPinOdUzytkownika() {
        return scanner.nextInt();
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

    static int dajPoprawnyPinUzytkownika() {
        return pinUzytkownika;
    }

    static void wybierzOperacje(){
        System.out.println(tablicaKomunikatow[3]); // wybor operacji
        int wyborOperacji = scanner.nextInt();
        switch (wyborOperacji) {
            case 1 -> wyplacGotowke();
            case 2 -> wyplacZblizeniowo();
            case 3 -> wyplacBlikiem();
            case 4 -> sprawdzSaldo();
            default -> System.out.println(tablicaKomunikatow[4]);// nie wybrano operacji
        };
    }

    static void wyplacGotowke(){

    }

    static void wyplacZblizeniowo(){

    }

    static void wyplacBlikiem(){

    }

    static void sprawdzSaldo(){

    }
}
