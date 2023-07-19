package podstawy;

import java.util.Scanner;

public class For1 {
    public static void main(String[] args) {
        //Ćwiczenie 12
        int[] tablicaLiczb = {-20, 0, 3, 14, 56, 78, 99, -74, 61, -100};

        int suma = 0;
        for (int liczba : tablicaLiczb) {
            suma += liczba;
        }
        double srednia = (double) suma / tablicaLiczb.length;
        System.out.println(srednia);
        int max = tablicaLiczb[0];
        for (int liczba1 : tablicaLiczb) {
            if (liczba1 > max) {
                max = liczba1;
            }
        }
        System.out.println(max);
        int min = tablicaLiczb[0];
        for (int liczba2 : tablicaLiczb) {
            if (liczba2 < min) {
                min = liczba2;
            }
        }
        System.out.println(min);
        //Ćwiczenie 13
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wprowadź znak wypełnienia prostokąta:");
        String wypelnienie = scanner.nextLine();
        System.out.println("Wprowadź wysokość prostokąta:");
        int wysokosc = scanner.nextInt();
        System.out.println("Podaj szerokość prostokąta:");
        int szerokosc = scanner.nextInt();
        System.out.println("Rysuję!");
        for (int i = 0; i < wysokosc; i++) {
            for (int j = 0; j < szerokosc; j++) {
                System.out.print(wypelnienie);
            }
            System.out.println();
        }
        scanner.close();
    }
}
