package obiektowosc.makao;

import java.util.ArrayList;
import java.util.List;

public class Gracz {
    private List<Karta> karty = new ArrayList<>();

    public void otrzymajKarte(Karta karta){
        karty.add(karta);
    }

    public int dajIloscKart(){
        return karty.size();
    }

    public void wyswietlKarty(){
        for (int i = 0; i < dajIloscKart(); i++) {
            System.out.println((i + 1) + ": " + karty.get(i));
        }
    }

    public Karta dajKarteZWybranejPozycji(int index){
        return karty.get(index);
    }

    public Karta wylozKarte(int numerKarty){
     return karty.remove(numerKarty-1);
    }

    public void wykonajRuch() {

    }
}
