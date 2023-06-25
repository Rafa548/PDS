package Ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Subject extends Produto{
    private List<Observer> observers = new ArrayList<>();
    private State state;
    private boolean leilao = false;
    private int offers = 0; 

    public void attach(Observer o) {
        observers.add(o);
    }

    public Subject(String desc, double preco) {
        super(desc, preco);
        this.state = State.stock;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
        notifyObs("State");
        if (state == State.leilao) {
            this.leilao = true;
            timer();
        }
        
    }

    private void timer() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                leilao = false;
                if (offers != 0 )
                    setState(State.vendido);
                else
                    setState(State.stock);
            }
        };

        timer.schedule(task, 10000);
    }

    private void notifyObs(String opt) {
        for (Observer o : observers) {
            o.update(opt, this);
        }
    }

    public void makeBid(double bid) {
        if (bid > this.getPreco()) {
            this.setPreco(bid);
            notifyObs("bid");
            offers++;
        }
    }

  
}
