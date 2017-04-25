/**
 * Created by rashmimech on 2/5/17.
 */
public class PowerOf2 {
    public static void main(String[] args) {
        PowerOf2 tester = new PowerOf2();

        System.out.println(tester.power("128"));
    }
    public int power(String a) {
        Integer lastChar = Integer.parseInt(a.charAt(a.length() - 1) + "");

        if(lastChar % 2 != 0){
            return 0;
        }

        String res = a;
        while(!res.equals("1")){
            lastChar = Integer.parseInt(res.charAt(res.length() - 1) + "");
            Integer firstChar = Integer.parseInt(res.charAt(0) + "");
            if(firstChar == 0){
                res = res.substring(1);
            }

            if(lastChar % 2 != 0) return 0;

            String tempRes = "";
            Integer carry = 0;
            for(int i = 0; i < res.length(); i++){
                Integer num = Integer.parseInt(res.charAt(i) + "");
                tempRes += ((num + (carry * 10)) / 2);
                carry = (num + (carry * 10)) % 2;
            }

            res = tempRes;

        }

        return 1;
    }
}
