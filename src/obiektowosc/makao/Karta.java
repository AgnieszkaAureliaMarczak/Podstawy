package obiektowosc.makao;

public class Karta {
    private Kolor kolor;
    private Nominal nominal;

    public Karta(Kolor kolor, Nominal nominal) {
        this.kolor = kolor;
        this.nominal = nominal;
    }

    public int getNumerycznaWartosc() {
        return nominal.getNumerycznaWartosc();
    }


    @Override
    public String toString() {

        return kolor + ", " + nominal;
    }
}
