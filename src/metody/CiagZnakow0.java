package metody;

public class CiagZnakow0 {
    public static void main(String[] args) {



        String mojaZmienna = "To nie jest moj testowy String.";
        System.out.println("To nie jest moj testowy String.".toUpperCase().concat("abc"));
        System.out.println(mojaZmienna.toUpperCase());

        int iloscSymboli = mojaZmienna.length();
        System.out.println(iloscSymboli);

        System.out.println(mojaZmienna.charAt(0));

        String wielkieLitery = "TO nie JEST MÓJ TESTOWY STRING.";
        mojaZmienna = wielkieLitery;
        System.out.println(mojaZmienna);

        if (mojaZmienna.contains("nie")) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

        System.out.println(mojaZmienna.substring(4,13));
        System.out.println(mojaZmienna.substring(6));

        System.out.println(mojaZmienna.charAt(mojaZmienna.length() - 1));

        System.out.println(mojaZmienna.concat(" "));
        String nowy = mojaZmienna.concat(" ")
                .concat("a")
                .concat("a")
                .concat("a")
                .concat("a")
                .concat("a")
                .concat("a")
                .concat("a")
                .concat("a")
                .concat("a")
                .concat("a")
                .concat("a")
                .concat("a")
                .concat("a");
        System.out.println(nowy);



        //System.out.print(nowy.repeat(5));

    }

  /*  static boolean czyNie(String zdanie) {
        return zdanie.contains("nie");
    }*/


}
