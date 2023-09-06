package podstawy;

public class Testy3 {
    public static void main(String[] args) throws Exception{

        System.out.println(Program.addUp(5));
        System.out.println(Program.silniaPrzezRekurencje(4));
        int numRows = 10;
        int numCols = 10;
        int playerShips;
        int computerShips;
        String[][] grid = new String[numRows][numCols];
        int[][] missedGuesses = new int[numRows][numCols];

        System.out.print("  ");
        for(int i = 0; i < numCols; i++)
            System.out.print(i);
        System.out.println();

        //Middle section of Ocean Map
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = " ";
                if (j == 0)
                    System.out.print(i + "|" + grid[i][j]);
                else if (j == grid[i].length - 1)
                    System.out.print(grid[i][j] + "|" + i);
                else
                    System.out.print(grid[i][j]);
            }
            System.out.println();
        }

        //Last section of Ocean Map
        System.out.print("  ");
        for(int i = 0; i < numCols; i++)
            System.out.print(i);
        System.out.println();

     /*   String linia = "";
        for (int i = 0; i < 10; i++) {
            linia += "8";
            System.out.println(linia);
        }*/

        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("8");
            }
            System.out.println();
        }
    }
    public static class Program {

        public static int silniaPrzezRekurencje(int n){
            if (n>0){
                return silniaPrzezRekurencje(n-1) * n;
            } else {
                return 1;
            }
        }
        public static int suma(int liczba){
            int suma = 0;
            while (liczba>0){
                suma+=liczba;
                liczba--;
            }
            return suma;
        }

        public static int addUp(int num) {
            if (num > 0) {
                return addUp(num - 1) + num;
            } else {
                return num;
            }
        }
    }
}
