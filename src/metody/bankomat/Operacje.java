package metody.bankomat;

import java.util.Scanner;

public class Operacje {

    private static int saldoUzytkownika = 3500;
    private static int maksymalnyLimitWyplat = 3000;
    static int iloscBanknotow20zl = 0;//4tys
    static int iloscBanknotow50zl = 1;//10 tys
    static int iloscBanknotow100zl = 100; //10 tys
    static int iloscBanknotow200zl = 30; //6tys
    static int[] iloscPrzechowywanychBanknotow = new int[4];

    static int dostepnaKwota = (iloscBanknotow20zl * 20) + (iloscBanknotow50zl * 50)
            + (iloscBanknotow100zl * 100) + (iloscBanknotow200zl * 200);
    static int[] iloscBanknotowDoWyplacenia = new int[4];

    static Scanner scanner = new Scanner(System.in);

    static void uzupelnijIloscPrzechowywanychBanknotow() {
        iloscPrzechowywanychBanknotow[0] = iloscBanknotow20zl;
        iloscPrzechowywanychBanknotow[1] = iloscBanknotow50zl;
        iloscPrzechowywanychBanknotow[2] = iloscBanknotow100zl;
        iloscPrzechowywanychBanknotow[3] = iloscBanknotow200zl;
    }

    static void wyplacGotowke() {
        wyswietlWyborKwoty();
        int wybranaKwota = pobierzKwoteOdUzytkownika();
        zareagujGdyZaDuzaKwota(wybranaKwota);
        zareagujGdyKwotaNiepodzielnaPrzez50lub20(wybranaKwota);
        boolean czyDostepneBanknoty = sprawdzCzySaDostepneBanknotyDoWyplaty(wybranaKwota);
        if (czyDostepneBanknoty) {
            wykonajEtapyWyplaty(wybranaKwota);
        } else {
            zareagujNaBrakMozliwosciWyplaty();
        }
    }

    static void wyswietlWyborKwoty() {
        System.out.println(Bankomat.tablicaKomunikatow[8]);//wybor kwoty
    }

    static int pobierzKwoteOdUzytkownika() {
        return scanner.nextInt();
    }

    static void zareagujGdyZaDuzaKwota(int wybranaKwota) {
        if (wybranaKwota > dajSaldo()) {
            System.out.println(Bankomat.tablicaKomunikatow[9]);//brak srodkow
            Bankomat.wybierzIwykonajOperacje();
        } else if (wybranaKwota > dajDziennyLimitWyplat()) {
            System.out.println(Bankomat.tablicaKomunikatow[10] + dajDziennyLimitWyplat()); // dzienny limit
            Bankomat.wybierzIwykonajOperacje();
        } else if (wybranaKwota > dostepnaKwota) {
            System.out.println(Bankomat.tablicaKomunikatow[12] + dostepnaKwota);// dostepna kwota
            Bankomat.wybierzIwykonajOperacje();
        }
    }

    static int dajSaldo() {
        return saldoUzytkownika;
    }

    static int dajDziennyLimitWyplat() {
        return maksymalnyLimitWyplat;
    }

    static void zareagujGdyKwotaNiepodzielnaPrzez50lub20(int wybranaKwota) {
        if ((wybranaKwota % 50 != 0) && (wybranaKwota % 20 != 0) && ((wybranaKwota % 50) % 20 != 0) &&
                ((wybranaKwota - 50) % 20 != 0)) {
            System.out.println(Bankomat.tablicaKomunikatow[15]);
            wyplacGotowke();
        }
    }

    static boolean sprawdzCzySaDostepneBanknotyDoWyplaty(int wybranaKwota) {
        switch (wybranaKwota) {
            case 20 -> {
                return czyJest20();
            }
            case 50 -> {
                return czyJest50();
            }
            case 100 -> {
                return czySaBanknotyDla100();
            }
            default -> {
                return czySaBanknotyDlaPozostalejKwoty(wybranaKwota);
            }
        }
    }

    static boolean czyJest20() {
        return iloscPrzechowywanychBanknotow[0] > 0;
    }

    static boolean czyJest50() {
        return iloscPrzechowywanychBanknotow[1] > 0;
    }

