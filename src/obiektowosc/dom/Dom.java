package obiektowosc.dom;

import java.util.Arrays;

public class Dom {
    private Pokoj[] pokoje;

    public Dom(Pokoj[] pokoje1){
        pokoje = pokoje1;
    }

    public String toString(){
        return Arrays.toString(pokoje);
    }
}
