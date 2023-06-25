package Ex3;

public abstract class ProdutoInterface {
    protected static StringBuffer indent = new StringBuffer();
    public abstract void draw();
    public abstract int getWeight();
}
