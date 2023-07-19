package metody;

import java.util.Scanner;

public class BibliotekiStatyczne0 {
    public static void main(String[] args) {
        System.out.println(Math.pow(2, 5));
        System.out.println(czyCyfra("ul. Wiejska 20"));
        System.out.println(zwrocLiczbe());

    }

    static boolean czyCyfra(String tekst) {
        return Character.isDigit(tekst.charAt(tekst.length() - 1));
    }

    static int zwrocLiczbe() {

        System.out.println("Podaj liczbę.");
        Scanner scanner = new Scanner(System.in);
        String pobranaLiczba = scanner.nextLine();
     /*  int oddanaLiczba;

       if (!czyLiczba(pobranaLiczba)) {

          oddanaLiczba = -1;

        } else {
            oddanaLiczba = Integer.parseInt(pobranaLiczba);
        }*/


       while((!czyLiczba(pobranaLiczba))){
           System.out.println("Wprowadziłeś tekst. Podaj liczbę.");
           pobranaLiczba = scanner.nextLine();
       }

        scanner.close();
        return Integer.parseInt(pobranaLiczba);

    }

    public static boolean czyLiczba(String wczytany) {
        if (wczytany.length() == 0) {
            return false;
        }
        for (int i = 0; i < wczytany.length(); i++) {
            if (!Character.isDigit(wczytany.charAt(i)))
                return false;
        }
        return true;
    }
}
