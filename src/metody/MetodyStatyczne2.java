package metody;

public class MetodyStatyczne2 {
    public static void main(String[] args) {
        System.out.println(podzielDwieLiczby(96, 0));
        System.out.println(wyswietlDateUrodzenia(1, "maj", 1990));
    }

    static int podzielDwieLiczby(int pierwsza, int druga) {

        if (druga == 0) {
            return -1;
        }
        return pierwsza / druga;
    }

    static String wyswietlDateUrodzenia(int dzien, String miesiac, int rok) {
        String[] miesiace = {"styczeń", "luty", "marzec", "kwiecień", "maj", "czerwiec", "lipiec", "sierpień", "wrzesień", "październik", "listopad", "grudzień"};
        String wyswietlanyMiesiac = "";
        int miesiacLiczbowo = -1;
        for (int i = 0; i < 12; i++) {
            if (miesiac.equals(miesiace[i])) {
               miesiacLiczbowo = i + 1;
                if (miesiacLiczbowo < 10) {
                    wyswietlanyMiesiac = "0";
                }
                break;
            }
        }
        wyswietlanyMiesiac += miesiacLiczbowo;
        return rok + "-" + wyswietlanyMiesiac + "-" + dzien;
    }


/*    static String wyswietlDateUrodzenia(int dzien, String miesiac, int rok) {
        String[] miesiace = {"styczeń", "luty", "marzec", "kwiecień", "maj", "czerwiec", "lipiec", "sierpień", "wrzesień", "październik", "listopad", "grudzień"};
        String wyswietlanyMiesiac = "";
        for (int i = 0; i < 12; i++) {
            if (miesiac.equals(miesiace[i])) {
                int miesiacLiczbowo = i + 1;
                if (miesiacLiczbowo < 10) {
                    wyswietlanyMiesiac = "0" + miesiacLiczbowo;
                } else {
                    wyswietlanyMiesiac = "" + miesiacLiczbowo;
                }
            }
        }

        return rok + "-" + wyswietlanyMiesiac + "-" + dzien;
    }*/
}
