import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rashmimech on 1/15/17.
 */
public class SortedInsertEle {
    public static void main(String[] args) {
        SortedInsertEle test = new SortedInsertEle();
        List<Integer> testCase;
        Integer a[] = new Integer[] {1,3,5,6};
        testCase = Arrays.asList(a);

        ArrayList<Integer> finalTest = new ArrayList<Integer>(testCase);
        test.searchInsert(finalTest, 2);
    }
    public int searchInsert(ArrayList<Integer> a, int b) {
        int index = 0;
        boolean set = false;
        Integer low = 0;
        Integer end = a.size() - 1;

        index = getLowerVal(a, b, low, end);
        if(index != -1){
            return index;
        }
        for(int i = 0; i < a.size(); i++){
            int val = a.get(i);
            if(val > b){
                break;
            }
            index = i;
        }

        return index + 1;
    }

    private int getLowerVal(ArrayList<Integer> a, int b, Integer start, Integer end) {
        int steps = a.size();
        int mid;
        int index = -1;

        while(steps > 0){
            mid = (end + start)/2;
            int midval = a.get(mid);

            if(b > midval){
                start = mid;
            }
            else if(b < midval){
                end = mid;
            }
            else{
                end = mid;
                start = mid - 1;
                index = mid;
                break;
            }
            steps /= 2;
        }

        return index;
    }
}
