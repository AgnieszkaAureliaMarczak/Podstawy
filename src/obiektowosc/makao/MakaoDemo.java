package obiektowosc.makao;

public class MakaoDemo {
    public static void main(String[] args) {
        Gra makao = new Gra();
        makao.powitaj();
        makao.ustalLiczbeGraczy();
        makao.potasujKartyDoGry(makao.stworzTalieKart());
        makao.rozdajKarty();
        makao.wyswietlKartyPierwszegoGracza();
        makao.wykonajRuch(makao.odslonPierwszaKarte());
        System.out.println();
        makao.wykonajRuch2();
      //  Czlowiek gracz1 = new Czlowiek();
      //  gracz1.wykonajRuch();


    }
}
