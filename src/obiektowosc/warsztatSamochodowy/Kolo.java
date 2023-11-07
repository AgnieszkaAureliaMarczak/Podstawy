package obiektowosc.warsztatSamochodowy;

public class Kolo {

    private boolean przebite;
    private double cisnienie;

    public Kolo() {
        this.przebite = false;
        this.cisnienie = 2.5;
    }

    public void przebijKolo() {
        przebite = true;
        cisnienie = 0;
    }

    public void naprawKolo(){
        przebite = false;
        cisnienie = 2.5;
    }

    public boolean isPrzebite() {
        return przebite;
    }

    @Override
    public String toString() {
        return "Kolo{" +
                "przebite=" + przebite +
                ", cisnienie=" + cisnienie +
                '}';
    }
}