    static boolean czySaBanknotyDla100() {
        return iloscPrzechowywanychBanknotow[2] > 0 || iloscPrzechowywanychBanknotow[1] > 1 ||
                iloscPrzechowywanychBanknotow[0] > 4;
    }

    static boolean czySaBanknotyDlaPozostalejKwoty(int wybranaKwota) {
        boolean czySaBanknoty = false;
        if (iloscPrzechowywanychBanknotow[3] >= wybranaKwota / 200) {
            wybranaKwota = wybranaKwota % 200;
        } else if (iloscPrzechowywanychBanknotow[3] < wybranaKwota / 200) {
            wybranaKwota = wybranaKwota - (iloscPrzechowywanychBanknotow[3] * 200);
        }
        if (iloscPrzechowywanychBanknotow[2] >= wybranaKwota / 100) {
            wybranaKwota = wybranaKwota % 100;
        } else if (iloscPrzechowywanychBanknotow[2] < wybranaKwota / 100) {
            wybranaKwota = wybranaKwota - (iloscPrzechowywanychBanknotow[2] * 100);
        }
        if (iloscPrzechowywanychBanknotow[1] >= wybranaKwota / 50) {
            int tempKwota = wybranaKwota;
            int kwotaWypelniona50 = (tempKwota / 50 - 1) * 50;
            int kwotaDoWypelnienia20 = tempKwota - kwotaWypelniona50;
            if ((kwotaDoWypelnienia20 % 20 == 0) &&
                    iloscPrzechowywanychBanknotow[0] >= kwotaDoWypelnienia20 / 20) {
                czySaBanknoty = true;
                return czySaBanknoty;
            }
            wybranaKwota = wybranaKwota % 50;
        } else if (iloscPrzechowywanychBanknotow[1] < wybranaKwota / 50) {
            wybranaKwota = wybranaKwota - (iloscPrzechowywanychBanknotow[1] * 50);
        }
        if ((wybranaKwota % 20 != 0) || (iloscPrzechowywanychBanknotow[0] < wybranaKwota / 20)) {
            return false;
        } else if ((iloscPrzechowywanychBanknotow[0] >= wybranaKwota / 20)) {
            czySaBanknoty = true;
            return czySaBanknoty;
        }
        return czySaBanknoty;
    }

    static void wykonajEtapyWyplaty(int wybranaKwota) {
        ustalIloscBanknotowDoWyplacenia(wybranaKwota);
        zmniejszIloscPrzechowywanychBanknotowDoWyplaty();
        wyswietlIloscWyplacanychBanknotow();
        ustalCzyWydrukowacPotwierdzenie();
        wyswietlKomunikatOwyplacieIzakoncz();
    }

    static void ustalIloscBanknotowDoWyplacenia(int wybranaKwota) {
        switch (wybranaKwota) {
            case 20 -> iloscBanknotowDoWyplacenia[0] = 1;
            case 50 -> iloscBanknotowDoWyplacenia[1] = 1;
            case 100 -> ustalIloscBanknotowDla100zl();
            default -> ustalIloscBanknotowDlaDowolnejKwoty(wybranaKwota);
        }
    }

    static void ustalIloscBanknotowDla100zl() {
        if (iloscPrzechowywanychBanknotow[2] > 0) {
            iloscBanknotowDoWyplacenia[2] = 1;
        } else if (iloscPrzechowywanychBanknotow[1] > 1) {
            iloscBanknotowDoWyplacenia[1] = 2;
        } else if (iloscPrzechowywanychBanknotow[0] > 4) {
            iloscBanknotowDoWyplacenia[0] = 5;
        }
    }

