package Ex1;

public class TermicBottle extends Container{

    private Portion p;

    public TermicBottle(Portion p) {
        this.p = p;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TermicBottle with portion: ");
        sb.append(p.toString());
        return sb.toString();
    }
    
}
