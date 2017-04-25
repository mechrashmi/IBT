import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rashmimech on 1/22/17.
 */
public class MinValInAMatrix {
    Integer[][] dp;

    public static void main(String[] args) {
       /* Integer a[][] = new Integer[][] { {20, 29, 84, 4, 32, 60, 86, 8, 7, 37},
                                            {77, 69, 85, 83, 81, 78, 22, 45, 43, 63},
                                            {60, 21, 0, 94, 59, 88, 9, 54, 30, 80},
                {40, 78, 52, 58, 26, 84, 47, 0, 24, 60},
                {40, 17, 69, 5, 38, 5, 75, 59, 35, 26},
                {64, 41, 85, 22, 44, 25, 3, 63, 33, 13},
                {2, 21, 39, 51, 75, 70, 76, 57, 56, 22},
                {31, 45, 47, 100, 65, 10, 94, 96, 81, 14}
        };*/

       Integer a[][] = new Integer[][]{{1, 3, 2}, {4, 3, 1}, {5, 6, 1}};
        List<Integer[]> list = Arrays.asList(a);
        ArrayList<ArrayList<Integer>> result = new ArrayList();
        for(Integer[] array : list){
            ArrayList<Integer> arrayInside = new ArrayList<>(Arrays.asList(array));
            result.add(arrayInside);
        }

        MinValInAMatrix tester = new MinValInAMatrix();
        tester.minPathSum(result);
    }

    public int minPathSum(ArrayList<ArrayList<Integer>> a) {
        dp = new  Integer[a.size()][a.get(0).size()];
        for(Integer[] row : dp){
            Arrays.fill(row, -1);
        }

        int res = minPathSumDP(a, 0, 0);
        System.out.println(res);
        return res;

    }


    public int minPathSumDP(ArrayList<ArrayList<Integer>> a, int row, int col){
        if(row == a.size() - 1 && col == a.get(row).size() - 1){
            dp[row][col] = a.get(row).get(col);
            return a.get(row).get(col);
        }

        if(row >= a.size() || col >= a.get(0).size()) return Integer.MAX_VALUE;

        if(dp[row][col] != -1) return dp[row][col];

        int val = a.get(row).get(col);
        int left =  minPathSumDP(a, row, col + 1);
        int right = minPathSumDP(a, row + 1, col);

        if(left != Integer.MAX_VALUE){
            left += val;
        }

        if(right != Integer.MAX_VALUE){
            right += val;
        }

        dp[row][col] = Math.min(left, right);
        return dp[row][col];
    }
}
