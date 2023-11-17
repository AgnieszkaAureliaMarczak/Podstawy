package obiektowosc.makao;

public enum Nominal {
    DWA(2),
    TRZY(3),
    CZTERY(4),
    PIEC(5),
    SZESC(6),
    SIEDEM(7),
    OSIEM(8),
    DZIEWIEC(9),
    DZIESIEC(10),
    WALET(11),
    DAMA(12),
    KROL(13),
    AS(14);

    //pola - cechy
    private int numerycznaWartosc;
    //konstruktory

    Nominal(int numerycznaWartosc) {
        this.numerycznaWartosc = numerycznaWartosc;
    }

    //metody
   /* public int getNumerycznaWartosc() {
        return numerycznaWartosc;
    }*/

    public int getNumerycznaWartosc() {
        return ordinal()+2;
    }

    @Override
    public String toString() {
        return name().substring(0,1)+ name().substring(1).toLowerCase();
    }
}
