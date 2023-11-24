package obiektowosc.makao;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FajniejszyScanner {
    private static Scanner scanner = new Scanner(System.in);

    public static int pobierzLiczbe() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Podano niepoprawną wartość. Podaj liczbę graczy (od 2 do 6).");
            scanner = new Scanner(System.in);
            return pobierzLiczbe();
        }
    }
}
