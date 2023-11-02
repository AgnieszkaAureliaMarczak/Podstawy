package obiektowosc.dom;

public class DomDemo {
    public static void main(String[] args) {
        Okno okno = new Okno();
        System.out.println(okno);
        okno.otworzOkno();
        System.out.println(okno);
        Okno[] tablicaOkien = new Okno[4];
        for (int i = 0; i < tablicaOkien.length; i++) {
            tablicaOkien[i] = new Okno();
            tablicaOkien[i].otworzOkno();
            System.out.println(tablicaOkien[i]);
        }

        Lozko lozko1 = new Lozko(6);
        Lozko lozko2 = new Lozko(10);
        System.out.println(lozko1);
        System.out.println(lozko2);

        Pokoj pokoj1 = new Pokoj(tablicaOkien, lozko1);
        System.out.println(pokoj1);


        Okno[] sypialnia = new Okno[2];
        sypialnia[0] = new Okno();
        sypialnia[1] = new Okno();
        Lozko lozkoWsypialni = new Lozko(5);
        Pokoj pokojSypialnia = new Pokoj();
        pokojSypialnia.setOkna(sypialnia);
        pokojSypialnia.setLozko(lozkoWsypialni);
        System.out.println(pokojSypialnia);

        pokojSypialnia.posprzatajPokoj();
        System.out.println(pokojSypialnia);

        Pokoj[] pokojeWchacie = new Pokoj[2];
        pokojeWchacie[0] = new Pokoj();
        pokojeWchacie[1] = new Pokoj(tablicaOkien, lozko1);
        Dom chata = new Dom(pokojeWchacie);
        System.out.println(chata);
    }
}
