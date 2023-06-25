package Ex3;

import java.util.ArrayList;
import java.util.List;

public class Satellite implements Mediator{

    private String name;

    List<User> users;

    public Satellite(String name) {
        this.name = name;
        this.users = new ArrayList<>();
    }

    @Override
    public void send(String message, User user) {
        for (User u : users) {
            if (u != user) {
                u.receive(message);
            }
        }
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }
    
}
