package podstawy;

import java.util.Scanner;

public class InstrukcjeWarunkowe2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj cenę towaru:");
        int cenaTowaru = scanner.nextInt();
        if (cenaTowaru < 100 || cenaTowaru > 10_000){
            System.out.println("Podana cena towaru wykracza poza zakres cen z naszego sklepu (100-10 000).");
            return;
        }
        System.out.println("Podaj liczbę rat:");
        int liczbaRat = scanner.nextInt();
        double miesiecznaRata = (double)cenaTowaru/liczbaRat;
        double odsetki;


        if (liczbaRat < 6 || liczbaRat > 48){
            System.out.println("Podana liczba rat wykracza poza dostępny zakres (6-48).");
            return;
        } else if (liczbaRat < 13) {
            odsetki = 0.025;
        } else if (liczbaRat < 25) {
            odsetki = 0.05;
        } else {
            odsetki = 0.1;
        }
        odsetki *=  miesiecznaRata;

        //double miesiecznaKwota = Math.round((miesiecznaRata + odsetki)*100.0) / 100.0;
        double miesiecznaKwota = miesiecznaRata + odsetki;
        System.out.println("Miesięczna rata twojego kredytu bedzie wynosić: " + miesiecznaKwota + ".");
        System.out.printf("Miesięczna rata twojego kredytu bedzie wynosić: %.2f\n",miesiecznaKwota);
        //f - zmiennoprzecinkowe
        //d - całkowite
        //s - string
        scanner.close();
    }
}
