package obiektowosc.makao;


public class MakaoDemo {
    public static void main(String[] args) {
        grajWmakao();
        System.exit(0);

        //  List<Gracz> gracze = List.of(new Czlowiek(), new Komputer(), new Komputer());


    }

    public static void grajWmakao() {
        Gra makao = new Gra();
        KartyDoGry taliaKart = new KartyDoGry();

        makao.powitaj();
        makao.ustalLiczbeGraczy();

        taliaKart.potasujTalie(taliaKart.stworzTalieKart());
        makao.rozdajKarty(taliaKart.dajTalieKart());
        makao.wyswietlKartyPierwszegoGracza();

        makao.rozpocznijGre();

        Karta odslonietaKarta = taliaKart.usunKarteZtalii();
        makao.dolozKarteDoStosu(odslonietaKarta);
        int aktualnyIndex = 0;
        Gracz aktualny = makao.dajGracza(aktualnyIndex);
        aktualny.wykonajRuch(odslonietaKarta, taliaKart.dajPierwszaKarteZtalii(), makao.dajGraczy());


    }
}
