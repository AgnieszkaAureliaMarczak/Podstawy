package obiektowosc.poczta;

public class PaczkaDemo {
    public static void main(String[] args) {
        Paczka pierwszaPaczka = new Paczka("Kamil Nowak","Jan Kowalski", 7.5);
       /* System.out.println(pierwszaPaczka);

        Paczka drugaPaczka = new Paczka();
        System.out.println(drugaPaczka);
        System.out.println(drugaPaczka.wyliczCenePaczki());

        Paczka trzeciaPaczka = null;
       // System.out.println(trzeciaPaczka.wyliczCenePaczki());

        trzeciaPaczka = pierwszaPaczka;
        System.out.println(trzeciaPaczka.wyliczCenePaczki());
        System.out.println(pierwszaPaczka.wyliczCenePaczki());

        Paczka[] paczkiDoNadania = new Paczka[3];
        paczkiDoNadania[0] = new Paczka("Joanna", "Anna", 21.45);
        paczkiDoNadania[1] = new Paczka("Jan", "Ksawery", 10.12);
        paczkiDoNadania[2] = new Paczka("Henryk", "Basia", 3.89);
        System.out.println(paczkiDoNadania[0]);

        Paczka[] paczkiDoWyslania = new Paczka[100];
        for (int i = 0; i < paczkiDoWyslania.length; i++) {
            paczkiDoWyslania[i] = new Paczka();
        }

        double lacznaCena = 0;
        for (Paczka paczka : paczkiDoWyslania) {
            System.out.println(paczka + " Cena: " + paczka.wyliczCenePaczki());
            lacznaCena += paczka.wyliczCenePaczki();
        }
        BigDecimal cenaPaczek = new BigDecimal(lacznaCena);
        cenaPaczek = cenaPaczek.setScale(2, RoundingMode.HALF_UP);
        lacznaCena = cenaPaczek.doubleValue();
        System.out.println("Łączna cena paczek: " + lacznaCena);*/

        Poczta poczta = new Poczta();
        poczta.nadajPaczke(pierwszaPaczka,17.50);
        System.out.println(poczta.getUtarg());

        Paczka nowostworzonaPaczka = poczta.stworzPaczke();
        poczta.nadajPaczke(nowostworzonaPaczka, 45.50);
        System.out.println(poczta.getUtarg());
    }
}
