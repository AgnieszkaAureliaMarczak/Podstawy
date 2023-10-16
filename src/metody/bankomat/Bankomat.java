package metody.bankomat;

import java.util.Scanner;

public class Bankomat {
    private static final int pinUzytkownika = 5236;
    public static int numerJezyka;

    public static void main(String[] args) {
        System.out.println("Dzień dobry. Wybierz język, podając liczbę od 1 do 4:\n" +
                "1. Polski\n" +
                "2. English\n" +
                "3. Deutsch\n" +
                "4. Français");
        Scanner scanner = new Scanner(System.in);
        numerJezyka = scanner.nextInt();
        String[] tablicaKomunikatow = switch (numerJezyka) {
            case 1 -> Polski.polskieKomunikaty;
            case 2 -> Angielski.angielskieKomunikaty;
            case 3 -> Niemiecki.niemieckieKomunikaty;
            case 4 -> Francuski.francuskieKomunikaty;
            default -> Polski.polskieKomunikaty;
        };
        System.out.println(tablicaKomunikatow[0]);
        System.out.println("____");
        int iloscNiepoprawnychProbPin = 0;
        int podanyPin;
        do {
            podanyPin = scanner.nextInt();
            if (podanyPin != dajPinUzytkownika()) {
                iloscNiepoprawnychProbPin++;
                if (iloscNiepoprawnychProbPin == 3){
                    System.out.println(tablicaKomunikatow[2]);
                    break;
                }
                System.out.println(tablicaKomunikatow[1]);
                System.out.println("____");
            }
        } while (podanyPin != dajPinUzytkownika());

    }

    static int dajPinUzytkownika() {
        return pinUzytkownika;
    }
}
