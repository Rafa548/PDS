package Ex1;

public class PlasticBottle extends Container{
    private Portion p;


    public PlasticBottle(Portion p) {
        this.p = p;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PlasticBottle with portion: ");
        sb.append(p.toString());
        return sb.toString();
    }
}
