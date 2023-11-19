package obiektowosc.makao;

import java.util.*;

public class Gra {
    private ArrayList<Karta> taliaKart = new ArrayList<>();
    private ArrayList<Karta> stos = new ArrayList<>();
    private List<Gracz> gracze = new ArrayList<>();
    private int liczbaGraczy;
    static Scanner scanner = new Scanner(System.in);


    public void powitaj() {
        System.out.println("Witaj w grze w makao!");
    }

    public void ustalLiczbeGraczy() {
        boolean wlasciwaLiczbaGraczy = true;
        do {
            System.out.println("Podaj liczbę graczy (od 2 do 6)");
            // try {
            liczbaGraczy = scanner.nextInt();
           /* } catch (InputMismatchException e){
                System.out.println("Podano niepoprawną wartość.");
                wlasciwaLiczbaGraczy = false;
            }*/
            if (liczbaGraczy < 2 || liczbaGraczy > 6) {
                System.out.println("Podana liczba graczy wykracza poza zakres 2-6.");
                wlasciwaLiczbaGraczy = false;
            }
        } while (!wlasciwaLiczbaGraczy);
        for (int i = 0; i < liczbaGraczy; i++) {
            gracze.add(new Gracz());
        }
    }

    public ArrayList<Karta> stworzTalieKart() {
        ArrayList<Karta> talia = new ArrayList<>();
        Kolor[] tablicaKolorow = Kolor.values();
        Nominal[] tablicaNominalow = Nominal.values();
        for (Kolor kolor : tablicaKolorow) {
            for (Nominal nominal : tablicaNominalow) {
                //    System.out.printf("%s %d\n",nominal,nominal.getNumerycznaWartosc());
                talia.add(new Karta(kolor, nominal));
            }
        }
        return talia;
    }

    public void potasujKartyDoGry(ArrayList<Karta> taliaDoTasowania) {
        Random random = new Random();
        for (int i = 0; i < 52; i++) {
            int wylosowanaKarta = random.nextInt(taliaDoTasowania.size());
            taliaKart.add(taliaDoTasowania.remove(wylosowanaKarta));
        }
    }

    public void rozdajKarty() {
        for (int i = 0; i < 5; i++) {
            for (Gracz gracz : gracze) {
                gracz.otrzymajKarte(taliaKart.remove(0));
            }
        }
    }

    public void wyswietlKartyGracza() {
        System.out.println("Twoje karty:");
        dajPierwszegoGracza().wyswietlKarty();
    }

    private Gracz dajPierwszegoGracza() {
        return gracze.get(0);
    }

    public Karta odslonPierwszaKarte() {
        System.out.println();
        System.out.println("Zaczynamy grę.");
        Karta kartaNaStole = taliaKart.get(0);
        System.out.println("Karta na stole to: " + kartaNaStole);
        System.out.println();
        stos.add(taliaKart.remove(0));
        return kartaNaStole;
    }

    public void wykonajRuch(Karta odslonietaKarta) {
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

        Karta kartaWylozonaPrzezGracza = dajPierwszegoGracza().dajKarteZWybranejPozycji(numerKarty - 1);

        if ((kartaWylozonaPrzezGracza.getNumerycznaWartosc() !=
                odslonietaKarta.getNumerycznaWartosc()) &&
                (!kartaWylozonaPrzezGracza.getKolor().name().equals(odslonietaKarta.getKolor().name()))) {
            System.out.println("Podana karta nie pasuje. Straciłeś ruch.");
        } else {
            stos.add(dajPierwszegoGracza().wylozKarte(numerKarty));
            /*dajPierwszegoGracza().wyswietlKarty();
            for (Karta karta : stos) {
                System.out.println(karta);
            }*/
        }
    }
}
