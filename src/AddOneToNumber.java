import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by rashmimech on 1/24/17.
 */
public class AddOneToNumber {
    public static void main(String[] args) {
        AddOneToNumber test = new AddOneToNumber();
        Integer[] i = new Integer[]{0, 0 , 0,0 ,0 ,0 ,1 };
        List<Integer> iL = Arrays.asList(i);
        ArrayList<Integer> input = new ArrayList<>(iL);

        System.out.println(test.plusOne(input));
    }
    public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(a == null) return res;
        if(a.size() == 0){
            res.add(1);
            return res;
        }
        for(int i = 0; i < a.size(); ){
            if(a.get(i) != 0){
                break;
            }
            else{
                a.remove(i);
            }
        }

        if(a.size() == 0){
            res.add(1);
            return res;
        }
        Collections.reverse(a);
        int carry = 0;
        for(int i = 0; i < a.size(); i++){
            int val = a.get(i);
            if(i == 0){
                val += 1;
                carry = val / 10;
            }
            else{
                val += carry;
                carry = val / 10;
            }
            val = val % 10;
            res.add(val);
        }

        if(carry == 1) res.add(carry);

        Collections.reverse(res);

        return res;
    }
}
