package obiektowosc.poczta;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Paczka {
    private String nadawca;
    private String odbiorca;
    private double waga;
    private boolean czyPriorytetowa;
    private String status = "utworzona";

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
        int[] wylosowanePozycje = new int[3];
        for (int i = 0; i < wylosowanePozycje.length; i++) {
            wylosowanePozycje[i] = losowanie.nextInt(0, 10);
        }
        DaneDoLosowania daneDoLosowania = new DaneDoLosowania();
        String[] nadawcy = daneDoLosowania.getNadawcy();
        this.nadawca = nadawcy[wylosowanePozycje[0]];
        String[] odbiorcy = daneDoLosowania.getOdbiorcy();
        this.odbiorca = odbiorcy[wylosowanePozycje[1]];
        double[] wagi = daneDoLosowania.getWagaPaczki();
        this.waga = wagi[wylosowanePozycje[2]];
        this.czyPriorytetowa = losowanie.nextBoolean();
    }

    public double wyliczCenePaczki() {
        double cena = 0;
        if (waga <= 0.5) {
            cena = 5;
        } else if (waga <= 1) {
            cena = 8;
        } else if (waga <= 2) {
            cena = 12;
        } else if (waga > 2) {
            cena = 12 + (waga - 2);
        }
        if (czyPriorytetowa) {
            cena = cena + (cena * 0.1);
        }
        BigDecimal bigDecimal = new BigDecimal(cena);
        bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
