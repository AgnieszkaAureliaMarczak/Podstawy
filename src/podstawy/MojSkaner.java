package podstawy;

import java.util.Scanner;

public class MojSkaner {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Cześć, jak masz na imię?");
        String imie = scanner.nextLine();
        System.out.println("Jak masz na nazwisko?");
        String nazwisko = scanner.nextLine();
        System.out.println("Cześć " + imie + "! Proszę podaj jeszcze swój wiek:");
        int wiek = scanner.nextInt();
      /*  boolean pelnoletni = wiek>=18;
        if(wiek>=18){
            System.out.println("Już wiem czy jesteś pełnoletni: " + pelnoletni);
        }
        else {
            System.out.println("Już wiem czy jesteś pełnoletni: " + pelnoletni);
        }*/
        System.out.print("Twój wiek kwalifikuje się do kategorii: ");

        //unikac niepotrzebnego zagniezdzania kodu

        if (wiek <= 0 || wiek >= 100) {
            System.out.println("Podany wiek nie jest poprawną wartością.");
            return;
        }

        if (wiek <= 10) {
            System.out.println("dziecko.");
        } else if (wiek < 18) {
            System.out.println("nastolatek.");
        } else if (wiek < 65) {
            System.out.println("osoba dorosła.");
        } else {
            System.out.println("senior.");
        }

    }
}

