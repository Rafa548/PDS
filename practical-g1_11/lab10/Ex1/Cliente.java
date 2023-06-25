package Ex1;


import java.util.ArrayList;
import java.util.List;


public class Cliente extends Observer{

    private List<Subject> subjects = new ArrayList<>();
    private String name;


    public Cliente(String name) {
        this.name = name;
    }

    public void add_subject(Subject s) {
        s.attach(this);
        subjects.add(s);
    }

    public void makeBid(double bid) {
        for (Subject s : subjects) {
            s.makeBid(bid);
        }
    }

    @Override
    public void update(String opt, Subject subject) {
        if (opt.equals("bid")){
            System.out.println("Client: New Bid " + subject.getPreco());
        }
        if (opt.equals("State")){
            System.out.println("Client: New State " + subject.getState());
        }
    }
    
}
