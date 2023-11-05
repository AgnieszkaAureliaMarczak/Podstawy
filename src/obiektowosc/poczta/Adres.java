package obiektowosc.poczta;

public class Adres {
    private String ulica;
    private int numerDomu;
    private String kodPocztowy;

    public Adres(String ulica, int numerDomu, String kodPocztowy){
        this.ulica= ulica;
        this.numerDomu = numerDomu;
        this.kodPocztowy = kodPocztowy;
    }

    @Override
    public String toString() {
        return "Adres{" +
                "ulica='" + ulica + '\'' +
                ", numerDomu=" + numerDomu +
                ", kodPocztowy='" + kodPocztowy + '\'' +
                '}';
    }
}
