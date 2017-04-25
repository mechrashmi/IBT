import java.util.Collections;

/**
 * Created by rashmimech on 2/5/17.
 */
public class MultiplyStrings
{
    public static void main(String[] args) {
        MultiplyStrings tester = new MultiplyStrings();
        System.out.println(tester.multiply("123", "144"));
    }
    public String multiply(String a, String b) {
        StringBuilder aB = new StringBuilder(a);
        StringBuilder bB = new StringBuilder(b);
        StringBuilder res = new StringBuilder();

        for(int i = 0; i < bB.length(); i++){
            int num1 = Integer.parseInt(bB.charAt(i) + "");
            StringBuilder s1 = new StringBuilder();
            int carry = 0;

            for(int j = 0; j < aB.length(); j++){
                int num2 = Integer.parseInt(aB.charAt(j) + "");
                int temp = num2 * num1 + carry;
                carry = temp % 10;
                temp /= 10;
                s1.append(temp);
            }

            if(carry != 0){
                s1.append(carry);
            }

            s1.reverse();
            int z = i;
            while(z > 0){
                s1.append("0");
            }

            s1.reverse();

            if(res.length() == 0){
                res = s1;
                continue;
            }

        }




        return res.toString();
    }
}
