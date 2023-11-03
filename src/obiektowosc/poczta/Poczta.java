package obiektowosc.poczta;

public class Poczta {

    private double utarg;
    public double nadajPaczke(Paczka paczka, double kwotaPieniedzy){
        double cena = paczka.wyliczCenePaczki();
        if (kwotaPieniedzy >= cena){
            paczka.setStatus("nadana");
            System.out.println("Reszta do zwrotu: " + (kwotaPieniedzy - cena));
            utarg += cena;
            return kwotaPieniedzy - cena;
        } else {
            System.out.println("Przekazana kwota jest za mała na nadanie tej paczki.");
            return kwotaPieniedzy;
        }
    }

    public double getUtarg() {
        return utarg;
    }

    public void setUtarg(double utarg) {
        this.utarg = utarg;
    }
}
