package obiektowosc.makao;

public class Komputer extends Gracz{
    @Override
    public Karta wybierzKarte(Karta kartaZeStosu) {
        return dajPasujacaKarteDoZagrania(kartaZeStosu);
    }
}
