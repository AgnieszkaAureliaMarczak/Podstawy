package obiektowosc.pies;

public class Pies {
    private String imie;
    private String rasa;
    private int wiek;
    private int waga;
    private boolean czyNakarmiony;

    public Pies(String imie, String rasa, int waga) {
        this.imie = imie;
        this.rasa = rasa;
        this.waga = waga;
        this.wiek = 0;
    }

    public void szczekaj(String odglos) {
        System.out.println(odglos);
    }

    public void nakarm(int wagaKarmy) {
        waga += wagaKarmy;
        czyNakarmiony = true;
    }

    public Pies nakarmImmutable(int wagaKarmy) { //podejście immutalbe - jak przy String, BigDecimal i LocalDate
        Pies pies = new Pies(imie, rasa, waga + wagaKarmy);
        pies.czyNakarmiony = true;
        return pies;
    }

    public int getWaga() {
        return waga;
    }

    public boolean isCzyNakarmiony() {
        return czyNakarmiony;
    }

    public String toString() {
        return "Imie: " + imie + "\nRasa: " + rasa + "\nWaga: " + waga + "\nWiek: " + wiek;
    }
}
