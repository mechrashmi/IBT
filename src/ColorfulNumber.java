import java.util.HashSet;

/**
 * Created by rashmimech on 2/26/17.
 amming Hashing Colorful Number

 Colorful Number

 For Given Number N find if its COLORFUL number or not

 Return 0/1

 COLORFUL number:

 A number can be broken into different contiguous sub-subsequence parts.
 Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
 And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different

 Example:

 N = 23
 2 3 23
 2 -> 2
 3 -> 3
 23 -> 6
 this number is a COLORFUL number since product of every digit of a sub-sequence are different.

 Output : 1

 */
public class ColorfulNumber {
    public static void main(String[] args) {
        System.out.println(new ColorfulNumber().colorful(23));
    }

    public int colorful(int a) {
        String input = a + "";
        int len = input.length();
        HashSet<Integer> storedProduct = new HashSet<>();
        while(len > 0){
            int start = 0;
            while((start + len) <= input.length()) {
                int product = 1;
                for (int i = start; i < start + len; i++) {
                    product *= Integer.parseInt(input.charAt(i) + "");
                }

                if (storedProduct.contains(product)) {
                    return 0;
                }

                storedProduct.add(product);
                start++;
            }
            len--;
        }
        return 1;
    }
}
