import java.util.*;

/**
 * Created by rashmimech on 2/26/17.


 Find the largest continuous sequence in a array which sums to zero.

 Example:


 Input:  {1 ,2 ,-2 ,4 ,-4}
 Output: {2 ,-2 ,4 ,-4}

 NOTE : If there are multiple correct answers, return the sequence which occurs first in the array.


 */


public class LargestContinuousSequenceZeroSum {

    public static void main(String[] args) {
        //Integer[] input = new Integer[]{1 ,2 ,-2 ,4 ,-4};
        Integer[] input = new Integer[]{1, 2, -3, 3 };
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(input));

        System.out.println(new LargestContinuousSequenceZeroSum().lszero(arrayList));
    }

    public ArrayList<Integer> lszero(ArrayList<Integer> a) {
        ArrayList<Integer> res = new ArrayList<>();

        Map<Integer, Integer> storeSumInfo = new HashMap<>();
        int sum = 0;
        int len = 0;
        int firstIndex = -1;
        int lastIndex = -1;
        storeSumInfo.put(0, -1);
        for(int i = 0; i < a.size(); i++){
            sum += a.get(i);

            if(storeSumInfo.containsKey(sum)){
                if(i - storeSumInfo.get(sum) > len) {
                    firstIndex = storeSumInfo.get(sum) + 1;
                    lastIndex = i;
                    len = i - storeSumInfo.get(sum);
                }
            }
            else{
                storeSumInfo.put(sum, i);
            }
        }

        if(firstIndex != -1 && lastIndex != -1) {
            for (int i = firstIndex; i <= lastIndex; i++) {
                res.add(a.get(i));
            }
        }

        return res;
    }
}
