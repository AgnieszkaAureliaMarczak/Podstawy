package obiektowosc.makao;

import java.util.*;

public class KartyDoGry {
    private List<Karta> taliaKart = new ArrayList<>();

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

    public void potasujTalie(List<Karta> taliaDoTasowania) {
        Random random = new Random();
        for (int i = 0; i < 52; i++) {
            int wylosowanaKarta = random.nextInt(taliaDoTasowania.size());
            taliaKart.add(taliaDoTasowania.remove(wylosowanaKarta));
        }
    }

    public List <Karta> dajTalieKart(){
        return taliaKart;
    }

    public Karta usunKarteZtalii(){
        if (taliaKart.isEmpty()) {
            return null;
        }
        return taliaKart.remove(0);
    }

    public Karta dajPierwszaKarteZtalii(){
        if (taliaKart.isEmpty()) {
            return null;
        }
        return taliaKart.get(0);
    }

    public void wyswietlTalie(){
        int indeks = 1;
        for (Karta karta : taliaKart) {
            System.out.println(indeks + ": " + karta);
            indeks++;
        }
    }

    public int dajIloscKartWtalii(){
      return taliaKart.size();
    }
}
