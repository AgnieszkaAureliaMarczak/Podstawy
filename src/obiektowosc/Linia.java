package obiektowosc;

public class Linia {
    int dlugosc;
    char wypelnienie;
    public Linia(int dlugosc, char wypelnienie){
        this.dlugosc = dlugosc;
        this.wypelnienie = wypelnienie;
    }

    public void drukujLinie(){
        for (int i = 0; i < dlugosc; i++) {
            System.out.print(wypelnienie);
        }
    }
    public String toString(){
        return "Długość linii: " + dlugosc + "\nWypełnienie linii: " + wypelnienie;
    }
    public static void main(String[] args) {
        Linia linia1 = new Linia(10,'P');
        Linia linia2 = new Linia(5,'u');
        Linia linia3 = new Linia(8,'g');

        linia1.dlugosc = 10;
        linia2.dlugosc = 15;
        linia3.dlugosc = 20;

        linia1.wypelnienie = '*';
        linia2.wypelnienie = '@';
        linia3.wypelnienie = '#';

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
