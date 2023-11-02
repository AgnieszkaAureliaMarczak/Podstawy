package obiektowosc;

public class Prostokat {
    private int wysokosc;
    private int szerokosc;
    private char wypelnienie;
    public Prostokat(int wysokosc, int szerokosc, char wypelnienie){
        this.wysokosc = wysokosc;
        this.szerokosc = szerokosc;
        this.wypelnienie = wypelnienie;
    }

    public int getWysokosc() {
        return wysokosc;
    }

    public void setWysokosc(int wysokosc) {
        this.wysokosc = wysokosc;
    }

    public int getSzerokosc(){
        return szerokosc;
    }

    public void setSzerokosc(int szerokosc){
        this.szerokosc = szerokosc;
    }

    public char getWypelnienie() {
        return wypelnienie;
    }

    public void setWypelnienie(char wypelnienie){
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
        prostokat1.setSzerokosc(8);
        prostokat1.setWysokosc(5);
        prostokat1.setWypelnienie('#');
        prostokat2.setSzerokosc(6);
        prostokat2.setWysokosc(3);
        prostokat2.setWypelnienie('%');
        prostokat1.drukujProstokat();
        System.out.println();
        prostokat2.drukujProstokat();
        System.out.println(prostokat1);
        System.out.println(prostokat2);;
    }
}
