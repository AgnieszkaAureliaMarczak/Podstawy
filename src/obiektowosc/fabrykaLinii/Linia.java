package obiektowosc.fabrykaLinii;

public class Linia {
    private int dlugosc;
    private char wypelnienie;

    public Linia() {
    }

    public Linia(int dlugosc, char wypelnienie) {
        this.dlugosc = dlugosc;
        this.wypelnienie = wypelnienie;
    }

    public void drukujLinie() {
        for (int i = 0; i < dlugosc; i++) {
            System.out.print(wypelnienie);
        }
        System.out.println();
    }

    public void setDlugosc(int dlugosc) {
        this.dlugosc = dlugosc;
    }

    public int getDlugosc() {
        return dlugosc;
    }

    public void setWypelnienie(char wypelnienie) {
        this.wypelnienie = wypelnienie;
    }

    @Override
    public String toString() {
        return "Linia{" +
                "dlugosc=" + dlugosc +
                ", wypelnienie=" + wypelnienie +
                '}';
    }
}
