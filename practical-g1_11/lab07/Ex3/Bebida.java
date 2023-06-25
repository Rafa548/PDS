package Ex3;

public class Bebida extends ProdutoInterface{

    private String name;
    private int weight;

    public Bebida(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public void draw() {
        System.out.println(indent + "Bebida: " + name + " (" + weight + "g)");
    }

}
