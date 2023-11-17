package obiektowosc.makao;

public class MakaoDemo {
    public static void main(String[] args) {
        Gra makao = new Gra();
        makao.powitaj();
        makao.ustalLiczbeGraczyIprzygotujIchTabliceKart();
        makao.potasujTalieKart(makao.stworzTalieKart());
        makao.rozdajKarty();
        makao.wyswietlKartyGracza();
        makao.rozpocznijGre();
        makao.wykonajRuch();
    }
}
