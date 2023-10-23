package obiektowosc.dom;

public class Okno {
    private boolean czyOtwarte;

    public void otworzOkno(){
        czyOtwarte = true;
    }
    public String toString(){
        return "okno: otwarte = " + czyOtwarte;
    }
}
