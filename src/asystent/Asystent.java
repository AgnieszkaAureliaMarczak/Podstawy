package asystent;

import java.util.Random;
import java.util.Scanner;

public class Asystent {
    static String pierwszaOpcjaGry = "Zgadnij liczbę od 1 do 10";
    static String drugaOpcjaGry = "Zagraj w Mastermind";
    static String trzeciaOpcjaGry = "Loteria 6 liczb";
    static String[] opcjeGry = {pierwszaOpcjaGry, drugaOpcjaGry, trzeciaOpcjaGry};

    public static void main(String[] args) {
        rozpocznijProgram();
    }

    static void rozpocznijProgram() {
        System.out.println(generujPowitanie());
        uruchomMenu();
        System.out.println(generujPozegnanie());
    }

    static String generujPowitanie() {
        String powitanie1 = "Cześć!\nCo chciałbyś dzisiaj zrobić?";
        String powitanie2 = "Witaj!\nNa co masz dziś ochotę?";
        String powitanie3 = "Hej!\nCo dziś robimy?";
        String powitanie4 = "Dzień dobry!\nJak Ci mija dzień? Może w coś zagramy?";
        String powitanie5 = "Halo!\nMoże trochę rozrywki?";

        String[] zbiorPowitan = {powitanie1, powitanie2, powitanie3, powitanie4, powitanie5};

        Random powitanie = new Random();
        int pozycjaWtablicy = powitanie.nextInt(0, 5);

        return zbiorPowitan[pozycjaWtablicy];
    }

    static void uruchomMenu() {
        drukujListeOpcji();
        int opcjaGry = pobierzWybor();
        uruchomOpcje(opcjaGry);
    }

    static String generujPozegnanie() {

        String slowoPozegnania = "pa";
        String pozegnanie = "";

        Random ileRazy = new Random();
        int iloscSlow = ileRazy.nextInt(1, 6);
        for (int i = 0; i < iloscSlow; i++) {
            pozegnanie = pozegnanie + slowoPozegnania;
        }
        return pozegnanie + "!";
    }

    static void drukujListeOpcji() {
        for (int i = 0; i < opcjeGry.length; i++) {
            System.out.print(i + 1);
            System.out.println(". " + opcjeGry[i]);
        }


    }

    static int pobierzWybor() {
        System.out.println("Wybierz jedną z powyższych opcji.");
        Scanner scanner = new Scanner(System.in);
        int wybranaOpcja;
        wybranaOpcja = scanner.nextInt();

     /*   do {
            System.out.println("Wybierz jedną z powyższych opcji.");
            wybranaOpcja = scanner.nextInt();
        } while (wybranaOpcja < 1 || wybranaOpcja > opcjeGry.length);
        */

        if (wybranaOpcja < 1 || wybranaOpcja > opcjeGry.length) {
            return pobierzWybor();
        }
        return wybranaOpcja;
    }

    static void uruchomOpcje(int opcja) {
        System.out.println("Uruchamiam grę nr " + opcja + ". " );
        opcja--;
        String wyswietlanaOpcja = opcjeGry[opcja];
        System.out.println(wyswietlanaOpcja);
        switch (opcja){
            case 0:
                ZgadnijLiczbe.rozpocznijGre();
                break;
            case 1:
               // Mastermind.main(null);
               Mastermind.zagrajWmastermind();
                break;
            case 2:
                Loteria.zagrajWloterie();
                break;
            default:
                System.out.println("Nie istnieje taka opcja");
        }

      /*  if (opcja == 0) {

        } else if (opcja == 1) {

        } else {

        }*/
    }
}
