/**
 * Created by rashmimech on 2/12/17.
 */
public class PowerOfInteger {
    public static void main(String[] args) {
        PowerOfInteger tester = new PowerOfInteger();
        System.out.println(tester.isPower(8));
    }
    public boolean isPower(int a) {

        int i = 2;
        int res;
        while(i <= Math.sqrt(a)){
            int p = 2;
            res = 1;
            while(res <= a){
                res = (int) Math.pow(i, p);
                if(res == a){
                    return true;
                }
                p++;
            }
            i++;
        }

        return false;
    }
}
