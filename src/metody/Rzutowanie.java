package metody;

import java.awt.*;
import java.math.BigDecimal;

public class Rzutowanie {
    public static void main(String[] args) {

     /*   for (int i = 0; i <= 8; i++) {
            System.out.println("Dla " + i + " bajtow: " + wyliczIloscKombinacji(i));
        }
        System.exit(0);*/
        for (int i = 0; i <= 16; i++) {
            System.out.println("Dla " + i + " bajtow: " + wyliczIloscKombinacji2(i));
        }
        System.exit(0);

        System.out.println();
        System.out.println(Short.MAX_VALUE * 2 + 2);
        int byteZakres = Byte.MAX_VALUE * 2 + 2;
        int shorZakres = byteZakres;
        for (int i = 0; i < 8; i++) {
            shorZakres *= 2;
        }
        System.out.println(shorZakres);
        System.out.println();
        System.out.println(Integer.MAX_VALUE * 2L + 2);
        System.out.println(Long.MAX_VALUE);


        System.out.println(podniesDoPotegi(3.8, 5));
        System.out.println(podniesDoPotegi(3, 5));
        int milisekundy = (int) zamienNaMilisekundy(500000000);
        System.out.println(milisekundy);
        //byte short int long
        // 1     2     4    8     byte
        //float  double
        // 4      8 byte
        //boolean char
        // 1       2 byte
        //   milisekundy = 150;
        //    byte myByte = 100;
//        milisekundy = myByte;
        //   myByte = (byte) milisekundy;
        //    System.out.println(myByte);
        System.out.println(policzIleRazyPrzekroczy(869));
        System.out.println(policzIleRazyPrzekroczy(372));
        System.out.println(policzIleRazyPrzekroczy(373));
        System.out.println(policzIleRazyPrzekroczy(374));
        System.out.println(policzIleRazyPrzekroczy(375));
        System.out.println(policzIleRazyPrzekroczy(376));
        System.out.println(policzIleRazyPrzekroczy(377));
        System.out.println(policzIleRazyPrzekroczy(378));
        System.out.println(policzIleRazyPrzekroczy(379));
        System.out.println(policzIleRazyPrzekroczy(380));
        System.out.println(policzIleRazyPrzekroczy(381));
        System.out.println(policzIleRazyPrzekroczy(382));
        System.out.println(policzIleRazyPrzekroczy(383));
        System.out.println(policzIleRazyPrzekroczy(384));
        System.out.println(policzIleRazyPrzekroczy(125836));
        System.out.println(policzIleRazyPrzekroczy(1279));
        System.out.println((byte) 382);
        System.out.println((byte) 383);
    }

    static double podniesDoPotegi(double liczbaBazowa, int potega) {
        double wynik = 1.0;
        for (int i = 0; i < potega; i++) {
            wynik *= liczbaBazowa;
        }
        return (int) wynik;
    }

    static long zamienNaMilisekundy(int minuty) {
        return (long) minuty * 60 * 1000;
    }

    static int policzIleRazyPrzekroczy(int liczba) {
        int iloscRazy = 0;  //-128 do 127
        if (liczba > 127) {
            iloscRazy++;
        }
        liczba -= 127;
        while (liczba > 256) {
            iloscRazy++;
            liczba -= 256;
        }
        return iloscRazy;
    }

    //1 BIT
    // 1,0     2 opcje

    //2 BIT
    // 00,01,10,11 4 opcje
    //3 BIT
    // 000,001,010,011, 100,101,110,111 8 opcji
    // 4 BIT
    /// .... 16 opcji
    // 5 BIT
    // 32
    // 6 BIT
    // 64
    // 7 BIT
    // 128
    // 8 BIT
    // 256

    public static long wyliczIloscKombinacji(int iloscBajtow) {
        int iloscBitow = iloscBajtow * 8;
        long kombinacje = 1;
        for (int i = 0; i < iloscBitow; i++) {
            kombinacje *= 2;
        }
        return kombinacje;
    }

    public static BigDecimal wyliczIloscKombinacji2(int iloscBajtow) {
        int iloscBitow = iloscBajtow * 8;
        BigDecimal kombinacje = new BigDecimal("1"); // BigInteger - tylko całkowite, Decimal dziesiętne
        for (int i = 0; i < iloscBitow; i++) {
           // kombinacje *= 2;
            kombinacje = kombinacje.multiply(new BigDecimal("2"));
        }
        return kombinacje;
    }


}
