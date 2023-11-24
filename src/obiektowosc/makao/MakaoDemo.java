package obiektowosc.makao;


public class MakaoDemo {
    public static void main(String[] args) {
        gra

        /*FajniejszyScanner fajniejszyScanner = new FajniejszyScanner();
        int wybrana = fajniejszyScanner.pobierzLiczbe("Wybierz karte");
        System.out.println("wybrano"+ wybrana);

        List<Gracz> gracze = List.of(new Czlowiek(), new Komputer(), new Komputer());*/

      //  int aktualnyIndex = 1;
        //polimorfizm
        //Gracz aktualny = gracze.get(aktualnyIndex);
        //aktualny.wykonajRuch();
        /*for (Gracz aktualny : gracze) {
            aktualny.wykonajRuch();
        }*/








       // Gracz gracz1 = makao.dajPierwszegoGracza();

        makao.potasujKartyDoGry(makao.stworzTalieKart());
        makao.rozdajKarty();
        makao.wyswietlKartyPierwszegoGracza();
        makao.wykonajRuch(makao.odslonPierwszaKarte());
        System.out.println();
        makao.wykonajRuch2();
    }
    public void grajWmakao(){
        Gra makao = new Gra();
        makao.powitaj();
        makao.ustalLiczbeGraczy();
    }
}
