package podstawy;

import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) {

        String[] pytania = utworzTablicePytan();
        String[] odpowiedzi = utworzTablicePoprawnychOdpowiedzi();
        rozpocznij();
        int punkty = uruchomQuiz(pytania, odpowiedzi);
        wyswietlWyniki(pytania, odpowiedzi, punkty);


    /*    String kapitan = scanner.nextLine();
        if (kapitan.equals("James Kirk")) {
            System.out.println("Twoja odpowiedź jest poprawna. Zdobyłeś 1 punkt.");
            zdobytePunkty++;
        } else {
            System.out.println("Niestety to nie jest poprawna odpowiedź. Właściwa odpowiedź to: James Kirk.");
        }
        //odp James Kirk

        var rok = scanner.nextLine();
        if (rok.equals("1979")) {
            System.out.println("Twoja odpowiedź jest poprawna. Zdobyłeś 1 punkt.");
            zdobytePunkty++;
        } else {
            System.out.println("Niestety to nie jest poprawna odpowiedź. Właściwa odpowiedź to: 1979.");
        }
        scanner.nextLine();
        //odp 1979

        String film = scanner.nextLine();
        if (film.equals("Pierwszy Kontakt")){
            System.out.println("Twoja odpowiedź jest poprawna. Zdobyłeś 1 punkt.");
            zdobytePunkty++;
        } else {
            System.out.println("Niestety to nie jest poprawna odpowiedź. Właściwa odpowiedź to: Pierwszy Kontakt.");
        }
        //odp Pierwszy Kontakt

        String aktor = scanner.nextLine();
        if (aktor.equals("Patrick Stewart")) {
            System.out.println("Twoja odpowiedź jest poprawna. Zdobyłeś 1 punkt.");
            zdobytePunkty++;
        } else {
            System.out.println("Niestety to nie jest poprawna odpowiedź. Właściwa odpowiedź to: Patrick Stewart.");
        }
        //odp Patrick Stewart

        var sezony = scanner.nextLine();
        if (sezony.equals("7")) {
            System.out.println("Twoja odpowiedź jest poprawna. Zdobyłeś 1 punkt.");
            zdobytePunkty++;
        } else {
            System.out.println("Niestety to nie jest poprawna odpowiedź. Właściwa odpowiedź to: 7.");
        }
        //odp 7*/
    }

    static String[] utworzTablicePytan() {
        String p1 = "Pytanie 1: Podaj imię i nazwisko kapitana Enterprise w serialu 'Star Trek: The Original Series'";
        String p2 = "Pytanie 2: W którym roku odbyła się premiera pierwszego filmu z serii Star Trek ('Star Trek: The Motion Picture')?";
        String p3 = "Pytanie 3: Podaj tytuł filmu z serii Star Trek z 1996, w którym załoga Enterprise-E cofa sie w czasie do 2063 roku aby wspólnie z Zeframem Cochranem " +
                "odbyć pierwszy lot z prędkością warp.";
        String p4 = "Pytanie 4: Podaj imię i nazwisko aktora odgrywającego role kapitana Jean-Luc Picarda";
        String p5 = "Pytanie 5: Ile sezonów liczył serial Star Trek: Deep Space Nine?";
        return new String[]{p1, p2, p3, p4, p5};
    }

    static String[] utworzTablicePoprawnychOdpowiedzi() {
        String odp1 = "James Kirk";
        String odp2 = "1979";
        String odp3 = "Pierwszy Kontakt";
        String odp4 = "Patrick Stewart";
        String odp5 = "7";
        return new String[]{odp1, odp2, odp3, odp4, odp5};
    }

    static void rozpocznij() {
        System.out.println("Zaczynamy quiz. Temat: Star Trek! Spróbuj odpowiedzieć poprawnie na poniższe 5 pytań.");
    }

    static int uruchomQuiz(String[] pytania, String[] odpowiedzi){
        Scanner scanner = new Scanner(System.in);
        int zdobytePunkty = 0;

        for (int i = 0; i < pytania.length; i++) {
            System.out.println(pytania[i]);
            String odpowiedz = scanner.nextLine();
            if (odpowiedz.equals(odpowiedzi[i])) {
                System.out.println("Twoja odpowiedź jest poprawna. Zdobyłeś 1 punkt.");
                zdobytePunkty++;
            } else {
                System.out.println("Niestety to nie jest poprawna odpowiedź.");
            }
        }
        scanner.close();
        return zdobytePunkty;
    }
    static void wyswietlWyniki(String[] pytania, String[] odpowiedzi, int punkty){
        System.out.println("Prawidłowe odpowiedzi:");
        for (int i = 0; i < pytania.length; i++) {
            System.out.println(pytania[i]);
            System.out.println(odpowiedzi[i]);
        }
        System.out.println("Twoje punkty: " + punkty);
    }
}
