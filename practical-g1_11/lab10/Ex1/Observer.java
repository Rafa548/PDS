package Ex1;

abstract class Observer {
    protected Subject subject;
    public abstract void update(String opt, Subject subject);
}


