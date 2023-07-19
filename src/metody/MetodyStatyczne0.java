package metody;

public class MetodyStatyczne0 {
    public static void main(String[] args) {
        przywitaj();
        przywitaj("Ania");
        przywitaj("Paweł");
        drukujTekst("Uczę się metod.", 5);
        przywitajPasujaco("Kamil", 15);
        przywitajPasujaco("Kacper", -2);
        przywitajPasujaco("Błażej", 65);
        String[] imiona = {"Ania", "Leon", "Kazimierz", "Zosia", "Alicja", "Krysia"};
        przywitaj(imiona);
        wyliczCene(10, 2, 20);
    }

    static void przywitaj() {
        System.out.println("Hello");
    }

    static void przywitaj(String imie) {
        System.out.println("Cześć " + imie + "!");
    }

    static void drukujTekst(String tekst, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(tekst);
        }
    }

    static void przywitajPasujaco(String imie, int wiek) {
        if (wiek > 0 && wiek <= 20) {
            System.out.println("Cześć " + imie);
        } else if (wiek > 20) {
            System.out.println("Dzień dobry " + imie);
        } else {
            System.out.println("Podany wiek jest niepoprawny.");
        }
    }

    static void przywitaj(String[] imiona) {
        for (String osoba : imiona) {
            System.out.println("Cześć " + osoba);
        }
    }

    static void wyliczCene(int sztukiTowaru, int cena, int procentowyPodatek) {
        double podatek = (procentowyPodatek / 100.00) * cena;
        double lacznaCena = (cena + podatek) * sztukiTowaru;
        boolean darmowaWysylka = false;
        if (lacznaCena > 100) {
            darmowaWysylka = true;
        }
        wyswietlKoszt(lacznaCena, darmowaWysylka);
    }

    static void wyswietlKoszt(double lacznaCena, boolean darmowaWysylka) {
        System.out.println("Łączna cena do zapłaty wynosi: " + lacznaCena + ".");
        double lacznyKoszt = 10 + lacznaCena;
        if (darmowaWysylka) {
            System.out.println("Wysyłka jest darmowa.");
        } else {
            System.out.println("Koszt wysyłki wynosi 10zl. Razem: " + lacznyKoszt);
        }
    }
}
