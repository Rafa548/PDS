package Ex2;

public class SpongeCakeBuilder implements CakeBuilder {
     
    private Shape shape;
    private String cakeLayer;
    private int numCakeLayers;
    private Cream midLayerCream;
    private Cream topLayerCream;
    private Topping topping;
    private String message;
    private Cake cake;

    public void setCakeShape(Shape shape) {
        this.shape = shape;
    }

    public void addCakeLayer() {
        this.cakeLayer = "Sponge cake";
        this.numCakeLayers++;
    }

    public void addCreamLayer() {
        this.midLayerCream = Cream.Red_Berries;
    }

    public void addTopLayer() {
        this.topLayerCream = Cream.Whipped_Cream;
    }

    public void addTopping() {
        this.topping = Topping.Fruit;
    }

    public void addMessage(String m) {
        this.message = m;
    }

    public void createCake() {
        this.cake = new Cake(this.shape, this.cakeLayer, this.numCakeLayers, this.midLayerCream, this.topLayerCream, this.topping, this.message);
    }

    public Cake getCake() {
        return this.cake;
    }
    
    
}
