package obiektowosc.ogrod;

import java.util.Random;

public class Drzewo {
    Random random = new Random();
    private int iloscOwocow = random.nextInt(100, 1001);

    public void owocuj() {
        int iloscNowychOwocow = random.nextInt(1, 101);
        System.out.println("Przybylo " + iloscNowychOwocow + " nowych owoców.");
        iloscOwocow += iloscNowychOwocow;
    }

    public int zbierajOwoce() {
        int aktualnaIloscOwocow = iloscOwocow;
        iloscOwocow = 0;
        return aktualnaIloscOwocow;
    }

    @Override
    public String toString() {
        return "Drzewo{" +
                "iloscOwocow=" + iloscOwocow +
                '}';
    }
}
