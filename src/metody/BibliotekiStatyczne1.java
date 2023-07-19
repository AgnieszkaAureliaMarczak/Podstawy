package metody;

import java.util.Arrays;

public class BibliotekiStatyczne1 {
    public static void main(String[] args) {
    int [] tablicaLiczb = {6, 154, 89, 36, -23574, 99, 87, 0, -5};
        System.out.println(Arrays.toString(Narzedzia.sortujBabelkowo(tablicaLiczb)));
        System.out.println(wyszukajElement(tablicaLiczb, 999));
    }
    public static int wyszukajElement(int[] tablicaLiczb, int szukanaLiczba){
        Narzedzia.sortujBabelkowo(tablicaLiczb);
        return Arrays.binarySearch(tablicaLiczb,szukanaLiczba);
    }

}
