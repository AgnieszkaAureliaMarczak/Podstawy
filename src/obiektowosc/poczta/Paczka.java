package obiektowosc.poczta;

import java.util.Random;

public class Paczka {
    private String nadawca;
    private String odbiorca;
    private double waga;
    private boolean czyPriorytetowa;

    public Paczka(String nadawca, String odbiorca, double waga) {
        if (nadawca.equals("")) {
            System.out.println("Nie podano nadawcy.");
        } else {
            this.nadawca = nadawca;
        }
        if (odbiorca.equals("")) {
            System.out.println("Nie podano odbiorcy");
        } else {
            this.odbiorca = odbiorca;
        }
        if (waga < 1 || waga > 1000) {
            System.out.println("Za duża lub za mała waga paczki.");
        } else {
            this.waga = waga;
        }
    }

    public Paczka() {
        Random losowanie = new Random();
        int wylosowanaPozycja = losowanie.nextInt(0, 10);
        DaneDoLosowania daneDoLosowania = new DaneDoLosowania();
        String[] nadawcy = daneDoLosowania.getNadawcy();
        this.nadawca = nadawcy[wylosowanaPozycja];
        String[] odbiorcy = daneDoLosowania.getOdbiorcy();
        this.odbiorca = odbiorcy[wylosowanaPozycja];
        double[] wagi = daneDoLosowania.getWagaPaczki();
        this.waga = wagi[wylosowanaPozycja];
        this.czyPriorytetowa = losowanie.nextBoolean();
    }

    @Override
    public String toString() {
        return "Paczka{" +
                "nadawca='" + nadawca + '\'' +
                ", odbiorca='" + odbiorca + '\'' +
                ", waga=" + waga +
                ", czyPriorytetowa=" + czyPriorytetowa +
                '}';
    }
}
