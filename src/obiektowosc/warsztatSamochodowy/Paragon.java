package obiektowosc.warsztatSamochodowy;

public class Paragon {

    private String rodzajUslugi;
    private int ilosc;
    private double lacznaCena;

    public Paragon(String rodzajUslugi, int ilosc, double lacznaCena) {
        this.rodzajUslugi = rodzajUslugi;
        this.ilosc = ilosc;
        this.lacznaCena = lacznaCena;
    }

    @Override
    public String toString() {
        return "Paragon{" +
                "rodzajUslugi='" + rodzajUslugi + '\'' +
                ", ilosc=" + ilosc +
                ", lacznaCena=" + lacznaCena +
                '}';
    }
}
