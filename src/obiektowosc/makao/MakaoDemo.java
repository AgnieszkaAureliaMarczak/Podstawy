package obiektowosc.makao;


public class MakaoDemo {
    public static void main(String[] args) {
        grajWmakao();


        //  List<Gracz> gracze = List.of(new Czlowiek(), new Komputer(), new Komputer());

    }

    public static void grajWmakao() {
        Gra makao = new Gra();
        KartyDoGry taliaKart = new KartyDoGry();

        makao.powitaj();
        makao.ustalLiczbeGraczy();

        taliaKart.potasujTalie(taliaKart.stworzTalieKart());
        makao.rozdajKarty(taliaKart.dajTalieKart());

        makao.dajGracza(0).wyswietlKarty();
        makao.dajGracza(1).wyswietlKarty();


        makao.rozpocznijGre();
        Karta odslonietaKarta = taliaKart.usunPierwszaKarteZtalii();
        makao.dolozKarteDoStosu(odslonietaKarta);


        makao.wykonajRuch(odslonietaKarta, taliaKart.dajTalieKart());

    }
}
