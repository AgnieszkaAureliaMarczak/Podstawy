package podstawy;

public class Tablice2 {
    public static void main(String[] args){
        //Ćwiczenie 8
        int[] noweLiczby = {1, 56, 896, 452, 3, 741, 23, 78, 996, 1000};
        int index = 0;
         /* while( index < noweLiczby.length ){
            System.out.println(noweLiczby[index]);
            index++;
        }*/
       /* while ( index < noweLiczby.length ){
            if ( noweLiczby[index] > 100 ){
                System.out.println(noweLiczby[index]);
            }
            index++;
        } */
      /*  while ( index < noweLiczby.length ){
            if ( noweLiczby[index] % 2 != 0 && noweLiczby[index] < 750){
                System.out.println(noweLiczby[index]);
            }
            index++;
        } */
        int suma = 0;
        while ( index < noweLiczby.length ){
            suma += noweLiczby[index];
            index++;
        }
        System.out.println((double) suma/ noweLiczby.length);
    }
}
