package obiektowosc.pies;

public class PiesDemo {
    public static void main(String[] args) {
        Pies pies1 =  new Pies("Kluska", "dalmatyńczyk", 3);
        Pies pies2 = new Pies("Jogurt", "owczarek niemiecki", 5);
        System.out.println(pies1);
        System.out.println(pies2);

        pies1.szczekaj("How, how");
        System.out.println(pies1.ileJedzeniaDziennieWkg(pies1.getWaga()));

        OpiekunPsa opiekun1 = new OpiekunPsa();

        System.out.println("Nakarm Jogurta:\n" +
                "Podaj " + pies2.ileJedzeniaDziennieWkg(pies2.getWaga()) + "kg jedzenia.");
        opiekun1.nakarmPsa(pies2);
        System.out.println(pies2.isCzyNakarmiony());
        System.out.println("Waga Jogurta po nakarmieniu: " + pies2.getWaga() + "kg.");
    }
}
