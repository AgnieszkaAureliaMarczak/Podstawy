package obiektowosc;

public class Samochod {
    private String marka;
    private int przebieg;
    private int przebiegDoPrzegladu;
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
        System.out.println("Marka samochodu: " + getMarka() + "\nPrzebieg: " + getPrzebieg());
    }

    public void wyliczPrzebiegPoPrzejechaniu(int odlegloscDoPrzejechania) {
        setPrzebieg(getPrzebieg() + odlegloscDoPrzejechania);
    }

    public int ileKmDoNastepnegoPrzegladu() {
        return getPrzebiegDoPrzegladu() - getPrzebieg();
    }

    public String toString() {
        return "Marka: " + getMarka() + "\nPrzebieg: " + getPrzebieg() + "\nPrzebieg do przeglądu: " + getPrzebiegDoPrzegladu();
    }
}
