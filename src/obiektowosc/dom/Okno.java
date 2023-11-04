package obiektowosc.dom;

public class Okno {
    private boolean czyOtwarte;

    public void otworz(){
        czyOtwarte = true;
    }
    public String toString(){
        return "okno: otwarte = " + czyOtwarte;
    }
}
