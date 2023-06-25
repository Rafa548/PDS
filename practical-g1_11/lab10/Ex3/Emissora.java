package Ex3;

public class Emissora extends User{

    public Emissora(Mediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void send(String message) {
        System.out.println("Emissora " + this.name + " sent: " + message);
        mediator.send(message, this);
    }

    @Override
    public void receive(String message) {
        System.out.println("Emissora " + this.name + " received: " + message);
    }
    
}
