package Ex1;


public class Fruit_juice implements Portion{
    private String fruit;

    public Fruit_juice(){
        this.fruit = "Orange";
    }

    public Fruit_juice(String fruit){
        this.fruit = fruit;
    }

    public Temperature getTemperature() {
        return Temperature.COLD;
    }

    public State getState() {
        return State.Liquid;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FruitJuice: ");
        sb.append(fruit);
        sb.append(", Temperature " + getTemperature());
        sb.append(", State " + getState());
        return sb.toString();
    }
}
