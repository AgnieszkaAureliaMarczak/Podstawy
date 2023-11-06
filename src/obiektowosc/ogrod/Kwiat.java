package obiektowosc.ogrod;

import java.util.Random;

public class Kwiat {
    private boolean czyKwitnie;
    private String kolor;

    public Kwiat(String kolor){
        this.kolor = kolor;
    }

    public Kwiat(){
        String[] koloryKwiatow = new String[4];
        koloryKwiatow[0] = "czerwony";
        koloryKwiatow[1] = "fioletowy";
        koloryKwiatow[2] = "żółty";
        koloryKwiatow[3] = "różowy";
        Random losujKolor = new Random();
        this.kolor = koloryKwiatow[losujKolor.nextInt(0, 4)];
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
