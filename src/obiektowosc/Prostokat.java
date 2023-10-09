package obiektowosc;

public class Prostokat {
    int wysokosc;
    int szerokosc;
    char wypelnienie;
    public Prostokat(int wysokosc, int szerokosc, char wypelnienie){
        this.wysokosc = wysokosc;
        this.szerokosc = szerokosc;
        this.wypelnienie = wypelnienie;
    }

    public void drukujProstokat(){
        for (int i = 0; i < wysokosc; i++) {
            for (int j = 0; j < szerokosc; j++) {
                System.out.print(wypelnienie);
            }
            System.out.println();
        }
    }
    public String toString(){
        return "Szerokosc: " + szerokosc +"\nWysokosc: "+ wysokosc + "\nWypełnienie: " + wypelnienie;
    }

    public static void main(String[] args) {
        Prostokat prostokat1 = new Prostokat(9,12,'k');
        Prostokat prostokat2 = new Prostokat(4,8,'h');
        prostokat1.szerokosc = 8;
        prostokat1.wysokosc = 5;
        prostokat1.wypelnienie = '&';
        prostokat2.szerokosc = 6;
        prostokat2.wysokosc = 3;
        prostokat2.wypelnienie = '%';
        prostokat1.drukujProstokat();
        System.out.println();
        prostokat2.drukujProstokat();
        System.out.println(prostokat1);
        System.out.println(prostokat2);;
    }
}
