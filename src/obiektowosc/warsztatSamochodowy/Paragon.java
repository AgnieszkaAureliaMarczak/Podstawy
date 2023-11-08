package obiektowosc.warsztatSamochodowy;

public class Paragon {

    private String rodzajUslugi;
    private int iloscNapraw;
    private double lacznaCena;

    public Paragon(String rodzajUslugi, int ilosc, double lacznaCena) {
        this.rodzajUslugi = rodzajUslugi;
        this.iloscNapraw = ilosc;
        this.lacznaCena = lacznaCena;
    }

    @Override
    public String toString() {
        return "Paragon{" +
                "rodzajUslugi='" + rodzajUslugi + '\'' +
                ", ilosc=" + iloscNapraw +
                ", lacznaCena=" + lacznaCena +
                '}';
    }
}
