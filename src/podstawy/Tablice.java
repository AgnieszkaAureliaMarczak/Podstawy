package podstawy;

import java.util.Arrays;
import java.util.Random;

public class Tablice {
    public static void main(String[] args){
      // Cwiczenie 6
        int[] liczby = new int[4];
        String[] teksty = new String[2];
        liczby[0] = 12;
        liczby[1] = 10;
        liczby[2] = 2022;
        liczby[3] = 2000000;
        teksty[0] = "Jan";
        teksty[1] = "Uciekinier";
        System.out.println(liczby[0] + "-" + liczby[1] + "-" + liczby[2] + " zbiegł więzień " + teksty[0] + " " + teksty[1] + "!");
        System.out.println("Nagroda za przyprowadzenie: " + liczby[3] + "$!");
        //Ćwiczenie 7
        double[] liczbyZmiennoprzecinkowe = {2.5, 3.69, 68.45, 3.268};
        boolean[] nowaTablica = {true, false};
        char[] fajnaTablica = {'j','a','v','a'};
        System.out.println(Arrays.toString(liczbyZmiennoprzecinkowe));
        System.out.println(Arrays.toString(nowaTablica));
        System.out.println(Arrays.toString(fajnaTablica));

        Random[] przypadkowaTablica = new Random[3];
        przypadkowaTablica[2] = new Random();
        int wylosowanaLiczba = przypadkowaTablica[2].nextInt(5);
        System.out.println(wylosowanaLiczba);
    }

}
