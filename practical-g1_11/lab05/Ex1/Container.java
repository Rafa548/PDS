package Ex1;

public class Container {
    public static Container create(Portion p){
        if (p.getState() == State.Liquid){
            if (p.getTemperature() == Temperature.WARM){
                return new TermicBottle(p);
            } 
            else {
                return new PlasticBag(p);
            }
        } else if (p.getState() == State.Solid){
            if (p.getTemperature() == Temperature.COLD){
                return new PlasticBag(p);
            } 
            else {
                return new Tupperware(p);
            }
        }
        return null;
    }
}
