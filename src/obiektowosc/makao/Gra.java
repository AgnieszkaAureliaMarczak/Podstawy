package obiektowosc.makao;

import java.util.*;

public class Gra {
    private List<Karta> stos = new ArrayList<>();
    private List<Gracz> gracze = new ArrayList<>();
    private int liczbaGraczy;

    public Gracz dajGracza(int indeks) {
        return gracze.get(indeks);
    }

    public List<Gracz> dajGraczy(){
        return gracze;
    }

    public List<Karta> dajStos(){
        return stos;
    }


    public void powitaj() {
        System.out.println("Witaj w grze w makao!");
    }

    public void ustalLiczbeGraczy() {
        boolean wlasciwaLiczbaGraczy;
        do {
            System.out.println("Podaj liczbę graczy (od 2 do 6).");
            liczbaGraczy = FajniejszyScanner.pobierzLiczbe();
            wlasciwaLiczbaGraczy = true;
            if (liczbaGraczy < 2 || liczbaGraczy > 6) {
                System.out.println("Podana liczba graczy wykracza poza zakres 2-6.");
                wlasciwaLiczbaGraczy = false;
            }
        } while (!wlasciwaLiczbaGraczy);
        gracze.add(new Czlowiek(1));
        for (int i = 1; i < liczbaGraczy; i++) {
            gracze.add(new Komputer(i + 1));
        }
        System.out.println("Jesteś graczem nr 1.");
    }

    public void rozdajKarty(List<Karta> taliaKart) {
        for (int i = 0; i < 5; i++) {
            for (Gracz gracz : gracze) {
                gracz.otrzymajKarte(taliaKart.remove(0));
            }
        }
    }

    public Gracz dajPierwszegoGracza() {
        return gracze.get(0);
    }

    public void rozpocznijGre(){
        System.out.println();
        System.out.println("Zaczynamy grę.");
    }

    public void wyswietlKomunikatJakaKartaNaStosie(Karta kartaNaStole){
            System.out.println("Twoj ruch. Karta na stole to: " + kartaNaStole);
            System.out.println();
    }
    public void dolozKarteDoStosu(Karta kartaDoWylozenia) {
        stos.add(kartaDoWylozenia);
    }

    public void wykonajRuch(Karta odslonietaKarta, List<Karta> taliaKart) {
        boolean koniecGry = false;
        while (!koniecGry){
            for (Gracz aktualny : gracze) {
                if (aktualny.equals(dajPierwszegoGracza())){
                    wyswietlKomunikatJakaKartaNaStosie(odslonietaKarta);
                }
                if (!aktualny.czyMozeszZagracNa(odslonietaKarta)) {
                    ///pusta talia kart
                    Karta otrzymana = taliaKart.remove(0);// metoda nie wywolana na obiekcie???
                    aktualny.otrzymajKarte(otrzymana);
                    System.out.println("Gracz nie mogl nic zagrac, dobiera kartę.\nOtrzymana karta to: " + otrzymana);
                    continue;
                }
                Karta wybranaKarta = aktualny.wybierzKarte(odslonietaKarta);
                aktualny.dajKarty().remove(wybranaKarta);
                stos.add(wybranaKarta);
                odslonietaKarta = wybranaKarta;
                sprawdzCzyMakao(aktualny);
                if (sprawdzCzyKoniecGry(aktualny)){
                    koniecGry = true;
                }
            }
        }
    }

    private void sprawdzCzyMakao(Gracz aktualny) {
        if (aktualny.dajIloscKart() == 1){
            System.out.println("Makao!");
        }
    }

    private boolean sprawdzCzyKoniecGry(Gracz aktualny){
        if (aktualny.dajIloscKart() == 0){
            System.out.println("Koniec gry. Wygral " + aktualny);
            return true;
        }
        return false;
    }
}
