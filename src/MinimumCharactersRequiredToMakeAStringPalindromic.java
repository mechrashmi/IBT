/**
 * Created by rashmimech on 3/31/17.

 You are given a string. The only operation allowed is to insert characters in the beginning of the string. How many minimum characters are needed to be inserted to make the string a palindrome string

 Example:
 Input: ABC
 Output: 2
 Input: AACECAAAA
 Output: 2
 */

public class MinimumCharactersRequiredToMakeAStringPalindromic {
    public static void main(String[] args) {
        //System.out.println(new MinimumCharactersRequiredToMakeAStringPalindromic().solve("ABC"));
        System.out.println(new MinimumCharactersRequiredToMakeAStringPalindromic().solve("AACECAAAA"));
    }

    public int solve(String A) {
        int i = 0, j = A.length() - 1;
        int paIndex = A.length();
        boolean isMatchedbefore = false;
        while(i < j){
            if(A.charAt(i) != A.charAt(j)){
                i = 0;
                paIndex = j;
                if(isMatchedbefore) {
                    j++;
                    paIndex++;
                    isMatchedbefore = false;
                }

                j--;


            }
            else
            {
                isMatchedbefore = true;
                i++;
                j--;
            }
        }

        return (A.length() - paIndex);
    }
}
