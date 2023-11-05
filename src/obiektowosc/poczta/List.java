package obiektowosc.poczta;

public class List {
    private Adres nadawca;
    private Adres odbiorca;
    private boolean czyPriorytetowy;
    private String status = "nie nadany";

    public List(Adres nadawcy, Adres odbiorcy) {
        nadawca = nadawcy;
        odbiorca = odbiorcy;
    }

    public double wyliczCene(){
        if (czyPriorytetowy){
           return 8.50;
        } else {
            return 6;
        }
    }

    @Override
    public String toString() {
        return "List{" +
                "nadawca=" + nadawca +
                ", odbiorca=" + odbiorca +
                ", czyPriorytetowy=" + czyPriorytetowy +
                ", status='" + status + '\'' +
                '}';
    }

    public void setStatus(String status){
        this.status = status;
    }

    public void setPriorytetowy(boolean priorytetowy) {
        czyPriorytetowy = priorytetowy;
    }
}
