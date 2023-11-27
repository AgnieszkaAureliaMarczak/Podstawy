package obiektowosc.makao;


public class MakaoDemo {
    public static void main(String[] args) {
        grajWmakao();
    }

    public static void grajWmakao() {
        Gra makao = new Gra();
        KartyDoGry taliaKart = new KartyDoGry();

        makao.powitaj();
        makao.ustalLiczbeGraczy();

        taliaKart.potasujTalie(taliaKart.stworzTalieKart());
        makao.rozdajKarty(taliaKart.dajTalieKart());


        makao.rozpocznijGre();
        Karta odslonietaKarta = taliaKart.usunPierwszaKarteZtalii();
        makao.dolozKarteDoStosu(odslonietaKarta);


        makao.wykonajRuch(odslonietaKarta, taliaKart.dajTalieKart());
    }
}
