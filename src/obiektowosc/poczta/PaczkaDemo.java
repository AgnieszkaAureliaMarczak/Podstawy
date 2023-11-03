package obiektowosc.poczta;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PaczkaDemo {
    public static void main(String[] args) {
        Paczka pierwszaPaczka = new Paczka("","Jan Kowalski", 7.5);
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

        for (int i = 0; i < paczkiDoNadania.length; i++) {
            paczkiDoNadania[i] = new Paczka();
        }

        double lacznaCena = 0;
        for (Paczka paczka : paczkiDoNadania) {
            System.out.println(paczka + " Cena: " + paczka.wyliczCenePaczki());
            lacznaCena += paczka.wyliczCenePaczki();
        }
        BigDecimal cenaPaczek = new BigDecimal(lacznaCena);
        cenaPaczek = cenaPaczek.setScale(2, RoundingMode.HALF_UP);
        lacznaCena = cenaPaczek.doubleValue();
        System.out.println("Łączna cena paczek: " + lacznaCena);
    }

}
