package Ex1;

import java.util.ArrayList;
import java.util.List;

public class Gestor extends Observer{

    private List<Subject> subjects = new ArrayList<>();
    private List<Subject> emleilao = new ArrayList<>();
    private List<Subject> stock = new ArrayList<>();
    private List<Subject> vendidos = new ArrayList<>();


    private String name;

    public Gestor(String name ) {
        this.name = name;
    }

    public void add_subject(Subject s) {
        s.attach(this);
        subjects.add(s);
    }

    @Override
    public void update(String opt, Subject subject) {
        if (opt.equals("bid")){
            System.out.println("Gestor: New Bid " + subject.getPreco());
        }
        if (opt.equals("State"))
            System.out.println("Gestor: New State " + subject.getState());
        if (subject.getState() == State.stock){
            stock.add(subject);
        }
        else if(subject.getState() == State.leilao){
            stock.remove(subject);
            emleilao.add(subject);
        }else{
            emleilao.remove(subject);
            vendidos.add(subject);
        }
        
    }
    
}
