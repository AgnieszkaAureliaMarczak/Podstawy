package obiektowosc;

public class Samochod {
    private String marka;
    private int przebieg;
    private int przebiegDoPrzegladu = 40_000;
    public Samochod(){
    }
    public Samochod(String marka, int przebieg) {
        this.marka = marka;
        this.przebieg = przebieg;
    }
    
    public void setMarka(String marka) {
        this.marka = marka;
    }

    public void setPrzebieg(int przebieg) {
        this.przebieg = przebieg;
    }

    public void setPrzebiegDoPrzegladu(int przebiegDoPrzegladu) {
        this.przebiegDoPrzegladu = przebiegDoPrzegladu;
    }

    public String getMarka() {
        return marka;
    }

    public int getPrzebieg() {
        return przebieg;
    }

    public int getPrzebiegDoPrzegladu() {
        return przebiegDoPrzegladu;
    }

    public void wyswietlMarkeIprzebieg() {
        System.out.println("Marka samochodu: " + marka + "\nPrzebieg: " + przebieg);
    }

    public void wyliczPrzebiegPoPrzejechaniu(int odlegloscDoPrzejechania) {
        setPrzebieg(przebieg + odlegloscDoPrzejechania);
    }

    public int ileKmDoNastepnegoPrzegladu() {
        if (przebieg > przebiegDoPrzegladu){
            return przebieg - przebiegDoPrzegladu;
        }
        return przebiegDoPrzegladu - przebieg;
    }

    public String toString() {
        return "Marka: " + marka + "\nPrzebieg: " + przebieg + "\nPrzebieg do przeglądu: " + przebiegDoPrzegladu;
    }
}
