package Ex1;

public class Milk implements Portion{
    public Milk(){
    }

    public Temperature getTemperature() {
        return Temperature.WARM;
    }

    public State getState() {
        return State.Liquid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Milk: ");
        sb.append("Temperature " + getTemperature());
        sb.append(", State " + getState());
        return sb.toString();
    }
    
}
