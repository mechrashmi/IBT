/*
 Rain Water Trapped

 Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

 Example :

 Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

 The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 In this case, 6 units of rain water (blue section) are being trapped.
 Notes
 All Notee
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RainWaterTrapped {
    public static void main(String[] args) {
        Integer[] intArr = new Integer[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(intArr));
        System.out.println(new RainWaterTrapped().trap(arrayList));

    }

    public int trap(final List<Integer> a) {
        int n = a.size();
        int[] leftMax = new int[n];
        int[] rightMax = new int [n];
        int left = 0;
        int right = 0;

        for(int i = 0; i < n; i++){
            leftMax[i] = left;
            if(left < a.get(i)){
                left = a.get(i);
            }
        }

        for(int i = n - 1; i >= 0; i--){
            rightMax[i] = right;
            if(right < a.get(i)){
                right = a.get(i);
            }
        }

        int res = 0;

        for(int i = 0; i < n ; i++){
            res += Math.max(0, Math.min(leftMax[i], rightMax[i]) - a.get(i));
        }

        return res;
    }
}
