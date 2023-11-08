package obiektowosc.poczta;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PaczkaDemo {
    public static void main(String[] args) {
        Paczka pierwszaPaczka = new Paczka("Kamil Nowak","Jan Kowalski", 7.5);
        System.out.println(pierwszaPaczka);

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
        System.out.println("Łączna cena paczek: " + lacznaCena);

        Poczta poczta = new Poczta();
        poczta.wyswietlOstatniaNadanaPaczke();
        poczta.nadajPaczke(pierwszaPaczka,17.50);
        System.out.println(poczta.getUtarg());
        poczta.wyswietlOstatniaNadanaPaczke();
        Paczka paczkaStworzonaNaPoczcie = poczta.stworzPaczke();
        poczta.nadajPaczke(paczkaStworzonaNaPoczcie, 45.50);
        System.out.println(poczta.getUtarg());

        poczta.wyswietlOstatniaNadanaPaczke();
//        Paczka[] paczkiNadane = new Paczka[2];
//        paczkiNadane[0] = pierwszaPaczka;
//        paczkiNadane[1] = paczkaStworzonaNaPoczcie;



        List list = new List(new Adres("Rajska", 41, "02-654"),
                new Adres("Kochanowskiego", 5, "00-125"));
        System.out.println(list);
        Poczta nowaPoczta = new Poczta();
        list.setPriorytetowy(true);
        nowaPoczta.nadajList(list, 9.50);
        System.out.println(nowaPoczta);
        nowaPoczta.wyslijListonosza();
        System.out.println(nowaPoczta);

    }
}
