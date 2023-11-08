package obiektowosc.serwisSamochodowy;

public class CarService {
    public int wyliczLacznyPrzebieg(Samochod[] samochody) {
        int lacznyPrzebieg = 0;
        for (Samochod samochod : samochody) {
            lacznyPrzebieg += samochod.getPrzebieg();
        }
        return lacznyPrzebieg;
    }
}
