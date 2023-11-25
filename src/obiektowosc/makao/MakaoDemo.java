package obiektowosc.makao;


public class MakaoDemo {
    public static void main(String[] args) {
        grajWmakao();


        System.exit(0);

        //  List<Gracz> gracze = List.of(new Czlowiek(), new Komputer(), new Komputer());

        //polimorfizm
        //Gracz aktualny = gracze.get(aktualnyIndex);
        //aktualny.wykonajRuch();
       /* for (Gracz aktualny : gracze) {
            aktualny.wykonajRuch();
        }*/


        //  makao.wykonajRuch(makao.odslonPierwszaKarte());
        System.out.println();
        //  makao.wykonajRuch2();
    }

    public static void grajWmakao() {
        Gra makao = new Gra();
        KartyDoGry taliaKart = new KartyDoGry();

        makao.powitaj();
        makao.ustalLiczbeGraczy();

        taliaKart.potasujTalie(taliaKart.stworzTalieKart());
        makao.rozdajKarty(taliaKart.dajTalieKart());
        makao.wyswietlKartyPierwszegoGracza();

        int aktualnyIndex = 0;
        Gracz aktualny = makao.dajGracza(aktualnyIndex);
        makao.odslonPierwszaKarte(taliaKart.dajPierwszaKarte());

        //aktualny.wykonajRuch();

    }
}
