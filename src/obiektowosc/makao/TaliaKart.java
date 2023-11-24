package obiektowosc.makao;

import java.util.*;

public class TaliaKart {
    private List<Karta> taliaKart;
    Random random = new Random();

    public TaliaKart(){
        taliaKart = new ArrayList<>();
        Kolor[] tablicaKolorow = Kolor.values();
        Nominal[] tablicaNominalow = Nominal.values();
        List<Karta> taliaDoTasowania = new ArrayList<>();
        for (Kolor kolor : tablicaKolorow) {
            for (Nominal nominal : tablicaNominalow) {
                //    System.out.printf("%s %d\n",nominal,nominal.getNumerycznaWartosc());
                taliaDoTasowania.add(new Karta(kolor, nominal));
            }
        }
       potasujKartyDoGry(taliaDoTasowania);
    }

    public int dajIloscKartWtalii(){
      return taliaKart.size();
    }

    public void potasujKartyDoGry(List<Karta> taliaDoTasowania) {
        Random random = new Random();
        for (int i = 0; i < dajIloscKartWtalii(); i++) {
            int wylosowanaKarta = random.nextInt(dajIloscKartWtalii());
            taliaKart.add(taliaDoTasowania.remove(wylosowanaKarta));
        }
    }

    public Karta wyciagnijKarte(){
        if (taliaKart.isEmpty()) {
            return null;
        }
        return taliaKart.remove(0);
    }
}
