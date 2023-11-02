package obiektowosc;

import java.util.Scanner;

public class SamochodSerwis {
    public Samochod pobierzDaneOsamochodzie(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj markę samochodu");
        String modelSamochodu = scanner.nextLine();
        System.out.println("Podaj przebieg samochodu");
        int przebiegSamochodu = scanner.nextInt();
        return new Samochod(modelSamochodu, przebiegSamochodu);
    }
    public void sprawdzKiedyNastepnyPrzeglad(Samochod samochod){
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
