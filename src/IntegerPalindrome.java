/**
 * Created by rashmimech on 1/16/17.
 */
public class IntegerPalindrome {
    public static void main(String[] args) {
        IntegerPalindrome test = new IntegerPalindrome();
        System.out.println(test.isPalindrome(2147447412));
    }
    public boolean isPalindrome(int a) {
        if(a < 0) return false;
        int temp = a;
        int newNum = 0;
        while(temp > 0){
            newNum = ((temp % 10) + (newNum * 10));
            temp = temp /10;
        }

        if(newNum == a)
            return true;

        return false;

    }
}
