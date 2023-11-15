package obiektowosc.makao;

public class Karta {
    private String kolor;
    private int nominal;

    public Karta(String kolor, int nominal) {
        this.kolor = kolor;
        this.nominal = nominal;
    }

    @Override
    public String toString() {
        if (nominal == 14){
            return kolor + ", as";
        } else if (nominal == 13) {
            return kolor + ", król";
        } else if (nominal == 12) {
            return kolor + ", dama";
        } else if (nominal == 11) {
            return kolor + ", walet";
        }
        return kolor + ", " + nominal;
    }
}
