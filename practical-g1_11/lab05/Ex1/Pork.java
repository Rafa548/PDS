package Ex1;

public class Pork implements Portion{

    public Pork(){
    }

    public Temperature getTemperature() {
        return Temperature.WARM;
    }

    public State getState() {
        return State.Solid;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pork: ");
        sb.append("Temperature " + getTemperature());
        sb.append(", State " + getState());
        return sb.toString();
    }
}
