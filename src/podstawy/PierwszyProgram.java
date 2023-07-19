package podstawy;

import metody.Narzedzia;
import podstawy.Kalkulator;

public class PierwszyProgram {
    //    public static void main(String[]args){
//        System.out.println("Moj pierwszy program");
//    }
    public static void main(String[] args) {
        System.out.println("Hello World!");

        String s1 = "Zaczynam naukę na\\ kursie: \"Java od Podstaw\"";
        String s2 = "Pora więc na podstawy";
        String s3 = "J";
        String s4 = "A";
        String s5 = "V";
        String s6 = "Y";

        String J = s3.indent(6);
        String A = s4.indent(6);
        String V = s5.indent(6);
        String Y = s6.indent(6);

       // System.out.println(s3 + s4);

       System.out.println(s1 + "\n" + s2 + "\n\n" + J + A + V + Y);

     //  Kalkulator.BMI(34,45);
      //  System.out.println(Narzedzia.skrocTablice());
    }
}
