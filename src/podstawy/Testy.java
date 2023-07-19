package podstawy;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Testy {
    public static void main(String[] args) {
     /*   char test = 35;
        char test2 = '3';
        System.out.println("Testowe zdanie: " + test2);
        long mojLong = 200L;
        byte mojByte = 80;
        double mojDouble = 5.99;
        char mojChar = (char)mojByte;
        mojLong = (long)mojDouble;*/
        //int liczba = 5;
       // liczba+=2;
       // liczba--;
       // System.out.println(liczba);
        //liczenie do 10 i szukanie

     //   int szukam = 1;
      //  System.out.println("Liczę do 10 i was szukam...");
     //   while(szukam <= 10){
     //       System.out.println(szukam);
     //       szukam++;
     //   }
     //   System.out.println("Szukam!");

    /*    String haslo = "Ala33";
        System.out.println("Podaj hasło:");
        Scanner proba = new Scanner(System.in);
        String podaneHaslo = proba.nextLine();
        while (!podaneHaslo.equals(haslo)){
            System.out.println("Podane hasło jest niepoprawne. Spróbuj ponownie:");
            podaneHaslo = proba.nextLine();
        }
        System.out.println("Poprawne hasło.");
        proba.close(); */

        int kodPIN = 5696;

        Scanner pinProba = new Scanner(System.in);
        int podanyPIN;

      //  while (!(podanyPIN == kodPIN)){
       //     System.out.println("Podany PIN jest nieporawny. Sprobuj ponownie:");
       //     podanyPIN = pinProba.nextInt();
      //  }
        do {
            System.out.println("Podaj PIN:");
            podanyPIN = pinProba.nextInt();
        } while (!(podanyPIN == kodPIN));

        System.out.println("PIN poprawny");
        pinProba.close();

        int[] tablica = new int[10];
        int[] liczby = {5,45,66};
        tablica[2] = 55;
        String[] cytaty = new String[2];
        //  System.out.println(Arrays.toString(liczby));
        // System.out.println(cytaty.length);
        int index = 0;
        while( index < liczby.length ){
            System.out.println(liczby[index]);
            index++;
        }
    }
}
