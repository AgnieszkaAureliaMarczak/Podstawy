package obiektowosc.poczta;

public class DaneDoLosowania {
    private String[] nadawcy = {"Jan", "Anna", "Marek", "Katarzyna", "Piotr",
            "Marta", "Wojciech", "Agnieszka", "Krzysztof", "Elżbieta"};

    private String[] odbiorcy = {"Zygmunt", "Stanisława", "Hipolit", "Eleonora", "Bogumił",
            "Edyta", "Władysław", "Zdzisława", "Wacława", "Rajmund"};

    private double[] wagaPaczki = {5.85, 47.10, 15.00, 23.65, 2.15,
            79.45, 8.96, 7.75, 45.63, 3.14};

    public String[] getNadawcy() {
        return nadawcy;
    }

    public String[] getOdbiorcy() {
        return odbiorcy;
    }

    public double[] getWagaPaczki() {
        return wagaPaczki;
    }
}
