package obiektowosc.makao;

import java.util.Scanner;

public class Czlowiek extends Gracz{
     Scanner scanner = new Scanner(System.in);

   /* @Override
    public void wykonajRuch() {
        boolean wlasciwyRuch = true;
        int numerKarty;
        do {
            System.out.println("Twoj ruch. \nWpisz liczbę odpowiadającej karcie, którą chcesz wyłożyć.\n" +
                    "Jeśli nie masz pasującej karty, wpisz 0.");
            numerKarty = scanner.nextInt();
            if (numerKarty > dajPierwszegoGracza().dajIloscKart() || numerKarty < 0) {
                System.out.println("Podana karta nie istnieje.\nSpróbuj jeszcze raz.");
                System.out.println();
                wlasciwyRuch = false;
            }
        } while (!wlasciwyRuch);
    }*/
}
