package podstawy;

public class Literaly {

    public static void main(String[]args){
//      Ćwiczenie 3
    /*    int a = -2, b = 3,c = a+b;

        System.out.println(c);
        System.out.println(-2+3);

        String s = "tekst";
        System.out.println(c+s);
        System.out.println("-2"+3);

        System.out.println(3+3.2);

        boolean wynik = a>b;
        System.out.println(wynik);

//      Ćwiczenie 4

        System.out.println(2+2);

        int z = 10 + 20;
        double m = z/7.0;
        System.out.println(m);
//        double m = 4.285714285714286;
        System.out.format("%.11f%n",m);

        System.out.print("10 + 20 to " + z + "\n" + "30/7 daje ");
        System.out.format("%.11f%n",m);*/

      //  int potega = (int)Math.pow(15,2);
      // int liczba = (int) Math.round(15.4);
      //  System.out.println(potega);
      //  boolean rezultat = potega>100;
      //  System.out.println("Czy wynik równania jest większy od 100: " + rezultat + " ");


      //  int z = 10 + 20;
      //  double m = z/7.0;

      //  System.out.format("%.2f dfgdfg\n",m);


        //pojedyncza liczba rezerwuje miejsce na te dane
         System.out.printf("%5d %5s\n", 123,"abc");
         System.out.printf("%5d %5s\n", 1,"ac");
         System.out.printf("%5d %5s\n", 123,"abc");
         System.out.printf("%5d %5s\n", 1234,"abc");
         System.out.printf("%5d %5s\n", 123,"abc");
         System.out.printf("%5d %5s\n", 12,"abc");
         System.out.printf("%5d %5s\n", 123,"abcc");
         System.out.printf("%5d %5s\n", 123,"abc");

        String text = String.format("%5d %5s\n", 123, "abc"); //zamiast drukować generuje String
        System.out.println(text);
        System.out.println(text.toUpperCase());

        byte byte1 = (byte)128345346;
        System.out.println(byte1);

        int asciiCode = 97;
        char symbol = (char)(asciiCode + 1);
        System.out.println(symbol);

       System.out.println(10/6.0);



    }

}
