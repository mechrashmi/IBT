/**
 * Created by rashmimech on 4/1/17.
 Given a string S, find the longest palindromic substring in S.

 Substring of string S:

 S[i...j] where 0 <= i <= j < len(S)

 Palindrome string:

 A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S.

 Incase of conflict, return the substring which occurs first ( with the least starting index ).

 Example :

 Input : "aaaabaaa"
 Output : "aaabaaa"
 */
public class LongestPalindrome {
    int start, end;
    int maxLength = 0;

    public static void main(String[] args) {
        //System.out.println(new LongestPalindrome().longestPalindrome("aaaabaaa"));
        System.out.println(new LongestPalindrome().longestPalindrome("abacdfgdcaba"));
    }

    public String longestPalindrome(String a) {
        start = 0;
        end = a.length();
        String res = null;
        for(int i = 0; i < a.length(); i++){
            if(maxLength > (a.length() - i) + 1) break;

            findPalindrome(a, i);
        }

        res = a.substring(start, end);

        return res;
    }

    private void findPalindrome(String a, int i) {
        StringBuilder str = new StringBuilder( a.substring(i));
        StringBuilder rStr = str;
        if(maxLength > str.length()) return;

        if(str.toString().equals(rStr.reverse().toString())){
            if(maxLength < str.length()){
                maxLength = str.length();
                start = i;
                end = a.length();
                return;
            }
        }

        Boolean isMatchedBefore = false;
        int index = i;
        int j = str.length() - 1;
        int indexNotmatched = str.length();
        while(index < j){
            if(str.charAt(index) != str.charAt(j)){
                index = i;
                indexNotmatched = j;
                if(isMatchedBefore){
                    j++;
                    isMatchedBefore = false;
                    indexNotmatched++;
                }
                j--;
            }
            else {
                index++;
                j--;
            }
        }

        int matchedlength = indexNotmatched - (i + 1);

        if(maxLength < matchedlength){
            maxLength = matchedlength;
            start = i;
            end = indexNotmatched--;
        }
    }
}
