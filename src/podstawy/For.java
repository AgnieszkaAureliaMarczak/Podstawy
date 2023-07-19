package podstawy;

import java.util.Arrays;
import java.util.Random;

public class For {
    public static void main(String[] args) {
        //Ćwiczenie 10
      /*  for (int i = 0; i <= 5000; i++) {
            System.out.println(i);
        }*/
        String[] imiona = {"Ala", "Zosia", "Bartek", "Marysia", "Ela"};
        //    System.out.println(Arrays.toString(imiona));
        //    for (String imie:imiona) {
        //        System.out.println(imie);
        //    }
        //    double liczba = 2.0;
        //    for (int i = 0; i < 20; i++) {
        //        System.out.println((int)Math.pow(liczba, i));
        //    }
        //Ćwiczenie 11
        int[] tablica = new int[1_000_000];
        Random losowanie = new Random();

//
        for (int i = 0; i < 1_000_000; i++) {
            tablica[i] = losowanie.nextInt(1, 101);
        }
     /*   int licznik = 0;
        for (int dana:tablica) {
            if (dana == 25){
                licznik++;
            }
        }
        System.out.print("Liczba 25 wystapiła " + licznik + " razy.");*/

        int[] liczby = new int[100];
        for (int i = 0; i < liczby.length; i++) {
            liczby[i] = i + 1;
            System.out.println(liczby[i]);
        }

        for (int i = 0; i < liczby.length; i++) {
            int suma = 0;
            for (int j = 0; j < tablica.length; j++) {
                if (liczby[i] == tablica[j]) {
                    suma++;
                }
            }
            System.out.println("Liczba " + liczby[i] + " pojawia się razy: " + suma);
        }

    }
}
