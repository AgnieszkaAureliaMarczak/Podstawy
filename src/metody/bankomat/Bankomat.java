package metody.bankomat;

import java.util.Scanner;

public class Bankomat {
    private static final int pinUzytkownika = 5236;
    public static int numerJezyka;

    public static void main(String[] args) {
        wyswietlWyborJezyka();
        Scanner scanner = new Scanner(System.in);
        numerJezyka = scanner.nextInt();
        String[] tablicaKomunikatow = switch (numerJezyka) {
            case 1 -> Polski.polskieKomunikaty;
            case 2 -> Angielski.angielskieKomunikaty;
            case 3 -> Niemiecki.niemieckieKomunikaty;
            case 4 -> Francuski.francuskieKomunikaty;
            default -> Polski.polskieKomunikaty;
        };
        System.out.println(tablicaKomunikatow[0]); // podaj PIN
        System.out.println("____");
        int iloscNiepoprawnychProbPin = 0;
        int podanyPin;
        do {
            podanyPin = scanner.nextInt();
            if (podanyPin != dajPinUzytkownika()) {
                iloscNiepoprawnychProbPin++;
                if (iloscNiepoprawnychProbPin == 3){
                    System.out.println(tablicaKomunikatow[2]); // blokada karty
                    break;
                }
                System.out.println(tablicaKomunikatow[1]); // niepoprawny PIN
                System.out.println("____");
            }
        } while (podanyPin != dajPinUzytkownika());
        System.out.println(tablicaKomunikatow[3]); // wybor operacji
        int wyborOperacji = scanner.nextInt();
    }

    static void wyswietlWyborJezyka(){
        System.out.println("Dzień dobry. Wybierz język, podając liczbę od 1 do 4:\n" +
                "1. Polski\n" +
                "2. English\n" +
                "3. Deutsch\n" +
                "4. Français");
    }

    static int dajPinUzytkownika() {
        return pinUzytkownika;
    }
}
