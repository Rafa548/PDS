package Ex2;

public class Cake{
    
    private Shape shape;
    private String cakeLayer;
    private int numCakeLayers;
    private Cream midLayerCream;
    private Cream topLayerCream;
    private Topping topping;
    private String message;

    public Cake(Shape shape, String cakeLayer, int numCakeLayers, Cream midLayerCream, Cream topLayerCream, Topping topping, String message) {
        this.shape = shape;
        this.cakeLayer = cakeLayer;
        this.numCakeLayers = numCakeLayers;
        this.midLayerCream = midLayerCream;
        this.topLayerCream = topLayerCream;
        this.topping = topping;
        this.message = message;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.cakeLayer);
        if (this.numCakeLayers == 1) {
            sb.append(" with " + this.numCakeLayers + " layer");
        }
        else
            sb.append(" with " + this.numCakeLayers + " layers");
        if (this.midLayerCream != null) {
            sb.append(" and " + this.midLayerCream);
        }
        if (this.topLayerCream != null) {
            sb.append(", topped with " + this.topLayerCream + " and " +  this.topping + ".");
        }
        else 
            sb.append(", topped with " + this.topping + ".");

        sb.append(" Message says: " + '"' + this.message + '"');
        return sb.toString();
    }
    
}
