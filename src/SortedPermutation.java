/**
 * Created by rashmimech on 2/12/17.
 */

//Incorrect solution
public class SortedPermutation {
    public static void main(String[] args) {
        SortedPermutation tester = new SortedPermutation();
        System.out.println(tester.findRank("zyxwvutsrqponmlkjihgfedcba"));
    }

    public int findRank(String a) {
        if(a.length() == 1) return 1;

        long rank = 1;
        for(int i = 0; i < a.length(); i++){
            int smallerChars = findSmallest(a, i);
            if(smallerChars == 0) continue;

            rank = (int) (rank + (smallerChars * (findfactorial(a.length() - (i + 1)))) )% 10000063;

        }

        return (int)rank;
    }

    public long findfactorial(int a){
        long res = 1;
        for(int i = 2; i <= a; i++){
            res *= i;
            if((res * i) >= Integer.MAX_VALUE){
                res = res % 1000003;
            }
        }
        return res;
    }

    public int findSmallest(String a, int index){
        char charToCheck = a.charAt(index);
        int res = 0;
        for(int i = index + 1; i < a.length(); i++){
            if(a.charAt(i) < charToCheck){
                res ++;
            }
        }

        return res;
    }
}
