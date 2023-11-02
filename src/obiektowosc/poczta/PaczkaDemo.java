package obiektowosc.poczta;

public class PaczkaDemo {
    public static void main(String[] args) {
        Paczka pierwszaPaczka = new Paczka("","Jan Kowalski", 15.7);
        System.out.println(pierwszaPaczka);

        Paczka drugaPaczka = new Paczka();
        System.out.println(drugaPaczka);

    }

}
