package obiektowosc.ogrod;

import java.util.Arrays;

public class Ogrod {
    private Drzewo[] drzewa;
    private Lawka lawka;
    private Pies pies;
    private Kwiat[] kwiaty;

    public Ogrod(Lawka lawka,Kwiat[] kwiaty, int iloscDrzew){
        this(lawka, kwiaty, iloscDrzew,null);
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

   public void wejdzDoOgrodu(){
        if (pies == null){
            System.out.println("W ogrodzie nie ma psa. Wita cię szum wiatru.");
        } else {
            System.out.println("How, how, witaj w ogrodzie. Teraz zrobię dla ciebie sztuczkę:");
            pies.bawSie();
        }
   }

   /* public void wejdzDoOgrodu(){
        System.out.println("W ogrodzie nie ma psa. Wita cię szum wiatru.");
    }*/

    public void podlejKwiaty(){
        for (Kwiat kwiat : kwiaty) {
            kwiat.podlejKwiat();
        }
    }

    public void odpocznij(){
        System.out.println("Siadasz na lawce z materiału: " + lawka.getMaterial());
    }

    public int zbierajOwoce(){
        int iloscOwocowZeWszystkichDrzew = 0;
        for (Drzewo drzewo : drzewa) {
            iloscOwocowZeWszystkichDrzew += drzewo.zbierajOwoce();
        }
        if (iloscOwocowZeWszystkichDrzew == 0){
            System.out.println("Przyjdź jutro.");
        } else {
            System.out.println("Zebrano " + iloscOwocowZeWszystkichDrzew + " owoców ze wszystkich drzew.");
        }
        return iloscOwocowZeWszystkichDrzew;
    }

    public void wyjdzZogrodu(){
        for (Drzewo drzewo : drzewa) {
            drzewo.owocuj();
        }
        for (Kwiat kwiat : kwiaty) {
            kwiat.setCzyKwitnie(false);
        }
    }

    public void   pracujWogrodzie(){
        wejdzDoOgrodu();
        podlejKwiaty();
        odpocznij();
        zbierajOwoce();
        wyjdzZogrodu();
    }

    public int pracujWogrodzie(int iloscDniPracujacych){
        int owoceZebraneWczasiePracy = 0;
        for (int i = 0; i < iloscDniPracujacych; i++) {
            //owoceZebraneWczasiePracy += pracujWogrodzie();
            wejdzDoOgrodu();
            podlejKwiaty();
            odpocznij();
            owoceZebraneWczasiePracy += zbierajOwoce();
            wyjdzZogrodu();
        }
        System.out.println(owoceZebraneWczasiePracy);
        return owoceZebraneWczasiePracy;
    }

    @Override
    public String toString() {
        return "Ogrod{" +
                "drzewa=" + Arrays.toString(drzewa) +
                ", lawka=" + lawka +
                ", pies=" + pies +
                ", kwiaty=" + Arrays.toString(kwiaty) +
                '}';
    }
}
