package obiektowosc.poczta;

import java.util.Arrays;
import java.util.Scanner;

public class Poczta {
    private double utarg;
    private List[] listyDoWyslania = new List[10];
    private int licznikNadanychListow = 0;

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

    public double nadajList(List list, double kwotaPieniedzy) {
        double cena = list.wyliczCene();
        System.out.println("Cena nadania listu: " + cena);
        if (kwotaPieniedzy >= cena) {
            list.setStatus("nadany");
            utarg += cena;
            listyDoWyslania[licznikNadanychListow] = list;
            licznikNadanychListow++;
            if (licznikNadanychListow == 10) {
                System.out.println("Przepraszamy, poczta jest w stanie wysyłać tylko 10 listów dziennie, i co nam zrobisz?");
            }
            System.out.println("Reszta do zwrotu: " + (kwotaPieniedzy - cena));
            return kwotaPieniedzy - cena;
        } else {
            System.out.println("Przekazana kwota jest za mała na nadanie tego listu.");
            return kwotaPieniedzy;
        }
    }

    public void wyslijListonosza(){
        for (int i = 0; i < listyDoWyslania.length; i++) {
            if (listyDoWyslania[i] != null){
                listyDoWyslania[i].setStatus("wysłany");
            }
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

    public void wyswietlOstatniaNadanaPaczke(Paczka[] nadanePaczki) {
        for (int i = 0; i < nadanePaczki.length; i++) {
            if (i == nadanePaczki.length - 1) {
                System.out.println(nadanePaczki[i]);
            }
        }
    }

    public double getUtarg() {
        return utarg;
    }

    @Override
    public String toString() {
        return "Poczta{" +
                "listyDoWyslania=" + Arrays.toString(listyDoWyslania) +
                '}';
    }
}
