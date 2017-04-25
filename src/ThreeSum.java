import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by rashmimech on 1/31/17.
 */
public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum tester = new ThreeSum();
        Integer[] i = new Integer[]{-6, 1, -4, -1, 8, -4, 9, 0, -3, 7, -3, 2, -4, -2, 3, -4, 10, 0, 9, 6, 1, 3, 4, 2};
        ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(i));

        System.out.println(tester.threeSumClosest(arrayList, -3));
    }
    public int threeSumClosest(ArrayList<Integer> a, int b) {
        int diff = Integer.MAX_VALUE;
        int res = 0;
        Collections.sort(a);

        for(int i = 0; i < a.size() - 2; i++){
            int sum = b - a.get(i);
            int j = i + 1, k = a.size() - 1;

            while(j < k){
                int temp = a.get(j) + a.get(k);
                if(sum > temp){
                    j++;
                }
                else{
                    k--;
                }
                int tempdif = Math.abs(b - (a.get(i) + temp));
                if(diff > tempdif){
                    diff = Math.abs(b - (a.get(i) + temp));
                    res = a.get(i) + temp;
                }
            }
        }

        return res;
    }


    /*public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> a) {
        int diff = Integer.MAX_VALUE;
        int res = 0;
        Collections.sort(a);

        for(int i = 0; i < a.size() - 2; i++){
            int sum = a.get(i);
            int j = i + 1, k = a.size() - 1;

            while(j < k){
                int temp = a.get(j) + a.get(k);
                if(sum > temp){
                    j++;
                }
                else{
                    k--;
                }
                int tempdif = Math.abs(b - (a.get(i) + temp));
                if(diff > tempdif){
                    diff = Math.abs(b - (a.get(i) + temp));
                    res = a.get(i) + temp;
                }
            }
        }

        return res;
    }*/
}
