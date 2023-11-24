package obiektowosc.makao;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FajniejszyScanner {
    private Scanner scanner = new Scanner(System.in);

    public int pobierzLiczbe(String komunikat) {
        try{
            System.out.println(komunikat);
            return scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Nie podajemy liter");
//            scanner.nextLine();
            scanner = new Scanner(System.in);
            return pobierzLiczbe(komunikat);
        }
    }
}
