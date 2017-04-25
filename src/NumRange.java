import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by rashmimech on 3/26/17.
 Given an array of non negative integers A, and a range (B, C),
 find the number of continuous subsequences in the array which have sum S in the range [B, C] or B <= S <= C

 Continuous subsequence is defined as all the numbers A[i], A[i + 1], .... A[j]
 where 0 <= i <= j < size(A)

 Example :

 A : [10, 5, 1, 0, 2]
 (B, C) : (6, 8)

 ans = 3
 as [5, 1], [5, 1, 0], [5, 1, 0, 2] are the only 3 continuous subsequence with their sum in the range [6, 8]
 */

public class NumRange {
    public static void main(String[] args) {
        Integer[] list = new Integer[]{ 76, 22, 81, 77, 95, 23, 27, 35, 24, 38, 15, 90, 19, 46, 53, 6, 77, 96, 100, 85, 43, 16, 73, 18, 7, 66};
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(list));

        System.out.println(new NumRange().numRange(arrayList, 98, 290));
    }
    public int numRange(ArrayList<Integer> a, int b, int c) {
        int count = 0;
        int sum = 0;
        for(int i = 0; i < a.size(); i++){
            for(int j = i; j < a.size(); j++){
                sum += a.get(j);
                if(sum >= b && sum <= c){
                    count++;
                }
                else if(sum > c){
                    break;
                }
            }
            sum = 0;
        }

        return count;
    }
}
