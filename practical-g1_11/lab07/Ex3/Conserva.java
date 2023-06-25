package Ex3;

public class Conserva extends ProdutoInterface{

    private String name;
    private int weight;

    public Conserva(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public void draw() {
        System.out.println(indent + "Conserva: " + name + " (" + weight + "g)");
    }

}
