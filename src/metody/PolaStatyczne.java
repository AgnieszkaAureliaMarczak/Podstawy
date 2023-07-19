package metody;

public class PolaStatyczne {
    private static String dna = "agtcatcattaacttactgcatgtcactta";

    public static void main(String[] args) {
        zapiszDuzymi();
        System.out.println(dna);
        System.out.println(zamienLitery());
        System.out.println(skrocKod());
        System.out.println(wstawSpacje());
    }

    private static void zapiszDuzymi() {
        dna = dna.toUpperCase();
    }

    private static String zamienLitery() {
        return dna.toUpperCase().replace('A', 'T').replace('G', 'C');
    }

    private static String skrocKod() {
        return dna.substring(0, 15);
    }

    private static String wstawSpacje() {
        String spacja = " ";
        String nowyDna = "";

      /*  nowyDna = dna.substring(0, 3).concat(spacja);
        nowyDna += dna.substring(3, 6).concat(spacja);
        nowyDna += dna.substring(6, 9).concat(spacja);
        nowyDna += dna.substring(9, 12).concat(spacja);
        nowyDna += dna.substring(12, 15).concat(spacja);
        nowyDna += dna.substring(15, 18).concat(spacja);
        nowyDna += dna.substring(18, 21).concat(spacja);
        nowyDna += dna.substring(21, 24).concat(spacja);
        nowyDna += dna.substring(24, 27).concat(spacja);
        nowyDna += dna.substring(27, 30).concat(spacja);*/

        for (int i = 0; i < dna.length(); i += 3) {
            if (i <= dna.length() - 3) {
                nowyDna += dna.substring(i, i + 3).concat(spacja);
            }
        }
        return nowyDna;
    }
}
