package obiektowosc.ogrod;

public class Lawka {
    private String material;

    public Lawka(String material) {
        this.material = material;
    }

    public String getMaterial(){
        return material;
    }
    @Override
    public String toString() {
        return "Lawka{" +
                "material='" + material + '\'' +
                '}';
    }
}
