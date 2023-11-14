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
        return "Karta{" +
                "kolor='" + kolor + '\'' +
                ", nominal=" + nominal +
                '}';
    }
}
