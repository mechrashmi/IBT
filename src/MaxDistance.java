import java.util.*;

/**
 * Created by rashmimech on 1/29/17.
 */
public class MaxDistance {
    public static void main(String[] args) {
        MaxDistance test = new MaxDistance();
        Integer[] array = new Integer[]{3, 5, 4, 2};
        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(array));
        System.out.println(test.maximumGap(input));
    }
    public int maximumGap(final List<Integer> a) {
        Integer[] minLeft = new Integer[a.size()];
        Integer[] maxRight = new Integer[a.size()];
        int n = a.size();
        int min = a.get(0);
        minLeft[0] = min;
        for(int i = 1; i < a.size(); i++){
            if(min > a.get(i)){
                min = a.get(i);
                minLeft[i] = min;
            }
        }

        int max = a.get(n - 1);
        maxRight[n - 1] = max;
        for(int j = n - 2; j >= 0; j--){
            if(max < a.get(j)){
                max = a.get(j);
                maxRight[j] = max;
            }
        }

        max = Integer.MIN_VALUE;
        for(int i = n - 1; i >= 0; i--){
            int num = maxRight[i];
            int ind =  minIndex(minLeft, num);
            max = Math.max(max, i - ind);
        }

        return max;


    }

    //Find the min index using binary search (copied from the solution)
    public int minIndex(Integer [] minLeft, int num) {

        int lo, hi, mid;
        int index = -1;

        lo = 0;
        hi = minLeft.length;

        while (lo <= hi) {
            mid = lo + ((hi - lo) >> 1);

            int minNum = minLeft[mid];

            if (num < minNum) {
                lo = mid + 1;
            } else {
                index = mid;
                hi = mid - 1;
            }
        }

        return index;

    }


    //Time complexity n2
    public int maximumGapBruteForce(final List<Integer> a) {
        ArrayList<Integer> sortedList = new ArrayList<Integer>(a);
        Map<Integer, Integer> index = new HashMap<Integer, Integer>();
        for(int i = 0; i < a.size(); i++){
            index.put(a.get(i), i);
        }

        Collections.sort(sortedList);
        int max = 0;

        for(int i = 0; i < a.size(); i++){
            int indexOfAi = sortedList.indexOf(a.get(i));

            for(int j = indexOfAi + 1; j < sortedList.size(); j++){
                int temp = index.get(sortedList.get(j)) - i;
                max = Math.max(max, temp);
            }

            if(((a.size()) - i) <= max)
                break;
        }

        return max;
    }
}
