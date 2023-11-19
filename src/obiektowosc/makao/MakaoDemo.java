package obiektowosc.makao;

public class MakaoDemo {
    public static void main(String[] args) {
        Gra makao = new Gra();
        makao.powitaj();
        makao.ustalLiczbeGraczy();
        makao.potasujKartyDoGry(makao.stworzTalieKart());
        makao.rozdajKarty();
        makao.wyswietlKartyGracza();
        makao.wykonajRuch(makao.odslonPierwszaKarte());
      //  Czlowiek gracz1 = new Czlowiek();
      //  gracz1.wykonajRuch();


    }
}
