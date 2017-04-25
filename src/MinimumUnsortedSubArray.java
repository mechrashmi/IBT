import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by rashmimech on 1/29/17.
 */
public class MinimumUnsortedSubArray {

    public static void main(String[] args) {
        MinimumUnsortedSubArray test = new MinimumUnsortedSubArray();
        Integer[] array = new Integer[]{1, 3, 2, 4, 5};
        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(array));
        System.out.println(test.subUnsort(input));
    }

    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int n = A.size();
        int i = 0; int j = n - 1;
        while(i < n - 1 && A.get(i) <= A.get(i + 1)){
            i++;
        }

        while(j > 0 && A.get(j) >= A.get(j - 1)){
            j--;
        }

        if(i == n - 1 && j == 0 ){
            res.add(-1);
            return res;
        }

        int max = A.get(i); int min = A.get(i);
        int l = i; int r = j;
        while(l <= j){
            max = Math.max(max, A.get(l));
            min = Math.min(min, A.get(l));
            l++;
        }

        l = 0; r = n-1;

        while(l <= i && A.get(l) <= min){
            l++;
        }


        while(r >= j && A.get(r) >= max){
            r--;
        }

        res.add(l);
        res.add(r);

        return res;
    }


}
