package Ex1;

public class PlasticBag extends Container{
    private Portion p;


    public PlasticBag(Portion p) {
        this.p = p;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PlasticBag with portion: ");
        sb.append(p.toString());
        return sb.toString();
    }
}
