import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rashmimech on 1/25/17.
 */
public class PositiveSumOfSubArray {

    public static void main(String[] args) {
        PositiveSumOfSubArray test = new PositiveSumOfSubArray();
        Integer[] l = new Integer[]{756898537, -1973594324, -2038664370, -184803526, 1424268980};
        List<Integer> integerList = Arrays.asList(l);
        ArrayList<Integer> arrayList = new ArrayList<>(integerList);

        System.out.println(test.maxset(arrayList));
    }

    public ArrayList<Integer> maxset(ArrayList<Integer> a) {
        if(a == null ||  a.size() == 0) return a;

        ArrayList<Integer> res = new ArrayList<Integer>();
        int maxI = 0, maxJ =0;
        long maxSum = Integer.MIN_VALUE;
        int k;
        for(k = 0; k < a.size(); k++){
            if(a.get(k) >= 0){
                maxI = k;
                maxJ = k;
                break;
            }
        }

        if(k == a.size() && maxI == 0) return res;
        int i = maxI;
        long temSum = 0;
        boolean isNeg = false;
        int j;
        for( j = maxJ; j < a.size(); j++){
            int val = a.get(j);
            if(val < 0 && !isNeg){
                if(maxSum == temSum){
                    int currLen = (j - 1) - i;
                    int maxLen = maxJ - maxI;

                    if((maxLen < currLen) || (maxLen == currLen && a.get(i) < a.get(maxI))){
                        maxI = i;
                        maxJ = j - 1;
                    }
                }
                else if( maxSum < temSum){
                    maxI = i;
                    maxJ = j - 1;
                }
                maxSum = Math.max(maxSum, temSum);
                temSum = 0;
                isNeg = true;
                i = j;
                while(i < a.size()){
                    if(a.get(i) < 0){
                        i++;
                    }
                    else{
                        break;
                    }
                }
            }
            else if(val > 0)
            {
                temSum += val;
                isNeg = false;
            }
        }

        if(maxSum == temSum){
            int currLen = (j - 1) - i;
            int maxLen = maxJ - maxI;

            if((maxLen < currLen) || (maxLen == currLen && a.get(i) < a.get(maxI))){
                maxI = i;
                maxJ = j - 1;
            }
        }
        else if( maxSum < temSum){
            maxI = i;
            maxJ = j - 1;
        }

        for(int l = maxI; l <= maxJ; l++ ){
            res.add(a.get(l));
        }

        return res;

    }


    public ArrayList<Integer> maxsetShortSolution(ArrayList<Integer> a) {
        long maxSum = 0;
        long newSum = 0;
        ArrayList<Integer> maxArray = new ArrayList<Integer>();
        ArrayList<Integer> newArray = new ArrayList<Integer>();
        for (Integer i : a) {
            if (i >= 0) {
                newSum += i;
                newArray.add(i);
            } else {
                newSum = 0;
                newArray = new ArrayList<Integer>();
            }
            if ((maxSum < newSum) || ((maxSum == newSum) && (newArray.size() > maxArray.size()))) {
                maxSum = newSum;
                maxArray = newArray;
            }
        }
        return maxArray;
    }
}
