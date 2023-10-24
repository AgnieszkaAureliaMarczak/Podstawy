package obiektowosc;

public class Linia {
    private int dlugosc;
    private char wypelnienie;

    public Linia(int dlugosc, char wypelnienie) {
        this.dlugosc = dlugosc;
        this.wypelnienie = wypelnienie;
    }

    public Linia() {
    }

    public void setDlugosc(int dlugosc) {
        this.dlugosc = dlugosc;
    }

    public int getDlugosc() {
        return dlugosc;
    }

    public void setWypelnienie(char wypelnienie) {
        this.wypelnienie = wypelnienie;
    }

    public char getWypelnienie() {
        return wypelnienie;
    }

    public void drukujLinie() {
        for (int i = 0; i < dlugosc; i++) {
            System.out.print(wypelnienie);
        }
    }

    public String toString() {
        return "Długość linii: " + dlugosc + "\nWypełnienie linii: " + wypelnienie;
    }

    public static void main(String[] args) {
        Linia linia1 = new Linia(10, 'P');
        Linia linia2 = new Linia(5, 'u');
        Linia linia3 = new Linia(8, 'g');

        linia1.setDlugosc(10);
        linia2.setDlugosc(15);
        linia3.setDlugosc(20);

        linia1.setWypelnienie('*');
        linia2.setWypelnienie('@');
        linia3.setWypelnienie('#');

        linia1.drukujLinie();
        System.out.println();
        linia2.drukujLinie();
        System.out.println();
        linia3.drukujLinie();
        System.out.println();

        System.out.println("Linia 1: " + linia1);
        System.out.println("Linia 2: " + linia2);
    }
}
