package obiektowosc.poczta;

import java.util.Scanner;

public class Poczta {
    private double utarg;

    public double nadajPaczke(Paczka paczka, double kwotaPieniedzy) {
        double cena = paczka.wyliczCenePaczki();
        System.out.println("Cena nadania paczki: " + cena);
        if (kwotaPieniedzy >= cena) {
            paczka.setStatus("nadana");
            System.out.println("Reszta do zwrotu: " + (kwotaPieniedzy - cena));
            utarg += cena;
            return kwotaPieniedzy - cena;
        } else {
            System.out.println("Przekazana kwota jest za mała na nadanie tej paczki.");
            return kwotaPieniedzy;
        }
    }

    public Paczka stworzPaczke() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nadawce");
        String nadawca = scanner.nextLine();
        System.out.println("Podaj odbiorcę");
        String odbiorca = scanner.nextLine();
        System.out.println("Podaj wagę paczki");
        double waga = scanner.nextDouble();
        return new Paczka(nadawca, odbiorca, waga);
    }



    public double getUtarg() {
        return utarg;
    }
}
