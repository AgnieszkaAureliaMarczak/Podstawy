package podstawy;

import java.util.Scanner;

public class Petle3 {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
     /* int haslo = 23698;
        int podaneHaslo;
        do {
            System.out.println("Podaj piecioliczbowe hasło..");
            podaneHaslo = scanner.nextInt();
        } while ( podaneHaslo != haslo );
        System.out.println("Podane hasło jest poprawne.");
        scanner.close(); */

        double podanaWaga;
        double podanyWzrost;
        do {
            System.out.println("Podaj wagę");
            podanaWaga = scanner.nextDouble();
            System.out.println("Podaj wzrost");
            podanyWzrost = scanner.nextDouble();
        } while (podanyWzrost> 2.5 || podanyWzrost<0.5);
        System.out.println("Obliczam BMI...");
        double bmi = podanaWaga/Math.pow(podanyWzrost,2);
        System.out.println("BMI wynosi " + bmi + ".");
        scanner.close();
    }
}
