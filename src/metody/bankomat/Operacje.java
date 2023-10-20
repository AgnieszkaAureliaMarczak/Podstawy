package metody.bankomat;

import java.util.Scanner;

public class Operacje {

    private static int saldoUzytkownika = 3500;
    private static int maksymalnyLimitWyplat = 3000;
    static int iloscBanknotow20zl = 200;//4tys
    static int iloscBanknotow50zl = 200;//10 tys
    static int iloscBanknotow100zl = 100; //10 tys
    static int iloscBanknotow200zl = 30; //6tys
    static int[] iloscBanknotowDoWyplacenia = new int[4];
    static int dostepnaKwota = iloscBanknotow20zl + iloscBanknotow50zl + iloscBanknotow100zl + iloscBanknotow200zl;
    static Scanner scanner = new Scanner(System.in);

    static void wyplacGotowke() {
        System.out.println(Bankomat.tablicaKomunikatow[8]);//wybor kwoty
        int wybranaKwota = scanner.nextInt();
        zareagujGdyZaDuzaKwota(wybranaKwota);
        switch (wybranaKwota) {
            case 20 -> {
                if (iloscBanknotow20zl > 0) {
                    wykonajEtapyWyplaty(wybranaKwota);
                } else {
                    zareagujNaBrakMozliwosciWyplaty();
                }
            }
            case 50 -> {
                if (iloscBanknotow50zl > 0) {
                    wykonajEtapyWyplaty(wybranaKwota);
                } else {
                    zareagujNaBrakMozliwosciWyplaty();
                }
            }
            case 100 -> {
                if (iloscBanknotow100zl > 0 || iloscBanknotow50zl > 1 || iloscBanknotow20zl > 4) {
                    wykonajEtapyWyplaty(wybranaKwota);
                } else {
                    zareagujNaBrakMozliwosciWyplaty();
                }
            }
            case 150 -> {
                if ((iloscBanknotow100zl > 0 && iloscBanknotow50zl > 0) || (iloscBanknotow50zl > 2) ||
                        (iloscBanknotow20zl > 4 && iloscBanknotow50zl > 0)) {
                    wykonajEtapyWyplaty(wybranaKwota);
                } else {
                    zareagujNaBrakMozliwosciWyplaty();
                }
            }
            case 200 -> {
                if ((iloscBanknotow200zl > 0) || (iloscBanknotow100zl > 1) ||
                        (iloscBanknotow100zl == 1 && iloscBanknotow50zl > 1) ||
                        (iloscBanknotow100zl == 1 && iloscBanknotow20zl > 4) ||
                        (iloscBanknotow50zl > 3) || (iloscBanknotow50zl == 2 && iloscBanknotow20zl > 4) ||
                        (iloscBanknotow20zl > 9)) {
                    wykonajEtapyWyplaty(wybranaKwota);
                } else {
                    zareagujNaBrakMozliwosciWyplaty();
                }
            }
            default -> System.out.println();
        }
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

    static void wykonajEtapyWyplaty(int wybranaKwota) {
        ustalIloscBanknotowDoWyplacenia(wybranaKwota);
        zmniejszIloscPrzechowywanychBanknotowDoWyplaty();
        wyswietlIloscWyplacanychBanknotow();
        ustalCzyWydrukowacPotwierdzenie();
        wyplacIzakoncz();
    }


    static void ustalIloscBanknotowDoWyplacenia(int wybranaKwota) {
        switch (wybranaKwota) {
            case 20 -> iloscBanknotowDoWyplacenia[0] = 1;
            case 50 -> iloscBanknotowDoWyplacenia[1] = 1;
            case 100 -> {
                if (iloscBanknotow100zl > 0) {
                    iloscBanknotowDoWyplacenia[2] = 1;
                } else if (iloscBanknotow50zl > 1) {
                    iloscBanknotowDoWyplacenia[1] = 2;
                } else if (iloscBanknotow20zl > 4) {
                    iloscBanknotowDoWyplacenia[0] = 5;
                }
            }
            case 150 -> {
                if (iloscBanknotow100zl > 0 && iloscBanknotow50zl > 0) {
                    iloscBanknotowDoWyplacenia[2] = 1;
                    iloscBanknotowDoWyplacenia[1] = 1;
                } else if (iloscBanknotow50zl > 2) {
                    iloscBanknotowDoWyplacenia[1] = 3;
                } else if (iloscBanknotow20zl > 4 && iloscBanknotow50zl > 0) {
                    iloscBanknotowDoWyplacenia[0] = 5;
                    iloscBanknotowDoWyplacenia[1] = 1;
                }
            }
            case 200 -> {
                if (iloscBanknotow200zl > 0) {
                    iloscBanknotowDoWyplacenia[3] = 1;
                } else if (iloscBanknotow100zl > 1) {
                    iloscBanknotowDoWyplacenia[2] = 2;
                } else if (iloscBanknotow100zl == 1 && iloscBanknotow50zl > 1) {
                    iloscBanknotowDoWyplacenia[2] = 1;
                    iloscBanknotowDoWyplacenia[1] = 2;
                } else if (iloscBanknotow100zl == 1 && iloscBanknotow20zl > 4) {
                    iloscBanknotowDoWyplacenia[2] = 1;
                    iloscBanknotowDoWyplacenia[0] = 5;
                } else if (iloscBanknotow50zl > 3) {
                    iloscBanknotowDoWyplacenia[1] = 4;
                } else if (iloscBanknotow50zl == 2 && iloscBanknotow20zl > 4) {
                    iloscBanknotowDoWyplacenia[1] = 2;
                    iloscBanknotowDoWyplacenia[0] = 5;
                } else if (iloscBanknotow20zl > 9) {
                    iloscBanknotowDoWyplacenia[0] = 10;
                }
            }
        }
    }


    static void zmniejszIloscPrzechowywanychBanknotowDoWyplaty() {
        iloscBanknotow20zl -= iloscBanknotowDoWyplacenia[0];
        iloscBanknotow50zl -= iloscBanknotowDoWyplacenia[1];
        iloscBanknotow100zl -= iloscBanknotowDoWyplacenia[2];
        iloscBanknotow200zl -= iloscBanknotowDoWyplacenia[3];
    }

    static void wyswietlIloscWyplacanychBanknotow() {
        System.out.println(Bankomat.tablicaKomunikatow[6]);
        System.out.println(iloscBanknotowDoWyplacenia[0] + " x 20PLN\n" +
                iloscBanknotowDoWyplacenia[1] + " x 50PLN\n" +
                iloscBanknotowDoWyplacenia[2] + " x 100PLN\n" +
                iloscBanknotowDoWyplacenia[3] + " x 200PLN");
    }

    static void ustalCzyWydrukowacPotwierdzenie() {
        System.out.println(Bankomat.tablicaKomunikatow[11]);
        int czyPotwierdzenie = scanner.nextInt();
        if (czyPotwierdzenie == 1) {
            System.out.println(Bankomat.tablicaKomunikatow[13]);
        } else {
            System.out.println();
        }
    }

    static void wyplacIzakoncz() {
        System.out.println(Bankomat.tablicaKomunikatow[14]); //wyplata + koniec
        System.exit(0);
    }

    static void zareagujNaBrakMozliwosciWyplaty() {
        System.out.println(Bankomat.tablicaKomunikatow[15]);
        Bankomat.wybierzOperacje();
    }

    static void sprawdzSaldo() {
        System.out.println(Bankomat.tablicaKomunikatow[7] + dajSaldo());//saldo wynosi
    }

    static int dajSaldo() {
        return saldoUzytkownika;
    }

    static void wyplacZblizeniowo() {

    }

    static void wyplacBlikiem() {

    }

    static int dajDziennyLimitWyplat() {
        return maksymalnyLimitWyplat;
    }

}
