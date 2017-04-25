/**
 * Created by rashmimech on 2/8/17.
 */
public class ReverseAnInteger {
    public static void main(String[] args) {
        ReverseAnInteger tester = new ReverseAnInteger();
        System.out.println(tester.reverse(-1146467285));
    }
    public int reverse(int a) {
        boolean isNeg = false;
        if(a < 0){
            isNeg = true;
            a = -a;
        }

        int res = 0;

        while(a > 0){
            int temp = a % 10;
            a = a / 10;
            if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && temp > Integer.MAX_VALUE % 10)){
                return 0;
            }
            res = temp + (res * 10);


        }

        if(isNeg){
            res = -(res);
        }

        return  res;
    }
}
