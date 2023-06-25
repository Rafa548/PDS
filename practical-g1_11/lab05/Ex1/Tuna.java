package Ex1;

public class Tuna implements Portion{

    public Tuna(){
    }

    public Temperature getTemperature() {
        return Temperature.COLD;
    }

    public State getState() {
        return State.Solid;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tuna: ");
        sb.append("Temperature " + getTemperature());
        sb.append(", State " + getState());
        return sb.toString();
    }
}
