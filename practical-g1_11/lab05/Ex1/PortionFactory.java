package Ex1;

public class PortionFactory {
    public static Portion create(String name, Temperature temp) {
        if (name.equals("Meat") && temp.equals(Temperature.COLD)) {
            return new Tuna();
        }
        else if (name.equals("Beverage") && temp.equals(Temperature.COLD)) {
            return new Fruit_juice();
        }
        else if (name.equals("Meat") && temp.equals(Temperature.WARM)) {
            return new Pork();
        }
        else if (name.equals("Beverage") && temp.equals(Temperature.WARM)) {
            return new Milk();
        }
        else {
            return null;
        }
    }
    public static Portion create(String name, Temperature temp, String fruit) {
        if (name.equals("Beverage") && temp.equals(Temperature.COLD)) {
            return new Fruit_juice(fruit);
        }
        else
            return null;
        
    }
}
