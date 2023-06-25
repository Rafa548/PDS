package Ex3;

public class Doce extends ProdutoInterface{

    private String name;
    private int weight;

    public Doce(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
    
    @Override
    public void draw() {
        System.out.println(indent + "Doce: " + name + " (" + weight + "g)");
    }



}
