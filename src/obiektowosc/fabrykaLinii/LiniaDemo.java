package obiektowosc.fabrykaLinii;

public class LiniaDemo {
    public static void main(String[] args) {

        //todo review/refactor
        FabrykaLinii fabryka = new FabrykaLinii();
        fabryka.stworzLinieLosowejDlugosciZwybranymZnakiem('*').drukujLinie();
        fabryka.stworzLinieWybranejDlugosciIzLosowymZnakiem(10).drukujLinie();
        fabryka.stworzLinieZlosowaDlugosciaIzLosowymZnakiem().drukujLinie();
        System.out.println();
        Linia[] tablicaLinii = fabryka.stworzOkreslonaIloscLiniiZlosowaDlugosciaIznakiem(5);
        for (Linia linia : tablicaLinii) {
            linia.drukujLinie();
        }
        System.out.println();
        fabryka.stworzLinie2razyWiekszaOdPoprzedniej(1).drukujLinie();
        fabryka.stworzLinie2razyWiekszaOdPoprzedniej(2).drukujLinie();
        fabryka.stworzLinie2razyWiekszaOdPoprzedniej(4).drukujLinie();
        System.exit(0);





        Linia linia1 = new Linia(10, 'P');
        Linia linia2 = new Linia(5, 'u');
        Linia linia3 = new Linia(8, 'g');

        linia1.setDlugosc(10);
        linia2.setDlugosc(15);
        linia3.setDlugosc(20);

        linia1.setWypelnienie('*');
        linia2.setWypelnienie('@');
        linia3.setWypelnienie('#');

        linia1.drukujLinie();
        System.out.println();
        linia2.drukujLinie();
        System.out.println();
        linia3.drukujLinie();
        System.out.println();

        System.out.println("Linia 1: " + linia1);
        System.out.println("Linia 2: " + linia2);
    }
}
