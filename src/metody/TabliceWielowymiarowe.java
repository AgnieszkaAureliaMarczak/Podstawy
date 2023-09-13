package metody;

import java.util.Random;

public class TabliceWielowymiarowe {
    public static void main(String[] args) {
        int[][] plansza = new int[8][8];

/*
        int[] rzad1 = new int[8];
        int[] rzad2 = new int[8];
        int[] rzad3 = new int[8];
        int[] rzad4 = new int[8];

        plansza[0] = rzad1;
        plansza[1] = rzad2;
        plansza[2] = rzad3;
        plansza[3] = rzad4;*/
        //  System.out.println(Arrays.toString(plansza[0]));
        Random wypelnienietablic = new Random();
        for (int y = 0; y < plansza.length; y++) {
            for (int x = 0; x < plansza[y].length; x++) {
                plansza[y][x] = wypelnienietablic.nextInt(2);
            }
        }
        for (int[] rzad : plansza) {
            for (int liczba : rzad) {
                System.out.print(liczba + " ");
            }
            System.out.println("");
        }
        System.out.println(plansza[2][7]);

    }
}
