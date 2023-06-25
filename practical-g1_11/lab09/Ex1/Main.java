package Ex1;


public class Main {
    int[] vec1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    
    public static void main(String[] args) {
        VectorGeneric<Integer> vec = new VectorGeneric<Integer>();
        for (int i = 0; i < 10; i++) {
            vec.addElem(i);
        }
        java.util.Iterator<Integer> it = vec.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

}
