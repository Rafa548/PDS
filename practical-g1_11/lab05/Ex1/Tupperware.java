package Ex1;

public class Tupperware extends Container{
    private Portion p;


    public Tupperware(Portion p) {
        this.p = p;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tupperware: ");
        sb.append(p.toString());
        return sb.toString();
    }
}
