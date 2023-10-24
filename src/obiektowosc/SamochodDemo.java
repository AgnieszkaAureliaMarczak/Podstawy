package obiektowosc;

public class SamochodDemo {
    public static void main(String[] args) {
        Samochod samochod1 = new Samochod();
        Samochod samochod2 = new Samochod();
        Samochod samochod3 = new Samochod();
        Samochod samochod4 = new Samochod();
        Samochod samochod5 = new Samochod();


        samochod1.setMarka("Opel");
        samochod1.setPrzebieg(56_000);
        samochod1.setPrzebiegDoPrzegladu(70_000);
        samochod2.setMarka("Renault");
        samochod2.setPrzebieg(98_000);
        samochod2.setPrzebiegDoPrzegladu(100_000);
        samochod3.setMarka("Fiat");
        samochod3.setPrzebieg(44_000);
        samochod3.setPrzebiegDoPrzegladu(50_000);
        samochod4.setMarka("Volvo");
        samochod4.setPrzebieg(105_000);
        samochod4.setPrzebiegDoPrzegladu(105_000);
        samochod5.setMarka("Peugeot");
        samochod5.setPrzebieg(45_000);
        samochod5.setPrzebiegDoPrzegladu(55_000);

        samochod1.wyswietlMarkeIprzebieg();
        samochod2.wyswietlMarkeIprzebieg();
        samochod1.wyliczPrzebiegPoPrzejechaniu(500);
        System.out.println(samochod1.getPrzebieg());
        System.out.println("Do następnego przeglądu: \nrenault: " + samochod2.ileKmDoNastepnegoPrzegladu() + "\nopel: " + samochod1.ileKmDoNastepnegoPrzegladu());

        Samochod[] komis = new Samochod[]{samochod1, samochod2, samochod3, samochod4, samochod5};
        for (int i = 0; i < komis.length; i++) {
            System.out.println("Marka: " + komis[i].getMarka());
            System.out.println("Przebieg: " + komis[i].getPrzebieg());
            System.out.println("Przebieg do przeglądu: " + komis[i].getPrzebiegDoPrzegladu());
            System.out.println();
        }
        for (Samochod samochod : komis) {
            System.out.println(samochod);
            System.out.println();
        }


    }
}
