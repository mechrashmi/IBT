/**
 * Created by rashmimech on 3/15/17.
 *
 *
 *

 A robot is located at the top-left corner of an A x B grid (marked ‘Start’ in the diagram below).

 The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked ‘Finish’ in the diagram below).

 How many possible unique paths are there?

 Note: A and B will be such that the resulting answer fits in a 32 bit signed integer.

 Example :

 Input : A = 2, B = 2
 Output : 2

 2 possible routes : (0, 0) -> (0, 1) -> (1, 1)
 OR  : (0, 0) -> (1, 0) -> (1, 1)

 Notes
 All Notes

 00 : 24 : 36
 Current Possible Score: 334
 Max Score: 375
 */

public class UniquePathINAGrid {
    public static void main(String[] args) {
        UniquePathINAGrid tester = new UniquePathINAGrid();
        System.out.println(tester.uniquePaths(0, 0));
    }

    public int uniquePaths(int a, int b) {
        if(a == 0 || b == 0) return 0;
        int[][] paths = new int[a][b];

        //Intializing last row and column by 1

        for(int r = a - 1; r >= 0; r--){
            paths[r][b - 1] = 1;
        }

        for(int c = b - 1; c >= 0; c--){
            paths[a - 1][c] = 1;
        }

        //calculating the paths
        for(int c = b - 2; c >= 0; c--){
            for(int r = a - 2; r >= 0; r--){
                paths[r][c] = paths[r+1][c] + paths[r][c+1];
            }
        }

        return paths[0][0];
    }


    //Combination is one of the solution
    public int uniquePathsCom(int m, int n) {
        // m+n-2 C n-1 = (m+n-2)! / (n-1)! (m-1)!
        long ans = 1;
        for (int i = n; i < (m + n - 1); i++) {
            ans *= i;
            ans /= (i - n + 1);
        }
        return (int)ans;
    }
}
