package Ex3;

public class Espectador extends User{

    public Espectador(Mediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void send(String message) {
        System.out.println("Espectador " + this.name + " sent: " + message);
        mediator.send(message, this);
    }

    @Override
    public void receive(String message) {
        System.out.println("Espectador " + this.name + " received: " + message);
    }
    
}
