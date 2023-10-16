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
        System.out.println(numerJezyka);
        System.out.println("Włóż kartę.");
        System.out.println("Podaj PIN");
        int podanyPin = scanner.nextInt();
        System.out.println(podanyPin);
    }
    static int dajPinUzytkownika(){
        return pinUzytkownika;
    }
}
