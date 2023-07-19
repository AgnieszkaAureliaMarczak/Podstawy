package podstawy;

public class Kalkulator {

    public static void main(String[]args){
    /*
        Ćwiczenie 5
        int a = 20, b = 5, c = 12;
        int d = a + b + c;
        System.out.println("Podane liczby to: " + a + ", " + b + ", " + c + " a ich suma wynosi: " + d + "!");

        Ćwiczenie 6
        int minuty = 33;
        int sekundy = minuty*60;
        int godziny = minuty/60;
        int sekundy1 = (minuty%60)*60;
//        System.out.println(sekundy);
        System.out.println(godziny);
        System.out.println(sekundy1);

        Ćwiczenie 7
        dolar(20);
        euro(20);
        Ćwiczenie 8*/



      BMI(63.5,1.75);
       
    }
    int pln;
    public static void dolar(int pln){
        double kursDolara = 0.24*pln;
        System.out.println(pln + " pln to " + kursDolara + " dolarów.");
    }
    public static void euro(int pln){
        double kursEuro = 0.21*pln;
        System.out.println(pln + " pln to " + kursEuro + " Euro.");
    }

//     Ćwiczenie 8
    double waga;
    double wzrost;
    public static void BMI(double waga,double wzrost){
        System.out.println("Waga wynosi " + waga + " kilogramów.");
        System.out.println("Wzrost wynosi " + wzrost + " metra.");
        System.out.println("Obliczam BMI...");
        double bmi = waga/Math.pow(wzrost,2);
        System.out.println("BMI wynosi " + bmi + ".");
        System.out.println("Sprawdzam czy twoje BMI jest prawidłowe...");
        if (bmi>24.90){
            System.out.println("Niestety, masz nadwagę. :( ");
        } else if (bmi<18.50) {
            System.out.println("Niestety, masz niedowagę. :(");
        } else {
            System.out.println("Gratulacje. Twoja waga jest prawidłowa!");
        }
    }

}
