package obiektowosc.ogrod;

import java.util.Random;

public class Kwiat {
    private boolean czyKwitnie;
    private String kolor;

    public Kwiat(String kolor){
        this.kolor = kolor;
    }

    public Kwiat(){
        String[] koloryKwiatow = {"czerwony", "fioletowy","żółty", "różowy" };
        Random losujKolor = new Random();
        kolor = koloryKwiatow[losujKolor.nextInt(koloryKwiatow.length)];
    }

    public void podlejKwiat(){
        czyKwitnie = true;
    }

    public void setCzyKwitnie(boolean czyKwitnie){
        this.czyKwitnie = czyKwitnie;
    }

    @Override
    public String toString() {
        return "Kwiat{" +
                "czyKwitnie=" + czyKwitnie +
                ", kolor='" + kolor + '\'' +
                '}';
    }
}
