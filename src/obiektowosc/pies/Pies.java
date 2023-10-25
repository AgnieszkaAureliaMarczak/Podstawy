package obiektowosc.pies;

public class Pies {
    private String imie;
    private String rasa;
    private int wiek;
    private int waga;
    private boolean czyNakarmiony;

    public int getWaga(){
        return waga;
    }

    public boolean isCzyNakarmiony() {
        return czyNakarmiony;
    }

    public void setCzyNakarmiony(boolean czyNakarmiony) {
        this.czyNakarmiony = czyNakarmiony;
    }

    public Pies(String imie, String rasa, int waga){
        this.imie = imie;
        this.rasa = rasa;
        this.waga = waga;
        this.wiek = 0;
    }

    public String toString(){
        return "Imie: " + imie + "\nRasa: " + rasa + "\nWaga: " + waga + "\nWiek: " + wiek;
    }

    public void szczekaj(String odglos){
        System.out.println(odglos);
    }

    public int ileJedzeniaDziennieWkg(int waga) {
        if (waga <= 3) {
            return 1;
        } else if (waga <= 6) {
            return 2;
        } else if (waga <= 10) {
            return 3;
        } else {
            return 4;
        }
    }
}
