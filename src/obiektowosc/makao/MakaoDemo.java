package obiektowosc.makao;


public class MakaoDemo {
    public static void main(String[] args) {
        grajWmakao();




        System.exit(0);

      //  List<Gracz> gracze = List.of(new Czlowiek(), new Komputer(), new Komputer());

      //  int aktualnyIndex = 1;

        //polimorfizm
        //Gracz aktualny = gracze.get(aktualnyIndex);
        //aktualny.wykonajRuch();
       /* for (Gracz aktualny : gracze) {
            aktualny.wykonajRuch();
        }*/








       // Gracz gracz1 = makao.dajPierwszegoGracza();

      //  makao.potasujKartyDoGry(makao.stworzTalieKart());
      //  makao.wyswietlKartyPierwszegoGracza();
      //  makao.wykonajRuch(makao.odslonPierwszaKarte());
        System.out.println();
      //  makao.wykonajRuch2();
    }

    public static void grajWmakao(){
        Gra makao = new Gra();
        TaliaKart taliaKart = new TaliaKart();

        makao.powitaj();
        makao.ustalLiczbeGraczy();
        taliaKart.potasujTalie(taliaKart.stworzTalieKart());
        makao.rozdajKarty(taliaKart.dajTalieKart());
        makao.wyswietlKartyPierwszegoGracza();
    }
}
