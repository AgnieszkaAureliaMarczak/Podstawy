package podstawy;

import java.util.Scanner;

public class Testy2 {
    public static void main(String[] args) {
    /*    String[] tab = new String[5];

        Scanner odczyt = new Scanner(System.in);
        //pobranie danych
        System.out.println("Podaj dane:");
        for(int i=0; i<5; i++)
            tab[i] = odczyt.nextLine();
        //wyświetlenie
        for(int i=0; i<5; i++)
            System.out.println("Cześć "+tab[i]);
        odczyt.close();*/

        String[] filmy = {
                "1999 - Matrix",
                "2015 - Chappie",
                "1968 - 2001: Odyseja Kosmiczna",
                "1982 - Łowca Androidów",
                "2009 - Avatar"
        };

        int wyczyszczone = 0;
        for (int i = 0; i < filmy.length; i++) {
            if (filmy[i].charAt(0) == '1'){
                filmy[i] = null;
                wyczyszczone++;
            }
        }

        String[] odfiltrowaneFilmy = new String[filmy.length - wyczyszczone];
        int znalezioneFilmy = 0;
        for (String film: filmy) {
            if (film != null){
                odfiltrowaneFilmy[znalezioneFilmy] = film;
                znalezioneFilmy++;
            }
        }
        for (String film : odfiltrowaneFilmy) {
            System.out.println(film);
        }
    }
}
