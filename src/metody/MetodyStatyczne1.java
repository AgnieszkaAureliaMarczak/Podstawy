package metody;

import java.util.Random;

public class MetodyStatyczne1 {
    public static void main(String[] args) {

       int liczba = ulubionaLiczba(15);
       System.out.println(liczba);

       System.out.println(sumaTrzechLiczb(5,2,1));

       System.out.println(losujLiczbe());

        System.out.println(policzDni(5));
    }
    static int ulubionaLiczba(int mojaLiczba){
        return mojaLiczba;
    }
    static int sumaTrzechLiczb(int liczba1, int liczba2, int liczba3){
        return liczba1 + liczba2 + liczba3;
    }
    static int losujLiczbe(){
        Random losowanie = new Random();
        return losowanie.nextInt(1,11);
    }
    static int policzDni(int iloscLat){
        return iloscLat*365;
    }
}
