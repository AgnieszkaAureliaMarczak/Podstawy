package metody.bankomat;

import java.util.Scanner;

public class Operacje {

    private static int saldoUzytkownika = 3500;
    private static int maksymalnyLimitWyplat = 3000;
    static int iloscBanknotow20zl = 200;//4tys
    static int iloscBanknotow50zl = 200;//10 tys
    static int iloscBanknotow100zl = 100; //10 tys
    static int iloscBanknotow200zl = 30; //6tys
    static int dostepnaKwota = iloscBanknotow20zl + iloscBanknotow50zl + iloscBanknotow100zl + iloscBanknotow200zl;
    static Scanner scanner = new Scanner(System.in);

    static void wyplacGotowke() {
        System.out.println(Bankomat.tablicaKomunikatow[8]);//wybor kwoty
        int wybranaKwota = scanner.nextInt();
        zareagujGdyZaDuzaKwota(wybranaKwota);
        /*switch (wybranaKwota) {
            case 1 -> {
                if (iloscBanknotow20zl > 0){
                    iloscBanknotow20zl-=1;
                    System.out.println(Bankomat.tablicaKomunikatow[14]); //wyplata + koniec
                    System.exit(0);
                } else if (iloscBanknotow50zl > 0){

                }
            }
            case 2 ->
            case 3 ->
            case 4 ->
            case 5 ->
            case 6 ->
            default ->
        }*/
    }

    static void zareagujGdyZaDuzaKwota(int wybranaKwota) {
        if (wybranaKwota > dajSaldo()) {
            System.out.println(Bankomat.tablicaKomunikatow[9]);//brak srodkow
            Bankomat.wybierzOperacje();
        } else if (wybranaKwota > dajDziennyLimitWyplat()) {
            System.out.println(Bankomat.tablicaKomunikatow[10] + dajDziennyLimitWyplat()); // dzienny limit
            Bankomat.wybierzOperacje();
        } else if (wybranaKwota > dostepnaKwota) {
            System.out.println(Bankomat.tablicaKomunikatow[12] + dostepnaKwota);// dostepna kwota
            Bankomat.wybierzOperacje();
        }
    }

    static void pobierzReakcjeNaPrzekroczenieSalda() {
        int coDalej = scanner.nextInt();
        switch (coDalej) {
            case 1 -> wyplacGotowke();
            case 2 -> {
                sprawdzSaldo();
                pobierzReakcjePoSprawdzeniuSalda();
            }
            case 3 -> Bankomat.zakoncz();
            default -> System.out.println(Bankomat.tablicaKomunikatow[6]);//niepoprawna wartosc - koniec programu
        }
    }

    static void sprawdzSaldo() {
        System.out.println(Bankomat.tablicaKomunikatow[7] + dajSaldo());//saldo wynosi
    }

    static int dajSaldo() {
        return saldoUzytkownika;
    }

    static void pobierzReakcjePoSprawdzeniuSalda() {
        System.out.println(Bankomat.tablicaKomunikatow[13]); //co dalej
        int coDalej = scanner.nextInt();
        switch (coDalej) {
            case 1 -> wyplacGotowke();
            case 2 -> wyplacZblizeniowo();
            case 3 -> wyplacBlikiem();
            case 4 -> Bankomat.zakoncz();
            default -> System.out.println(Bankomat.tablicaKomunikatow[6]);
        }
    }

    static void wyplacZblizeniowo() {

    }

    static void wyplacBlikiem() {

    }

    static int dajDziennyLimitWyplat() {
        return maksymalnyLimitWyplat;
    }

    static void pobierzReakcjeNaPrzekroczenieLimitu() {
        System.out.println(Bankomat.tablicaKomunikatow[11]);//co dalej
        int coDalej = scanner.nextInt();
        switch (coDalej) {
            case 1 -> {
                System.out.println(Bankomat.tablicaKomunikatow[13]);
                int dalaszaReakcja = scanner.nextInt();
                switch (dalaszaReakcja) {
                    case 1 -> wyplacGotowke();
                    case 2 -> wyplacZblizeniowo();
                    case 3 -> wyplacBlikiem();
                    case 4 -> Bankomat.zakoncz();
                    default -> System.out.println(Bankomat.tablicaKomunikatow[6]);
                }
            }
            case 2 -> Bankomat.zakoncz();
            default -> System.out.println(Bankomat.tablicaKomunikatow[6]);
        }
    }
}
