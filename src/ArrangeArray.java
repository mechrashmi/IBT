import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by rashmimech on 2/12/17.
 */
public class ArrangeArray {
    public static void main(String[] args) {
        ArrangeArray tester = new ArrangeArray();
        Integer[] array = new Integer[]{4, 5, 6, 0, 2, 1, 3};
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(array));
        tester.arrange(input);
        System.out.println(input);
    }
    public void arrange(ArrayList<Integer> a) {
        int n = a.size();
        for(int i = 0; i < n; i++){
            a.set(i, a.get(i) + (a.get(a.get(i)) % n) * n);
        }

        for(int i = 0; i < n; i++){
            a.set(i, a.get(i) / n);
        }
    }
}
