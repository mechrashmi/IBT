import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rashmimech on 1/24/17.
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        RemoveDuplicates tester = new RemoveDuplicates();
        Integer[] i = new Integer[]{1000, 1001, 1002, 1003, 1003, 1004, 1010 };
        List<Integer> iL = Arrays.asList(i);
        ArrayList<Integer> input = new ArrayList<Integer>(iL);
        System.out.println(tester.removeDuplicates(input));
    }
    public int removeDuplicates(ArrayList<Integer> a) {
        int prev = a.get(0);
        int i = 1, j = 1;
        int sum = 1;
        while(i < a.size() && j < a.size()){
            int curr = a.get(j);
            if(prev == curr && sum < 2){
                int temp = a.get(i);
                a.set(i, curr);
                a.set(j, temp);
                i++;
                j++;
                sum++;
            }
            else if(prev != curr && sum <= 2){
                prev = curr;
                int temp = a.get(i);
                a.set(i, curr);
                a.set(j, temp);
                sum = 1;
                i++;
                j++;
            }else if(prev == curr && sum >= 2){
                j++;
                sum ++;
            }else if(prev != curr && sum > 2){
                int temp = a.get(i);
                a.set(i, curr);
                a.set(j, temp);
                prev = a.get(i);
                i++;
                j++;
                sum = 1;
            }
        }
        return i;
    }
}
