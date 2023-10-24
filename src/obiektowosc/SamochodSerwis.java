package obiektowosc;

import java.util.Scanner;

public class SamochodSerwis {

    public static void main(String[] args) {
        SamochodSerwis samochodSerwis = new SamochodSerwis();
        samochodSerwis.dajDaneOprzegladzie(samochodSerwis.utworzSamochod());
    }

    public Samochod utworzSamochod(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj markę samochodu");
        String modelSamochodu = scanner.nextLine();
        System.out.println("Podaj przebieg samochodu");
        int przebiegSamochodu = scanner.nextInt();
        return new Samochod(modelSamochodu, przebiegSamochodu);
    }
    public void dajDaneOprzegladzie(Samochod samochod){
        samochod.setPrzebiegDoPrzegladu(50_000);
        if (samochod.getPrzebieg() > samochod.getPrzebiegDoPrzegladu()){
            System.out.println("Samochód o marce " + samochod.getMarka() + " powinien zrobić przegląd " +
                    samochod.ileKmDoNastepnegoPrzegladu() + " kilometrów temu.");
        } else if (samochod.getPrzebiegDoPrzegladu() > samochod.getPrzebieg()) {
            System.out.println("Dla samochodu o marce " + samochod.getMarka() +
                    " zostało jeszcze " + samochod.ileKmDoNastepnegoPrzegladu() +
                    " kilometrów do przeglądu.");
        }
    }
}
