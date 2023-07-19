package podstawy;

import java.util.Scanner;

public class InstrukcjeWarunkowe {
    public static void main(String[] args) {
      //  System.out.println("Proszę podaj trzy liczby.");
        Scanner scanner = new Scanner(System.in);
       int liczba = scanner.nextInt();
        if (liczba>0){
            System.out.println("Twoja liczba jest dodatnia.");
        } else if (liczba<0){
            System.out.println("Twoja liczba jest ujemna.");
        } else {
            System.out.println("Twoja liczba to 0.");
        }
        if (liczba % 2 == 0){
            System.out.println("Twoja liczba jest parzysta.");
        } else {
            System.out.println("Twoja liczba jest nieparzysta.");
        }
         scanner.close();
        int liczba1 = scanner.nextInt();
        int liczba2 = scanner.nextInt();
        int liczba3 = scanner.nextInt();
        scanner.close();
        System.out.println("Największa liczba to " + najwiekszaLiczba(liczba1, liczba2, liczba3));

        if (liczba1>liczba2 && liczba1>liczba3) {
        }
      //  Ćwiczenie 12


        boolean deszcz;
        boolean swieciSlonce;
        System.out.println("Opiszę aktualne warunki pogodowe.\nCzy pada deszcz? Podaj odpowiedz \"true\" lub \"false\"");
        //tak/nie



        if (scanner.nextBoolean()) {
            deszcz = true;
        } else {
            deszcz = false;
        }
        System.out.println("Powiedz jeszcze czy świeci słonce: \"true\" lub \"false\"");
        if (scanner.nextBoolean()) {
            swieciSlonce = true;
        } else {
            swieciSlonce = false;
        }

        if (deszcz && swieciSlonce){
            System.out.println("Tęcza!");
        } else if (!deszcz && swieciSlonce) {
            System.out.println("Jest pogodnie!");
        } else if (!deszcz && !swieciSlonce) {
            System.out.println("Jest pochmurno!");
        } else if (deszcz&& !swieciSlonce){
            System.out.println("Ulewa!");
        }
      //  Ćwiczenie 13

        System.out.println("Podaj swój wiek:");
        int wiek = scanner.nextInt();

        if (wiek < 0){
            System.out.println("Nie udzielamy porad dla absurdalnych wartości.");
            return;
        }
         if (wiek > 100){
            System.out.println("Nie udzielamy porad ludziom starszym  niż 100 lat.");
            return;
        }
         if (wiek > 0 && wiek < 18) {
            System.out.println("Porady dla nieletnich opatrzone są specjalną klauzulą.");
            System.out.println("Podaj swoją wagę w kilogramach:");
        } else {
            System.out.println("Podaj swoją wagę w kilogramach:");
        }

        double waga = scanner.nextDouble();

        if (wiek == 14 && waga > 100){
            System.out.println("Red alert: twoja waga wymaga natychmiastowej konsultacji!");
            return;
        }

        System.out.println("Podaj swój wzrost w metrach:");
        double wzrost = scanner.nextDouble();

        if (wiek > 14 && waga < 40 && wzrost > 1){
            System.out.println("Uwaga: podejrzenie anoreksji.");
        } else if (waga > 100 && wzrost > 2) {
            System.out.println("Twoja waga jest uzasadniona.");
            return;
        }

        scanner.close();
    }

    public static int najwiekszaLiczba(int liczba1, int liczba2, int liczba3){
        return Math.max(liczba1,Math.max(liczba2, liczba3));
    }


}
