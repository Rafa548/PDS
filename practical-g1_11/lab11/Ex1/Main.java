package Ex1;


public class Main {
    public static void main(String[] args) {
        telemovel telemovel1 = new telemovel("Snapdragon 888", 8, 108, 899);
        telemovel telemovel2 = new telemovel("Snapdragon 688", 6, 108, 199);
        telemovel telemovel3 = new telemovel("Snapdragon 885", 8, 188, 899);

        telemovel[] telemovel = {telemovel1, telemovel2, telemovel3};

        Sort sort = new Sort(new BubbleSort());
        sort.sort(telemovel);
        Sort sort2 = new Sort(new MergeSort());
        sort2.sort(telemovel);
        Sort sort3 = new Sort(new QuickSort());
        sort3.sort(telemovel);

    }
}
