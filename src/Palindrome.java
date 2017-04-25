/**
 * Created by rashmimech on 3/31/17.
 Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 Example:

 "A man, a plan, a canal: Panama" is a palindrome.

 "race a car" is not a palindrome.

 Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class Palindrome {

    public static void main(String[] args) {
        System.out.println(new Palindrome().isPalindrome("123 ,"));
    }

    public int isPalindrome(String a) {
        StringBuilder rs = new StringBuilder();
        a = a.toLowerCase();

        for(int i = 0; i < a.length(); i++){
            if(('0' <= a.charAt(i) && a.charAt(i) <= '9') || ('a' <= a.charAt(i) && a.charAt(i) <= 'z')){
                rs.append(a.charAt(i));
            }
        }

        String s = rs.toString();
        rs.reverse();
        if(rs.toString().equals(s)){
            return 1;
        }

        return 0;
    }
}
