package metody;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ZapisywanieDoPliku {
    static String[] polscyAktorzyIAktorki =
            {"Andrzej Grabowski", "Janusz Gajos", "Anna Przybylska", "Franciszek Pieczka",
                    "Pola Negri", "Borys Szyc", "Joanna Kulig", "Jan Englert",
                    "Joanna Koroniewska", "Anita Sokołowska", "Katarzyna Figura", "Anna Dereszowska",
                    "Małgorzata Kożuchowska", "Adrianna Biedrzyńska", "Barbara Brylska", "Wacław Kowalski",
                    "Artur Żmijewski", "Adam Fidusiewicz", "Jerzy Cnota", "Mieczysław Hryniewicz"};

    static String[] aktorzy = new String[50];
    static String[] geografiaSwiata =
            {"Mauna Kea", "Morze Żółte", "Morze Arafura", "Ramla Bay",
                    "Sognefjorden", "Nanga Parbat", "Orinoko", "Zambezi",
                    "Rzeka Świętego Wawrzyńca", "Rio de Janeiro", "Belo Horizonte", "Kuala Lumpur",
                    "Ponta Delgada", "Dolina Śmierci", "Góry Brooksa", "Cieśnina Maltańska",
                    "Góry Kaledońskie", "Zatoka Botnicka", "Wielka Nizina Węgierska", "Góry Kantabryjskie"};
    static String[] jedzenie =
            {"Śledź pod pierzynką", "Sałatka jarzynowa", "Gulasz segedyński", "Ratatouille",
                    "Grzyby marynowane", "Czeburek", "Pierogi ruskie", "Zupa z dyni",
                    "Ciasto drożdżowe", "Omlet biszkoptowy", "Sznycel wiedeński", "Mizeria",
                    "Placek zbójnicki", "Placki ziemniaczane", "Jajka po benedyktyńsku", "Potrawka z królika",
                    "Kiszka ziemniaczana", "Zupa mleczna", "Wodzianka", "Barszcz ukraiński"};
    static String[] zwierzeta =
            {"Zając szarak", "Mysz domowa", "Morświn", "Norka amerykańska",
                    "Jeleń szlachetny", "Tchórz stepowy", "Mewa kanadyjska", "Koliberek czarnobrody",
                    "Sikora dwubarwna", "Wrona meksykańska", "Goryl górski", "Hipopotam nilowy",
                    "Słoń afrykański", "Wydra europejska", "Zebra sawannowa", "Dingo australijski ",
                    "Wombat tasmański", "Kangur rdzawoszyi", "Dziobak australijski", "Mrówkożer workowaty"};
    static String[] rosliny =
            {"Buk pospolity", "Daglezja zielona", "Klon jawor", "Lipa szerokolistna",
                    "Modrzew europejski", "Robinia akacjowa", "Sosna wejmutka", "Topola osika",
                    "Wiąz szypułkowy", "Wierzba biała", "Dziewanna fioletowa", "Fiołek ogrodowy",
                    "Goździk majowy", "Malwa różowa", "Niezapominajka", "Szałwia błyszcząca",
                    "Begonia królewska", "Filodendron", "Różanecznik indyjski", "Lubczyk ogrodowy"};

    public static void main(String[] args) {
       // czytajHaslaZpliku();
       // System.out.println(Arrays.toString(aktorzy));
        String nazwaPliku = "PUSTE_aktorzy.csv";
        wpiszHaslaDoPliku(nazwaPliku);
    }

    static String[] czytajHasla() {
        try {
            Scanner skanowanie = new Scanner(new File("aktorzy.txt"));
            while (skanowanie.hasNextLine()) {
                String hasla = skanowanie.nextLine();
                System.out.println(hasla);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku");
        }
        return null;
    }

    static void czytajHaslaZpliku() {
        try {
            Pattern znakRozdzielajacy = Pattern.compile(",|\n");
            Scanner scanner = new Scanner(new File("aktorzy.csv")).useDelimiter(znakRozdzielajacy);
            int pozycjaWtablicy = 0;
            while (scanner.hasNext()) {
                aktorzy[pozycjaWtablicy] = scanner.next();
                System.out.println(aktorzy[pozycjaWtablicy]);
                pozycjaWtablicy++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku");
        }
    }

    static void wpiszHaslaDoPliku(String nazwaPliku) {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(nazwaPliku);
            for (int i = 0; i < polscyAktorzyIAktorki.length; i++) {
                fileWriter.write(polscyAktorzyIAktorki[i]);
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Nie znaleziono pliku");
        }
    }
}
