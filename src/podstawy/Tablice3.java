package podstawy;

import java.util.Random;
import java.util.Scanner;

public class Tablice3 {
    public static void main(String[] args) {
        //Cwiczenie 9
        Scanner scanner = new Scanner(System.in);
    /*
        System.out.println(scanner.next());
        System.out.println(scanner.next());
        System.out.println(scanner.next());*/




        System.out.println("Stworzę dla ciebie tablicę na notatki. Podaj ile miejsca potrzebujesz:");
        int potrzebneMiejsce = scanner.nextInt();

        String[] notatki = new String[potrzebneMiejsce];
        System.out.println("Tablica gotowa. Mozesz zacząć wprowadzać notatki: ");


      scanner.nextLine();

        int index = 0;

        while ( index < notatki.length ){
            notatki[index++] = scanner.nextLine();
         //   index++;
        }

      //  for (int i = 0; i < notatki.length; i++) {
      //      notatki[i] = scanner.nextLine();
      //  }

        scanner.close();

    /*    System.out.println("Twoje notatki: ");
        int index1 = 0;
        while ( index1 < notatki.length ){
            System.out.println(notatki[index1]);
            index1++;
        }*/
        Random losowanie = new Random();
        int wylosowaneMiejsce = losowanie.nextInt(0, potrzebneMiejsce);
        System.out.println(notatki[wylosowaneMiejsce]);
    }
}
