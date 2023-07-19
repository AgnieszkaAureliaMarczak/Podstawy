package podstawy;

import java.util.Scanner;

public class For3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Narysuję dla Ciebie choinkę. Podaj liczbę wierszy");
        int liczbaWierszy = scanner.nextInt();
      /*  for (int i = 0; i < liczbaWierszy; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }*/
        for (int i = 1; i <= liczbaWierszy; i++) {
            for (int j = 0; j < liczbaWierszy - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < (i * 2) - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        scanner.close();
    }

}
