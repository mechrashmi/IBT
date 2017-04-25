import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by rashmimech on 1/28/17.
 */
public class NextPermutation {
    public static void main(String[] args) {
        Integer[] l = new Integer[]{3, 2, 1};
        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(l));
        NextPermutation tester = new NextPermutation();
        tester.nextPermutation(input);
        System.out.println(input);
    }
    public void nextPermutation(ArrayList<Integer> a) {
        if(a.size() == 0 || a == null || a.size() == 1) return;
        int i ;
        int j;

        for(j = a.size() - 2; j >= 0; j--){
            if(a.get(j) < a.get(j + 1)){
                break;
            }
        }

        if(j < 0)
            Collections.reverse(a);
        else
        {
            for(i = a.size() - 1; i > j; i--){
                if(a.get(j) < a.get(i)){
                    int temp = a.get(i);
                    a.set(i, a.get(j));
                    a.set(j, temp);
                    break;
                }
            }
            Collections.sort(a.subList(j + 1 , a.size()));
        }
    }
}