    static void ustalIloscBanknotowDlaDowolnejKwoty(int wybranaKwota) {
        if (iloscPrzechowywanychBanknotow[3] >= wybranaKwota / 200) {
            iloscBanknotowDoWyplacenia[3] = wybranaKwota / 200;
            wybranaKwota = wybranaKwota % 200;
        } else if (iloscPrzechowywanychBanknotow[3] < wybranaKwota / 200) {
            iloscBanknotowDoWyplacenia[3] = iloscPrzechowywanychBanknotow[3];
            wybranaKwota = wybranaKwota - (iloscPrzechowywanychBanknotow[3] * 200);
        }
        if (iloscPrzechowywanychBanknotow[2] >= wybranaKwota / 100) {
            iloscBanknotowDoWyplacenia[2] = wybranaKwota / 100;
            wybranaKwota = wybranaKwota % 100;
        } else if (iloscPrzechowywanychBanknotow[2] < wybranaKwota / 100) {
            iloscBanknotowDoWyplacenia[2] = iloscPrzechowywanychBanknotow[2];
            wybranaKwota = wybranaKwota - (iloscPrzechowywanychBanknotow[2] * 100);
        }
        if (iloscPrzechowywanychBanknotow[1] >= wybranaKwota / 50) {
            int tempKwota = wybranaKwota;
            int kwotaWypelniona50 = (tempKwota / 50 - 1) * 50;
            int kwotaDoWypelnienia20 = tempKwota - kwotaWypelniona50;
            if ((kwotaDoWypelnienia20 % 20 == 0) && iloscPrzechowywanychBanknotow[0] >= kwotaDoWypelnienia20 / 20) {
                iloscBanknotowDoWyplacenia[1] = tempKwota / 50 - 1;
                iloscBanknotowDoWyplacenia[0] = kwotaDoWypelnienia20 / 20;
                return;
            }
            iloscBanknotowDoWyplacenia[1] = wybranaKwota / 50;
            wybranaKwota = wybranaKwota % 50;
        } else if (iloscPrzechowywanychBanknotow[1] < wybranaKwota / 50) {
            iloscBanknotowDoWyplacenia[1] = iloscPrzechowywanychBanknotow[1];
            wybranaKwota = wybranaKwota - (iloscPrzechowywanychBanknotow[1] * 50);
        }
        if (iloscPrzechowywanychBanknotow[0] >= wybranaKwota / 20) {
            iloscBanknotowDoWyplacenia[0] = wybranaKwota / 20;
        }
    }

    static void zmniejszIloscPrzechowywanychBanknotowDoWyplaty() {
        iloscPrzechowywanychBanknotow[0] -= iloscBanknotowDoWyplacenia[0];
        iloscPrzechowywanychBanknotow[1] -= iloscBanknotowDoWyplacenia[1];
        iloscPrzechowywanychBanknotow[2] -= iloscBanknotowDoWyplacenia[2];
        iloscPrzechowywanychBanknotow[3] -= iloscBanknotowDoWyplacenia[3];
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

    static void wyswietlKomunikatOwyplacieIzakoncz() {
        System.out.println(Bankomat.tablicaKomunikatow[14]); //wyplata + koniec
        System.exit(0);
    }

    static void zareagujNaBrakMozliwosciWyplaty() {
        System.out.println(Bankomat.tablicaKomunikatow[15]);
        Bankomat.wybierzIwykonajOperacje();
    }

    static void wyplacBlikiem() {
        poprosOkodBlik();
        Bankomat.pobierzKodOdUzytkownika();
        wyplacGotowkeBlikiem();
    }

    static void poprosOkodBlik(){
        System.out.println(Bankomat.tablicaKomunikatow[16]);//podaj kod blik
    }

    static void wyplacGotowkeBlikiem() {
        wyswietlWyborKwoty();
        int wybranaKwota = pobierzKwoteOdUzytkownika();
        zareagujGdyZaDuzaKwota(wybranaKwota);
        zareagujGdyKwotaNiepodzielnaPrzez50lub20(wybranaKwota);
        boolean czyDostepneBanknoty = sprawdzCzySaDostepneBanknotyDoWyplaty(wybranaKwota);
        if (czyDostepneBanknoty) {
            zatwierdzWyplateWaplikacji();
            wykonajEtapyWyplaty(wybranaKwota);
        } else {
            zareagujNaBrakMozliwosciWyplaty();
        }
    }

    static void zatwierdzWyplateWaplikacji() {
        System.out.println(Bankomat.tablicaKomunikatow[17]); //zatwierdz w aplikacji
        System.out.println(Bankomat.tablicaKomunikatow[18]); //wcisnij enter
        scanner.nextLine();
        scanner.nextLine();
    }

    static void sprawdzSaldo() {
        System.out.println(Bankomat.tablicaKomunikatow[7] + dajSaldo());//saldo wynosi
    }
}
