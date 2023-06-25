package Ex1;

public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject("Produto1", 10.0);
        Cliente cliente = new Cliente("Cliente1");
        cliente.add_subject(subject);
        Gestor gestor = new Gestor("Gestor1");
        gestor.add_subject(subject);
        subject.setState(State.leilao);
        
        cliente.makeBid(100);
        
        //subject.setState(State.stock);
        
    }
    
}
