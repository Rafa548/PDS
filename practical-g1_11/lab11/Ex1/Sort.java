package Ex1;

public class Sort {
    private final SortStrategy strategy;

    public Sort(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void sort(telemovel[] telemovel) {
        strategy.sort(telemovel);
    }
}
