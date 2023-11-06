package obiektowosc.ogrod;

public class Ogrod {
    private Drzewo[] drzewa;
    private Lawka lawka;
    private Pies pies;
    private Kwiat[] kwiaty;

    public Ogrod(Lawka lawka,Kwiat[] kwiaty, int iloscDrzew){
        this.lawka = lawka;
        this.kwiaty = kwiaty;
        Drzewo[] drzewa = new Drzewo[iloscDrzew];
        for (int i = 0; i < iloscDrzew; i++) {
            drzewa[i] = new Drzewo();
        }
        this.drzewa = drzewa;
    }

    public Ogrod(Lawka lawka,Kwiat[] kwiaty, int iloscDrzew, Pies pies){
        this.lawka = lawka;
        this.kwiaty = kwiaty;
        Drzewo[] drzewa = new Drzewo[iloscDrzew];
        for (int i = 0; i < iloscDrzew; i++) {
            drzewa[i] = new Drzewo();
        }
        this.drzewa = drzewa;
        this.pies = pies;
    }
}
