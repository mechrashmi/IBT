import java.util.*;

/**
 * Created by rashmimech on 1/22/17.
 */
public class MaxMultiply {
    public static void main(String[] args) {
        Integer[] input = new Integer[]{0, -1, 3, 100, 70, 50};
        List<Integer> list = Arrays.asList(input);
        ArrayList<Integer> inputList = new ArrayList<>(list);
        MaxMultiply tester = new MaxMultiply();
        System.out.println(tester.maxp3(inputList));
    }
    public int maxp3(ArrayList<Integer> a) {
        Collections.sort(a);
        if(a == null || a.size() < 3) return 0;

        int max;
        int n = a.size();
        max = a.get(n - 1) * a.get(n - 2) * a.get(n - 3);
        max = Math.max(max, a.get(0) * a.get(1) * a.get(n - 1));

        return max;
    }
}
