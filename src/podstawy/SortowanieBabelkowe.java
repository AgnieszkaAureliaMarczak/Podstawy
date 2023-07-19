package podstawy;

public class SortowanieBabelkowe {
    public static void main(String[] args) {
        int[] babelki = {-8, -75, 123, 96, 42, 63, 769, -12, -76, 6666, 124};
        int temp;
        int counter = 0;
        for (int i = 0; i < babelki.length; i++) {
            for (int j = i + 1; j < babelki.length - i; j++) { // jeden mniej niż ostatnio bo właśnie jedną ustawiliśmy na końcu na jej własciwej pozycji
                counter++;
                if (babelki[i] > babelki[j]) {
                    temp = babelki[i];
                    babelki[i] = babelki[j];
                    babelki[j] = temp;
                }
            }
        }
        for (int numer : babelki) {
            System.out.println(numer);
        }
        System.out.println(counter); // ile razy pętla się wykonuje
    }
}
