package obiektowosc.warsztatSamochodowy;

public class Warsztat {

    private Samochod samochod;

    public Warsztat(Samochod samochod){
        this.samochod = samochod;
    }

    public Paragon naprawSamochod(){
       Kolo[] kola = samochod.getKola();
        for (int i = 0; i < kola.length; i++) {
            if(kola[i].isPrzebite()){
                kola[i].naprawKolo();
            }
        }
        return new Paragon("naprawa koła", 1, 25); //todo
    }

    @Override
    public String toString() {
        return "Warsztat{" +
                "samochod=" + samochod +
                '}';
    }
}
