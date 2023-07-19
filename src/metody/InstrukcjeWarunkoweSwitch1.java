package metody;

import java.time.LocalDate;

public class InstrukcjeWarunkoweSwitch1 {
    public static void main(String[] args) {
       // System.out.println(wykonajRownanie(5, -3, '+'));
        System.out.println(wyliczPoreRoku(31,13 ));
    }

    public static int wykonajRownanie(int zmienna1, int zmienna2, char znak) {
        int wynik = switch (znak) {
            case '+' -> zmienna1 + zmienna2;
            case '-' -> zmienna1 - zmienna2;
            case '*' -> zmienna1 * zmienna2;
            case '/' -> zmienna1 / zmienna2;
            default -> 0;
        };
        return wynik;
    }

    public static String wyliczPoreRoku(int dzien, int miesiac) {
        String poraRoku = "";
        if (!sprawdzDane(dzien, miesiac)) {
            return "error";
        }


        switch (miesiac) {
            case 1:
            case 2:
                poraRoku = "Zima";
                break;
            case 3:
                if (dzien < 21) {
                    poraRoku = "Zima";
                } else  {
                    poraRoku = "Wiosna";
                }
                break;
            case 4:
            case 5:
                poraRoku = "Wiosna";
                break;
            case 6:
                if (dzien < 21) {
                    poraRoku = "Wiosna";
                } else {
                    poraRoku = "Lato";
                }
                break;
            case 7:
            case 8:
                poraRoku = "Lato";
                break;
            case 9:
                if (dzien < 23) {
                    poraRoku = "Lato";
                } else {
                    poraRoku = "Jesień";
                }
                break;
            case 10:
            case 11:
                poraRoku = "Jesień";
                break;
            case 12:
                if (dzien < 22) {
                    poraRoku = "Jesień";
                } else  {
                    poraRoku = "Zima";
                }
                break;
        }
        return poraRoku;
    }

    public static boolean sprawdzDane(int dzien, int miesiac) {
        String bladDnia = "Podano niepoprawny dzień.";
        if (miesiac < 1 || miesiac > 12) {
            System.out.println("Podano niepoprawny miesiąc.");
            return false;
        }

        int maxDay = 31;
        switch (miesiac) {
            case 2 -> maxDay = 28;
            case 4, 6, 9, 11 -> maxDay = 30;
        }

        if (dzien > maxDay || dzien < 1) {
            System.out.println(bladDnia);
            return false;
        }

        return true;
    }

/*    public static boolean sprawdzDane(int dzien, int miesiac) {
        boolean poprawneDane = false;
        String bladDnia = "Podano niepoprawny dzień.";
        if (miesiac < 1 || miesiac > 12) {
            System.out.println("Podano niepoprawny miesiąc.");
            return false;
        }

        int maxDay = 31;
        switch (miesiac){
            case 2 -> maxDay = 28;
            case 4,6,9,11 -> maxDay = 30;
        }


        if (dzien < 1) {
            System.out.println(bladDnia);

        } else if (miesiac == 1 || miesiac == 3 || miesiac == 5 || miesiac == 7 || miesiac == 8 || miesiac == 10 || miesiac == 12 && dzien > 31) {
            System.out.println(bladDnia);
        } else if (miesiac == 4 || miesiac == 6 || miesiac == 9 || miesiac == 11 && dzien > 30) {
            System.out.println(bladDnia);
        } else if (miesiac == 2 && dzien > 28) {
            System.out.println(bladDnia);
        } else {
            poprawneDane = true;
        }
        return poprawneDane;
    }*/
}
