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
        int rozmiarTalii = taliaDoTasowania.size();
        for (int i = 0; i < rozmiarTalii; i++) {
            int wylosowanaKarta = random.nextInt(taliaDoTasowania.size());
            taliaKart.add(taliaDoTasowania.remove(wylosowanaKarta));
        }
    }

    public List <Karta> dajTalieKart(){
        return taliaKart;
    }

    public Karta usunPierwszaKarteZtalii(){
        if (taliaKart.isEmpty()) {
            return null;
        }
        return taliaKart.remove(0);
    }

    private void wyswietlTalie(){
        int indeks = 1;
        for (Karta karta : taliaKart) {
            System.out.println(indeks + ": " + karta);
            indeks++;
        }
    }

    public void uzupelnijTalie(List<Karta> stos){
        int rozmiarStosu = stos.size();
        List<Karta> taliaDoTasowania = new ArrayList<>();
        for (int i = 1; i < rozmiarStosu; i++) {
            taliaDoTasowania.add(stos.remove(i));
        }
        potasujTalie(taliaDoTasowania);
        wyswietlTalie();
    }
}
