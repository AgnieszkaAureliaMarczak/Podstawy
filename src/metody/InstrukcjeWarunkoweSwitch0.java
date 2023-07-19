package metody;

import java.util.Scanner;

public class InstrukcjeWarunkoweSwitch0 {
    public static void main(String[] args) {
        boolean poprawnaStrona;
        do {
          String podanyKierunek = pobierzKierunek();
            poprawnaStrona = wyruszWstroneSwiata(podanyKierunek);
        }
        while (!poprawnaStrona);
    }

    public static String pobierzKierunek() {
        Scanner sc = new Scanner(System.in);
        System.out.println("W którą stronę świata chcesz się udać? \nWybierz z następujących:\npólnoc\npołudnie\nwschód\nzachód");
        String answer = sc.nextLine();
        return answer;
    }

    public static boolean wyruszWstroneSwiata(String stronaSwiata) {
        boolean poprawna = true;
        switch (stronaSwiata) {
            case "północ" ->
                    System.out.println("Wyruszasz w podróż na daleką północ. Pamietaj o zabraniu ciepłych ubrań :)");
            case "południe" ->
                    System.out.println("Zaczynamy wycieczkę na południe, do krajów wiecznego słońca i ciepłej wody w morzu :)");
            case "wschód" -> System.out.println("Czy jesteś pewien wybranego kierunku?");
            case "zachód" -> System.out.println("Ruszamy autostradami w kierunku zachodzącego słońca.");
            default -> {
                System.out.println("Podany kierunek jest niepoprawny. Spróbuj ponownie.");
                poprawna = false;
            }
        }
        return poprawna;
    }
}
